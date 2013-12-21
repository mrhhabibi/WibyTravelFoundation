package com.jee.fp.domain;

public class Transaksi {
	private int id;
	private String emailAnggota;
	private int idJadwal;
	private boolean status;
	private int harga;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailAnggota() {
		return emailAnggota;
	}
	public void setEmailAnggota(String emailAnggota) {
		this.emailAnggota = emailAnggota;
	}
	public int getIdJadwal() {
		return idJadwal;
	}
	public void setIdJadwal(int idJadwal) {
		this.idJadwal = idJadwal;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getHarga() {
		return harga;
	}
	public void setHarga(int harga) {
		this.harga = harga;
	}
}
