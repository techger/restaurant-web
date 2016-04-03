package io.github.tortuvshin.common;

import org.hibernate.InvalidMappingException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.github.tortuvshin.natoriat.bo.NatoriatBo;
import io.github.tortuvshin.natoriat.model.Natoriat;

public class App {
	static ApplicationContext appContext;
	public static void main(String[] args) {
		try {
			appContext = 
					new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		}
		catch (BeanCreationException be){
			System.out.println("Алдаа BeanCreationException: "+be);
		}
		catch (InvalidMappingException ie){
			System.out.println("Алдаа InvalidMappingException: "+ie);			
		} 
		catch (NullPointerException ex) {
			System.out.println("Алдаа NullPointerException: "+ex);
		} 
		catch (Exception e){
			System.out.println("Алдаа: "+e);
		}
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
