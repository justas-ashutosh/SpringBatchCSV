package com.example.learning.batch.SpringBatchCSV.Writer;

import com.example.learning.batch.SpringBatchCSV.pojo.Users;
import com.example.learning.batch.SpringBatchCSV.repository.UserRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Item_Writer implements ItemWriter<Users> {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void write(List<? extends Users> users) throws Exception {
        System.out.println("Data Saved for Users: " + users);
        userRepository.saveAll(users);
    }
}
