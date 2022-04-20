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

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserAccountController {

	@Autowired
	UserAccountService userAccountService;
	@Autowired
	UserAccountRepository userAccountRepository;

	@RequestMapping(value = "/create-account", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<UserAccount> createAccount() {
		UserAccount account = new UserAccount();

		return new ResponseEntity<>(account, HttpStatus.OK);
	}

	@RequestMapping(value = "/create-account", method = RequestMethod.POST)
	public UserAccount handleCreateAccount(@RequestBody UserAccount account) {
		userAccountRepository.save(account);
		
		return account;
	}

	@RequestMapping(value = "/login",

			method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<UserAccount> loginAccount(@RequestBody UserAccount account) {
		System.out.println(account);

		UserAccount loginAccount = userAccountRepository.login(account.getEmail(), account.getPassword());
			System.out.println(loginAccount.getFirst_Name());
//		if (loginAccount == null) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
		return new ResponseEntity<>(loginAccount, HttpStatus.OK);
	}

	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserAccount> getAccount(@PathVariable("id")Long id) {

		return new ResponseEntity<>(userAccountService.getAccount(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/account/settings/update/{userAccountId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<UserAccount> getAccountToUpdate(@PathVariable("userAccountId") Long id) {

		return new ResponseEntity<>(userAccountService.getAccount(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/account/settings/update/", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<UserAccount> updateAccount(@RequestBody UserAccount account) {

		if (account.getId() == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(userAccountService.handleUpdateAccount(account), HttpStatus.OK);
	}

	@RequestMapping(value = "/account/settings/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<UserAccount> deleteAccount(@RequestBody UserAccount account) {

		userAccountRepository.delete(account);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@RequestMapping(value = "/account/settings/deleteworkout", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<UserAccount> deleteWorkoutFromAccount(@RequestBody UserAccount account) {
		account.setPlan(null);
		account.setWorkoutStartDate(null);
		userAccountRepository.save(account);
		return new ResponseEntity<>(account, HttpStatus.OK);
	}

}
