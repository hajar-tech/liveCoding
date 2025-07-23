package com.livecoding.livecodingdto.controller;

import com.livecoding.livecodingdto.dto.ProduitRequestDto;
import com.livecoding.livecodingdto.dto.RespenseProduct;
import com.livecoding.livecodingdto.model.Product;
import com.livecoding.livecodingdto.service.ProduitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController (ProduitService produitService){
        this.produitService = produitService;
    }

    @PostMapping("/createProduct")
    public ResponseEntity<Product> createProduct(@RequestBody ProduitRequestDto dto){
        return ResponseEntity.ok(produitService.createProduct(dto));
    }

    @GetMapping
    public List<RespenseProduct> getAll(){
        return produitService.getAllProducts();
    }
}
