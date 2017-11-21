package com.iia.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.iia.ecommerce.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
