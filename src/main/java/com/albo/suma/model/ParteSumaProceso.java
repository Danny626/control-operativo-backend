package com.albo.suma.model;

import java.util.List;

//import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
//import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */

public class ParteSumaProceso {
	public String id;
	public String cor;
	public long fecTra;
	public Dst dst;
	public Object dec;
	public String estAct;
	public DatGen datGen;
	public IngUbiMer ingUbiMer;
	public InfTec infTec;
	public ArrMer arrMer;
	public List<AlmRec> almRec;
	public String usr;
	public Object des;
	public ConTotSobFal conTotSobFal;
	public List<Bit> bit;
	public List<Object> bitFal;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public long getFecTra() {
		return fecTra;
	}

	public void setFecTra(long fecTra) {
		this.fecTra = fecTra;
	}

	public Dst getDst() {
		return dst;
	}

	public void setDst(Dst dst) {
		this.dst = dst;
	}

	public Object getDec() {
		return dec;
	}

	public void setDec(Object dec) {
		this.dec = dec;
	}

	public String getEstAct() {
		return estAct;
	}

	public void setEstAct(String estAct) {
		this.estAct = estAct;
	}

	public DatGen getDatGen() {
		return datGen;
	}

	public void setDatGen(DatGen datGen) {
		this.datGen = datGen;
	}

	public IngUbiMer getIngUbiMer() {
		return ingUbiMer;
	}

	public void setIngUbiMer(IngUbiMer ingUbiMer) {
		this.ingUbiMer = ingUbiMer;
	}

	public InfTec getInfTec() {
		return infTec;
	}

	public void setInfTec(InfTec infTec) {
		this.infTec = infTec;
	}

	public ArrMer getArrMer() {
		return arrMer;
	}

	public void setArrMer(ArrMer arrMer) {
		this.arrMer = arrMer;
	}

	public List<AlmRec> getAlmRec() {
		return almRec;
	}

	public void setAlmRec(List<AlmRec> almRec) {
		this.almRec = almRec;
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public Object getDes() {
		return des;
	}

	public void setDes(Object des) {
		this.des = des;
	}

	public ConTotSobFal getConTotSobFal() {
		return conTotSobFal;
	}

	public void setConTotSobFal(ConTotSobFal conTotSobFal) {
		this.conTotSobFal = conTotSobFal;
	}

	public List<Bit> getBit() {
		return bit;
	}

	public void setBit(List<Bit> bit) {
		this.bit = bit;
	}

	public List<Object> getBitFal() {
		return bitFal;
	}

	public void setBitFal(List<Object> bitFal) {
		this.bitFal = bitFal;
	}
}


