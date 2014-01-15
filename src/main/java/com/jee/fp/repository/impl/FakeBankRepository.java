package com.jee.fp.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jee.fp.domain.Bank;
import com.jee.fp.domain.Booking;
import com.jee.fp.repository.BankRepository;

@Service
public class FakeBankRepository implements BankRepository {

	List<Bank> banks = new ArrayList<Bank>();
	
	@Override
	public List<Bank> getData() {
		banks.add(new Bank("123","Wiby",300000));
		banks.add(new Bank("234","Habibi",500000));
		return null;
	}

	@Override
	public boolean validate(Booking book) {
		return true;
	}
	
}
