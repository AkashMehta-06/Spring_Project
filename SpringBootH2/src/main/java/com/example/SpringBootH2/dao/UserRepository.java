package com.example.SpringBootH2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootH2.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer>{






	List<UserModel> findAllById(Integer id);

	List<UserModel> findAllByEmail(String email);



}