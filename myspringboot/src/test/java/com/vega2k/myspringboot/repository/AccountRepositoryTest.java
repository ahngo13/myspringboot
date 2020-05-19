package com.vega2k.myspringboot.repository;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vega2k.myspringboot.entity.Account;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {
   @Autowired
   AccountRepository accountRepository;
   
   @Test
   public void optional() throws Exception{
	   Optional<Account> notnullOpt = accountRepository.findByUsername("spring");
	   System.out.println(notnullOpt.isPresent());
	   Account account = notnullOpt.get();
	   System.out.println(account);
	   
	   Optional<Account> nullOpt = accountRepository.findByUsername("test");
	   System.out.println(nullOpt.isPresent());
	   
	   Optional<Account> opt1 = accountRepository.findByUsername("test");
	   Account acct1 = opt1.orElse(new Account()); // 있는 경우와 없는 경우 모두 커버가능
	   System.out.println(acct1);
	   
	   //orElseThrow(Supplier)
	   //Supplier의 추상메서드 T get()
	   Account acct2 = opt1.orElseThrow(() -> new RuntimeException("Account Not Found"));
	   System.out.println(acct2);
	   
   }
   
   @Test @Ignore
   public void account() throws Exception{
      Account account = new Account();
      account.setUsername("spring");
      account.setPassword("1234");
      
      //등록
      Account saveAccount = accountRepository.save(account);
      
      System.out.println(saveAccount);
      
      //조회 (finder method 호출)
//      Account existAcct = accountRepository.findByUsername(saveAccount.getUsername());
//      System.out.println(existAcct);
   }
}