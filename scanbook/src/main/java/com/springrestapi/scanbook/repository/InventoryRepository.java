package com.springrestapi.scanbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrestapi.scanbook.model.Inventory;


public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}