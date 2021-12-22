package com.albo.controlop.dto;

public class RespVerificaTokenSuma {

	private boolean success;
	private ResultVerificaTokenSuma result;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public ResultVerificaTokenSuma getResult() {
		return result;
	}

	public void setResult(ResultVerificaTokenSuma result) {
		this.result = result;
	}

}
