package com.example.demo.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.AccountModel;
import com.example.demo.Repository.AccountDb;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountDb account_db;

	@Override
	public List<AccountModel> get_all_account() {
		// TODO Auto-generated method stub
		return account_db.findAll();
	}

	@Override
	public AccountModel get_account_by_id(long id) {
		// TODO Auto-generated method stub
		return account_db.getOne(id);
	}

	@Override
	public void save_account(AccountModel account) {
		// TODO Auto-generated method stub
		account_db.save(account);
		
	}

	@Override
	public void delete_account(AccountModel account) {
		// TODO Auto-generated method stub
		account_db.delete(account);
	}

	@Override
	public void add_account(AccountModel account) {
		// TODO Auto-generated method stub
		save_account(account);
	}
	
}