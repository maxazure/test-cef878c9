package nz.co.cocca.test.javatest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/users")
    public ResponseEntity<?> listAllUsers() {
    	
    	// Requirement:
    	
    	// Retrieve all users from https://reqres.in/api/users
    	// Note that https://reqres.in/api/users returns a pageable result. You'll need to handle the pagination logic and to dump all users from that API.  
    	// After you dumped all users from the API, sort the records in alphabetical order based on each person's last_name.
    	
    	// Implementation starts below
    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}