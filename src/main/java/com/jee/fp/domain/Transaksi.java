package com.jee.fp.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaksi {
	private int id;
	private Jadwal jadwal;
	private Anggota anggota;
	private String via;
	private String rekening;
	private String an;
	private String batas;
	private int kuota;

	public Transaksi() {
		setBatas(null);
	}

	public Transaksi(Jadwal jadwal, int kuota) {
		this.jadwal = jadwal;
		this.kuota = kuota;
		setBatas(null);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Anggota getAnggota() {
		return anggota;
	}

	public void setAnggota(Anggota anggota) {
		this.anggota = anggota;
	}

	public Jadwal getJadwal() {
		return jadwal;
	}

	public void setJadwal(Jadwal jadwal) {
		this.jadwal = jadwal;
	}

	public String getRekening() {
		return rekening;
	}

	public void setRekening(String rekening) {
		this.rekening = rekening;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getAn() {
		return an;
	}

	public void setAn(String an) {
		this.an = an;
	}

	public String getBatas() {
		return batas;
	}

	public void setBatas(String batas) {
		this.batas = batas;
	}

	public int getKuota() {
		return kuota;
	}

	public void setKuota(int kuota) {
		this.kuota = kuota;
	}
}
