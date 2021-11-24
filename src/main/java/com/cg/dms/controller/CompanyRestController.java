package com.cg.dms.controller;

import com.cg.dms.entities.Company;
import com.cg.dms.entities.Dealer;
import com.cg.dms.exception.CompanyNotFoundException;
import com.cg.dms.exception.DealerNotFoundException;
import com.cg.dms.service.ICompanyService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/c")
public class CompanyRestController {

	private static final Logger LOG = LoggerFactory.getLogger(DealerRestController.class);

	@Autowired
	private ICompanyService iCompanyService;

//    @PostMapping("/company")
//    public Company insertCompany(@RequestBody Company company){
//
//        // also just in case they pass an id in JSON ... set id to 0
//        // this is to force a save of new item ... instead of update
//        company.setId(0);
//        iCompanyService.insertCompany(company);
//        return company;
//    }

	@PostMapping("/addcompany")
	public ResponseEntity<Company> addcompany(@RequestBody Company company) throws CompanyNotFoundException {
		LOG.info("Controller addCompany");
		Company comp = iCompanyService.insertComapny(company);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", " New company is added to the Database");
		LOG.info(headers.toString());
		ResponseEntity<Company> response = new ResponseEntity<Company>(comp, headers, HttpStatus.OK);
		return response;
	}

	@GetMapping("/getcompanybyid/{companyId}")
	public ResponseEntity<Company> getcompanyById(@PathVariable(name = "companyId") int companyId)throws CompanyNotFoundException {
			 
		LOG.info("getcompanyById");
		Company company = iCompanyService.getCompanyById(companyId);
		LOG.info(company.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This company is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<Company> response = new ResponseEntity<Company>(company, headers, HttpStatus.OK);
		return response;
	}
	 @DeleteMapping("/deletecompanybyid/{companyid}")
		public ResponseEntity<Company> deletecompanyById(@PathVariable(name = "companyrid") int companyid) throws CompanyNotFoundException {
			LOG.info("deletecompanybyid");
			Company company = iCompanyService.deleteCompanyById(companyid);
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "This company is deleted from the Database");
			LOG.info(headers.toString());
			ResponseEntity<Company> response1 = new ResponseEntity<Company>(company, headers, HttpStatus.OK);
			return response1;
		}
	 @PutMapping("/updatecompany")
		public ResponseEntity<Company> updatecompany(@RequestBody Company company) throws CompanyNotFoundException {
			LOG.info("Controller company");
			 
			Company company1 = iCompanyService.updateCompany(company);
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "This company data is updated in database.");
			ResponseEntity<Company> response = new ResponseEntity<Company>(company, headers, HttpStatus.OK);
			return response;
		}


	@GetMapping("/getallcompany")
	public List<Company> getAllCompany() {
		LOG.info("getAllCompany");
		LOG.info("getAllCompany");
		LOG.info("getAllCompany");

		return iCompanyService.getAllCompany();
	}
}

//    @PutMapping("/company")
//    public Company updateCompany(@RequestBody Company company) {
//
//        iCompanyService.insertCompany(company);
//
//        return company;
//    }

//    @DeleteMapping("/company/{companyId}")
//    public String deleteCompany(@PathVariable int companyId) {
//
//        Company company = iCompanyService.findById(companyId);
//
//        // throw exception if null
//
//        if (company == null) {
//            throw new RuntimeException("Employee id not found - " + companyId);
//        }
//
//        iCompanyService.deleteCompanyById(companyId);
//
//        return "Deleted employee id - " + companyId;
//    }
//
//}
