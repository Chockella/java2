/**
 * 
 */
package com.iia.ecommerce;

// Imports
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.iia.ecommerce.entity.Caddy;
import com.iia.ecommerce.entity.Customer;
import com.iia.ecommerce.entity.Product;
import com.iia.ecommerce.repository.CaddyRepository;
import com.iia.ecommerce.repository.CustomerRepository;
import com.iia.ecommerce.repository.ProductRepository;


/**
 * @author jguerr
 *Main Application
 */

@SpringBootApplication
public class Application {
	
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);
		
	}
	
	@Bean
	public CommandLineRunner customer(CustomerRepository repository,ProductRepository productRepository, CaddyRepository caddyRepository1) {
		return (args) ->{
			
			repository.deleteAll();
			
			Customer customer = new Customer("Joris", "Guerrier", "0202020202", "24 allee des grives",49000,"Angers");
			repository.save(customer);			
			repository.save(new Customer("jean","jack", "0101010101", "blabla", 32000, "nantes"));
			repository.save(new Customer("Jean","BonBeurre", "0303030303", "blabla", 32000, "Quimper"));
			
			productRepository.deleteAll();
			
			Product prod = new Product("Gateau", "Chocolat", 2, true);
			productRepository.save(prod);
			productRepository.save(new Product("Cheval", "DeTroie", 95, true));
			productRepository.save(new Product("Benjamin", "Portugais ", 1, true));
			
			
			
			
			
			
		};
	}
	
}
