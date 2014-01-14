package com.jee.fp.domain;

public class Jadwal {
	private int id;
	private String kotaAsal;
	private String kotaTujuan;
	private String tanggal;
	private String waktu;
	private int kuota;
	private int harga;

	public Jadwal() {

	}

	public Jadwal(int id, String kotaAsal, String kotaTujuan, String tanggal,
			String waktu, int kuota, int harga) {
		this.id = id;
		this.tanggal = tanggal;
		this.waktu = waktu;
		this.kuota = kuota;
		this.kotaAsal = kotaAsal;
		this.kotaTujuan = kotaTujuan;
		this.harga = harga;
	}

	public String getTanggal() {
		return tanggal;
	}

	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}

	public int getKuota() {
		return kuota;
	}

	public void setKuota(int kuota) {
		this.kuota = kuota;
	}

	public String getKotaAsal() {
		return kotaAsal;
	}

	public void setKotaAsal(String kotaAsal) {
		this.kotaAsal = kotaAsal;
	}

	public String getKotaTujuan() {
		return kotaTujuan;
	}

	public void setKotaTujuan(String kotaTujuan) {
		this.kotaTujuan = kotaTujuan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWaktu() {
		return waktu;
	}

	public void setWaktu(String waktu) {
		this.waktu = waktu;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}
}
