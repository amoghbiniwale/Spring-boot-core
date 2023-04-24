package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Accounts;
import com.aurionpro.entity.Bank;
import com.aurionpro.repository.AccountsRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountsRepository accountsRepository;

	@Override
	public ResponseEntity<String> saveAccount(Accounts accData) {
		accountsRepository.save(accData);
		return ResponseEntity.ok("Accounts data saved");
	}

	@Override
	public Accounts getAccountById(Long accountNo) {
		return accountsRepository.findById(accountNo).get();
	}

	@Override
	public List<Accounts> getAccounts() {
		return accountsRepository.findAll();
	}

	@Override
	public ResponseEntity<String> updateBankDetails(Accounts bankData) {
		accountsRepository.save(bankData);
		return ResponseEntity.ok("account details updated successfully");
	}

	

}
