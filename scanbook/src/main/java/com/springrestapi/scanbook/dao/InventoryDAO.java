package com.springrestapi.scanbook.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestapi.scanbook.model.Inventory;
import com.springrestapi.scanbook.repository.InventoryRepository;

@Service
public class InventoryDAO {
	
	@Autowired
	InventoryRepository invRepository;
	
	
	public Inventory save(Inventory bk) {
		return invRepository.save(bk);
	}
	
	
	
	public Inventory findOne(Long bkcode) {
		return invRepository.findOne(bkcode);
	}
	
	
	public void delete(Inventory bk) {
		invRepository.delete(bk);
	}
	

}
