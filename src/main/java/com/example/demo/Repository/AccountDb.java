package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.AccountModel;

@Repository
public interface AccountDb extends JpaRepository<AccountModel, Long>{
	AccountModel findByUsername(String username);
}