package io.github.tortuvshin.natoriat.bo.impl;

import io.github.tortuvshin.natoriat.bo.NatoriatBo;
import io.github.tortuvshin.natoriat.dao.NatoriatDao;
import io.github.tortuvshin.natoriat.model.Natoriat;

public class NatoriatBoImpl implements NatoriatBo {
	
	NatoriatDao natoriatDao;

	public void setNatoriatDao(NatoriatDao natoriatDao){

		this.natoriatDao = natoriatDao;
	}
	
	public void save(Natoriat natoriat) {
		this.save(natoriat);;
		
	}

	public void update(Natoriat natoriat) {
		this.update(natoriat);
	}

	public void delete(Natoriat natoriat) {
		// TODO Auto-generated method stub
		this.delete(natoriat);
	}

	public Natoriat findByNatoriatCode(String natoriatCode) {
		// TODO Auto-generated method stub
		return natoriatDao.findByNatoriatCode(natoriatCode);
	}

}
