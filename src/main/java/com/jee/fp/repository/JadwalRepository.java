package com.jee.fp.repository;

import java.util.List;

import com.jee.fp.domain.Jadwal;

public interface JadwalRepository {
	List<Jadwal> getData();
	List<Jadwal> getData(String asal, String tujuan, String tanggal, int kuota);
	void tambah(Jadwal jadwal);
	void hapus(int id);
	Jadwal getData(int id);
	List<String> getKota();
	void simpan(Jadwal jadwal);
}
