package com.example.springbatch.batch;

import com.example.springbatch.model.User;
import com.example.springbatch.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DBWriter implements ItemWriter<User> {

    private final UserRepository userRepository;

    @Override
    public void write(Chunk<? extends User> chunk) throws Exception {
        System.out.println("Data Saved for Users: " + chunk);
        userRepository.saveAll(chunk);
    }
}
