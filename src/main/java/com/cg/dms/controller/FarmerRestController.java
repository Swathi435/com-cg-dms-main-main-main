package com.cg.dms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dms.entities.Farmer;
import com.cg.dms.exception.DealerNotFoundException;
import com.cg.dms.exception.FarmerNotFoundException;
import com.cg.dms.exception.FarmerAlreadyExistsException;
import com.cg.dms.service.IFarmerService;

@RestController
@RequestMapping("/api/f")
public class FarmerRestController {
	private static final Logger LOG = LoggerFactory.getLogger(DealerRestController.class);
	
    @Autowired
    private IFarmerService iFarmerService;
    @PostMapping("/adddfarmer")
	public ResponseEntity<Farmer> addfarmer(@RequestBody Farmer farmer) throws FarmerAlreadyExistsException  {
		LOG.info("Controller addfarmer");
		Farmer former = iFarmerService.insertFarmer(farmer);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", " New former is added to the Database");
		LOG.info(headers.toString());
		ResponseEntity<Farmer> response = new ResponseEntity<Farmer>(farmer, headers, HttpStatus.OK);
		return response;
	}
    @PutMapping("/updatefarmer")
	public ResponseEntity<Farmer> updatefarmer(@RequestBody Farmer farmer) throws FarmerNotFoundException {
		LOG.info("Controller updatefarmer");
	 Farmer farmer1 = iFarmerService.updatefarmer(farmer);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This farmer data is updated in database.");
		ResponseEntity<Farmer> response = new ResponseEntity<Farmer>(farmer, headers, HttpStatus.OK);
		return response;
	}
    @GetMapping("/getallfarmer")
	public List<Farmer> getAllFarmer() {
		LOG.info("getAllFarmer"); 
		LOG.info("getAllFarmer");  
		LOG.info("getAllFarmer");  

		return iFarmerService.getAllFarmer();
	}
    @GetMapping("/getFarmer/{dealerId}")
	public ResponseEntity<Farmer> getFarmer(@PathVariable(name = "Farmer") int dealerId) throws DealerNotFoundException {
		LOG.info("getFarmer");
		Farmer farmer = iFarmerService.getFarmer(dealerId);
		LOG.info(farmer.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This Farmer is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<Farmer> response = new ResponseEntity<Farmer>(farmer, headers, HttpStatus.OK);
		return response;
	}
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//
//    @GetMapping("/farmer")
//    public List<Farmer> getAllFarmer() {
//        return iFarmerService.getAllFarmer();
//    }
//
//    @PostMapping("/farmer")
//    public Farmer addFarmer(@RequestBody Farmer user){
//
//        // also just in case they pass an id in JSON ... set id to 0
//        // this is to force a save of new item ... instead of update
//        user.setFarmerId(0);
//        iFarmerService.addFarmer(user);
//        return user;
//    }
//
//    @PutMapping("/farmer")
//    public Farmer updateFarmer(@RequestBody Farmer farmer) {
//
//        iFarmerService.addFarmer(farmer);
//
//        return farmer;
//    }
//}