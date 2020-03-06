package com.ecart.jpa.controller;

import com.ecart.jpa.entity.Cart;
import com.ecart.jpa.entity.Transactions;
import com.ecart.jpa.service.BuyerService;
import com.ecart.jpa.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
@RequestMapping("/cart")
@CrossOrigin("*")
@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private BuyerService buyerService;
    
    @GetMapping(value = "/{buyerId}/getAll")
	public List<Cart> getAllCartItems(@PathVariable("buyerId")Long buyerId) {
	return cartService.getAllCartItems(buyerId);
	}

    @PostMapping(value="/buyers/{buyerId}/cart",produces="application/json")
    public Cart addCartItem(@PathVariable (value = "buyerId") Long buyerId,
                                 @Valid @RequestBody Cart cart) {
    	Optional<Cart> cartItem=cartService.addCartItem(cart,buyerId);
    	return cartItem.get();
    }

    @PutMapping(value="/buyers/{buyerId}/cart/{cartId}",produces="application/json")
    public Cart updateCartItem(@Valid @RequestBody Cart cart,@PathVariable (value = "cartId") Long cartId
                                 ) {
        return cartService.updateCartItem(cart,cartId);
    }
    
    @DeleteMapping(value = "/{cartId}/delete")
	public String deleteCartItem(@PathVariable("cartId") Long cartId) {
		return cartService.deleteCartItemById(cartId);
	}
	
	@DeleteMapping(value = "/{buyerId}/deleteall")
	public void emptyCart(@PathVariable("buyerId") Long buyerId) {
		cartService.emptyCart(buyerId);
	}
	
	@PostMapping(value = "/{buyerId}/checkout",produces = "application/json")
	public String checkoutCart(@RequestBody Transactions transaction, @PathVariable("buyerId") Long buyerId) {
		return cartService.checkOutCart(transaction,buyerId);
	
	}
    
}
