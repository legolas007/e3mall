package cn.e3mall.activemq;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * activemq,spring整合测试
 * @author usher
 *
 */
public class ActiveMqSpring {
	
	@Test
	public void sendMessage() throws Exception{
		
		//初始化spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-activemq.xml");
		//从容器中获得JmsTemplate对象
		JmsTemplate jmsTemplate = applicationContext.getBean(JmsTemplate.class);
		//destination
		Destination destination = (Destination) applicationContext.getBean("queueDestination");
		
		jmsTemplate.send(destination,new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage("send sctivemq message");
			}
		});
	}

}
