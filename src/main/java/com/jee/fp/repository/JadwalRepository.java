package com.jee.fp.repository;

import java.util.List;

import com.jee.fp.domain.Jadwal;

public interface JadwalRepository {
	List<Jadwal> getData();
	void tambah(Jadwal jadwal);
}
