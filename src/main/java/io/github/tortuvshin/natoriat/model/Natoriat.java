package io.github.tortuvshin.natoriat.model;

import java.io.Serializable;

public class Natoriat implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long natoriatId;
	private String natoriatCode;
	private String natoriatName;
	
	public Natoriat(){
		
	}

	public Long getNatoriatId() {
		return natoriatId;
	}

	public Natoriat(String natoriatCode, String natoriatName) {
		super();
		this.natoriatCode = natoriatCode;
		this.natoriatName = natoriatName;
	}

	public void setNatoriatId(Long natoriatId) {
		this.natoriatId = natoriatId;
	}

	public String getNatoriatCode() {
		return natoriatCode;
	}

	public void setNatoriatCode(String natoriatCode) {
		this.natoriatCode = natoriatCode;
	}

	public String getNatoriatName() {
		return natoriatName;
	}

	public void setNatoriatName(String natoriatName) {
		this.natoriatName = natoriatName;
	}

	@Override
	public String toString() {
		return "Natoriat [natoriatId=" + natoriatId + ", natoriatCode=" + natoriatCode + ", natoriatName="
				+ natoriatName + "]";
	}
	
	
}
