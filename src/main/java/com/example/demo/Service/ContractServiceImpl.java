package com.example.demo.Service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ContractModel;
import com.example.demo.Repository.ContractDb;


@Service
@Transactional
public class ContractServiceImpl implements ContractService {
	int current_id = 1;
	
	@Autowired
	private ContractDb contract_db;

	@Override
	public void save_contract(ContractModel contract) {
		// TODO Auto-generated method stub
		contract_db.save(contract);
	}

	@Override
	public void add_contract(ContractModel contract) {
		// TODO Auto-generated method stub
		int tenor = contract.getTotal_tenor();
		int angsuran = contract.getPokok_hutang()/tenor;
		int bunga = ((contract.getRate_kredit()*contract.getPokok_hutang())/tenor)/100;
		for(int i = 0 ; i < tenor ; i++) {
			ContractModel db_contract = contract;
			db_contract.setId(++current_id);
			db_contract.setTenor_ke(i+1);
			db_contract.setAngsuran(angsuran);
			db_contract.setBunga(bunga);
			Date tanggal_kredit = contract.getTanggal_kredit_input();
			db_contract.setTanggal_kredit(tanggal_kredit);
			save_contract(db_contract);
		}
	}

	@Override
	public List<ContractModel> get_all_contract() {
		// TODO Auto-generated method stub
		return contract_db.findAll();
	}

	@Override
	public void do_payment(int nominal, int kontrak_no) {
		// TODO Auto-generated method stub
		for(int i = current_id ; i < contract_db.findAll().size() ; i++) {
			ContractModel contract = contract_db.getOne(Long.valueOf(i));
			if(contract.getContract_no() == Long.valueOf(kontrak_no)) {
				if(nominal <= contract.getAngsuran()) {
					contract.setBayar_angsuran(nominal);
				}else if(nominal == contract.getAngsuran() + contract.getBunga()) {
					contract.setBayar_angsuran(contract.getAngsuran());
					contract.setBayar_bunga(contract.getBunga());
				}else {
					contract.setBayar_angsuran(contract.getAngsuran());
					contract.setBayar_bunga(contract.getBunga());
					nominal = nominal - (contract.getAngsuran()+contract.getBunga());
				}
			}
		}
	}
	
	
}
