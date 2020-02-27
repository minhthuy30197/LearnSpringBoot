package com.example.demo.repository;

import com.example.demo.entity.IdentityCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityCardRepository extends JpaRepository<IdentityCard, Integer> {
}
