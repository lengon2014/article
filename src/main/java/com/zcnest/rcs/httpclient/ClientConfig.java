package com.zcnest.rcs.httpclient;


public class ClientConfig {
	private String domain;
	private boolean isProxy;

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public boolean isProxy() {
		return isProxy;
	}

	public void setProxy(boolean isProxy) {
		this.isProxy = isProxy;
	}

}
