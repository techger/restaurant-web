package io.github.tortuvshin.natoriat.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import io.github.tortuvshin.natoriat.dao.NatoriatDao;
import io.github.tortuvshin.natoriat.model.Natoriat;


public class NatoriatDaoImpl extends HibernateDaoSupport implements NatoriatDao{
	
	void save(Natoriat natoriat){
		getHibernateTemplate().save(natoriat);
	}
	
	void update(Natoriat natoriat){
		getHibernateTemplate().update(natoriat);
	}
	
	void delete(Natoriat natoriat){
		getHibernateTemplate().delete(natoriat);
	}
	
	Natoriat findByNatoriatCode(String natoriatCode){
		
		List list = getHibernateTemplate().find("from Natoriat where natoriatCode=?", natoriatCode);
		return (Natoriat)list.get(0);
	}
}
