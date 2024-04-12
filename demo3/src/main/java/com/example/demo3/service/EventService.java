package com.example.demo3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo3.model.Event;
import com.example.demo3.repository.EventRepo;

@Service
public class EventService {
    @Autowired
    EventRepo mr;

    public Event create(Event mm) {
        return mr.save(mm);
    }

    public List<Event> getAll() {
        return mr.findAll();
    }

    public Event getMe(int id) {
        return mr.findById(id).orElse(null);
    }

    public boolean updateDetails(int id, Event mm) {
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

    public boolean deleteProduct(int id) {
        if (this.getMe(id) == null) {
            return false;
        }
        mr.deleteById(id);
        return true;
    }

    public List<Event> sort(String field) {
        Sort sort = Sort.by(Sort.Direction.ASC, field);
        return mr.findAll(sort);
    }

    public List<Event> page(int pageSize, int pageNumber) {
        PageRequest page = PageRequest.of(pageNumber, pageSize);
        return mr.findAll(page).getContent();
    }

    // sorting and pagination
    public List<Event> getsort(int pageNumber, int pageSize, String field) {
        return mr.findAll(PageRequest.of(pageNumber, pageSize).withSort(Sort.by(Sort.Direction.ASC, field)))
                .getContent();
    }

    public List<Event> getUsersWithEvents() {

        return mr.findByPlace();
    }

}
