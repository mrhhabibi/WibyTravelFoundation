package com.jee.fp.repository;

import java.util.List;

import com.jee.fp.domain.Anggota;

public interface AnggotaRepository {
	List<Anggota> getData();
	void tambah(Anggota anggota);
	void hapus(String username);
}
