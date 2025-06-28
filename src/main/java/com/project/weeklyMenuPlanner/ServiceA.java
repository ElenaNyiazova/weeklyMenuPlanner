package com.project.weeklyMenuPlanner;

import com.project.weeklyMenuPlanner.data.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceA {
    private final Repository repo;

    public List<User> getAllUsers() {
        return repo.findAll();
    }
}
