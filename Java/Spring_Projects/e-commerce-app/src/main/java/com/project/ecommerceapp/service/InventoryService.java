package com.project.ecommerceapp.service;

import com.project.ecommerceapp.dto.InventoryRequest;
import com.project.ecommerceapp.dto.InventoryResponse;

import java.util.List;

public interface InventoryService {

    InventoryResponse changeInventory(InventoryRequest inventoryRequest);
    List<InventoryResponse> findAll();

    void deleteInventory(Long id);

}
