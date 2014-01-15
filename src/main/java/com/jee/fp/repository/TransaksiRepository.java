package com.jee.fp.repository;

import java.util.List;
import com.jee.fp.domain.Transaksi;

public interface TransaksiRepository {
	List<Transaksi> getData();
	List<Transaksi> getHistory(String email);
	void tambah(Transaksi transaksi);
}