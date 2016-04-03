package io.github.tortuvshin.common;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.github.tortuvshin.natoriat.bo.NatoriatBo;
import io.github.tortuvshin.natoriat.model.Natoriat;

public class App {

	public static void main(String[] args) {

		ApplicationContext appContext = 
				new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		
		NatoriatBo natoriatBo = (NatoriatBo)appContext.getBean("natoriatBo");
		
		Natoriat natoriat = new Natoriat();
		natoriat.setNatoriatCode("1111");
		natoriat.setNatoriatName("Natoriat Name");
		natoriatBo.save(natoriat);
		
		System.out.println("Saved: "+natoriat);
		
		Natoriat natoriat2 = natoriatBo.findByNatoriatCode("1111");
		System.out.println("Find: "+natoriat);
		
		natoriat.setNatoriatName("NatoriatUpdated");
		natoriatBo.update(natoriat2);
		
		
	}

}
