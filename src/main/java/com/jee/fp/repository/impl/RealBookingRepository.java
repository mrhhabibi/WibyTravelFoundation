package com.jee.fp.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jee.fp.domain.Booking;
import com.jee.fp.repository.BookingRepository;

@Service
public class RealBookingRepository implements BookingRepository {
	private List<Booking> bookings = new ArrayList<Booking>();

	@Override
	public List<Booking> getAll() {
		bookings.add(new Booking(null, null, "8763823", "Habibi",
				"12/12/12 12:12", 2));
		bookings.add(new Booking(null, null, "7862362", "Wiby", "9/2/11 13:12",
				3));
		return null;
	}

	@Override
	public void tambah(Booking booking) {
		bookings.add(booking);
	}

	@Override
	public Booking getData(String email) {
		for (Booking book : bookings) {
			if (book.getAnggota().getEmail() == email)
				return book;
		}
		return new Booking();
	}

	@Override
	public void hapus(String email) {
		for (int i = 0; i < bookings.size(); i++) {
			if (bookings.get(i).getAnggota().getEmail() == email) {
				bookings.remove(bookings.get(i));
				break;
			}
		}
	}
}
