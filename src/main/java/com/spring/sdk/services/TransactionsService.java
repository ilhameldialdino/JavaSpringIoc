package com.spring.sdk.services;

import com.spring.sdk.model.Transactions;
import com.spring.sdk.model.Quotations;
import com.spring.sdk.repository.TransactionsRepository;
import com.spring.sdk.repository.QuotationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class TransactionsService{
	
	@Autowired
	TransactionsRepository transactionsRepository;
	
	@Autowired
	QuotationsRepository quotationsRepository;
	
	public Transactions createTransactions( Transactions transactions ) {
		return transactionsRepository.save( transactions );
	}
	
	public void assignQuotations(Map<String,Object> body) {
        Long convertedLong = Long.parseLong(body.get("transactioId").toString());
        Transactions transactions = transactionsRepository.findOneId(convertedLong);
        List<Object> list = new ArrayList<>();
        if (body.get("quotations").getClass().isArray()){
            list = Arrays.asList((Object[])body.get("quotations"));
        }else if (body.get("quotations") instanceof Collection) {
            list = new ArrayList<>((Collection<?>)body.get("quotations"));
        }
        Set<Quotations> quotations = new HashSet<>();
        list.stream().forEach(value -> {
        	Quotations quotation = quotationsRepository.findOneName(value.toString());
            if (quotation != null){
                quotations.add(quotation);
                System.out.println(quotation);
                transactions.setQuotations(quotations);
            }
        });
        transactionsRepository.save(transactions);
        
	}

	public Iterable<Transactions> findAll() {
        return transactionsRepository.findAll();
    }

}
