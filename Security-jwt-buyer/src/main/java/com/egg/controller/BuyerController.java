package com.egg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.egg.model.Buyer;
import com.egg.service.BuyerService;

import java.util.Optional;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @GetMapping("/buyer")
    public Page<Buyer> getAll(Pageable pageable) {
        return buyerService.findAll(pageable);
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
