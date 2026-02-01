package com.project.ecommerceapp.service.impl;

import com.project.ecommerceapp.dto.InventoryRequest;
import com.project.ecommerceapp.dto.InventoryResponse;
import com.project.ecommerceapp.entity.Inventory;
import com.project.ecommerceapp.exception.ProductNotFoundException;
import com.project.ecommerceapp.repository.InventoryRepository;
import com.project.ecommerceapp.repository.ProductRepository;
import com.project.ecommerceapp.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(InventoryServiceImpl.class);

    @Override
    public InventoryResponse changeInventory(InventoryRequest inventoryRequest) {

        logger.info("InventoryRequest: {}", inventoryRequest);

        Inventory inventory = getInventory(inventoryRequest.getProduct().getId());

        inventory.setQuantity(inventoryRequest.getQuantity());
        inventoryRepository.save(inventory);
        logger.info("Inventory List: {}", inventoryRepository.findAll());
        Inventory savedInventory = inventoryRepository.findById(inventory.getId()).orElseThrow(() -> new ProductNotFoundException("InventoryService: No inventory present with product id: " + inventory.getId()));
        return modelMapper.map(savedInventory, InventoryResponse.class);
    }

    @Override
    public List<InventoryResponse> findAll() {
        List<Inventory> inventoryList = inventoryRepository.findAll();
        return inventoryList.stream().map(inventory -> mapToInventoryResponse(inventory)).collect(Collectors.toList());
    }

    @Override
    public void deleteInventory(Long id) {
        inventoryRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("No Inventory with ID: " + id + " present in DB"));
        inventoryRepository.deleteById(id);
    }

    private InventoryResponse mapToInventoryResponse(Inventory inventory) {
        return modelMapper.map(inventory, InventoryResponse.class);
    }

    private Inventory getInventory(Long productId) {
        Inventory inventory = inventoryRepository.findInventoryByProductId(productId);
        if(inventory == null){
            inventory = new Inventory();
            inventory.setProduct(productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product with ID: " + productId + " not found!")));
            inventory.setQuantity(0L);
            inventoryRepository.save(inventory);
        }

        return inventoryRepository.findInventoryByProductId(productId);
    }


}
