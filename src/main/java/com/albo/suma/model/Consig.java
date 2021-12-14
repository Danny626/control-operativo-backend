package com.albo.suma.model;

import java.util.List;

public class Consig {
	public boolean oea;
	public boolean oac;
	public Car car;
	public String codTipDoc;
	public String desTipDoc;
	public String numDoc;
	public String nomRazSoc;
	public String cat;
	public List<TipOpe> tipOpe;
	public List<Object> marOpe;
	public String codTipSol;
	public String desTipSol;
	public Dom dom;

	public boolean isOea() {
		return oea;
	}

	public void setOea(boolean oea) {
		this.oea = oea;
	}

	public boolean isOac() {
		return oac;
	}

	public void setOac(boolean oac) {
		this.oac = oac;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getCodTipDoc() {
		return codTipDoc;
	}

	public void setCodTipDoc(String codTipDoc) {
		this.codTipDoc = codTipDoc;
	}

	public String getDesTipDoc() {
		return desTipDoc;
	}

	public void setDesTipDoc(String desTipDoc) {
		this.desTipDoc = desTipDoc;
	}

	public String getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	public String getNomRazSoc() {
		return nomRazSoc;
	}

	public void setNomRazSoc(String nomRazSoc) {
		this.nomRazSoc = nomRazSoc;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public List<TipOpe> getTipOpe() {
		return tipOpe;
	}

	public void setTipOpe(List<TipOpe> tipOpe) {
		this.tipOpe = tipOpe;
	}

	public List<Object> getMarOpe() {
		return marOpe;
	}

	public void setMarOpe(List<Object> marOpe) {
		this.marOpe = marOpe;
	}

	public String getCodTipSol() {
		return codTipSol;
	}

	public void setCodTipSol(String codTipSol) {
		this.codTipSol = codTipSol;
	}

	public String getDesTipSol() {
		return desTipSol;
	}

	public void setDesTipSol(String desTipSol) {
		this.desTipSol = desTipSol;
	}

	public Dom getDom() {
		return dom;
	}

	public void setDom(Dom dom) {
		this.dom = dom;
	}
}
