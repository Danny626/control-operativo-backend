package com.albo.controlop.dto;

import com.albo.soa.model.VInventarioEgr;

public class ExistenVirtualbo {

	private int bultoSaldo;
	private VInventarioEgr vInventarioEgr;

	public ExistenVirtualbo(int bultoSaldo, VInventarioEgr vInventarioEgr) {
		super();
		this.bultoSaldo = bultoSaldo;
		this.vInventarioEgr = vInventarioEgr;
	}

	public int getBultoSaldo() {
		return bultoSaldo;
	}

	public void setBultoSaldo(int bultoSaldo) {
		this.bultoSaldo = bultoSaldo;
	}

	public VInventarioEgr getvInventarioEgr() {
		return vInventarioEgr;
	}

	public void setvInventarioEgr(VInventarioEgr vInventarioEgr) {
		this.vInventarioEgr = vInventarioEgr;
	}

}
