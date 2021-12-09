package com.albo.controlop.dto;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.albo.controlop.model.ParteSumaExcel;

public class ResultadoCargaExcel {

	private Integer totalRegistros;
	private Integer procesadosSinError;
	private Integer registrosGuardados;
	private Integer registrosNoGuardados;
	private HttpStatus responseCode;
	private String uploadStatus;
	private List<ParteSumaExcel> partesSuma;
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

	public List<ParteSumaExcel> getPartesSuma() {
		return partesSuma;
	}

	public void setPartesSuma(List<ParteSumaExcel> partesSuma) {
		this.partesSuma = partesSuma;
	}

	public List<ErrorExcel> getRegistrosError() {
		return registrosError;
	}

	public void setRegistrosError(List<ErrorExcel> registrosError) {
		this.registrosError = registrosError;
	}

	public HttpStatus getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(HttpStatus responseCode) {
		this.responseCode = responseCode;
	}

	public String getUploadStatus() {
		return uploadStatus;
	}

	public void setUploadStatus(String uploadStatus) {
		this.uploadStatus = uploadStatus;
	}

}
