package com.jee.fp.repository;

import java.util.List;
import com.jee.fp.domain.Transaksi;

public interface TransaksiRepository {
	List<Transaksi> getData();
	void tambah(Transaksi transaksi);
	List<Transaksi> getHistory(String email);
}