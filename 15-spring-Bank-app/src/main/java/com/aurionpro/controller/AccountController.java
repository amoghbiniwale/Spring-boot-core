package com.aurionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Accounts;
import com.aurionpro.entity.Bank;
import com.aurionpro.service.AccountService;
import com.aurionpro.service.BankService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/saveAccount")
	public ResponseEntity<String> saveAccount(@RequestBody Accounts accData) {
		return accountService.saveAccount(accData);
	}
	
	@GetMapping("/getAccountByid/{accountNo}")
	public Accounts getAccountById(@PathVariable Long accountNo) {
		return accountService.getAccountById(accountNo);
	}
	
	@GetMapping("/getAccounts")
	public List<Accounts> getAccounts(){
		return accountService.getAccounts();
	}
	
	@PutMapping("/updateAccountDetails")
	public ResponseEntity<String> updateAccountDetails(@RequestBody Accounts bankData){
		return accountService.updateBankDetails(bankData);
	}
	
}
