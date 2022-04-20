package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.entity.UserAccount;
import com.app.repository.UserAccountRepository;

@Service
public class UserAccountService {

	@Autowired
	UserAccountRepository userAccountRepository;

	public UserAccount handleUpdateAccount(UserAccount account) {
		Optional<UserAccount> updateAccount = userAccountRepository.findById(account.getId());
		if (updateAccount.isPresent()) {
			UserAccount accountFound = updateAccount.get();
			accountFound.setAge(account.getAge());
			accountFound.setFirst_Name(account.getFirst_Name());
			accountFound.setLast_Name(account.getLast_Name());
			accountFound.setWeight(account.getWeight());
			accountFound.setPicture(account.getPicture());
			accountFound.setUsername(account.getUsername());
			accountFound.setEmail(account.getEmail());
			accountFound.setPassword(account.getPassword());
			return userAccountRepository.save(accountFound);
		}
		return null;

	}
	public UserAccount getAccount(Long id) {
		Optional<UserAccount> updateAccount = userAccountRepository.findById(id);
		if (updateAccount.isPresent()) {
			UserAccount accountFound = updateAccount.get();
			return userAccountRepository.save(accountFound);
		}
		return null;
	
}
	public UserAccount getAccountByEmail(String email) {
		Optional<UserAccount> updateAccount = userAccountRepository.getEMail(email);
		if (updateAccount.isPresent()) {
			UserAccount accountFound = updateAccount.get();
			return userAccountRepository.save(accountFound);
		}
		return null;
	
}

	
}
