package com.spring.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String userID;
	private String userName;
	private String gender;
	@OneToMany(mappedBy = "transactionId")
    private Set<Transactions> transactions;
}
