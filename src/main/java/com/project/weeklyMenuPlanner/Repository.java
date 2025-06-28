package com.project.weeklyMenuPlanner;

import com.project.weeklyMenuPlanner.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<User, Long> {}
