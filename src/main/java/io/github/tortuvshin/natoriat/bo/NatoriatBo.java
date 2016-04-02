package io.github.tortuvshin.natoriat.bo;

import io.github.tortuvshin.natoriat.model.*;

public interface NatoriatBo {

	void save(Natoriat natoriat);
	
	void update(Natoriat natoriat);
	
	void delete(Natoriat natoriat);
	
	Natoriat findByNatoriatCode(String natoriatCode);
}
