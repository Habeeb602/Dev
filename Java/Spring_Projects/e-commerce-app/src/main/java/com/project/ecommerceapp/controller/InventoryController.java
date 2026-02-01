package com.project.ecommerceapp.controller;


import com.project.ecommerceapp.dto.InventoryRequest;
import com.project.ecommerceapp.dto.InventoryResponse;
import com.project.ecommerceapp.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping("/inventory")
    public ResponseEntity<InventoryResponse> changeInventory(@RequestBody InventoryRequest inventoryRequest){
        InventoryResponse inventoryResponse = inventoryService.changeInventory(inventoryRequest);
        return new ResponseEntity<>(inventoryResponse, HttpStatus.OK);
    }

    @GetMapping("/inventory")
    public ResponseEntity<List<InventoryResponse>> findAll(){
        List<InventoryResponse> inventoryResponses = inventoryService.findAll();

        return new ResponseEntity<>(inventoryResponses, HttpStatus.OK);
    }

    @DeleteMapping("/inventory/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteInventory(@PathVariable(value = "id") Long id){
        inventoryService.deleteInventory(id);
    }



}
