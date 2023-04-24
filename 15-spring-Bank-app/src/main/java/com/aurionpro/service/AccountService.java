package com.aurionpro.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.aurionpro.entity.Accounts;
import com.aurionpro.entity.Bank;

public interface AccountService {

	ResponseEntity<String> saveAccount(Accounts accData);

	Accounts getAccountById(Long accountNo);


	List<Accounts> getAccounts();

	ResponseEntity<String> updateBankDetails(Accounts bankData);

}
