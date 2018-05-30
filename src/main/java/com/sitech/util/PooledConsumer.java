package com.sitech.util;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.pool2.KeyedObjectPool;
import org.apache.commons.pool2.impl.GenericKeyedObjectPool;
import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;

import com.sitech.crmpd.idmm2.client.MessageContext;
import com.sitech.crmpd.idmm2.client.api.Message;
import com.sitech.crmpd.idmm2.client.api.PropertyOption;
import com.sitech.crmpd.idmm2.client.api.PullCode;
import com.sitech.crmpd.idmm2.client.api.ResultCode;
import com.sitech.crmpd.idmm2.client.pool.PooledMessageContextFactory;

public class PooledConsumer {
	
	private String brokerURL;
	private String consumerTopic;
	private String consumerID;
	private int maxTotalPerKey = Integer.valueOf(8);
	private int listSize = Integer.valueOf(10000);
	private static final GenericKeyedObjectPoolConfig config = new GenericKeyedObjectPoolConfig();
	
	
	public PooledConsumer(String brokerURL, String consumerTopic, String consumerID, int maxTotalPerKey) {
		this.brokerURL = brokerURL;
		this.consumerTopic = consumerTopic;
		this.consumerID = consumerID;
		this.maxTotalPerKey = maxTotalPerKey;
	}

	/** 
	 * Create on 2015-7-1 
	 * @author: songxj
	 * @Title: getMessage 
	 * @Description: 消息中间件version2.0 消费者API
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	public String getMessage() {
		String msg = null;
		/*String brokerURL = PropertiesUtil.getProperty("inform.properties", "brokerURL");
		String consumerTopic = PropertiesUtil.getProperty("inform.properties", "consumerTopic");
		String consumerID = PropertiesUtil.getProperty("inform.properties", "consumerID");*/
		final long processingTime = 60;
		config.setMaxTotalPerKey(this.maxTotalPerKey);
		config.setTestOnBorrow(true);
		final KeyedObjectPool<String, MessageContext> pool = new GenericKeyedObjectPool<String, MessageContext>(
				new PooledMessageContextFactory(this.brokerURL, 60000), config);
		try {
			MessageContext context = pool.borrowObject(this.consumerID);
			String lastMessageId = null;
			PullCode code = null;
			String description = "消费成功";
			while (true) {
			final Message message = context.fetch(this.consumerTopic, processingTime,
					lastMessageId, code, description, false);
			final ResultCode resultCode = ResultCode.valueOf(message
					.getProperty(PropertyOption.RESULT_CODE));
			if (resultCode == ResultCode.NO_MORE_MESSAGE) {
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (Exception e) {
				}
				lastMessageId = null;
				code = null;
				description = null;
				//continue;
			}
			msg = message.getContentAsString();
			System.out.println("-----msg----- " + msg);
			//System.out.println(message.getStringProperty(PropertyOption.TOPIC));	//获取生产者主题名称
			lastMessageId = message.getId();
			code = PullCode.COMMIT;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public List getMessageList() {
		List list = new ArrayList();
		String msg = null;
		/*String brokerURL = PropertiesUtil.getProperty("inform.properties", "brokerURL");
		String consumerTopic = PropertiesUtil.getProperty("inform.properties", "consumerTopic");
		String consumerID = PropertiesUtil.getProperty("inform.properties", "consumerID");*/
		final long processingTime = 60;
		config.setMaxTotalPerKey(this.maxTotalPerKey);
		config.setTestOnBorrow(true);
		final KeyedObjectPool<String, MessageContext> pool = new GenericKeyedObjectPool<String, MessageContext>(
				new PooledMessageContextFactory(this.brokerURL, 60000), config);
		try {
			MessageContext context = pool.borrowObject(this.consumerID);
			String lastMessageId = null;
			PullCode code = null;
			String description = "消费成功";
			int i = 0;
			while (i <= this.listSize) {
				
				final Message message = context.fetch(this.consumerTopic, processingTime,
					lastMessageId, code, description, false);
				final ResultCode resultCode = ResultCode.valueOf(message
					.getProperty(PropertyOption.RESULT_CODE));
				if (resultCode == ResultCode.NO_MORE_MESSAGE) {
					try {
						TimeUnit.SECONDS.sleep(3);
					} catch (Exception e) {
					}
					lastMessageId = null;
					code = null;
					description = null;
					break;
				}
				
				if(i==this.listSize)
				{
					this.listSize = this.listSize + 10000;
				}
				
				msg = message.getContentAsString();
				System.out.println("-----msg----- " + msg);
				i ++;
				if (null != msg && !"".equals(msg)) {
					list.add(msg);
				}
				//System.out.println(message.getStringProperty(PropertyOption.TOPIC));	//获取生产者主题名称
				lastMessageId = message.getId();
				code = PullCode.COMMIT;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Create on 2015-8-1
	 * @author:jiaxla
	 * @Title: 只消费指定条数消息
	 * @Description:
	 * @return
	 * version 1.0
	 * update_date:            update_author:              update_note
	 */
	public List getMessageList(int size) {
		List list = new ArrayList();
		String msg = null;
		final long processingTime = 60;
		config.setMaxTotalPerKey(this.maxTotalPerKey);
		config.setTestOnBorrow(true);
		final KeyedObjectPool<String, MessageContext> pool = new GenericKeyedObjectPool<String, MessageContext>(
				new PooledMessageContextFactory(this.brokerURL, 60000), config);
		try {
			MessageContext context = pool.borrowObject(this.consumerID);
			String lastMessageId = null;
			PullCode code = null;
			String description = "消费成功";
			int i = 0;
			while (i <= size) {
				
				final Message message = context.fetch(this.consumerTopic, processingTime,
						lastMessageId, code, description, false);
				final ResultCode resultCode = ResultCode.valueOf(message
						.getProperty(PropertyOption.RESULT_CODE));
				if (resultCode == ResultCode.NO_MORE_MESSAGE) {
					try {
						TimeUnit.SECONDS.sleep(3);
					} catch (Exception e) {
					}
					lastMessageId = null;
					code = null;
					description = null;
					break;
				}
				
				msg = message.getContentAsString();
				System.out.println("-----msg----- " + msg);
				i ++;
				if (null != msg && !"".equals(msg)) {
					list.add(msg);
				}
				//System.out.println(message.getStringProperty(PropertyOption.TOPIC));	//获取生产者主题名称
				lastMessageId = message.getId();
				code = PullCode.COMMIT;
			}
				context.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			pool.close();
		}
		return list;
	}
}
