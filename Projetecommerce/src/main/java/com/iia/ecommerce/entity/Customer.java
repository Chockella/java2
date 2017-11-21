/**
 * 
 */
package com.iia.ecommerce.entity;

import java.util.List;

//Imports
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author jguerr
 *
 */
@Entity
@Table(name="shop_customer")
public class Customer {
	
	/** Technical ID for Database*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	/** Last name of Customer*/ 
	@Column(nullable = false, unique = true, length = 255)
	private String lastName;
	/** First name of Customer*/
	@Column(nullable = false, length = 255)
	private String firstName;
	/**Phone number of Customer*/
	@Column(length=15)
	private String phone;
	/** Adress of Customer */
	@Column(length=255)
	private String adress;
	
	/** Code postal of Customer*/
	private Integer CP;
	/** City of Customer*/
	private String city;
	
	protected Customer(){}	
	
	/**
	 * Constructor of class @see Customer
	 * @param firstName		@see String			First Name of this @see Product
	 * @param lastName		@see String			Last Name of this @see Product
	 * @param phone			@see String			Phone of this @see Product
	 * @param adress		@see String			Adress of this @see Product
	 * @param CP			@see Integer		CP of this @see Product
	 * @param city			@see String			City of this @see Product
	 */
	public Customer(String firstName, String lastName, String phone, String adress, Integer CP, String city) {
		//FLUENT
		this.setAdress(adress)
			.setFirstName(firstName)
			.setLastName(lastName)
			.setPhone(phone)
			.setCP(CP)
			.setCity(city);
	}
	
	//ToString method
	@Override
	public String toString() {
		return String.format(
				"Customer(String firstName'%s', String lastName'%s', String phone '%s', String adress '%s', Integer CP '%d', String city'%s')",
				this.firstName, this.lastName, this.phone, this.adress, this.CP, this.city);
	}
	
	//Link to table
	@ManyToOne
	private List<Caddy> caddys;
	
	
	//// GETTERS AND SETTERS
	
	/**
	 * 
	 * @return the list caddy
	 */
	public List<Caddy> getCaddy() {
		return caddys;
	}

	/**
	 * @param caddy the caddy to set
	 */
	public Customer setCaddy(List<Caddy> caddys) {
		this.caddys = caddys;
		return this;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public Customer setId(Long id) {
		Id = id;
		return this;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public Customer setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public Customer setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public Customer setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	/**
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}
	/**
	 * @param adress the adress to set
	 */
	public Customer setAdress(String adress) {
		this.adress = adress;
		return this;
	}
	/**
	 * @return the cP
	 */
	public Integer getCP() {
		return CP;
	}
	/**
	 * @param cP the cP to set
	 */
	public Customer setCP(Integer cP) {
		CP = cP;
		return this;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public Customer setCity(String city) {
		this.city = city;
		return this;
	}
	
}
