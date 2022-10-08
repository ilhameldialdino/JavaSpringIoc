package com.spring.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transactions{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This anotation function will make "TransactionID" become a Primary Key 
	@Column(name = "transactionId")
	private Long transactionId;                         // Primary Key of Trasaction table
	private String type;                                // Attribute of Transaction table
	private String date;                                // Attribute of Transaction table
	@ManyToOne                                          // Set relation beween "Transactions" table to "Users" table 
	@JoinColumn(name="UserId", nullable=false)          // Set the table relation using the primary key of "Users" table
	private Set<Users> users;                           // Foreign Key to build relation with Users table
	@OneToMany(mappedBy = "goodsId")                    // Set relation between "Transactions" table to "Goods" table
	private Set<Goods> goods;                           // Foreign Key to build relation with "Goods" table
	@ManyToMany(fetch = FetchType.LAZY,                                //Set relation between "Transactions" table to "Quotations" table
			cascade = { CascadeType.PERSIST, CascadeType.MERGE })      
	@JoinTable(name = "Transactions_Quotation",                        //Set the table realation using both primary key from each table 
			joinColumns = { @JoinColumn(name = "TransactionId")},      
			inverseJoinColumns= {@JoinColumn( name = "QuotationId")})  
	private Set<Quotations> quotations = new HashSet<>();              //Define the quotation into quptation object


}
