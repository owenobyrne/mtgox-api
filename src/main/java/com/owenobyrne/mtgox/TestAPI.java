package com.owenobyrne.mtgox;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.owenobyrne.mtgox.api.model.Info;
import com.owenobyrne.mtgox.api.model.Quote;

public class TestAPI {
	static final Logger logger = Logger.getLogger(TestAPI.class.getName());
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		MtGox mg = (MtGox)context.getBean("mtGox");
		
		try {
			Info i = mg.getInfo();
			//Quote bidq = mg.getQuote("bid");
			Quote askq = mg.getQuote("ask");
			
			logger.info("MtGox portfolio value = " + 
					i.getData().getWallets().get("BTC").getBalance().getValue_int().multiply(askq.getData().getAmount())
					);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
