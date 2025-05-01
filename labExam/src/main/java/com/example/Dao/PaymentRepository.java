package com.example.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>
{

}
