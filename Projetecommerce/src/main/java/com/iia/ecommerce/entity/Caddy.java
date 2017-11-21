/**
 * 
 */
package com.iia.ecommerce.entity;

//Imports
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * @author jguerr
 *
 */
@Entity
@Table(name="Caddy")
public class Caddy {

	/** Technical Id for Database*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	/** Date of the command */
	@Column
	private Date date;
	@Column
	private CaddyState state;
	@Column
	private float totalPrice;
	
	protected Caddy() {}
	
	/**
	 * Constructor of class @see Caddy
	 * @param date			@see Date			date of this @see Caddy
	 * @param state			@see CaddyState		State of this @see Caddy
	 * @param totalPrice	@see Float			totalPrice of this @see Caddy
	 */
	public Caddy(Date date, CaddyState state, float totalPrice) {
		//FLUENT
		this.setDate(date)
			.setState(state)
			.setTotalPrice(totalPrice);
	}
	
	
	@OneToMany(mappedBy="Caddy")
	private Customer customer;
	
	//Getter
	/**
	 * @return the customers
	 */
	public Customer getCustomers() {
		return customer;
	}

	//Setter
	/**
	 * @param customers the customers to set
	 */
	public Caddy setCustomers(Customer customer) {
		this.customer = customer;
		return this;
	}

	//Link to table
	@ManyToMany(targetEntity=Product.class, cascade = {CascadeType.ALL})
	@JoinTable(
			name = "Caddy_Product",
			joinColumns = {@JoinColumn(name = "caddy_id")},
			inverseJoinColumns = {@JoinColumn(name = "project_id")}
			)
		private Set<Product> products = new HashSet<Product>();
	
	
	///// GETTERS AND SETTERS
	
	/**
	 * @return the products
	 */
	public Set<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public Caddy setProducts(Set<Product> products) {
		this.products = products;
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
	 * @return this @see Caddy
	 */
	public Caddy setId(Long id) {
		Id = id;
		return this;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public Caddy setDate(Date date) {
		this.date = date;
		return this;
	}
	/**
	 * @return the state
	 */
	public CaddyState getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public Caddy setState(CaddyState state) {
		this.state = state;
		return this;
	}
	/**
	 * @return the totalPrice
	 */
	public float getTotalPrice() {
		return totalPrice;
	}
	/**
	 * @param totalPrice the totalPrice to set
	 */
	public Caddy setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
		return this;
	}
	
	
	
}
