package com.ecart.jpa.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecart.jpa.entity.Items;
import com.ecart.jpa.service.ItemService;

@RequestMapping("/item")
@CrossOrigin(origins="*")
@RestController
public class ItemController {
     
	@Autowired
	private ItemService itemService;
	
	@PostMapping(value = "/seller/{sellerId}/items", produces = "application/json")
    public Items addItem(@RequestBody Items item,@PathVariable (value = "sellerId") Long sellerId) {
    	 Optional<Items> newItem=itemService.addItem(item,sellerId);
    	 return newItem.get();
    }
  
	@PutMapping("/sellers/{sellerId}/items/{itemId}")
    public Items updateItem(@PathVariable (value = "itemId") Long sellerId,
                                 @Valid @RequestBody Items items) {
       return itemService.updateItem(sellerId, items);
    }
	
	@DeleteMapping(value = "/{itemId}/delete")
	public String deleteItem(@PathVariable("itemId") Long itemId) {
		return itemService.deleteItemById(itemId);
	}
	 
    @GetMapping(value = "/{sellerId}/getAll")
	public List<Items> getAllItems(@PathVariable("sellerId")Long sellerId) {
	   return itemService.getAllItems(sellerId);
	}
    
    @DeleteMapping(value = "/{sellerId}/deleteall")
	public void deleteAll(@PathVariable("sellerId") Long sellerId) {
		itemService.deleteAll(sellerId);
	}
    
    @GetMapping(value="/get/{itemName}" ,produces = "application/json")
    public List<Items> getMatchingProduct(@PathVariable("itemName") String itemName) {
    	System.out.println("controller");
    	return itemService.SearchItem(itemName);
    }
}