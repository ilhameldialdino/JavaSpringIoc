/**
 * 
 */
package com.spring.sdk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.sdk.model.Users;
import com.spring.sdk.model.Transactions;
import com.spring.sdk.model.Goods;

import com.spring.sdk.services.UsersService;
import com.spring.sdk.services.TransactionsService;
import com.spring.sdk.services.GoodsService;

import java.util.Map;

/**
 * @author Ilham
 *
 */
@RestController
@RequestMapping("/method")
public class Controller {

	@Autowired
	UsersService usersService;
	
	@Autowired
	TransactionsService transactionsService;

	@Autowired
	GoodsService goodsService;
	
	
	//--------------------------------------//
	
	@Autowired
	Users users;
	
	@Autowired
	Transactions transactions;
	
	@Autowired
	Goods goods;
	
	//---------------------------------------------------------------------------------------//
	
	@RequestMapping("/createUsers")
	private ResponseEntity<?> createUsers(@RequestBody Users users){
		Users createdUsers = usersService.createUsers(users);
		return ResponseEntity.ok().body(createdUsers);
	}
	
	@RequestMapping("/createTransactions")
	private ResponseEntity<?> createTransactions(@RequestBody Transactions transactions){
		Transactions createdTransactions = transactionsService.createTransactions(transactions);
		return ResponseEntity.ok().body(createdTransactions);
	}

	@RequestMapping("/createGoods")
	private ResponseEntity<?> createGoods(@RequestBody Goods goods){
		Goods createdGoods = goodsService.createGoods(goods);
		return ResponseEntity.ok().body(createdGoods);
	}
	
	//---------------------------------------------------------------------------------------//
	
	@RequestMapping("/assignQuotations")
	private ResponseEntity<?> assignQuotations(@RequestBody Map<String,Object> transactions){
		transactionsService.assignQuotations(transactions);
		return ResponseEntity.ok().build();
	}
	
	//---------------------------------------------------------------------------------------//
	
	@RequestMapping("/getUsers")
	private ResponseEntity<?> getUsers(){
		Iterable<Users> users = usersService.findAll();
		return ResponseEntity.ok().body(users);
	}
	
	@RequestMapping("/getTransactions")
	private ResponseEntity<?> getTransactions(){
		Iterable<Transactions> transactions = transactionsService.findAll();
		return ResponseEntity.ok().body(transactions);
	}

	@RequestMapping("/getGoods")
	private ResponseEntity<?> getGoods(){
		Iterable<Goods> goods = goodsService.findAll();
		return ResponseEntity.ok().body(goods);
	}
	
}