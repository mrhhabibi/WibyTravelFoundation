package com.jee.fp.domain;

public class Anggota {
	private String password;
	private String nama;
	private String email;
	private String kontak;
	private String tipe;

	public Anggota() {
		this.tipe = "anonim";
	}

	public Anggota(String password, String nama, String email, String kontak,
			String tipe) {
		this.nama = nama;
		this.password = password;
		this.email = email;
		this.kontak = kontak;
		this.tipe = tipe;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKontak() {
		return kontak;
	}

	public void setKontak(String kontak) {
		this.kontak = kontak;
	}

	public String getTipe() {
		return tipe;
	}

	public void setTipe(String tipe) {
		this.tipe = tipe;
	}

}
