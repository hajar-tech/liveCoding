package com.livecoding.livecodingdto.controller;

import com.livecoding.livecodingdto.dto.RequestProduct;
import com.livecoding.livecodingdto.dto.ResponseProduct;
import com.livecoding.livecodingdto.model.Product;
import com.livecoding.livecodingdto.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity< ResponseProduct> createProduct (@RequestBody RequestProduct dto){
        return ResponseEntity.ok(productService.createProduct(dto));
    }
@DeleteMapping("/{id}")
 public  ResponseEntity<ResponseProduct> updateProduct (@RequestBody RequestProduct dto,@PathVariable Long id ){
        return ResponseEntity.ok(productService.updateProduct(id ,dto));
}
    @GetMapping
    public List<ResponseProduct> getAll (){
        return productService.getAllProducts();
    }
}
