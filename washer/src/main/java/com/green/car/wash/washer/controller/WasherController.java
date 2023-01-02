package com.green.car.wash.washer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.green.car.wash.washer.model.OrderDetails;
import com.green.car.wash.washer.model.WashPacks;
import com.green.car.wash.washer.service.WasherService;

import java.util.List;


@RestController
@RequestMapping("/washers")
public class WasherController {
    @Autowired
    WasherService wr;
    
    /** Only the methods that consume rest template are below this comment **/
    //To see the Unassigned orders
    @GetMapping("/findUnassigned")
    public List<OrderDetails> getUnassignedOrders(){
        return wr.getUnassignedOrders();
    }
    //The status of the order can be either pending or completed
    @PutMapping("/updateStatus")
    public OrderDetails updateStatusoftheOrder(@RequestBody OrderDetails orderDetails){
        return wr.updateStatus(orderDetails);
    }
    //To assign a washer to the order by washer
    @PutMapping("/assign")
    public OrderDetails assignSelf(@RequestBody OrderDetails orderDetails){
        return wr.assignSelf(orderDetails);
    }
    //To see all the wash packs
    @GetMapping("/seeWP")
    public List<WashPacks> getAllWP(){
        return wr.getAllWP();
    }
    
}
