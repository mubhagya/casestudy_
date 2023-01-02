package com.green.car.wash.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.green.car.wash.user.Repository.UserRepo;
import com.green.car.wash.user.model.AuthenticationRequest;
import com.green.car.wash.user.model.AuthenticationResponse;
import com.green.car.wash.user.model.JwtUtil;
import com.green.car.wash.user.model.OrderDetails;
import com.green.car.wash.user.model.Ratings;
import com.green.car.wash.user.model.User1;
import com.green.car.wash.user.model.WashPacks;
import com.green.car.wash.user.service.MyUserDetailsService;
import com.green.car.wash.user.service.RatingsService;
import com.green.car.wash.user.service.userService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private userService us;
    @Autowired
    private RatingsService rs;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private MyUserDetailsService userDetailsService;
    
    @Autowired
    private JwtUtil jwtTokenUtil;
    
    @Autowired
    UserRepo userRepo;

    /** Only User-end Rating controls below this **/
    //To add a rating from User-end
    @PostMapping("/addRating")
    public Ratings addRating(@RequestBody Ratings ratings){
        return rs.addRating(ratings);
    }
    //For user to see ratings to decide the service
    @GetMapping("/getallRatings")
    public List<Ratings> getallratings(){
        return rs.getallRatings();
    }
    //For user to check a washer's history to make informed decision
    @GetMapping("/washerSpecificRating/{washerName}")
    public List<Ratings> washerecifSpicRating(@PathVariable String washerName){
    		 return rs.washerSpecific(washerName);
    }
	

    //To see all the wash packs
    @GetMapping("/seeWP")
    public List<WashPacks> getAllWP(){
        return us.getAllWP();
    }
	

    /** Only the methods that call rest-template methods from services are below this comment**/
    //To add an order from User-end
    @PostMapping("/addOrder")
    public OrderDetails addOrder(@RequestBody OrderDetails orderDetails){
        return us.addOrder(orderDetails);
    }
    //To update and order from User-end
    //This won't update the status of order
    @PutMapping("/updateOrder")
    public OrderDetails updateOrder(@RequestBody OrderDetails orderDetails){
       return us.updateOrder(orderDetails);
    }
    //To cancel the Order from user end
    @PutMapping("/cancelOrder")
    public String cancelOrder(@RequestBody OrderDetails orderDetails){
        return us.cancelOrder(orderDetails);
    }
    
    
    @PostMapping("/reg")
    private ResponseEntity<?> subscribe(@RequestBody AuthenticationRequest request)
    {
      
        String username = request.getUsername();
        String password = request.getPassword();

 

        User1 model = new User1();
        model.setUsername(username);
        model.setPassword(password);

 

        try {
            userRepo.save(model);
        } catch (Exception e) {
            return ResponseEntity.ok(new AuthenticationResponse("Error while subsribing the user with username " + username));
        }
            return ResponseEntity.ok(new AuthenticationResponse("client subscribed with username " + username));
    }

    @RequestMapping(value="/authenticate", method=RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest  authenticationRequest) throws Exception {
        try
        {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
    }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

 


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

 

        final String jwt = jwtTokenUtil.generateToken(userDetails);

 

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
