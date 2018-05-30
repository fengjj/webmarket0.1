package com.sitech.util;

import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.pool2.KeyedObjectPool;
import org.apache.commons.pool2.impl.GenericKeyedObjectPool;
import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;

import com.sitech.crmpd.idmm2.client.MessageContext;
import com.sitech.crmpd.idmm2.client.api.Message;
import com.sitech.crmpd.idmm2.client.api.PropertyOption;
import com.sitech.crmpd.idmm2.client.pool.PooledMessageContextFactory;

public class PooledProducer {
	
	private static Log log=LogFactory.getLog(PooledProducer.class);
	public static String brokerURL=PropertiesUtil.getProperty("inform.properties", "brokerURL");
	public static String producerTopic_sendMsg= PropertiesUtil.getProperty("inform.properties","producerTopic_sendMsg");
	public static String producerId_sendMsg = PropertiesUtil.getProperty("inform.properties", "producerId_sendMsg");
	public static String producerTopic_FinishOrderTopic = PropertiesUtil.getProperty("inform.properties", "producerTopic_FinishOrderTopic");
	public static String producerID_FinishOrderTopic = PropertiesUtil.getProperty("inform.properties", "producerID_FinishOrderTopic");
	public static String producerTopic_givefee = PropertiesUtil.getProperty("inform.properties", "producerTopic_givefee");
	public static String producerID_givefee = PropertiesUtil.getProperty("inform.properties", "producerID_givefee");
	public static String producerTopic_kaihu = PropertiesUtil.getProperty("inform.properties", "producerTopic_kaihu");
	public static String producerId_kaihu = PropertiesUtil.getProperty("inform.properties", "producerId_kaihu");
	private static final GenericKeyedObjectPoolConfig CONFIG = new GenericKeyedObjectPoolConfig();
	private static final KeyedObjectPool<String, MessageContext> pool = new GenericKeyedObjectPool<String, MessageContext>(
			new PooledMessageContextFactory(brokerURL, 60000),CONFIG);
	static{
		CONFIG.setMaxTotalPerKey(50);
		CONFIG.setTestOnBorrow(true);
	}
	
	public static void sendMessage(String mspId,String mspTopic,String msg) {
		MessageContext context = null;
		try {
			context = pool.borrowObject(mspId);
			final Message message = Message.create(msg);
			message.setProperty(PropertyOption.COMPRESS, true);
			String s = String.valueOf(((Math.random()*9+1)*100000)); 
			message.setProperty(PropertyOption.GROUP, s);
			message.setProperty(PropertyOption.PRIORITY, 500);
			final String id = context.send(mspTopic, message);
			log.info("----message id ---- " + id);
			context.commit(id);
		}catch (final Exception e) {
			e.printStackTrace();
		}finally {
			if (context != null) {
				try {
					pool.returnObject(mspId, context);
				} catch (final Exception e) {}
			}
		}
	}
	
	public static void sendMessage(String mspId,String mspTopic,String phoneNo,String msg) throws Exception {
		final KeyedObjectPool<String, MessageContext> pool = new GenericKeyedObjectPool<String, MessageContext>(
				new PooledMessageContextFactory(brokerURL, 60000),CONFIG);
		final MessageContext context = pool.borrowObject(mspId);
		final Message message = Message.create(msg);
		message.setProperty(PropertyOption.GROUP, phoneNo);
		message.setProperty(PropertyOption.PRIORITY, 500);//���ȼ�
		message.setProperty(PropertyOption.valueOf("msg_part"),  phoneNo.substring(9));
		final String id = context.send(mspTopic, message);
		log.info("----message id ---- " + id);
		context.commit(id);
		pool.returnObject(mspId, context);
	}
	public static void main(String[] args) {
		Random r = new Random();
		String s = r.nextInt(600000)+"";
		System.out.println(s);
	}
}
