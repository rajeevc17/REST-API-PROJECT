package com.springrestapi.scanbook.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.scanbook.dao.InventoryDAO;
import com.springrestapi.scanbook.model.Inventory;

@RestController
@RequestMapping("/library")
public class InventoryController {
	
	@Autowired
	InventoryDAO invDAO;
	
	
	@PostMapping("/books")
	public Inventory createInventory(@Valid @RequestBody Inventory bk) {
		return invDAO.save(bk);
	}
	
	
	
	
	
	@GetMapping("/books/{barcode}")
	public ResponseEntity<Inventory> getBookById(@PathVariable(value="barcode") Long bkcode){
		
		Inventory bk=invDAO.findOne(bkcode);
		
		if(bk==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(bk);
		
	}
	
	
	
	@PutMapping("/books/{barcode}")
	public ResponseEntity<Inventory> updateInventory(@PathVariable(value="barcode") Long bkcode,@Valid @RequestBody Inventory bkDetails){
		
		Inventory bk=invDAO.findOne(bkcode);
		if(bk==null) {
			return ResponseEntity.notFound().build();
		}
		
		bk.setTitle(bkDetails.getTitle());
		bk.setFinish(bkDetails.getFinish());
		bk.setAuthor(bkDetails.getAuthor());
		bk.setPages(bkDetails.getPages());
		
		Inventory updateBook=invDAO.save(bk);
		return ResponseEntity.ok().body(updateBook);
		
		
		
	}
	
	
	@DeleteMapping("/books/{barcode}")
	public ResponseEntity<Inventory> deleteBook(@PathVariable(value="barcode") Long bkcode){
		
		Inventory bk=invDAO.findOne(bkcode);
		if(bk==null) {
			return ResponseEntity.notFound().build();
		}
		invDAO.delete(bk);
		
		return ResponseEntity.ok().build();
		
		
	}
	
}
