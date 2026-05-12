package com.hyfbe.pet_sitter.repository;

import com.hyfbe.pet_sitter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    public boolean existsByEmployeeId(Long id);

}
