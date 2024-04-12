package com.example.demo3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.model.Event;
import com.example.demo3.service.EventService;

@RestController
public class EventController {
    @Autowired
    EventService ms;

    @PostMapping("api/product")
    public ResponseEntity<Event> addelements(@RequestBody Event m) {
        Event mm = ms.create(m);
        return new ResponseEntity<>(mm, HttpStatus.CREATED);
    }

    @GetMapping("/api/products")
    public ResponseEntity<List<Event>> showinfo() {
        return new ResponseEntity<>(ms.getAll(), HttpStatus.OK);
    }

    @GetMapping("/api/product/{productId}")
    public ResponseEntity<Event> getById(@PathVariable Integer productId) {
        Event obj = ms.getMe(productId);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping("/api/product/{productId}")
    public ResponseEntity<Event> putMethodName(@PathVariable("productId") int id, @RequestBody Event m) {
        if (ms.updateDetails(id, m) == true) {
            return new ResponseEntity<>(m, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/api/product/{productId}")
    public ResponseEntity<Boolean> delete(@PathVariable("productId") int id) {
        if (ms.deleteProduct(id) == true) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/product/sortBy/{field}")
    public List<Event> g(@PathVariable String field) {
        return ms.sort(field);
    }

    @GetMapping("/api/product/{offset}/{pagesize}")
    public List<Event> get(@PathVariable int offset, @PathVariable int pagesize) {
        return ms.page(pagesize, offset);
    }

    // sorting and pagination
    @GetMapping("/api/product/{offset}/{pagesize}/{field}")
    public List<Event> getsorting(@PathVariable int offset, @PathVariable int pagesize, @PathVariable String field) {
        return ms.getsort(offset, pagesize, field);
    }

    @GetMapping("/eventPlace")
    public List<Event> getUsersWithEvents() {
        return ms.getUsersWithEvents();
    }

}
