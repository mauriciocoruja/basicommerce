package com.uniesquina.basicommerce.repositories;

import com.uniesquina.basicommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
