package com.lcwd.user.service.reposiratory;

import com.lcwd.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserReposiratory extends JpaRepository<User, Long> {
}
