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
		jadwals.add(new Jadwal(1, "Gresik", "Bali", "12/3/2013", 3));
		jadwals.add(new Jadwal(2, "Surabaya", "Bandung", "2/5/2013", 9));
		jadwals.add(new Jadwal(3, "Kediri", "Bengkulu", "11/4/2014", 2));
		jadwals.add(new Jadwal(4, "Jakarta", "Banyuwangi", "13/3/2014", 1));
	}

	@Override
	public List<Jadwal> getData() {
		return jadwals;
	}

	@Override
	public void tambah(Jadwal jadwal) {
		jadwals.add(jadwal);
	}

}
