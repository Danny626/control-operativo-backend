package com.albo.controlop.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ParamsMisPartesSuma {

	private Integer page;
	private Integer size;
	private String search;
	private List<String> tipPre;
	private LocalDateTime to;
	private LocalDateTime from;
	private String column;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public List<String> getTipPre() {
		return tipPre;
	}

	public void setTipPre(List<String> tipPre) {
		this.tipPre = tipPre;
	}

	public LocalDateTime getTo() {
		return to;
	}

	public void setTo(LocalDateTime to) {
		this.to = to;
	}

	public LocalDateTime getFrom() {
		return from;
	}

	public void setFrom(LocalDateTime from) {
		this.from = from;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

}
