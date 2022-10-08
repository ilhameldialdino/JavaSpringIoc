package com.spring.sdk.services;

import com.spring.sdk.model.Goods;
import com.spring.sdk.repository.GoodsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GoodsService{

	@Autowired
	GoodsRepository goodsRepository;
	
	public Goods createGoods(Goods goods) {
		return goodsRepository.save( goods );
	}
	
	public Iterable<Goods> findAll() {
        return goodsRepository.findAll();
    }
}
