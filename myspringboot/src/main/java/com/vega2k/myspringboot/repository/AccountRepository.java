package com.vega2k.myspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vega2k.myspringboot.entity.Account;


public interface AccountRepository extends JpaRepository<Account, Long>{

}