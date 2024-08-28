package com.recykal.JWT.repository;

import com.recykal.JWT.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository  extends JpaRepository<UserEntity,Integer> {

    UserEntity findByUname(String uname);
}
