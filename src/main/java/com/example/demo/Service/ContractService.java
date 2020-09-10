package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.ContractModel;

public interface ContractService {
	List<ContractModel> get_all_contract();
	void save_contract(ContractModel contract);
	void add_contract(ContractModel contract);
	void do_payment(int nominal, int kontrak_no);
}

