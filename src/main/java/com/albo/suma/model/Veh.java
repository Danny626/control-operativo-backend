package com.albo.suma.model;

import java.util.List;

public class Veh {
	public boolean veh;
	public Object cha;
	public boolean rev;
	public List<Object> ite;

	public boolean isVeh() {
		return veh;
	}

	public void setVeh(boolean veh) {
		this.veh = veh;
	}

	public Object getCha() {
		return cha;
	}

	public void setCha(Object cha) {
		this.cha = cha;
	}

	public boolean isRev() {
		return rev;
	}

	public void setRev(boolean rev) {
		this.rev = rev;
	}

	public List<Object> getIte() {
		return ite;
	}

	public void setIte(List<Object> ite) {
		this.ite = ite;
	}
}
