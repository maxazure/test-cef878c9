package nz.co.cocca.test.javatest;

import com.alibaba.fastjson.JSON;
import nz.co.cocca.test.javatest.service.IUserService;
import nz.co.cocca.test.javatest.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;



@RestController
public class Controller {

    private final static Logger logger = LoggerFactory.getLogger(Controller.class);
    @Autowired
    IUserService userService;

    @RequestMapping("/users")
    public ResponseEntity<?> listAllUsers() {

        // Requirement:

        // Retrieve all users from https://reqres.in/api/users
        // Note that https://reqres.in/api/users returns a pageable result. You'll need to handle the pagination logic and to dump all users from that API.
        // After you dumped all users from the API, sort the records in alphabetical order based on each person's last_name.

        // Implementation starts below
        //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


        try
        {
            List<User> users = userService.getAllUsers();
            String res = JSON.toJSON(users).toString();
            return new ResponseEntity<>(res, HttpStatus.OK);

        }catch(Exception ex) // if anything is wrong, print "Sorry, something was wrong."
        {
            logger.error("getAllUsers Error {0}", ex);
            return new ResponseEntity<>("Sorry, something was wrong.", HttpStatus.OK);
        }


    }

}