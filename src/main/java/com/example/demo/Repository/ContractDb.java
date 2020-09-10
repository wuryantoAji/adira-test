package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.ContractModel;

@Repository
public interface ContractDb extends JpaRepository<ContractModel, Long>{
}
