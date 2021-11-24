package com.cg.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.dms.entities.Dealer;

public interface IDelearRepository extends JpaRepository<Dealer, Integer>{
	


  // public Dealer insertDealer(Dealer dealer);
}
//
//	public Dealer updateDealer Dealer dealer) throws DealerNotFoundException;
//
//	public Dealer deleteDealer(Dealer dealer) throws DealerNotFoundException;
//
//	public List<Dealer> getDealer(int dealerId);
//
//	public List<Customer> getAllCustomers();
//	public List<Customer> getCustomer(int customerId);
//	public List<Company> getAllCompanys();
//	public Company getCompany(int comapnyId);
