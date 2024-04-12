package com.example.demo3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo3.model.Login;
import com.example.demo3.repository.LoginRepo;

@Service
public class LoginService {
    @Autowired
    LoginRepo mr;

    public Login create(Login mm) {
        return mr.save(mm);
    }

    public List<Login> getAll() {
        return mr.findAll();
    }

    public Login getMe(int id) {
        return mr.findById(id).orElse(null);
    }

    public boolean updateDetails(int id, Login mm) {
        if (this.getMe(id) == null) {
            return false;
        }
        try {
            mr.save(mm);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deleteLogin(int id) {
        if (this.getMe(id) == null) {
            return false;
        }
        mr.deleteById(id);
        return true;
    }
    // public List<Login> getUsersWithStateEvents() {

    // return mr.findByState();
    // }
}