package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
	
	@Query("SELECT S FROM UserAccount S WHERE S.email = ?1 and S.password = ?2")
	public UserAccount login(String email, String password);

	@Query("SELECT S FROM UserAccount S WHERE S.email = ?1")
	public UserAccount getEMail(String email);
}
