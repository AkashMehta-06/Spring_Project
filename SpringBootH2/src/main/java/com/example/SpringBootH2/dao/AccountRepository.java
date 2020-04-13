package com.example.SpringBootH2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootH2.model.AccountModel;

public interface AccountRepository extends JpaRepository<AccountModel, Integer>{



	List<AccountModel> findAllById(Integer id);

	

	

}
