package com.jee.fp.domain;

public class Bank {
	private String rekening;
	private String an;
	private int nominal;

	public Bank(String rekening, String an, int nominal) {
		this.rekening = rekening;
		this.an = an;
		this.nominal = nominal;
	}

	public int getNominal() {
		return nominal;
	}

	public void setNominal(int nominal) {
		this.nominal = nominal;
	}

	public String getAn() {
		return an;
	}

	public void setAn(String an) {
		this.an = an;
	}

	public String getRekening() {
		return rekening;
	}

	public void setRekening(String rekening) {
		this.rekening = rekening;
	}
}
