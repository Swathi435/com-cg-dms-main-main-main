package com.cg.dms.service;

import com.cg.dms.controller.DealerRestController;
import com.cg.dms.entities.Company;
import com.cg.dms.entities.Dealer;
import com.cg.dms.exception.CompanyNotFoundException;
import com.cg.dms.exception.DealerNotFoundException;
import com.cg.dms.repository.ICompanyRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ICompanyService {

	private static final Logger LOG = LoggerFactory.getLogger(DealerRestController.class);

	@Autowired
	private ICompanyRepository iCompanyRepository;

//    public void insertCompany(int company){
//        iCompanyRepository.save(company);
//    }
//
//    public void deleteCompanyById(int id) {
//        iCompanyRepository.deleteById(id);
//    }
//
//    public Company findById(int id) {
//        Optional<Company> result = iCompanyRepository.findById(id);
//
//        Company company = null;
//
//        if (result.isPresent()) {
//            company = result.get();
//        }
//        else {
//            // we didn't find the company
//            throw new RuntimeException("Did not find company id - " + id);
//        }
//
//        return company;
//    }

	public Company insertComapny(Company company) throws CompanyNotFoundException {

		LOG.info("Service addCompany");

		if (!iCompanyRepository.existsById(company.getId())) {
			LOG.info("New Company is Added");
			return iCompanyRepository.save(company);
		} else {
			LOG.info("Company Data is already exists");
			throw new CompanyNotFoundException("Company already exists");
		}
	}

	public Company getCompanyById(int companyId) throws CompanyNotFoundException {
		LOG.info("getCompanyId");
		Optional<Company> companyOpt = iCompanyRepository.findById(companyId);
		if (companyOpt.isPresent()) {
			LOG.info("company is available.");
			return companyOpt.get();
		} else {
			LOG.info("company is NOT available.");
			throw new CompanyNotFoundException(companyId + " this company is not found.");
		}
	}

	public Company deleteCompanyById(int companyId) throws CompanyNotFoundException {
		LOG.info("Service deleteCompanyById");
		Optional<Company> companyOpt = iCompanyRepository.findById(companyId);
		if (companyOpt.isPresent()) {
			LOG.info("Company is Available");
			iCompanyRepository.deleteById(companyId);
			return companyOpt.get();
		} else {
			LOG.info("Company is not available");
			throw new CompanyNotFoundException(companyId + " this dealer is not found.");
		}
	}

	public Company updateCompany(Company company) throws CompanyNotFoundException {
		LOG.info("Service companyDealer");
		if (iCompanyRepository.existsById(company.getId()) )
				{
			LOG.info("Company Data is Updated");
			return iCompanyRepository.save(company);
		} else {
			LOG.info(company.getCompanyName() + " Company data is Not updated");
			throw new CompanyNotFoundException("Company Data is not updated");
		}
	}

	public List<Company> getAllCompany() {
		LOG.info("Service getAllCompany");
		return iCompanyRepository.findAll();
	}

}
