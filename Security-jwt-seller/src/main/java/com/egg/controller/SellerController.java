package com.egg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.egg.model.Seller;
import com.egg.service.SellerService;

import java.util.List;

import javax.validation.Valid;

@RestController
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping("/seller/getAll")
    public List<Seller> getAll(Seller seller) {
        return sellerService.getAll(seller);
    }

    @PostMapping(value = "/seller", produces = "application/json")
    public Seller createSeller(@Valid @RequestBody Seller seller) {
        return sellerService.save(seller);
    }
    
}
