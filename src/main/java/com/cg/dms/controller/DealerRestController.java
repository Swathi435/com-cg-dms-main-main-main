package com.cg.dms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dms.entities.Company;
import com.cg.dms.entities.Customer;
import com.cg.dms.entities.Dealer;
import com.cg.dms.exception.CompanyNotFoundException;
import com.cg.dms.exception.CustomerNotFoundException;
import com.cg.dms.exception.DealerAlreadyExistsException;
import com.cg.dms.exception.DealerNotFoundException;
import com.cg.dms.service.ICompanyService;
import com.cg.dms.service.ICustomerService;
import com.cg.dms.service.IDealerService;

//import antlr.collections.List;
 

@RestController
@RequestMapping("/api/f")

public class DealerRestController {
	
	private static final Logger LOG = LoggerFactory.getLogger(DealerRestController.class);
	
	 @Autowired
	    private IDealerService iDealerService;
	 @Autowired
	    private ICompanyService iCompanyService;
	 @Autowired
	    private ICustomerService iCustomerService;
	 
//	 @GetMapping("/Dealer")
//	    public List<Customer> getAllCustomer() {
//	        return iDealerService.getAllCustomers();
//	        }
//	 
//	 @PostMapping("/Dealer")
//	    public Dealer addDealer(@RequestBody Dealer user) throws DealerNotFoundException{
//
//	        // also just in case they pass an id in JSON ... set id to 0
//	        // this is to force a save of new item ... instead of update
//	        user.setDealerId(0);
//	        iDealerService.insertDealer(user);
//	        return user;
//	    }
	//https://localhost:8082/adddealer
	 @PostMapping("/adddealer")
		public ResponseEntity<Dealer> adddealer(@RequestBody Dealer dealer) throws DealerAlreadyExistsException{
			LOG.info("Controller addDealer");
			Dealer deal = iDealerService.insertDealer(dealer);
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", " New dealer is added to the Database");
			LOG.info(headers.toString());
			ResponseEntity<Dealer> response = new ResponseEntity<Dealer>(deal, headers, HttpStatus.OK);
			return response;
		}
	//https://localhost:8082/getdealbyid/{dealerId}
	 @GetMapping("/getdealbyid/{dealerId}")
		public ResponseEntity<Dealer> getDealById(@PathVariable(name = "dealerId") int dealerId) throws DealerNotFoundException {
			LOG.info("getdealById");
			Dealer deal = iDealerService.getDelaerById(dealerId);
			LOG.info(deal.toString());
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "This dealer is available in the database.");
			LOG.info(headers.toString());
			ResponseEntity<Dealer> response = new ResponseEntity<Dealer>(deal, headers, HttpStatus.OK);
			return response;
		}
	//https://localhost:8082/updatedealer
	 @PutMapping("/updatedealer")
		public ResponseEntity<Dealer> updateEmp(@RequestBody Dealer dealer) throws DealerNotFoundException {
			LOG.info("Controller updatedealer");
			Dealer deal = iDealerService.updateDealer(dealer);
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "This dealer data is updated in database.");
			ResponseEntity<Dealer> response = new ResponseEntity<Dealer>(deal, headers, HttpStatus.OK);
			return response;
		}
	//https://localhost:8082/deletedealbyid/{dealerid}
	 @DeleteMapping("/deletedealbyid/{dealerid}")
		public ResponseEntity<Dealer> deletedealById(@PathVariable(name = "dealerid") int dealerid) throws DealerNotFoundException {
			LOG.info("deletedealerbyid");
			Dealer dealer = iDealerService.deleteDealerById(dealerid);
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "This dealer is deleted from the Database");
			LOG.info(headers.toString());
			ResponseEntity<Dealer> response1 = new ResponseEntity<Dealer>(dealer, headers, HttpStatus.OK);
			return response1;
		}
//	 @GetMapping("/getallcustomer")
//		public List<Customer> getAllCustomer() {
//			LOG.info("getAllCustomer");  
//			LOG.info("getAllCustomer");  
//			LOG.info("getAllCustomer");  
//			 return ICustomerService.getAllCustomer();
//		}
	 //https://localhost:8082/getallcompany
	 @GetMapping("/getallcompany")
		public List<Company> getAllCompany() {
			LOG.info("getAllCompany"); 
			return iCompanyService.getAllCompany();
		}
	//https://localhost:8082/getCompanybyId/{id}
	 @GetMapping("/getCompanybyId/{id}")
		public ResponseEntity<Company> getCompanyById(@PathVariable(name = "CompanyId") int companyId) throws CompanyNotFoundException {
			LOG.info("getCompanyById");
			Company comp = iCompanyService.getCompanyById(companyId);
			LOG.info(comp.toString());
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "This Company is available in the database.");
			LOG.info(headers.toString());
			ResponseEntity<Company> response = new ResponseEntity<Company>(comp, headers, HttpStatus.OK);
			return response;
	 }
	//https://localhost:8082/getallcustomer
	 @GetMapping("/getallcustomer")
		public List<Customer> getAllCustomer() {
			LOG.info("getAllCustomer"); 
			return iCustomerService.getAllCustomers();
		}
	//https://localhost:8082/getcustomerId/{id}
	 @GetMapping("/getcustomerId/{id}")
		public ResponseEntity<Customer> getcustomerById(@PathVariable(name = "customerId") int customerId) throws CustomerNotFoundException {
			LOG.info("getcustomerById");
			Customer customer = iCustomerService.getCustomerById(customerId);
			LOG.info(customer.toString());
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "This Customer is available in the database.");
			LOG.info(headers.toString());
			ResponseEntity<Customer> response = new ResponseEntity<Customer>(customer, headers, HttpStatus.OK);
			return response;
	 }
}




//order milk to company, sell milk, get customer, send bill to customer

