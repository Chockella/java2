/**
 * 
 */
package com.iia.ecommerce.entity;

//Imports
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

/**
 * @author jguerr
 *
 */
@Entity
public class Product {

	private static final GenerationType GenerationType_AUTO = null;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String Name;
	private String Description;
	private Integer Quantity;
	private Boolean Dead;
	
	protected Product(){}
	
	
	/**
	 * Constructor of class @see Product
	 * @param Name			@see String			Name of this @see Product
	 * @param Description	@see String			Description of this @see Product
	 * @param Quantity		@see Integer		Quantity of this @see Product
	 * @param Dead			@see Boolean		Dead of this @see Product
	 */
	public Product(String Name, String Description, Integer Quantity, Boolean Dead) {
		this.setName(Name)
			.setDescription(Description)
			.setQuantity(Quantity)
			.setDead(Dead);
	}
	
	//ToString method
	@Override
	public String toString() {
		return String.format(
				"Product(String Name'%s', String Description'%s', Integer Quantity '%d', Boolean Dead )",
				this.Name, this.Description, this.Quantity, this.Dead);
	}
	
	//Link to table
	@ManyToMany(mappedBy = "product")
	private Set<Caddy> caddys = new HashSet<Caddy>();
	
		
	//// GETTERS AND SETTERS 
	
	
	/**
	 * @return the caddys
	 */
	public Set<Caddy> getCaddys() {
		return caddys;
	}


	/**
	 * @param caddys the caddys to set
	 */
	public Product setCaddys(Set<Caddy> caddys) {
		this.caddys = caddys;
		return this;
	}


	/**
	 * Return the id
	 * @return the id
	 */
	public Long getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public Product setId(Long id) {
		Id = id;
		return this;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public Product setName(String name) {
		Name = name;
		return this;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}
	/**
	 * @param description the description to set
	 */
	public Product setDescription(String description) {
		Description = description;
		return this;
	}
	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return Quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public Product setQuantity(Integer quantity) {
		Quantity = quantity;
		return this;
	}
	/**
	 * @return the dead
	 */
	public Boolean getDead() {
		return Dead;
	}
	/**
	 * @param dead the dead to set
	 */
	public Product setDead(Boolean dead) {
		Dead = dead;
		return this;
	}
}
