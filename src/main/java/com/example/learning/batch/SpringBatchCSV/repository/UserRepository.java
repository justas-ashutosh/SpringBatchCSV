package com.example.learning.batch.SpringBatchCSV.repository;

import com.example.learning.batch.SpringBatchCSV.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
}
