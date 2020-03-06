package com.ecart.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Repository;

import com.ecart.jpa.entity.Items;

@Repository
public interface ItemRepository extends JpaRepository<Items,Long> {

	Optional<Items> findAllByItemId(Long long1);

}
