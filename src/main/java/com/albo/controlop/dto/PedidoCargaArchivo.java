package com.albo.controlop.dto;

import org.springframework.web.multipart.MultipartFile;

public class PedidoCargaArchivo {

	private String codRecinto;
	private MultipartFile file;
	
	public String getCodRecinto() {
		return codRecinto;
	}
	public void setCodRecinto(String codRecinto) {
		this.codRecinto = codRecinto;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
