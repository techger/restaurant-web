package io.github.tortuvshin.natoriat.dao;

import io.github.tortuvshin.natoriat.model.Natoriat;

public interface NatoriatDao {

	void save(Natoriat natoriat);
	
	void update(Natoriat natoriat);
	
	void delete(Natoriat natoriat);
	
	Natoriat findByNatoriatCode(String natoriatCode);

}
