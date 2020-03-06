package com.ecart.jpa.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ecart.jpa.entity.Items;
import com.ecart.jpa.repository.ItemRepository;
import com.ecart.jpa.repository.SellerRepository;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private SellerRepository sellerRepository;

	public Optional<Items> addItem(Items item, Long sellerId) {
		return sellerRepository.findById(sellerId).map(seller -> {
			item.setSeller(seller);
			return itemRepository.save(item);
		});
	}

	public Items updateItem(Long sellerId,Items items) {
		Optional<Items> newItem = itemRepository.findById(sellerId);
		Items b=null;
		if(newItem.isPresent()) {
			b = newItem.get();
			b.setCategory(items.getCategory());
			b.setSubCategory(items.getSubCategory());
			b.setItemName(items.getItemName());
			b.setPrice(items.getPrice());
			b.setDescription(items.getDescription());
			b.setRemarks(items.getRemarks());
			b.setStockNumber(items.getStockNumber());
			return itemRepository.save(b); 
		}
		return null;
	}

	public String deleteItemById(Long itemId) {
		itemRepository.deleteById(itemId);
		return "Item with cartId "+itemId+" is deleted.";
	}
	public List<Items> getAllItems(Long sellerId) {

		return itemRepository.getAllItems(sellerId);
	}
	public void deleteAll(Long sellerId) {

		itemRepository.deleteAll(sellerId);
	}

	public List<Items> SearchItem(String itemName) {
		System.out.println("service");
		return itemRepository.findItem(itemName);
	}
}


