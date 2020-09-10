package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.AccountModel;

public interface AccountService{
	List<AccountModel> get_all_account();
	AccountModel get_account_by_id(long id);
	void save_account(AccountModel account);
	void add_account(AccountModel account);
	void delete_account(AccountModel account);
	
}