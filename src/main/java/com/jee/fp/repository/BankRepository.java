package com.jee.fp.repository;

import java.util.List;

import com.jee.fp.domain.Bank;
import com.jee.fp.domain.Booking;

public interface BankRepository {
	List<Bank> getData();
	boolean validate(Booking book);
}
