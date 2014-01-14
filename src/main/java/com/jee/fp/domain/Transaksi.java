package com.jee.fp.domain;

public class Transaksi {
	private int id;
	private Jadwal jadwal;
	private Anggota anggota;
	private int kuota;

	public Transaksi() {
		
	}

	public Transaksi(int id, Jadwal jadwal, Anggota anggota, int kuota) {
		this.id = id;
		this.jadwal = jadwal;
		this.anggota = anggota;
		this.kuota = kuota;
	}

	public Transaksi(Jadwal jadwal, int kuota) {
		this.jadwal = jadwal;
		this.kuota = kuota;
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

	public int getKuota() {
		return kuota;
	}

	public void setKuota(int kuota) {
		this.kuota = kuota;
	}
}
