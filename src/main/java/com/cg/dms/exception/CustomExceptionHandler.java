package com.cg.dms.exception;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends  ResponseEntityExceptionHandler {
private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

@ExceptionHandler(DealerNotFoundException.class)
public ResponseEntity<Object> handleDealerNotFoundException() {
	LOG.error("handleDealerNotFoundException");
	HttpHeaders headers = new HttpHeaders();
	headers.add("message", "This Dealer is NOT available in the database.");
	return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
}
@ExceptionHandler(DealerAlreadyExistsException.class)
public ResponseEntity<Object> handleDealAlreadyExistsException(){
	LOG.error("handleDealAlreadyExistsException");
	HttpHeaders headers = new HttpHeaders();
	headers.add("message", "Dealer already exists");
	return new ResponseEntity<Object>(null,headers,HttpStatus.NOT_FOUND);
}
@ExceptionHandler(CompanyNotFoundException.class)
public ResponseEntity<Object> handleCompanyNotFoundException() {
	LOG.error("handleCompanyNotFoundException");
	HttpHeaders headers = new HttpHeaders();
	headers.add("message", "This Companyis NOT available in the database.");
	return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
}
@ExceptionHandler(FarmerNotFoundException.class)
public ResponseEntity<Object> handleFarmerNotFoundException1() {
	LOG.error("handleFarmerNotFoundException");
	HttpHeaders headers = new HttpHeaders();
	headers.add("message", "This Farmeris NOT available in the database.");
	return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
}
@ExceptionHandler(FarmerAlreadyExistsException.class)
public ResponseEntity<Object> FarmerAlreadyExists() {
	LOG.error("FarmerAlreadyExistsException");
	HttpHeaders headers = new HttpHeaders();
	headers.add("message", "This Farmeris NOT available in the database.");
	return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
}
@ExceptionHandler(CustomerNotFoundException.class)
public ResponseEntity<Object> handleCustomerNotFoundException() {

	LOG.error("handleEmployeeNotFoundException");
	HttpHeaders headers = new HttpHeaders();
	headers.add("message", "Customer data not foudnd");
	return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);

}

@ExceptionHandler(CustomerAlreadyExistsException.class)
public ResponseEntity<Object> handleCustomerAlreadyExistsException(){
	
	LOG.error("handleCustomerAlreadyExistsException");
	HttpHeaders headers = new HttpHeaders();
	headers.add("message","Customer data already exists in database");
	return new ResponseEntity<Object>(null,headers,HttpStatus.NOT_FOUND);
}
}