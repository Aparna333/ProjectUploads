package com.ecart.jpa.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecart.jpa.entity.Buyer;
import com.ecart.jpa.entity.Cart;
import com.ecart.jpa.entity.Items;
import com.ecart.jpa.entity.PurchaseHistory;
import com.ecart.jpa.entity.Transactions;
import com.ecart.jpa.exception.ResourceNotFoundException;
import com.ecart.jpa.repository.BuyerRepository;
import com.ecart.jpa.repository.CartRepository;
import com.ecart.jpa.repository.ItemRepository;
import com.ecart.jpa.repository.PurchaseRepository;
import com.ecart.jpa.repository.TransactionRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private BuyerRepository buyerRepository;
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	public Optional<Cart> addCartItem( Cart cartItem, Long buyerId) {
		return buyerRepository.findById(buyerId).map(buyer -> {
			cartItem.setBuyer(buyer);
			return cartRepository.save(cartItem);});
		//}).orElseThrow(() -> new ResourceNotFoundException("BuyerId " + buyerId + " not found"));
	}

	public Cart updateCartItem(Cart cart,Long cartId) {
		Optional<Cart> cartItem = cartRepository.findById(cartId);
		Cart b=null;
		if(cartItem.isPresent()) {
			b = cartItem.get();
			b.setQuantity(cart.getQuantity());
			
		return cartRepository.save(b); 
		}
		return null;
	}
	
	public String deleteCartItemById(Long cartId) {
		cartRepository.deleteById(cartId);
		return "Item with cartId "+cartId+" is deleted.";
	}
	
	public void emptyCart(Long buyerId) {
		
		cartRepository.emptyCart(buyerId);
	}
	
	/*public String checkoutCart(Long buyerId) {
		Double totalAmount = 0.00;
		Transactions transaction = null;
		PurchaseHistory purchaseHistory = null;
		Items cartItem = null;
		//Integer iter = 0;
		List<Cart> getAllCart = cartRepository.getAllCartItems(buyerId);
		for(Cart cart : getAllCart) {
			Optional<Items> item = itemRepository.findAllByItemId(cart.getItemId());
			totalAmount += item.get().getPrice();
		}
		Optional<Buyer> buyer  = buyerRepository.findById(buyerId);
		transaction = new Transactions();
		transaction.setBuyerId(buyer.get());
		transaction.setTotalAmount(totalAmount);
		transaction.setTransactionType("Debited");
		transaction.setRemarks("PaymentDone");

		transactionRepository.save(transaction);


		for(Cart cart : getAllCart) {
			//System.out.println(iter++);
			purchaseHistory = new PurchaseHistory();
			purchaseHistory.setTransactions(transaction);
			purchaseHistory.setItemId(cart.getItemId());
			purchaseHistory.setBuyer(buyer.get());
			purchaseHistory.setRemarks("purchased");
			purchaseHistory.setNumberOfItems(cart.getQuantity());

			purchaseRepository.save(purchaseHistory);

			cartItem = new Items();
			Optional<Items> newitem = itemRepository.findById(cart.getItemId());
			cartItem = newitem.get();
			Long quantity = cartItem.getStockNumber();
			cartItem.setStockNumber(quantity-cart.getQuantity());

			itemRepository.save(cartItem);

		}

		cartRepository.emptyCart(buyerId);

		return "Successful";
	}*/

	public List<Cart> getAllCartItems(Long buyerId) {
		
		return cartRepository.getAllCartItems(buyerId);
	}

	public String checkOutCart(Transactions transaction, Long buyerId) {
	
		Buyer buyer=buyerRepository.getOne(buyerId);
		System.out.println(buyer);
		transaction.setBuyer(buyer);
		transactionRepository.save(transaction);
		List<Cart> cart=cartRepository.getAllCartItems(buyerId);
		for(int i=0;i<cart.size();i++) {
			PurchaseHistory purchaseHistory=new PurchaseHistory();
			Cart newCart=cart.get(i);
			int size=newCart.getQuantity();
			purchaseHistory.setNumberOfItems(size);
			purchaseHistory.setBuyer(buyer);
			cartRepository.deleteById(newCart.getCartId());
			purchaseRepository.save(purchaseHistory);
		}
		
		return null;
	}
}

