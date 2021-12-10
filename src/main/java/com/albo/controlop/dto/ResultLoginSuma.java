package com.albo.controlop.dto;

public class ResultLoginSuma {

	private boolean success;
	private ResultTokenSuma result;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public ResultTokenSuma getResult() {
		return result;
	}

	public void setResult(ResultTokenSuma result) {
		this.result = result;
	}

}
