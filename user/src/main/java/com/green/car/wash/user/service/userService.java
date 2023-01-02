package com.green.car.wash.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.green.car.wash.user.model.OrderDetails;
import com.green.car.wash.user.model.WashPacks;

import java.util.Arrays;
import java.util.List;

@Service
public class userService {
    @Autowired
    private RestTemplate restTemplate;

    //Url to access the methods of Order Service
    String url="http://ORDER-SERVICE/orders";
   

    //To see all the WashPacks
	  public List<WashPacks> getAllWP(){ 
		  WashPacks wp=restTemplate.getForObject(url+"/findallWP",WashPacks.class); 
		  return (Arrays.asList(wp)); 
		  }
	 
    /** Only the methods that use rest template are below this comment**/
    //To add an order from User-end
    public OrderDetails addOrder(OrderDetails orderDetails){
        HttpEntity<OrderDetails> addOrderbyUser = new HttpEntity<>(orderDetails);
        return restTemplate.postForObject(url+"/add",addOrderbyUser,OrderDetails.class);
    }
    //To update an order from User-end
    //This won't update the status of order
    public OrderDetails updateOrder(OrderDetails orderDetails){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderDetails> updatedOrder = new HttpEntity<>(orderDetails,headers);
        return restTemplate.exchange(url+"/update", HttpMethod.PUT,updatedOrder,OrderDetails.class).getBody();
    }
    //To cancel the Order from user end
    public String cancelOrder(OrderDetails orderDetails){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderDetails> cancelledOrder = new HttpEntity<>(orderDetails,headers);
        ResponseEntity<String> response=restTemplate.exchange(url+"/cancelOrder",HttpMethod.PUT,cancelledOrder,String.class);
        return response.getBody();
    }
	
}
