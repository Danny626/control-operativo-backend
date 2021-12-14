package com.albo.suma.model;

import java.util.List;

public class DetRec {
	public String numIte;
	public String desMer;
	public long fecRec;
	public List<Ubi> ubi;
	public ConTotSobFal conTotSobFal;

	public String getNumIte() {
		return numIte;
	}

	public void setNumIte(String numIte) {
		this.numIte = numIte;
	}

	public String getDesMer() {
		return desMer;
	}

	public void setDesMer(String desMer) {
		this.desMer = desMer;
	}

	public long getFecRec() {
		return fecRec;
	}

	public void setFecRec(long fecRec) {
		this.fecRec = fecRec;
	}

	public List<Ubi> getUbi() {
		return ubi;
	}

	public void setUbi(List<Ubi> ubi) {
		this.ubi = ubi;
	}

	public ConTotSobFal getConTotSobFal() {
		return conTotSobFal;
	}

	public void setConTotSobFal(ConTotSobFal conTotSobFal) {
		this.conTotSobFal = conTotSobFal;
	}
}
