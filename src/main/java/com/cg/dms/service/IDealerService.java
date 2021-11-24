package com.cg.dms.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dms.entities.Company;
import com.cg.dms.entities.Customer;
import com.cg.dms.entities.Dealer;
import com.cg.dms.exception.CompanyNotFoundException;
import com.cg.dms.exception.CustomerNotFoundException;
import com.cg.dms.exception.DealerAlreadyExistsException;
import com.cg.dms.exception.DealerNotFoundException;
import com.cg.dms.repository.ICompanyRepository;
import com.cg.dms.repository.ICustomerRepository;
import com.cg.dms.repository.IDelearRepository;

@Service
public class IDealerService {

	private static final Logger LOG = LoggerFactory.getLogger(IDealerService.class);

	@Autowired
	private IDelearRepository iDealerRepository;
	@Autowired
	private ICompanyRepository iCompanyRepository;
	@Autowired
	private ICustomerRepository iCustomerRepository;


	public Dealer insertDealer(Dealer dealer) throws DealerAlreadyExistsException {

		LOG.info("Service addDealer");

		if (!iDealerRepository.existsById(dealer.getDealerId())) {
			LOG.info("New Dealer is Added");
			return iDealerRepository.save(dealer);
		} else {
			LOG.info("Dealer Data is already exists");
			throw new DealerAlreadyExistsException("Dealer already exists");
		}
	}

	public Dealer getDelaerById(int dealerId) throws DealerNotFoundException {
		LOG.info("getDealerId");
		Optional<Dealer> dealerOpt = iDealerRepository.findById(dealerId);
		if (dealerOpt.isPresent()) {
			LOG.info("dealer is available.");
			return dealerOpt.get();
		} else {
			LOG.info("dealer is NOT available.");
			throw new DealerNotFoundException(dealerId + " this delaer is not found.");
		}
	}
		
		public Dealer updateDealer(Dealer dealer) throws DealerNotFoundException {
			LOG.info("Service updateDealer");
			if (iDealerRepository.existsById(dealer.getDealerId())) {
				LOG.info("dealear Data is Updated");
				return iDealerRepository.save(dealer);
			}else {
			LOG.info(dealer.getDealerId() + " dealer data is Not updated");
			throw new DealerNotFoundException("delaer Data is not updated");
			}
		}
	public Dealer deleteDealerById(int dealerId) throws DealerNotFoundException {
			LOG.info("Service deleteDealerById");
			Optional<Dealer> dealOpt = iDealerRepository.findById(dealerId);
			if(dealOpt.isPresent()) {
				LOG.info("Dealer is Available");
				iDealerRepository.deleteById(dealerId);
				return dealOpt.get();
			}
			else 
			{
				LOG.info("Dealer is not available");
				throw new DealerNotFoundException(dealerId + " this dealer is not found.");
			}
		}
	 public List<Company> getAllCompany() {
			LOG.info("Service getAllCompany");
			return iCompanyRepository.findAll();
	}
	 public Company getCompanyById(int companyId) throws CompanyNotFoundException {
			LOG.info("getCompanyById");
			Optional<Company> com = iCompanyRepository.findById(companyId);
			if (com.isPresent()) {
				LOG.info("Company is available.");
				return com.get();
			} else {
				LOG.info("Company is NOT available.");
				throw new CompanyNotFoundException(companyId+ " this company is not found.");
			}
		}
	 public List<Customer> getAllCustomer() {
			LOG.info("Service getAllCustomer");
			return iCustomerRepository.findAll();
		}
	 public Customer getcustomerById(int customerId) throws CustomerNotFoundException {
			LOG.info("getCustomerById");
			Optional<Customer> custmer = iCustomerRepository.findById(customerId);
			if (custmer.isPresent()) {
				LOG.info("Customer is available.");
				return custmer.get();
			} else {
				LOG.info("Customer is NOT available.");
				throw new CustomerNotFoundException(customerId+ " this Customer is not found.");
			}
	 }
}

//	public Dealer updateDealer(Dealer dealer) throws DealerNotFoundException;
//	public Dealer deleteDealer(Dealer dealer) throws DealerNotFoundException;

//	public List<Dealer> getDealer(int dealerId) {
//		return iDealerRepository.findAll();
//	}
//
//	public List<Customer> getAllCustomers() {
//		// TODO Auto-generated method stub
//		return null;


//	public List<Customer> getAllCustomers();
//	public List<Customer> getCustomer(int customerId);

// iDealerRepository.save(dealer);

//			 public Employee addEmployee(Employee employee) {
//					LOG.info("Service addEmployee");
//					if (!empRepository.existsById(employee.getEid())) {
//						LOG.info("New Employee is Added");
//						return empRepository.save(employee);
//					}else {
//					  LOG.info("Employee Data is already exists");
//					  throw new EmployeeNotFoundException("Employee already exists");
//					}
//				}
//			 
//	    	
//	    }
//	    	
