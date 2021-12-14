package com.albo.suma.model;

public class ConCof {
	public boolean obs;
	public boolean obsSimMul;
	public Object tipObsSim;
	public Object tipObsMul;
	public boolean reqActIns;
	public String des;
	public Object obsAdu;

	public boolean isObs() {
		return obs;
	}

	public void setObs(boolean obs) {
		this.obs = obs;
	}

	public boolean isObsSimMul() {
		return obsSimMul;
	}

	public void setObsSimMul(boolean obsSimMul) {
		this.obsSimMul = obsSimMul;
	}

	public Object getTipObsSim() {
		return tipObsSim;
	}

	public void setTipObsSim(Object tipObsSim) {
		this.tipObsSim = tipObsSim;
	}

	public Object getTipObsMul() {
		return tipObsMul;
	}

	public void setTipObsMul(Object tipObsMul) {
		this.tipObsMul = tipObsMul;
	}

	public boolean isReqActIns() {
		return reqActIns;
	}

	public void setReqActIns(boolean reqActIns) {
		this.reqActIns = reqActIns;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Object getObsAdu() {
		return obsAdu;
	}

	public void setObsAdu(Object obsAdu) {
		this.obsAdu = obsAdu;
	}
}
