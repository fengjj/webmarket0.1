package com.sitech.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import me.prettyprint.cassandra.model.BasicColumnDefinition;
import me.prettyprint.cassandra.model.BasicColumnFamilyDefinition;
import me.prettyprint.cassandra.model.IndexedSlicesQuery;
import me.prettyprint.cassandra.serializers.LongSerializer;
import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.cassandra.service.ThriftCfDef;
import me.prettyprint.cassandra.service.spring.HectorTemplateImpl;
import me.prettyprint.cassandra.service.template.ColumnFamilyResult;
import me.prettyprint.cassandra.service.template.ColumnFamilyRowMapper;
import me.prettyprint.cassandra.service.template.ColumnFamilyTemplate;
import me.prettyprint.cassandra.service.template.ColumnFamilyUpdater;
import me.prettyprint.cassandra.service.template.MappedColumnFamilyResult;
import me.prettyprint.cassandra.service.template.ThriftColumnFamilyTemplate;
import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.beans.CounterRow;
import me.prettyprint.hector.api.beans.CounterRows;
import me.prettyprint.hector.api.beans.HColumn;
import me.prettyprint.hector.api.beans.HCounterColumn;
import me.prettyprint.hector.api.beans.HSuperColumn;
import me.prettyprint.hector.api.beans.OrderedRows;
import me.prettyprint.hector.api.beans.Row;
import me.prettyprint.hector.api.beans.Rows;
import me.prettyprint.hector.api.ddl.ColumnFamilyDefinition;
import me.prettyprint.hector.api.ddl.ColumnType;
import me.prettyprint.hector.api.ddl.KeyspaceDefinition;
import me.prettyprint.hector.api.exceptions.HectorException;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.mutation.Mutator;
import me.prettyprint.hector.api.query.ColumnQuery;
import me.prettyprint.hector.api.query.MultigetSliceCounterQuery;
import me.prettyprint.hector.api.query.MultigetSliceQuery;
import me.prettyprint.hector.api.query.QueryResult;
import me.prettyprint.hector.api.query.RangeSlicesQuery;
import me.prettyprint.hector.api.query.SuperColumnQuery;

import org.apache.cassandra.thrift.IndexOperator;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.JSONObject;

/**
 * cassandraDao数据库操作封装
 * 
 * @author evelyn create column family custGroups with column_type = 'Standard'
 *         and comparator = 'UTF8Type' and default_validation_class =
 *         'BytesType' and key_validation_class = 'UTF8Type' AND column_metadata
 *         =[{column_name: phoneNo,validation_class: 'UTF8Type',index_type:
 *         KEYS},{column_name: custId, validation_class: 'UTF8Type', index_type:
 *         KEYS}, {column_name: custName,validation_class:
 *         'UTF8Type',index_type: KEYS}]; create column family userInfo with
 *         column_type = 'Standard' and comparator = 'UTF8Type' and
 *         default_validation_class = 'BytesType' and key_validation_class =
 *         'UTF8Type' AND column_metadata =[{column_name:
 *         userId,validation_class: 'UTF8Type',index_type: KEYS},{column_name:
 *         birthday, validation_class: 'LongType', index_type: KEYS},
 *         {column_name: birthmonth,validation_class: 'LongType',index_type:
 *         KEYS}];
 * 
 *         使用了hector的hectorTemplateImpl用于spring依赖注入相关的配置 部分使用了hector
 *         api中ColumnFamilyTemplate模板类 使用fastjson作为json解析工具
 */
public class CopyOfCassandraUtil implements Serializable {

 private static StringSerializer stringSerializer = StringSerializer.get();

 private static LongSerializer longSerializer = LongSerializer.get();

 private static Logger logger = Logger.getLogger(CopyOfCassandraUtil.class);
 // private HectorTemplate hectorTemplate;
 @Resource
 private HectorTemplateImpl hectorTemplateImpl;

 /**
  * @param cloumFamilyName
  * @param conditions
  * @param columns
  * @return such as: String[] columns={"birthday","birthmonth"};
  *         Map<Map<String,Long>,IndexOperator> mp= new
  *         HashMap<Map<String,Long>,IndexOperator>(); Map<String,Long>
  *         mp1=new HashMap<String,Long>(); mp1.put("birthday", 1978L);
  *         mp.put(mp1,IndexOperator.LT); mp1=new HashMap<String,Long>();
  *         mp1.put("birthmonth", 6L); mp.put(mp1, IndexOperator.EQ);
  *         JSONObject
  *         json=this.cassandraDaoTemplate.getMultiByCompareColumn(
  *         "userInfo",mp,columns); logger.debug("json="+json);
  *         多条件时必须至少有一个等于的条件，不然报错
  */
 public JSONObject getMultiByCompareColumn(String cloumFamilyName, Map<Map<String, Long>, IndexOperator> conditions,
   String... columns) {

  IndexedSlicesQuery<String, String, Long> indexedSlicesQuery = this.hectorTemplateImpl.createIndexSlicesQuery(
    stringSerializer, stringSerializer, longSerializer);
  for (Map.Entry<Map<String, Long>, IndexOperator> map : conditions.entrySet()) {
   Map<String, Long> dataMap = map.getKey();
   IndexOperator opt = map.getValue();

   for (Map.Entry<String, Long> temp1 : dataMap.entrySet()) {
    String optCloumn = temp1.getKey();
    Long optValue = temp1.getValue();

    if (IndexOperator.EQ.equals(opt)) {
     indexedSlicesQuery.addEqualsExpression(optCloumn, optValue);
    } else if (IndexOperator.GT.equals(opt)) {
     indexedSlicesQuery.addGtExpression(optCloumn, optValue);
    } else if (IndexOperator.GTE.equals(opt)) {
     indexedSlicesQuery.addGteExpression(optCloumn, optValue);
    } else if (IndexOperator.LT.equals(opt)) {
     indexedSlicesQuery.addLtExpression(optCloumn, optValue);
    } else if (IndexOperator.LTE.equals(opt)) {
     indexedSlicesQuery.addLteExpression(optCloumn, optValue);
    }
   }

  }

  indexedSlicesQuery.setColumnNames(columns);
  indexedSlicesQuery.setColumnFamily(cloumFamilyName);
  indexedSlicesQuery.setStartKey("");

  QueryResult<OrderedRows<String, String, Long>> result = indexedSlicesQuery.execute();

  OrderedRows<String, String, Long> orderedRows = result.get();

  logger.debug("orderedRows=" + orderedRows);
  // logger.debug("result json: {}",jo.toString());
  JSONObject rowsData = orderRowsLongToJSON(orderedRows, -1);
  logger.debug("Contents of rows: \n" + rowsData);

  return rowsData;

 }

 /**
  * 向columnfamily中添加记录，适合于rowkey自己定义,多行一起插入数据库
  * 
  * @param cloumFamilyName
  * @param datas格式为
  *            ：List<Map<rowKey,Map<column_name,column_value>>>
  */
 public void insertMultiCloumAndRows(String cloumFamilyName, List<Map<String, Map<String, Object>>> datas) {

  Mutator<String> mutator = this.hectorTemplateImpl.createMutator(stringSerializer);
//  logger.info("cloumFamilyName:" + cloumFamilyName + " data:" + datas.toString());
  String key = "";
  Map<String, Object> value;

  for (Map<String, Map<String, Object>> map : datas) {
   for (Map.Entry<String, Map<String, Object>> temp : map.entrySet()) {
    key = temp.getKey();
    value = temp.getValue();
    for (Map.Entry<String, Object> temp1 : value.entrySet()) {
     String column = temp1.getKey();
     Object cvalue = temp1.getValue();

     if (cvalue != null && cvalue instanceof String) {
      mutator.addInsertion(key, cloumFamilyName, HFactory.createStringColumn(column, (String) cvalue));
     } else if (cvalue instanceof Long) {
      mutator.addInsertion(key, cloumFamilyName, HFactory.createColumn(column, (Long) cvalue));
     }
    }
   }
  }
  mutator.execute();

 }

 /**
  * 向columnfamily中添加记录，适合于rowkey的数据也作为一列插入数据表中
  * 
  * @param cloumFamilyName
  * @param rowKey
  * @param datas格式
  *            ：Map<rowKey_name/column_name,rowKey_value/column_value>
  * 注意：与下一个方法的区别：String key = datas.get(rowKey);
  */
 public void insertMultiCloumAndSingleRowForRowKey(String cloumFamilyName, String rowKey, Map<String, String> datas) {

  Mutator<String> mutator = this.hectorTemplateImpl.createMutator(stringSerializer);
  logger.debug("cloumFamilyName:" + cloumFamilyName + " data:" + datas.toString());

  String key = datas.get(rowKey);
  for (Map.Entry<String, String> temp : datas.entrySet()) {

   mutator.addInsertion(key, cloumFamilyName, HFactory.createStringColumn(temp.getKey(), temp.getValue()));
  }
  mutator.execute();
 }
 
 /**
  * 向columnfamily中添加记录，适合于rowkey的数据也作为一列插入数据表中
  * 
  * @param cloumFamilyName
  * @param rowKey
  * @param datas格式
  *            ：Map<rowKey_name/column_name,rowKey_value/column_value>
  *           
  */
 public void insertMultiCloumAndSingleRow(String cloumFamilyName, String rowKey, Map<String, String> datas) {

  Mutator<String> mutator = this.hectorTemplateImpl.createMutator(stringSerializer);
  logger.debug("cloumFamilyName:" + cloumFamilyName + " data:" + datas.toString());

  for (Map.Entry<String, String> temp : datas.entrySet()) {

   mutator.addInsertion(rowKey, cloumFamilyName, HFactory.createStringColumn(temp.getKey(), temp.getValue()));
  }
  mutator.execute();
 }

 /**
  * 向columnfamily中添加一条记录，其中columnFamily,rowkey,column(column_name),value(
  * column_value)自己指定入值
  * 
  * @param columnFamily
  * @param rowKey
  * @param column
  * @param value
  *            such
  *            as:insertSingleColumnAndSingleRow("custGroups","13611112226",
  *            "custId", "1007");
  */
 public void insertSingleColumnAndSingleRow(String columnFamily, String rowKey, String column, String value) {

  Mutator<String> mutator = this.hectorTemplateImpl.createMutator(stringSerializer);
  mutator.insert(rowKey, columnFamily, HFactory.createStringColumn(column, value));
 }

 public String getSingleSuperColumn(String columnFamily, String rowKey, String superColumn, String column) {
  SuperColumnQuery<String, String, String, String> q = hectorTemplateImpl.createSuperColumnQuery(
    stringSerializer, stringSerializer, stringSerializer, stringSerializer);
  QueryResult<HSuperColumn<String, String, String>> r = q.setColumnFamily(columnFamily).setKey(rowKey)
    .setSuperName(superColumn).execute();
  HSuperColumn<String, String, String> sc = r.get();
  if (sc != null && sc.getSize() > 0) {
   HColumn<String, String> hc = sc.getSubColumnByName(column);
   return hc == null ? null : hc.getValue();
  }
  return null;
 }

 /**
  * 通过columnfamily,index对应的column信息和要查看的列数
  * 
  * @param columnsFamily
  *            ：columnFamily_name
  * @param conditions
  *            :Map<"column_name","column_value">(其中必须有index的列存在，要不报错)
  * @param columns
  *            ：要展示的列数
  * @return 
  *         格式：{"rowKey_value":{"column_name1":"column_value1","column_name2":
  *         "column_value2"}}
  * @example 例子： getEQByMultiColumnAndRange("userInfo", mp,
  *          4)=>{"200":{"fav_fee"
  *          :"30","new_busicode":"4","old_busicode":"3M","op_code":"200"}}
  *          getEQByMultiColumnAndRange("userInfo", mp,
  *          3)=>{"200":{"fav_fee":
  *          "30","new_busicode":"4","old_busicode":"3M"}}
  *          getEQByMultiColumnAndRange("userInfo", mp,
  *          2)=>{"200":{"fav_fee":"30","new_busicode":"4"}}
  */
 public JSONObject getEQByMultiColumnAndRange(String columnsFamily, Map<String, String> conditions, int columns) {

  IndexedSlicesQuery<String, String, String> indexedSlicesQuery = HFactory.createIndexedSlicesQuery(
    this.hectorTemplateImpl.getKeyspace(), stringSerializer, stringSerializer, stringSerializer);

  for (Map.Entry<String, String> map : conditions.entrySet()) {

   indexedSlicesQuery.addEqualsExpression(map.getKey(), map.getValue());
  }

  indexedSlicesQuery.setColumnFamily(columnsFamily);
  indexedSlicesQuery.setStartKey("");
  indexedSlicesQuery.setRange(null, null, false, columns);
  QueryResult<OrderedRows<String, String, String>> result = indexedSlicesQuery.execute();
  // List<Row<String, String, String>> rows = result.get().getList();
  Rows<String, String, String> orderedRows = result.get();
  // logger.debug("result json: {}",jo.toString());
  JSONObject rowsData = orderRowsToJSON(orderedRows);

  return rowsData;

 }

 /**
  * @since 通过columnFamily,rowkey,和要查找的columnName，找到columnValue
  * @param columnFamily
  * @param rowKey
  * @param columnName
  * @return String
  * @example getSingleByKeyAndColumnName("custGroupInfo", "1234567890",
  *          "cust_group_id")=>"123456789"
  */

 public String getSingleByKeyAndColumnName(String columnFamily, String rowKey, String columnName) {

  String res = "";
  try {
   if (rowKey == null || rowKey.equals(""))
    return "";
   logger.debug("columnFamily=" + columnFamily + " rowKey=" + rowKey + " columnName=" + columnName);
   logger.debug("hectorTemplateImpl=" + this.hectorTemplateImpl);
   // ColumnQuery<String, String, String> q =
   // HFactory.createColumnQuery(
   // this.hectorTemplateImpl.getKeyspace(), stringSerializer,
   // stringSerializer, stringSerializer);
   ColumnQuery<String, String, String> q = this.hectorTemplateImpl.createColumnQuery(stringSerializer);
   QueryResult<HColumn<String, String>> r = q.setKey(rowKey).setName(columnName).setColumnFamily(columnFamily)
     .execute();
   HColumn<String, String> c = r.get();
   // System.out.println(r.toString()+"+"+c.toString());
   res = c != null ? c.getValue() : null;

  } catch (HectorException e) {
   logger.error(e.getMessage());
  }
  return res;

 }

 /**
  * 通过columnFamily和多个rowKey，查找columnNames对应的columnValues
  * 
  * @param columnFamily
  *            :columnFamilyName
  * @param columnNames
  *            :columnNames
  * @param rowKeys
  *            :同一个columnFamily中的rowKey的Arrays集合,
  * @return JSONObject 格式：
  *         {"rowkey1":{"columnName1":"columnValue1"},"rowkey2"
  *         :{"columnName2"
  *         :"columnValue2"},"rowkey3":{"columnName3":"columnValue3"}}
  * @Example getMultiByKeysAndColumns("custGroupInfo", columnNames, rowKeys)
  *          =>{"123":{"cust_group_id":"444444"},"1234567890":{
  *          "cust_group_id":"123456789"},"13591235568":{"cust_group_id":
  *          "201207051003808578"}}
  */
 public JSONObject getMultiByKeysAndColumns(String columnFamily, String[] columnNames, String[] rowKeys) {

  MultigetSliceQuery<String, String, String> q = this.hectorTemplateImpl.createMultigetSliceQuery(
    stringSerializer, stringSerializer, stringSerializer);
  q.setColumnFamily(columnFamily);
  q.setKeys(rowKeys);
  q.setColumnNames(columnNames);

  QueryResult<Rows<String, String, String>> r = q.execute();
  Rows<String, String, String> rows = r.get();
  logger.debug("rows=" + rows);
  // System.out.println("rows++:"+rows);

  JSONObject jsonData = orderRowsToJSON(rows);

  return jsonData;
 }

 
 /**
  * 根据columnfamily、rowKey集合和展示列数，查找相应记录
  * 
  * @param cloumFamilyName
  * @param range
  *            ：结果中展示的列数
  * @param rowKeys
  *            ：rowKey集合
  * @return JSONObject
  *         格式：{"rowKey1":{"column_name1":"column_value1","column_name2"
  *         :"column_value2"
  *         }(此处展示出的column_name和column_value的数量与方法中的参数range是对应的),
  *         "rowKey2":{"column_name2"
  *         :"column_value2","column_name3":"column_value3"} }
  * @example: getMultiByKeysAndRange("userInfo", 3,
  *           rowKeys)=>{"100":{"fav_fee"
  *           :"20","new_busicode":"2","old_busicode"
  *           :"1M"},"300":{"fav_fee":"40"
  *           ,"new_busicode":"6","old_busicode":"5M"}}
  *           getMultiByKeysAndRange("userInfo", 2,
  *           rowKeys)=>{"100":{"fav_fee"
  *           :"20","new_busicode":"2"},"300":{"fav_fee"
  *           :"40","new_busicode":"6"}}
  */
 public JSONObject getMultiByKeysAndRange(String cloumFamilyName, int range, String... rowKeys) {

  MultigetSliceQuery<String, String, String> multigetSliceQuery = HFactory.createMultigetSliceQuery(
    this.hectorTemplateImpl.getKeyspace(), stringSerializer, stringSerializer, stringSerializer);
  multigetSliceQuery.setColumnFamily(cloumFamilyName);
  multigetSliceQuery.setKeys(rowKeys);

  // set null range for empty byte[] on the underlying predicate
  multigetSliceQuery.setRange(null, null, false, range);

  QueryResult<Rows<String, String, String>> result = multigetSliceQuery.execute();
  Rows<String, String, String> orderedRows = result.get();
  logger.debug("rows:" + orderedRows);

  JSONObject rowsData = orderRowsToJSON(orderedRows);
  logger.debug("Contents of rows: \n" + rowsData);

  return rowsData;
 }

 // public JSONObject getPaginateRangeSlices(String cloumFamilyName, int
 // range, int start,
 // int end) {
 //
 // RangeSlicesQuery<String, String, String> rangeSlicesQuery =
 // this.hectorTemplateImpl
 // .createRangeSlicesQuery(stringSerializer, stringSerializer,
 // stringSerializer);
 //
 // rangeSlicesQuery.setColumnFamily(cloumFamilyName);
 // rangeSlicesQuery.setKeys("", "");
 // rangeSlicesQuery.setRange("", "", false, range);
 // //rangeSlicesQuery.setColumnNames(columnNames);
 //
 // rangeSlicesQuery.setRowCount(end-start);
 // QueryResult<OrderedRows<String, String, String>> result =
 // rangeSlicesQuery
 // .execute();
 //
 // OrderedRows<String, String, String> orderedRows = result.get();
 // logger.debug("end-start:"+(end-start)+" orderedRows="+orderedRows);
 // // JSONObject res=orderedRows JSONObject();
 // JSONObject rowsData=new JSONObject();
 // JSONObject rowsData1=new JSONObject();
 // if(start<end-start){
 // rowsData1 = orderRowsToJSON(orderedRows, end - start);
 // }
 // logger.debug("rowsData1="+rowsData1);
 // Row<String, String, String> lastRow = orderedRows.peekLast();
 // logger.debug("lastRow="+rowsData1);
 //
 //
 //
 // rangeSlicesQuery.setKeys(lastRow.getKey(), "");
 // orderedRows = rangeSlicesQuery.execute().get();
 // logger.debug("orderedRows2="+orderedRows);
 // JSONObject rowsData2 = orderRowsToJSON(orderedRows, end - start);
 //
 // if(rowsData1.size()>0){
 // rowsData.putAll(rowsData1);
 // }
 // if(rowsData2.size()>0){
 // rowsData.putAll(rowsData2);
 // }
 //
 // //String temp=rowsData1.toJSONString()+rowsData2.toJSONString();
 //
 // return rowsData;
 //
 // }

 /**
  * 通过columnFamilyname、展示的列数、其实行、终止行查找相应记录
  * 
  * @param cloumFamilyName
  * @param range
  *            ：结果中展示的列数
  * @param start
  * @param end
  * @return JSONObject
  *         格式：{"rowkey1":{"column_name1":"column_value1","column_name2"
  *         :"column_value2"},
  *         "rowkey2":{"column_name2":"column_value2","column_name2"
  *         :"column_value2"} }
  * @example 
  *          getPaginateRangeSlices("userInfo",1,3,4)=>{"300":{"fav_fee":"40"}
  *          ,"400":{"fav_fee":"P"}}
  *          getPaginateRangeSlices("userInfo",1,2,4)=
  *          >{"100":{"fav_fee":"20"}
  *          ,"300":{"fav_fee":"40"},"400":{"fav_fee":"P"}}
  *          getPaginateRangeSlices
  *          ("userInfo",1,1,4)=>{"100":{"fav_fee":"20"}
  *          ,"200":{"fav_fee":"30"
  *          },"300":{"fav_fee":"40"},"400":{"fav_fee":"P"}}
  *          getPaginateRangeSlices
  *          ("userInfo",2,1,4)=>{"100":{"fav_fee":"20",
  *          "new_busicode":"2"},"200"
  *          :{"fav_fee":"30","new_busicode":"4"},"300"
  *          :{"fav_fee":"40","new_busicode"
  *          :"6"},"400":{"fav_fee":"P","new_busicode":"7"}}
  */
 public JSONObject getPaginateRangeSlices(String cloumFamilyName, int range, int start, int end) {

  if (start >= end)
   return null;

  RangeSlicesQuery<String, String, String> rangeSlicesQuery = this.hectorTemplateImpl.createRangeSlicesQuery(
    stringSerializer, stringSerializer, stringSerializer);

  rangeSlicesQuery.setColumnFamily(cloumFamilyName);
  rangeSlicesQuery.setKeys("", "");
  rangeSlicesQuery.setRange("", "", false, range);

  rangeSlicesQuery.setRowCount(end);
  QueryResult<OrderedRows<String, String, String>> result = rangeSlicesQuery.execute();

  OrderedRows<String, String, String> orderedRows = result.get();
  logger.debug("rows: orderedRows=" + orderedRows);
  // JSONObject res=orderedRows JSONObject();
  JSONObject rowsData = orderRowsToJSON(orderedRows, start, end);

  return rowsData;

 }

 /**
  * 该方法是用来创建keyspace,column family,column_name的。
  * 
  * @param keySpace
  * @param cloumFamilyName
  * @param cf_super
  * @param columnDefinitions
  */
 public void createSchema(String keySpace, String cloumFamilyName, String cf_super,
   BasicColumnDefinition... columnDefinitions) {
  Cluster cluster = this.hectorTemplateImpl.getCluster();
  if (this.hectorTemplateImpl.getCluster().describeKeyspace(keySpace) != null) {
   this.hectorTemplateImpl.getCluster().dropKeyspace(keySpace);
  }

  BasicColumnFamilyDefinition columnFamilyDefinition = new BasicColumnFamilyDefinition();
  columnFamilyDefinition.setKeyspaceName(keySpace);
  columnFamilyDefinition.setName(cloumFamilyName);

  ColumnFamilyDefinition[] columnFamilyDefinitions = new ColumnFamilyDefinition[2];
  for (BasicColumnDefinition columnDefinition : columnDefinitions) {
   columnFamilyDefinition.addColumnDefinition(columnDefinition);
   ColumnFamilyDefinition cfDefStandard = new ThriftCfDef(columnFamilyDefinition);
   columnFamilyDefinitions[0] = cfDefStandard;

  }
  // BasicColumnDefinition columnDefinition = new BasicColumnDefinition();
  // columnDefinition.setName(stringSerializer.toByteBuffer("birthdate"));
  // columnDefinition.setIndexName("birthdate_idx");
  // columnDefinition.setIndexType(ColumnIndexType.KEYS);
  // columnDefinition.setValidationClass(ComparatorType.LONGTYPE.getClassName());

  if (cf_super != null && !cf_super.equals("")) {
   BasicColumnFamilyDefinition superCfDefinition = new BasicColumnFamilyDefinition();
   superCfDefinition.setKeyspaceName(keySpace);
   superCfDefinition.setName(cf_super);
   superCfDefinition.setColumnType(ColumnType.SUPER);
   columnFamilyDefinitions[1] = new ThriftCfDef(superCfDefinition);
  }

  // ColumnFamilyDefinition cfDefStandard = new ThriftCfDef(
  // columnFamilyDefinition);
  // ColumnFamilyDefinition cfDefSuper = new
  // ThriftCfDef(superCfDefinition);

  KeyspaceDefinition keyspaceDefinition = HFactory.createKeyspaceDefinition(keySpace,
    "org.apache.cassandra.locator.SimpleStrategy", 1, Arrays.asList(columnFamilyDefinitions));

  cluster.addKeyspace(keyspaceDefinition);

  // insert some data

  List<KeyspaceDefinition> keyspaces = cluster.describeKeyspaces();
  for (KeyspaceDefinition kd : keyspaces) {
   if (kd.getName().equals(keySpace)) {
    logger.debug("Name: " + kd.getName());
    logger.debug("RF: " + kd.getReplicationFactor());
    logger.debug("strategy class: " + kd.getStrategyClass());
    List<ColumnFamilyDefinition> cfDefs = kd.getCfDefs();
    for (ColumnFamilyDefinition def : cfDefs) {
     logger.debug("  cloumFamilyName Type: " + def.getColumnType());
     logger.debug("  cloumFamilyName Name: " + def.getName());
     logger.debug("  cloumFamilyName Metadata: " + def.getColumnMetadata());
    }

   }
  }
 }

 /**
  * 该方法是将rowkey,column_name,column_value整合在一个JSONObject中
  * 
  * @param orderedRows
  * @param rows
  * @return JSONObject
  *         格式：{{"rowKey":"rowKey值"},{"rowKey值":{"column_name":"column_value"
  *         }}}
  * @example {{"rowKey":"13591235568"},{"13591235568":{"cust_group_id":
  *          "201207051003808578"}}}
  * 
  */
 // protected JSONObject orderRowsToJSON(
 // Rows<String, String, String> orderedRows, int rows) {
 // JSONObject jo = new JSONObject();
 // JSONObject jo1 = new JSONObject();
 // int i = 0;
 // for (Row<String, String, String> row : orderedRows) {
 // jo1=new JSONObject();
 // if (i < rows || rows == -1) {
 //
 // for (HColumn<String, String> c : row.getColumnSlice()
 // .getColumns()) {
 //
 // jo1.put(c.getName(), c.getValue());
 // logger.debug(c.getName() + "=" + c.getValue());
 // }
 // jo.put("rowKey", row.getKey());
 // jo.put(row.getKey(), jo1);
 // }
 // i++;
 // }
 //
 // return jo;
 // }

 protected JSONObject orderRowsToJSON(Rows<String, String, String> orderedRows) {
  JSONObject jo = new JSONObject();
  JSONObject jo1 = new JSONObject();
  int i = 0;
  for (Row<String, String, String> row : orderedRows) {
   jo1 = new JSONObject();

   for (HColumn<String, String> c : row.getColumnSlice().getColumns()) {

    jo1.put(c.getName(), c.getValue());
    logger.debug(c.getName() + "=" + c.getValue());
   }
   // jo.put("rowKey" + i, row.getKey());
   jo.put(row.getKey(), jo1);
   i++;
  }

  return jo;
 }

 /**
  * 
  * @param orderedRows
  * @param start
  * @param rows
  * @return
  */
 protected JSONObject orderRowsToJSON(Rows<String, String, String> orderedRows, int start, int rows) {
  JSONObject jo = new JSONObject();
  JSONObject jo1 = new JSONObject();
  int i = 0;
  for (Row<String, String, String> row : orderedRows) {
   jo1 = new JSONObject();
   if (i < rows && i >= start - 1 || rows == -1) {

    for (HColumn<String, String> c : row.getColumnSlice().getColumns()) {

     jo1.put(c.getName(), c.getValue());
     // logger.debug(c.getName() + "=" + c.getValue());
    }
    // jo.put("rowKey" + i, row.getKey());
    jo.put(row.getKey(), jo1);
   }
   i++;
  }

  return jo;
 }

 /**
  * 该方法是将rowkey,column_name,column_value整合在一个JSONObject中
  * 
  * @param orderedRows
  * @param rows
  * @return JSONObject 格式：{"rowKey值":{"column_name":"column_value"}}
  * @example {"13591235568":{"cust_group_id":"201207051003808578"}}
  * 
  */
 protected JSONObject orderRowsLongToJSON(Rows<String, String, Long> orderedRows, int rows) {
  JSONObject jo = new JSONObject();
  JSONObject jo1 = new JSONObject();
  int i = 0;
  for (Row<String, String, Long> row : orderedRows) {
   i++;
   jo1 = new JSONObject();
   if (i < rows || rows == -1) {
    for (HColumn<String, Long> c : row.getColumnSlice().getColumns()) {
     jo1.put(c.getName(), c.getValue());
     logger.debug(c.getName() + "=" + c.getValue());
    }
    jo.put(row.getKey(), jo1);
   }
  }

  return jo;
 }

 /**
  * 该方法的作用是删除某一个rowkey下columnname列
  * 
  * @param columnFamily
  * @param columnName
  * @param rowKey
  * @example deleteMulti("userInfo", "fav_fee", "400");
  */
 public void deleteMulti(String columnFamily, String columnName, String rowKey) {
  Mutator<String> m = this.hectorTemplateImpl.createMutator(stringSerializer);
  m.addDeletion(rowKey, columnFamily, columnName, stringSerializer);
  m.execute();
 }

 /**
  * 该方法的作用是删除某一个rowkey下columnname列
  * 
  * @param columnFamily
  * @param columnName
  * @param rowKey
  * @example deleteSingle("userInfo", "new_busicode", "300");
  */
 public void deleteSingle(String columnFamily, String columnName, String rowKey) {
  Mutator<String> m = this.hectorTemplateImpl.createMutator(stringSerializer);

  m.delete(rowKey, columnFamily, columnName, stringSerializer);
 }

 /**
  * 该方法的作用是向columnfamily中插入超级列
  * 
  * @param cloumFamilyName
  * @param rowKey
  * @param cf_super
  * @param columnName
  * @param value
  */
 @SuppressWarnings("unchecked")
 public void inserSuperColumn(String cloumFamilyName, String rowKey, String cf_super, String columnName, String value) {
  Mutator<String> mutator = this.hectorTemplateImpl.createMutator(stringSerializer);
  mutator.insert(rowKey, cloumFamilyName, HFactory.createSuperColumn(cf_super,
    Arrays.asList(HFactory.createStringColumn(columnName, value)), stringSerializer, stringSerializer,
    stringSerializer));
  // SuperColumnQuery<String, String, String, String> superColumnQuery =
  // HFactory
  // .createSuperColumnQuery(this.hectorTemplateImpl.getKeyspace(),
  // stringSerializer, stringSerializer, stringSerializer,
  // stringSerializer);
  // superColumnQuery.setColumnFamily(cloumFamilyName).setKey(rowKey)
  // .setSuperName(cf_super);
  //
  // QueryResult<HSuperColumn<String, String, String>> result =
  // superColumnQuery.execute();
  // logger.debug("Read HSuperColumn from cassandra: " + result.get());
  // logger.debug("Verify on CLI with:  get Keyspace1.Super1['billing']['jsmith'] ");

 }

 /**
  * 该方法的作用是向column family中的某一个rowkey中插入多个列
  * 
  * @param columnFamily
  * @param rowKey
  * @param columns
  */
 public void insertMultiCloumnByRowKey(String columnFamily, String rowKey, Map<String, Object> columns) {
  ColumnFamilyTemplate<String, String> template = new ThriftColumnFamilyTemplate<String, String>(
    this.hectorTemplateImpl.getKeyspace(), columnFamily, stringSerializer, stringSerializer);

  ColumnFamilyUpdater<String, String> updater = template.createUpdater(rowKey);

  for (Map.Entry<String, Object> map : columns.entrySet()) {
   String column = map.getKey();
   Object value = map.getValue();
   if (value instanceof String) {
    updater.setString(column, (String) value);
   } else if (value instanceof Long) {
    updater.setLong(column, (Long) value);
   } else if (value instanceof Date) {
    updater.setDate(column, (Date) value);
   } else if (value instanceof Long) {
    updater.setLong(column, (Long) value);
   } else if (value instanceof UUID) {
    updater.setUUID(column, (UUID) value);
   } else if (value instanceof Float) {
    updater.setFloat(column, (Float) value);
   } else if (value instanceof Integer) {
    updater.setInteger(column, (Integer) value);
   } else if (value instanceof Double) {
    updater.setDouble(column, (Double) value);
   }
  }

  template.update(updater);

  // template.addColumn(column, stringSerializer);
  // ColumnFamilyResult<String,String> wrapper =
  // template.queryColumns(rowKey);
  // logger.debug(" rowKey:{} value:{}",rowKey,wrapper.getString(column));

 }

 /**
  * 该方法是通过多个rowkey查询某个column_name对应的cloumn_value组成的集合
  * 
  * @param columnFamily
  * @param column
  * @param rowKeys
  * @return JSONOjbect
  *         格式：{"rowkey1":"column_value1","rowkey2":"column_value2"}
  * @example {"13591235568":"201207051003808578","3333":"44444444444"}
  */
 public JSONObject querySingleColumnByMultiRowKeys(String columnFamily, final String column, String... rowKeys) {
  ColumnFamilyTemplate<String, String> template = new ThriftColumnFamilyTemplate<String, String>(
    this.hectorTemplateImpl.getKeyspace(), columnFamily, stringSerializer, stringSerializer);

  MappedColumnFamilyResult<String, String, String> result = template.queryColumns(Arrays.asList(rowKeys),
    new ColumnFamilyRowMapper<String, String, String>() {
     public String mapRow(ColumnFamilyResult<String, String> results) {

      return results.getString(column);
     }
    });

  JSONObject jo = new JSONObject();
  String rowKey = "";
  String value = "";
  rowKey = result.getKey();
  value = result.getRow();
  jo.put(rowKey, value);

  boolean flag = result.hasResults();
  while (flag && result.hasNext()) {
   result.next();
   rowKey = result.getKey();
   value = result.getRow();
   jo.put(rowKey, value);
  }

  return jo;
 }

 /**
  * 该方法是删除rowkey集合对应的column列
  * 
  * @param columnFamily
  * @param keys
  * @param columnNames
  */
 public void deleteMultiByColumnAndKeys(String columnFamily, String[] keys, String[] columnNames) {
  Mutator<String> m = this.hectorTemplateImpl.createMutator(stringSerializer);
  for (String key : keys) {
   for (String columnName : columnNames) {
    m.addDeletion(key, columnFamily, columnName, stringSerializer);
   }
  }
  m.execute();
 }

 /**
  * 通过column
  * family名和rowkey查找，结果格式为：{rowkey:{{name:value,name:value,name:value}}}
  * 
  * @param colfamily
  *            :Cassandra数据库的columnfamily名
  * @param keys
  *            ：Cassandra数据库中columnfamily里面的rowkey
  * @return JSONObject 格式：
  *         {"rowkey1":{"column_name1":"column_value1","column_name2"
  *         :"column_value2"},
  *         "rowkey2":"{"column_name1":"column_value1","column_name2
  *         ":"column_value2"} }
  * @throws Exception
  * @example {"13591235568":{"cust_group_id":"201207051003808578"}}
  */

 public JSONObject query_by_key(String colfamily, String... keys) throws Exception {
  Keyspace keyspace = this.hectorTemplateImpl.getKeyspace();
  //synchronized (keyspace) {
   // ColumnParent columnParent = new ColumnParent(colfamily);

   MultigetSliceQuery<String, String, String> multigetSliceQuery = HFactory.createMultigetSliceQuery(keyspace,
     stringSerializer, stringSerializer, stringSerializer);
   multigetSliceQuery.setColumnFamily(colfamily);
   multigetSliceQuery.setKeys(keys);
   multigetSliceQuery.setRange(null, null, false, 50);
   QueryResult<Rows<String, String, String>> result = multigetSliceQuery.execute();
   Rows<String, String, String> orderedRows = result.get();
   JSONObject ret = new JSONObject();
   for (Row<String, String, String> r : orderedRows) {
    JSONObject jr = new JSONObject();
    for (HColumn<String, String> c : r.getColumnSlice().getColumns()) {
     jr.put(c.getName(), c.getValue());
    }
    ret.put(r.getKey(), jr);
   }
   return ret;
  }
 //}

 /**
  * 通过columnfamily、其他字段名和字段值，找到整条记录
  * 
  * @param colfamily
  * @param conds
  * @return 
  *         格式:{"入参所在的行的rowkey":{"column_name1":"column_value1","column_name2"
  *         :"column_value2"}(查找出的整条记录)
  * @throws Exception
  * @example 
  *          {"300":{"fav_fee":"40","new_busicode":"6","old_busicode":"5M","op_code"
  *          :"300"}}
  */

 public JSONObject query_by_idx(String colfamily, String... conds) throws Exception {
  Keyspace keyspace = this.hectorTemplateImpl.getKeyspace();
  //synchronized (keyspace) {
   IndexedSlicesQuery<String, String, String> qry = HFactory.createIndexedSlicesQuery(keyspace,
     stringSerializer, stringSerializer, stringSerializer);
   for (int i = 0; i < conds.length / 2; i++)
    qry.addEqualsExpression(conds[i * 2], conds[i * 2 + 1]);
   qry.setRange(null, null, false, 20);
   qry.setColumnFamily(colfamily);
   qry.setStartKey("");

   QueryResult<OrderedRows<String, String, String>> result = qry.execute();
   JSONObject ret = new JSONObject();
   for (Row<String, String, String> row : result.get().getList()) {
    JSONObject jr = new JSONObject();
    for (HColumn<String, String> c : row.getColumnSlice().getColumns()) {
     jr.put(c.getName(), c.getValue());
    }
    ret.put(row.getKey(), jr);
   }
   return ret;
  }
 
 /**
  * 通过columnfamily、columnName1和columnValue1查询出columnName2对应的columnValue>columnValue2,
  * 且columnName3对应的columnValue<columnValue3的记录，返回columnName4对应的columnName和columnValue值
  * @param colfamily------columnFamily
  * @param columnName1----Index columnName     
  * @param columnValue1---Index columnName对应的值
  * @param columnName2----筛选条件 columnName
  * @param columnValue2---筛选条件 columnName对应的值(>=)
  * @param columnName3----筛选条件 columnName
  * @param columnValue3---筛选条件 columnName对应的值(<)
  * @param columnName4----返回的columnName
  * @param rowCount-------返回的行数
  * @return {rowkey:{columnName4:columnValue}}
  * @throws Exception
  */
 public JSONObject query_by_id(String colfamily, String columnName1,String columnValue1,String columnName2,
	String columnValue2,String columnName3,String columnValue3,String columnName4,int rowCount) throws Exception{
	  Keyspace keyspace = this.hectorTemplateImpl.getKeyspace();
	  IndexedSlicesQuery<String, String, String> qry = HFactory.createIndexedSlicesQuery(keyspace,
	        stringSerializer, stringSerializer, stringSerializer);
	  qry.addEqualsExpression(columnName1, columnValue1);
	  qry.addGteExpression(columnName2, columnValue2);//该方法表示">="
	  qry.addLtExpression(columnName3, columnValue3);//该方法表示"<"
	  qry.setRange(columnName4, columnName4, false, 1);//1表示返回的列数
	  qry.setColumnFamily(colfamily);
	  qry.setStartKey("");
	  qry.setRowCount(rowCount);
	  QueryResult<OrderedRows<String, String, String>> result = qry.execute();
	  JSONObject ret = new JSONObject();
	  for (Row<String, String, String> row : result.get().getList()) {
	    JSONObject jr = new JSONObject();
	    for (HColumn<String, String> c : row.getColumnSlice().getColumns()) {
	        jr.put(c.getName(), c.getValue());
	    }
	    ret.put(row.getKey(), jr);
	  }
	  return ret;
 }
 
 /**
  * 
  * @Description: 获取rowkey对应的column信息，针对CounterColumn
  * @param @param colFamily
  * @param @param rowKey
  * @param @return   
  * @return JSONObject  
  * @throws
  * @author zhaiwt
  * @date Apr 1, 2015
  * @version V1.0
  * 修改时间    修改人    实现功能
  */
 public JSONObject queryCounter_by_key(String colFamily, String rowKey) {
	 Keyspace keyspace = this.hectorTemplateImpl.getKeyspace();
	 MultigetSliceCounterQuery<String, String> q =HFactory.createMultigetSliceCounterQuery(keyspace, stringSerializer, stringSerializer);
		  q.setColumnFamily(colFamily);
		  q.setKeys(rowKey);
		  q.setRange(null, null, false, 50);
	QueryResult<CounterRows<String, String>> result= q.execute();
  
	CounterRows<String, String> orderedRows = result.get();
	JSONObject ret = new JSONObject();
	for (CounterRow<String, String> r : orderedRows) {
	    JSONObject jr = new JSONObject();
	    for (HCounterColumn<String> c : r.getColumnSlice().getColumns()) {
	    	jr.put(c.getName(), c.getValue());
	    }
	    ret.put(r.getKey(), jr);
	}
   return ret;
 }
 
 /**
 *	truncate columFamilyName
 * @param cloumFamilyName
 * @author jiaxla  Jun 10, 2014
 */
public void truncate(String columFamilyName){
	  Cluster cluster = this.hectorTemplateImpl.getCluster();
	  String keySpaceName=this.hectorTemplateImpl.getKeyspaceName();
	  System.out.println("keySpaceName: "+keySpaceName +" columFamilyName: "+columFamilyName);
	  if (this.hectorTemplateImpl.getCluster().describeKeyspace(keySpaceName) != null) {
		  cluster.truncate(keySpaceName, columFamilyName);
//		  cluster.dropColumnFamily(keySpaceName, columFamilyName);
	  }
 }

 /**
  * @param hectorTemplateImpl
  *            the hectorTemplateImpl to set
  */
 public void setHectorTemplateImpl(HectorTemplateImpl hectorTemplateImpl) {
  this.hectorTemplateImpl = hectorTemplateImpl;
 }

 /**
  * @return the hectorTemplateImpl
  */
 public HectorTemplateImpl getHectorTemplateImpl() {
  return hectorTemplateImpl;
 }

 public void close() {
  this.hectorTemplateImpl.getCluster().getConnectionManager().shutdown();
 }

 public static void main(String[] args) throws Exception {

  JSONObject jsons = new JSONObject();
//  String str = "{\"cust_group_id\":12345}";
//  JSONObject j = jsons.parseObject(str);
//  System.out.println(j.toString());

//  String s = j.getString("cust_group_id");
  CopyOfCassandraUtil demoDao = (CopyOfCassandraUtil) ConfigBeanFactory.getBean("cassandraUtil");
  System.out.println("demoDao:"+demoDao);
  demoDao.deleteMultiByColumnAndKeys("mk_phone_info", new String[]{"18803592324"}, new String[]{"id_no","phone_no"});
//  String json = demoDao.getSingleByKeyAndColumnName("custGroupInfo", "13591235568", "cust_group_id");
  // String[] keys = {"3333","123678"};
  // String[] columnNames = {"cust_group_id"};
  // demoDao.deleteMultiByColumnAndKeys("custGroupInfo", keys,
  // columnNames);

  // String[] rowkeys = { "3333", "13591235568"};
  // JSONObject json =
  // demoDao.querySingleColumnByMultiRowKeys("custGroupInfo",
  // "cust_group_id", rowkeys);

  // Map<String, Object> columns = new HashMap<String, Object>();
  // String rowKey = "3333";
  // columns.put("cust_group_id", "44444444444");
  // demoDao.insertMultiCloumnByRowKey("custGroupInfo", rowKey, columns);

  // demoDao.deleteSingle("userInfo", "new_busicode", "300");

  // JSONObject json =demoDao.getPaginateRangeSlices("userInfo",1,2,4);

  // String[] rowKeys = { "300","100",};
  // JSONObject json =demoDao.getMultiByKeysAndRange("userInfo", 2,
  // rowKeys);

  // String[] rowKeys = { "1234567890","123", "13591235568" };
  // String[] columnNames = { "cust_group_id","cust_group_id",
  // "cust_group_id" };
  // JSONObject json = demoDao.getMultiByKeysAndColumns("custGroupInfo",
  // columnNames, rowKeys);

  // String json = demoDao.getSingleByKeyAndColumnName("custGroupInfo",
  // "1234567899", "cust_group_id");

  // Map<String, String> mp = new HashMap<String, String>();
  // mp.put("old_busicode", "3M");
  // mp.put("new_busicode", "4");
  // JSONObject json = demoDao.getEQByMultiColumnAndRange("userInfo", mp,
  // 3);

  // demoDao.insertSingleColumnAndSingleRow("custGroupInfo", "123",
  // "cust_group_id", "444444");
//  long startTime = System.currentTimeMillis();
//  Map<String, String> datas = new HashMap<String, String>();
//  String rowKey = "156";
//  datas.put("156", "1000");
//  datas.put("new_fee", "123678");
//  datas.put("new_fee1", "12367");
//  datas.put("new_fee2", "1236");
//  datas.put("new_fee3", "123");
//  demoDao.insertMultiCloumAndSingleRowForRowKey("test", rowKey, datas);
//  long endTime = System.currentTimeMillis();
//  System.out.println("cli共耗时："+(endTime - startTime));
//   long startTime = System.currentTimeMillis();
//   Map<String, String> datas = new HashMap<String, String>();
//   String rowKey = "156";
//   datas.put("new_fee", "123678");
//   datas.put("new_fee1", "12367");
//   datas.put("new_fee2", "1236");
//   datas.put("new_fee3", "123");
//   demoDao.insertMultiCloumAndSingleRow("test", rowKey, datas);
//   long endTime = System.currentTimeMillis();
//   System.out.println("cli共耗时："+(endTime - startTime));
//   List<Map<String, Map<String, Object>>> datas = new ArrayList<Map<String, Map<String, Object>>>();
//   Map<String, Map<String, Object>> datass = new HashMap<String,
//   Map<String, Object>>();
//   Map<String,Object> datasss = new HashMap<String,Object>();
//   datasss.put("cust_group_id", "123456789");
//   datass.put("1234567890", datasss);
//   datas.add(datass);
//   demoDao.insertMultiCloumAndRows("test", datas);

//   JSONObject json= demoDao.query_by_key("test","456");
//   JSONObject jsonString1 = JSONObject.parseObject(json.getString("456"));
   
//   JSONObject json1= demoDao.query_by_key("test","234");
//   JSONObject jsonString2 = JSONObject.parseObject(json1.getString("234"));
//   JSONObject object = new JSONObject();
//   object.putAll(json);
//   object.putAll(json1);
//   System.out.println("fav_fee++:"+object);
//   JSONObject json2= object.parseObject(json1.getString("234"));
//   Set set = json2.keySet();
//   Iterator it = set.iterator();
//   while(it.hasNext()){
//	   String keyString = (String) it.next();
//	   System.out.println("keyString++:"+keyString);
//   }
   //JSONObject json= demoDao.query_by_idx("test","new_fee", "300");
  // "300","old_busicode", "5M","new_busicode", "6");
   //String str =demoDao.getSingleByKeyAndColumnName("test", "123", "new_fee");
  // JSONObject.parseObject(json.getString("300")).getString("fav_fee");
  // .getSingleByKeyAndColumnName("userInfo", "300", "fav_fee");
  // System.out.println(json==null);
  // String
  // pin="<?xml version=\"1.0\" encoding=\"GBK\" standalone=\"no\" ?> <ROOT> <COMMON_INFO> <PROVINCE_GROUP type=\"string\">10017</PROVINCE_GROUP> </COMMON_INFO>"
  // +"<REQUEST_INFO> <PHONE_NO type=\"string\">13591235568</PHONE_NO> <BUSI_ID type=\"string\">201307211000004722</BUSI_ID> </REQUEST_INFO></ROOT>";
  // Map<String,String> map = infoXmlInService(pin);
  // String phone_no=map.get("phoneNo");
  // String servCode = map.get("busiId");
  // System.out.println("phone_no:"+phone_no+"+"+"busiId+"+servCode);
  //System.out.println("fav_fee++:"+(null == json2.getString("ok")));
  //HashMap map = new HashMap();
  //map.put("123", null);
  //System.out.println("map:"+map);
 }
 

 /*
  * 将请求报文中的数据封装成类，并将数据保存到类中
  */
 private static Map<String, String> infoXmlInService(String requestInfoXml) {
  try {
   Document documentXML = DocumentHelper.parseText(requestInfoXml);
   Element root = documentXML.getRootElement();
   // 解析出入报文成对象
   Element requestInfo = root.element("REQUEST_INFO");
   Element common_info = root.element("COMMON_INFO");
   String phoneNo = requestInfo.elementText("PHONE_NO");
   String busiId = requestInfo.elementText("BUSI_ID");
   Map<String, String> map = new HashMap<String, String>();
   map.put("phoneNo", phoneNo);
   map.put("busiId", busiId);
   return map;
  } catch (Exception e) {
   e.printStackTrace();
  }
  return null;
 }
}
