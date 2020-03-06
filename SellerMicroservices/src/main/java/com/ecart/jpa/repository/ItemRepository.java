package com.ecart.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ecart.jpa.entity.Items;
import com.ecart.jpa.entity.Seller;

@Repository
public interface ItemRepository extends JpaRepository<Items, Long>{

	@Query(value = "SELECT * FROM Items cart WHERE items.seller_Id_fk = :sellerId" ,nativeQuery = true)
	public List<Items> getAllItems(@Param("sellerId")Long sellerId);
	//Optional<Seller> findByIdAndPostId(Long sellerId, Long itemId);
	@Query(value = "DELETE FROM Items WHERE items.seller_Id_fk = :sellerId" ,nativeQuery = true)
	public void deleteAll(@Param("sellerId")Long sellerId);
	
	@Query(value="from Items WHERE item_name Like %:itemName%")
	public List<Items> findItem(@Param("itemName")String itemName);

}
