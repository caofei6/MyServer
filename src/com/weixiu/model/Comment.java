package com.weixiu.model;

public class Comment {
	private Boolean isRequest;
	private String markTime;
	private String markName;
	private String markContent;

	
	public Boolean getIsRequest() {
		return isRequest;
	}

	public void setIsRequest(Boolean isRequest) {
		this.isRequest = isRequest;
	}

	public String getMarkTime() {
		return markTime;
	}

	public void setMarkTime(String markTime) {
		this.markTime = markTime;
	}

	public String getMarkName() {
		return markName;
	}

	public void setMarkName(String markName) {
		this.markName = markName;
	}

	public String getMarkContent() {
		return markContent;
	}

	public void setMarkContent(String markContent) {
		this.markContent = markContent;
	}

}
