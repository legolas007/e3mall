package cn.e3mall.search.message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 配置监听容器
 * @author usher
 *
 */
public class MyMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		//取消息内容
		TextMessage textMessage = (TextMessage)message;
		try {
			String text =textMessage.getText();
			System.out.println(text);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
 
	
}
