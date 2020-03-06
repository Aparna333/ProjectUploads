package com.ecart.jpa.controller;

import com.ecart.jpa.entity.Seller;
import com.ecart.jpa.service.SellerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping("/seller")
    public List<Seller> getAll(Seller seller) {
        return sellerService.getAll(seller);
    }

    @PostMapping("/seller")
    public Seller createSeller(@Valid @RequestBody Seller seller) {
        return sellerService.save(seller);
    }
    
}
