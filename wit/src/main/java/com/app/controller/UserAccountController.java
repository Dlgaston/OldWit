package com.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.UserAccount;
import com.app.repository.UserAccountRepository;
import com.app.service.UserAccountService;

@CrossOrigin()
@RestController
public class UserAccountController {

	@Autowired
	UserAccountService userAccountService;
	@Autowired
	UserAccountRepository userAccountRepository;
	
	
	@RequestMapping(value="/create-account",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<UserAccount> createAccount () {
			UserAccount account = new UserAccount();
			
			return new ResponseEntity<>(account, HttpStatus.OK);
	}
	
	@RequestMapping(value="/create-account",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST)
	public void handleCreateAccount(@RequestBody UserAccount account) {
		userAccountRepository.save(account);
	}
	
	@RequestMapping(value="/login",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<UserAccount> loginAccount (@RequestBody UserAccount account) {
		
		UserAccount loginAccount = userAccountRepository.login(account.getEmail(), account.getPassword());
			
			if(loginAccount == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(loginAccount, HttpStatus.OK);
	}
	@RequestMapping(value="/account/{userAccountId}",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<UserAccount> getAccount (@PathVariable("userAccountId") Long id ) {
			
			
			return new ResponseEntity<>(userAccountService.getAccount(id), HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/account/settings/update/{userAccountId}",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<UserAccount> getAccountToUpdate (@PathVariable("userAccountId") Long id ) {
			
			
			return new ResponseEntity<>(userAccountService.getAccount(id), HttpStatus.OK);
	}

	@RequestMapping(value="/account/settings/update/",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<UserAccount> updateAccount (@RequestBody UserAccount account) {
			
			if(account.getId() == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(userAccountService.handleUpdateAccount(account), HttpStatus.OK);
	}
	@RequestMapping(value="/account/settings/delete",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<UserAccount> deleteAccount (@RequestBody UserAccount account) {
		
		userAccountRepository.delete(account);
		return new ResponseEntity<>(HttpStatus.OK);
		
			
	}
	@RequestMapping(value="/account/settings/deleteworkout",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<UserAccount> deleteWorkoutFromAccount (@RequestBody UserAccount account) {
		account.setPlan(null);
		account.setWorkoutStartDate(null);
		userAccountRepository.save(account);
		return new ResponseEntity<>(account,HttpStatus.OK);
	}
	
}

