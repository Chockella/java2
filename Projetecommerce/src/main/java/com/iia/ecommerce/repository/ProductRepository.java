/**
 * 
 */
package com.iia.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.iia.ecommerce.entity.Product;

/**
 * @author jguerr
 *
 */
public interface ProductRepository extends CrudRepository<Product, Long>{

}
