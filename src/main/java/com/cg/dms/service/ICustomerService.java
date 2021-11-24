package com.cg.dms.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dms.entities.Customer;
import com.cg.dms.exception.CustomerAlreadyExistsException;
import com.cg.dms.exception.CustomerNotFoundException;
import com.cg.dms.repository.ICustomerRepository;

	@Service
	public class ICustomerService {

		private static final Logger LOG = LoggerFactory.getLogger(ICustomerService.class);

		@Autowired
		private ICustomerRepository icustomerRepository;

//		public List<Customer>viewCustomers() throws CustomerNotFoundException;
		public List<Customer> getAllCustomers() {
			LOG.info("Get All Customer Services");
			return icustomerRepository.findAll();
		}

//		public Customer insertCustomer(Customer customer);
		public Customer insertCustomer(Customer customer) throws CustomerNotFoundException {
			LOG.info("add New Customer Service");
			Optional<Customer> custom = icustomerRepository.findById(customer.getCustomerId());
			if(custom.isPresent())
				throw new CustomerAlreadyExistsException(customer.getCustomerId()+"is already present in Customer data");
			else
				return icustomerRepository.save(customer);		
		}

		// public Customer updateCustomer(Customer customer) throws
		// CustomerNotFoundException;
		public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
			LOG.info("Update Customer");
			if (icustomerRepository.existsById(customer.getCustomerId())) {
				LOG.info("Already data is available");
				return icustomerRepository.save(customer);
			} else {
				LOG.info("Customer data is not updated");
				throw new CustomerNotFoundException(customer + "this customer is not Updated");
			}
	 }
		

		// public Customer deleteCustomer(Customer customer) throws
		// CustomerNotFoundException;
		public Customer deleteCustomer(int customerId) throws CustomerNotFoundException {
			LOG.info("Delete Customer By CustomerId");
			Optional<Customer> customId = icustomerRepository.findById(customerId);
			if (customId.isPresent()) {
				LOG.info("Customer is available");
				icustomerRepository.deleteById(customerId);
				return customId.get();
			} else {
				LOG.info("Customer Data not Found");
				throw new CustomerNotFoundException(customerId + " --> customer Id not found ");
			}
		}

		// public Customer viewCustomer(int customerId) throws
		// CustomerNotFoundException;
		public Customer viewCustomer(int customerId) throws CustomerNotFoundException {
			LOG.info("View customer by customerId");
			Optional<Customer> customId = icustomerRepository.findById(customerId);
			if (customId.isPresent()) {
				LOG.info("Customer Data Found");
				return customId.get();
			} else {
				LOG.info("Customer Data not Found");
				throw new CustomerNotFoundException(customerId + " --> customer Id not found ");
			}

		}
//		public List<Customer> getAllCustomer() {
//			LOG.info("Service getAllCustomer");
//			return icustomerRepository.findAll();
//		}
		
		public  Customer getCustomerById(int customerId) throws CustomerNotFoundException {
			LOG.info("getcustomerId");
			Optional<Customer> CustomerOpt = icustomerRepository.findById(customerId);
			if (CustomerOpt.isPresent()) {
				LOG.info("Customer is available.");
				return CustomerOpt.get();
			} else {
				LOG.info("Customer is NOT available.");
				throw new CustomerNotFoundException(customerId + " this Customer is not found.");
			}
		}


//		public Customer validateCustomer(String username, String password) throws CustomerNotFoundException;
		/*
		 * public Customer validateCustomer(String username,String password) throws
		 * CustomerNotFoundException { LOG.info("Validating Customer credntials");
		 * 
		 * return null; }
		 */

	}

	// Extra added
	//
	//

//	public Customer insertCustomer(Customer customer);
//	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
//	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException;
//	public List<Customer>viewCustomers() throws CustomerNotFoundException;
//	public Customer viewCustomer(int customerId) throws CustomerNotFoundException;
//	public Customer validateCustomer(String username, String password) throws CustomerNotFoundException;
//}