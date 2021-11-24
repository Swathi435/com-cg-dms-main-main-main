package com.cg.dms.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dms.entities.Farmer;
import com.cg.dms.exception.DealerNotFoundException;
import com.cg.dms.exception.FarmerAlreadyExistsException;
import com.cg.dms.exception.FarmerNotFoundException;
import com.cg.dms.repository.IFarmerRepository;

@Service
public class IFarmerService {
	private static final Logger LOG = LoggerFactory.getLogger(IDealerService.class);
    @Autowired
    private IFarmerRepository iFarmerRepository;
    
  
    public Farmer insertFarmer(Farmer farmer) throws FarmerAlreadyExistsException {
      LOG.info("Service add Farmer");
      if (!iFarmerRepository.existsById(farmer.getFarmerId())) {
			LOG.info("New Farmer is Added");
			return iFarmerRepository.save(farmer);
		} else {
			LOG.info("Farmer Data is already exists");
			throw new  FarmerAlreadyExistsException("Farmer already exists");
		}
    }
    
    public Farmer updatefarmer( Farmer farmer) throws  FarmerNotFoundException {
		LOG.info("Service update Farmer");
		if (iFarmerRepository.existsById(farmer.getFarmerId())) {
			LOG.info(" Farmer Data is Updated");
			return iFarmerRepository.save(farmer);
		}else {
		LOG.info(farmer.getFarmerId() + "  Farmer data is Not updated");
		throw new  FarmerNotFoundException(" Farmer Data is not updated");
		}
}
    public Farmer getFarmer(int dealerId) throws DealerNotFoundException {
		LOG.info("getFarmerId");
		Optional<Farmer> farmerOpt = iFarmerRepository.findById(dealerId);
		if (farmerOpt.isPresent()) {
			LOG.info("Farmer is available.");
			return farmerOpt.get();
		} else {
			LOG.info("Farmer is NOT available.");
			throw new DealerNotFoundException(dealerId + " this delaer is not found.");
		}
	}
    public List<Farmer> getAllFarmer() {
		LOG.info("Service getAllFarmer");
		return iFarmerRepository.findAll();
}
    }
//    public List<Farmer> getAllFarmer() {
//        return iFarmerRepository.findAll();
//    }
//
//    public void addFarmer(Farmer user){
//        iFarmerRepository.save(user);
//    }
//
//}