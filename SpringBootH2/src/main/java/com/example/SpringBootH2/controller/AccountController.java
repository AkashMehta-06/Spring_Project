package com.example.SpringBootH2.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootH2.dao.AccountRepository;
import com.example.SpringBootH2.model.AccountModel;

@RestController
@RequestMapping(value="/api/account")
public class AccountController {
	
	
	@Autowired
	private AccountRepository repository;
	
	@PostMapping("/createAccount")
	public AccountModel createAccount(@RequestBody AccountModel account){
		return repository.save(account);
	}
	
	@GetMapping("/getAccountById")
	public List<AccountModel> getAccountById(@PathVariable Integer id){
		return repository.findAllById(id);
	}
	
	@PutMapping("/updateAccountById/{id}")
	public String updateAccountById(@RequestBody AccountModel account,@PathVariable Integer id){
	        repository.save(account);
	        return "Updated value..";  	
	}
	
	@DeleteMapping("/deleteAccountById/{id}")
	public String deleteAccountById(@PathVariable Integer id){
		repository.deleteById(id);
		return "Deleted Account..";
	}	

}