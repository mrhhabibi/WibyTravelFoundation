package com.jee.fp.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jee.fp.domain.Anggota;
import com.jee.fp.domain.Jadwal;
import com.jee.fp.domain.Transaksi;
import com.jee.fp.repository.TransaksiRepository;

@Service
public class FakeTranskasiRepository implements TransaksiRepository {

	private List<Transaksi> transaksis = new ArrayList<Transaksi>();

	public FakeTranskasiRepository()
	{
		transaksis.add(new Transaksi(1, new Jadwal(1, "as", "sd", "12/12/12",
				"12:12", 12, 12), new Anggota("qwe", "qwe", "qwe", "123",
				"user"), 12));
		transaksis.add(new Transaksi(2, new Jadwal(2, "as", "sd", "12/12/12",
				"12:12", 12, 12), new Anggota("qwe", "qwe", "qwe", "123",
				"user"), 12));
		transaksis.add(new Transaksi(3, new Jadwal(3, "as", "sd", "12/12/12",
				"12:12", 12, 12), new Anggota("qwe", "qwe", "qwe", "123",
				"user"), 12));
		transaksis.add(new Transaksi(4, new Jadwal(4, "as", "sd", "12/12/12",
				"12:12", 12, 12), new Anggota("qwe", "qwe", "qwe", "123",
				"user"), 12));
	}
	
	@Override
	public List<Transaksi> getData() {
		return transaksis;
	}

	@Override
	public void tambah(Transaksi transaksi) {
		transaksis.add(transaksi);
	}

	@Override
	public List<Transaksi> getHistory(String email) {
		return transaksis;
	}

}
