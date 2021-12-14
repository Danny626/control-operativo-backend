package com.albo.suma.model;

import java.util.List;

public class AlmRec {
	public Alm alm;
	public List<DetRec> detRec;
	public ConTotSobFal conTotSobFal;
	public ConCof conCof;

	public Alm getAlm() {
		return alm;
	}

	public void setAlm(Alm alm) {
		this.alm = alm;
	}

	public List<DetRec> getDetRec() {
		return detRec;
	}

	public void setDetRec(List<DetRec> detRec) {
		this.detRec = detRec;
	}

	public ConTotSobFal getConTotSobFal() {
		return conTotSobFal;
	}

	public void setConTotSobFal(ConTotSobFal conTotSobFal) {
		this.conTotSobFal = conTotSobFal;
	}

	public ConCof getConCof() {
		return conCof;
	}

	public void setConCof(ConCof conCof) {
		this.conCof = conCof;
	}
}
