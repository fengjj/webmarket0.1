package com.sitech.util;

import javax.jms.JMSException;
import com.sitech.crmpd.idmm.BuildConfig;
import com.sitech.crmpd.idmm.Message;
import com.sitech.crmpd.idmm.PropertyOption;
import com.sitech.crmpd.idmm.SimpleBuilderProvider;
import com.sitech.crmpd.idmm.SimpleProducer;

/**
 * Create on 2015-4-17
 * @author: dongyh
 * @Title: MultiThreadProducer
 * @Description： 生产者消息中间件
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class Producer{
	
	private String brokerURL;
	private String clientID;
	private String destination;
	
	/**
	 * Create on 2015-4-17 
	 * @author: dongyh
	 * @Title: sendMessage 
	 * @Description: 发送消息
	 * @param message 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 * @throws JMSException 
	 */
	public void sendMessage(String msg) throws JMSException {
		BuildConfig config = new BuildConfig();
		brokerURL = "10.162.200.73:7778";
		clientID = "Pub101";
		destination = "T101DataSyn";
		config.setBrokerURL(brokerURL);
		config.setClientID(clientID);
		config.setDestination(destination);
		
		SimpleProducer producer = null;
		try {
			producer = SimpleBuilderProvider.getInstance().buildProducer(config);
			Message<String> message = new Message<String>();
			message.setProperty(PropertyOption.GROUP_ID, "20150330111");
			message.setBody(msg);    //设置消息报文
			producer.send(message);  //发送消息
			System.out.println("36----------------------");
			producer.commit();       //发送提交
		} catch (JMSException e) {
			e.printStackTrace();
		}finally{
			if (producer != null) {
				producer.close();
			}
		}
	}
	
}
