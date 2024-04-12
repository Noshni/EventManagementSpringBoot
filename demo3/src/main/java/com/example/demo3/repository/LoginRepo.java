package com.example.demo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo3.model.Login;

public interface LoginRepo extends JpaRepository<Login, Integer> {

}