package com.uniesquina.basicommerce.resources;

import com.uniesquina.basicommerce.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/userrs")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L,"Maria","maria@maria.com"
                ,"999999999","12345");
        return ResponseEntity.ok().body(u);
    }

}
