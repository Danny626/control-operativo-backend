package com.albo.controlop.dto;

import java.util.List;

import com.albo.controlop.model.ParteSuma;

public class ResultadoComparaSumaVirtu {

	private List<ExistenVirtualbo> listaExistenVirtu;
	private List<ParteSuma> listaNoExistenSuma;
	private List<ParteSuma> listaDifierenSuma;

	public List<ExistenVirtualbo> getListaExistenVirtu() {
		return listaExistenVirtu;
	}

	public void setListaExistenVirtu(List<ExistenVirtualbo> listaExistenVirtu) {
		this.listaExistenVirtu = listaExistenVirtu;
	}

	public List<ParteSuma> getListaNoExistenSuma() {
		return listaNoExistenSuma;
	}

	public void setListaNoExistenSuma(List<ParteSuma> listaNoExistenSuma) {
		this.listaNoExistenSuma = listaNoExistenSuma;
	}

	public List<ParteSuma> getListaDifierenSuma() {
		return listaDifierenSuma;
	}

	public void setListaDifierenSuma(List<ParteSuma> listaDifierenSuma) {
		this.listaDifierenSuma = listaDifierenSuma;
	}

}
