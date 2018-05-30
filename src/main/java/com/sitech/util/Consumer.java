package com.sitech.util;

import javax.jms.JMSException;

import scala.concurrent.forkjoin.LinkedTransferQueue;
import com.sitech.crmpd.idmm.BuildConfig;
import com.sitech.crmpd.idmm.Message;
import com.sitech.crmpd.idmm.MessageListener;
import com.sitech.crmpd.idmm.SimpleBuilderProvider;
import com.sitech.crmpd.idmm.SimpleConsumer;

public class Consumer {

	public static String ComsumerMessage(){
		final LinkedTransferQueue<Message> messageQueue = new LinkedTransferQueue<Message>();
		
		BuildConfig config = new BuildConfig();
		String url = PropertiesUtil.getProperty("inform.properties", "brokerURL");
		String clientId = PropertiesUtil.getProperty("inform.properties", "brokerURL");
		String topic = PropertiesUtil.getProperty("inform.properties", "destination");
		
		config.setBrokerURL(url);
		config.setClientID(clientId);
		config.setDestination(topic);
		
		config.setMessageListener(new MessageListener(){
			@Override
			public void onMessage(Message<?> message) {
			    System.out.println("---messInfo---"+message.getBody());
			    messageQueue.offer(message);
			    if (true) {
					throw new RuntimeException("rollback reason");
				}
			}
			
		});
		SimpleConsumer consumer = null;
	    try{
    		consumer=SimpleBuilderProvider.getInstance()
    		.buildConsumer(config);
    		consumer.start();
   		    consumer.awaitForStop();
    	}catch(Exception e){
    		e.printStackTrace();
    		if (consumer != null) {
    			try {
    			consumer.stop();
    			} catch (JMSException e1) {
    			e1.printStackTrace();
    			}
    			}
    	}
    	String result ="";
		if(messageQueue.size()>0){
			Message msg = messageQueue.poll();
			result = (String) msg.getBody();
		}
		return result;
	}
	
}
