package com.jee.fp.repository;

import java.util.List;

import com.jee.fp.domain.Booking;

public interface BookingRepository {
	List<Booking> getAll();
	Booking getData(String email);
	void tambah(Booking booking);
	void hapus(String email);
}
