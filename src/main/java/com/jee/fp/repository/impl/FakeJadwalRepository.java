package com.jee.fp.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jee.fp.domain.Jadwal;
import com.jee.fp.repository.JadwalRepository;

@Service
public class FakeJadwalRepository implements JadwalRepository {
	private List<Jadwal> jadwals = new ArrayList<Jadwal>();

	public FakeJadwalRepository() {
		this.jadwals.add(new Jadwal(1, "Gresik", "Bali", "12/3/2013", "12.00",
				30));
		this.jadwals.add(new Jadwal(2, "Surabaya", "Bandung", "2/5/2013",
				"03.00", 90));
		this.jadwals.add(new Jadwal(3, "Kediri", "Bengkulu", "11/4/2014",
				"11.30", 20));
		this.jadwals.add(new Jadwal(4, "Jakarta", "Banyuwangi", "13/3/2014",
				"00.30", 10));
	}

	@Override
	public List<Jadwal> getData() {
		return jadwals;
	}

	@Override
	public void tambah(Jadwal jadwal) {
		jadwals.add(jadwal);
	}

	@Override
	public void hapus(int id) {
		for (Jadwal jadwal : jadwals)
			if (jadwal.getId() == id) {
				jadwals.remove(jadwal);
				break;
			}
	}

	@Override
	public List<Jadwal> getData(String asal, String tujuan, String tanggal,
			int kuota) {
		List<Jadwal> jadwalFilter = new ArrayList<Jadwal>();
		jadwalFilter.add(new Jadwal(1, "Gresik", "Bali", "12/3/2013", "12.00",
				30));
		jadwalFilter.add(new Jadwal(2, "Surabaya", "Bandung", "2/5/2013",
				"03.00", 90));
		return jadwalFilter;
	}

	@Override
	public Jadwal getData(int id) {
		return jadwals.get(0);
	}

	@Override
	public List<String> getKota() {
		List<String> kotas = new ArrayList<String>();
		kotas.add("Surabaya");
		kotas.add("Kediri");
		kotas.add("Gresik");
		kotas.add("Malang");
		kotas.add("Jakarta");
		kotas.add("Sidoarjo");
		kotas.add("Bandung");
		kotas.add("Semarang");
		kotas.add("Bojonegoro");
		return kotas;
	}
}
