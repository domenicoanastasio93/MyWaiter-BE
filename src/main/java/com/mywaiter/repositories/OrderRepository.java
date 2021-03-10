package com.mywaiter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mywaiter.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
