package com.albo.controlop.dto;

import java.util.List;

import com.albo.soa.model.ParteSuma;

public class ResultadoRegistroPartesSuma {

	private Integer totalRegistros;
	private Integer registrosGuardados;
	private Integer registrosNoGuardados;
	private List<ErrorParte> registrosError;
	private List<ParteSuma> partesSumaGuardados;

	public Integer getTotalRegistros() {
		return totalRegistros;
	}

	public void setTotalRegistros(Integer totalRegistros) {
		this.totalRegistros = totalRegistros;
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

	public List<ErrorParte> getRegistrosError() {
		return registrosError;
	}

	public void setRegistrosError(List<ErrorParte> registrosError) {
		this.registrosError = registrosError;
	}

	public List<ParteSuma> getPartesSumaGuardados() {
		return partesSumaGuardados;
	}

	public void setPartesSumaGuardados(List<ParteSuma> partesSumaGuardados) {
		this.partesSumaGuardados = partesSumaGuardados;
	}
}
