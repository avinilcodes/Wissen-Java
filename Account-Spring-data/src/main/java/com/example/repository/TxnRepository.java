package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Txn;

public interface TxnRepository extends JpaRepository<Txn, Integer>{

}
