package com.jee.fp.domain;

public class Booking {
	private Anggota anggota;
	private Jadwal jadwal;
	private String rekening;
	private String an;
	private String batas;

	public Booking() {
		setBatas(null);
	}

	public Booking(Anggota anggota, Jadwal jadwal, String rekening, String an,
			String batas) {
		this.anggota = anggota;
		this.jadwal = jadwal;
		this.rekening = rekening;
		this.an = an;
		this.batas = batas;
	}

	public String getRekening() {
		return rekening;
	}

	public void setRekening(String rekening) {
		this.rekening = rekening;
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
}
