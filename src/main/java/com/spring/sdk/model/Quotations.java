/**
 * 
 */
package com.spring.sdk.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Ilham
 *
 */

@Entity
@Table(name = "quotations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quotations {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long quoatationId;
	private String quotationName; 
	
}
