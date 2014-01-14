package com.jee.fp.repository;

import java.util.List;

import com.jee.fp.domain.Booking;

public interface BookingRepository {
	List<Booking> getAll();
	void tambah(Booking booking);
}
