package com.example.Login.And.Registration.Using.Security.repository;

import com.example.Login.And.Registration.Using.Security.LoginAndRegistrationUsingSecurityApplication;
import com.example.Login.And.Registration.Using.Security.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends CrudRepository<Customer, Integer> {
    public  Customer findByUname(String cname);
}
