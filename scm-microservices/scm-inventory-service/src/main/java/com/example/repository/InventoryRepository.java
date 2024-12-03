package com.example.repository;

import com.example.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {

    // Метод для поиска товара по SKU
    Optional<InventoryItem> findBySku(String sku);
}
