package com.ecart.jpa.controller;

import com.ecart.jpa.entity.Buyer;
import com.ecart.jpa.service.BuyerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
//@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @GetMapping("/buyer")
    public List<Buyer> getAll(Buyer buyer) {
        return buyerService.findAll();
    }

    @RequestMapping(value="/buyers",method= RequestMethod.POST,produces = "application/json")
    public Buyer createBuyer(@RequestBody Buyer buyer) {
        return buyerService.createBuyer(buyer);
    }

    @RequestMapping(value="/buyers/{buyerId}",method=RequestMethod.PUT,produces="application/json")
    public Buyer updateBuyer(@RequestBody Buyer buyer) {
        return buyerService.updateBuyer(buyer);
    }
    
    @GetMapping(value="/get/{buyerId}")
    public Optional<Buyer> getById(@PathVariable(value="buyerId") Long buyerId) {
    	
    	return buyerService.getBuyerById(buyerId);
    }
    
}
