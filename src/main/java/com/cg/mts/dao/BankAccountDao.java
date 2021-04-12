package com.cg.mts.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mts.entities.BankAccount;
import com.cg.mts.repository.BankAccountRepository;

@Component("jpaBankAccountDao")
public class BankAccountDao implements IBankAccountDao {

	
	
	@Autowired
	BankAccountRepository bankrepo;
	
	
	public BankAccountDao() {
		
	}

	@Override
	public void save(BankAccount b) {
		// TODO Auto-generated method stub
		bankrepo.save(b);
		
	}

}
