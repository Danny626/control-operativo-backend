package com.albo.controlop.dto;

import java.util.List;

import com.albo.controlop.model.ParteSumaExcel;

public class ResultadoComparaSumaVirtu {

	private List<ExistenVirtualbo> listaExistenVirtu;
	private List<ParteSumaExcel> listaNoExistenSuma;
	private List<ParteSumaExcel> listaDifierenSuma;

	public List<ExistenVirtualbo> getListaExistenVirtu() {
		return listaExistenVirtu;
	}

	public void setListaExistenVirtu(List<ExistenVirtualbo> listaExistenVirtu) {
		this.listaExistenVirtu = listaExistenVirtu;
	}

	public List<ParteSumaExcel> getListaNoExistenSuma() {
		return listaNoExistenSuma;
	}

	public void setListaNoExistenSuma(List<ParteSumaExcel> listaNoExistenSuma) {
		this.listaNoExistenSuma = listaNoExistenSuma;
	}

	public List<ParteSumaExcel> getListaDifierenSuma() {
		return listaDifierenSuma;
	}

	public void setListaDifierenSuma(List<ParteSumaExcel> listaDifierenSuma) {
		this.listaDifierenSuma = listaDifierenSuma;
	}

}
