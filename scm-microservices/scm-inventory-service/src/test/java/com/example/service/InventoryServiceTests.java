//package com.example.service;
//
//import com.example.model.InventoryItem;
//import com.example.repository.InventoryRepository;
//import com.example.service.InventoryService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@SpringBootTest
////@RunWith(SpringRunner.class)
//public class InventoryServiceTests {
//
//    @Autowired
//    private InventoryService inventoryService;
//
//    @Autowired
//    private InventoryRepository inventoryRepository;
//
//    @Test
//    public void testCheckAvailability_SufficientStock() {
//        // Arrange
//        InventoryItem item = new InventoryItem();
//        item.setId(1L);
//        item.setQuantity(100);
//        inventoryRepository.save(item);
//
//        // Act
//        boolean available = inventoryService.getItemById(1L).isPresent();
//
//        // Assert
//        assertTrue(available);
//    }
//
//    @Test
//    public void testCheckAvailability_InsufficientStock() {
//        // Arrange
//        InventoryItem item = new InventoryItem();
//        item.setId(1L);
//        item.setQuantity(5);
//        inventoryRepository.save(item);
//
//        // Act
//        boolean available = inventoryService.getItemById(1L).isPresent();
//
//        // Assert
//        assertFalse(available);
//    }
//
//    @Test
//    public void testUpdateInventory_AfterStockChange() {
//        // Arrange
//        InventoryItem item = new InventoryItem();
//        item.setId(1L);
//        item.setQuantity(50);
//        inventoryRepository.save(item);
//
//
//        InventoryItem item2 = new InventoryItem();
//        item.setId(1L);
//        item2.setQuantity(30);
//        // Act
//        inventoryService.updateItem(1L, item2); // Simulate item being sold
//        InventoryItem updatedItem = inventoryRepository.getById(1L);
//
//        // Assert
//        assertEquals(30, updatedItem.getQuantity());
//    }
//}
