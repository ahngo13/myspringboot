package com.vega2k.myspringboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vega2k.myspringboot.entity.Account;


public interface AccountRepository extends JpaRepository<Account, Long>{
	//finder method
	Optional<Account> findByUsername(String username);
}