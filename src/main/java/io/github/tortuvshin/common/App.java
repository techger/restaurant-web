package io.github.tortuvshin.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.github.tortuvshin.natoriat.bo.NatoriatBo;
import io.github.tortuvshin.natoriat.model.Natoriat;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		
		NatoriatBo = (NatoriatBo).appContext.getBean("natoriatBo");
	}

}
