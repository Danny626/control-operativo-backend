package com.albo.controlop.dto;

import java.util.List;

import com.albo.controlop.model.ParteSuma;

public class ResultadoCargaExcel {

	private Integer totalRegistros;
	private Integer procesadosSinError;
	private Integer registrosGuardados;
	private Integer registrosNoGuardados;
	private List<ParteSuma> partesSuma;
	private List<ErrorExcel> registrosError;

	public Integer getTotalRegistros() {
		return totalRegistros;
	}

	public void setTotalRegistros(Integer totalRegistros) {
		this.totalRegistros = totalRegistros;
	}

	public Integer getProcesadosSinError() {
		return procesadosSinError;
	}

	public void setProcesadosSinError(Integer procesadosSinError) {
		this.procesadosSinError = procesadosSinError;
	}

	public Integer getRegistrosGuardados() {
		return registrosGuardados;
	}

	public void setRegistrosGuardados(Integer registrosGuardados) {
		this.registrosGuardados = registrosGuardados;
	}

	public Integer getRegistrosNoGuardados() {
		return registrosNoGuardados;
	}

	public void setRegistrosNoGuardados(Integer registrosNoGuardados) {
		this.registrosNoGuardados = registrosNoGuardados;
	}

	public List<ParteSuma> getPartesSuma() {
		return partesSuma;
	}

	public void setPartesSuma(List<ParteSuma> partesSuma) {
		this.partesSuma = partesSuma;
	}

	public List<ErrorExcel> getRegistrosError() {
		return registrosError;
	}

	public void setRegistrosError(List<ErrorExcel> registrosError) {
		this.registrosError = registrosError;
	}

}
