package com.jee.fp.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jee.fp.domain.Anggota;
import com.jee.fp.repository.AnggotaRepository;

@Service
public class FakeAnggotaRepository implements AnggotaRepository {

	private List<Anggota> anggotas=new ArrayList<Anggota>();
	
	public FakeAnggotaRepository() {
		anggotas.add(new Anggota("mrhabibi","Habibi","rizkyhabibi09@gmail.com","085733030815"));
		anggotas.add(new Anggota("wiby","Wiby","wiby115@gmail.com","08348265254"));
		anggotas.add(new Anggota("ilmi","Ilmi","ilmiandalan@gmail.com","0818762482"));
		anggotas.add(new Anggota("rimby","Rimby","distributorsusu@gmail.com","08928394235"));
	
	}
	
	@Override
	public List<Anggota> getData() {
		return anggotas;
	}

	@Override
	public void tambah(Anggota anggota) {
		anggotas.add(anggota);
	}

	@Override
	public void hapus(String username) {
		// TODO Auto-generated method stub
	}
	
}
