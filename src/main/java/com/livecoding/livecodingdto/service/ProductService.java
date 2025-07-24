package com.livecoding.livecodingdto.service;

import com.livecoding.livecodingdto.dto.RequestProduct;
import com.livecoding.livecodingdto.dto.ResponseProduct;
import com.livecoding.livecodingdto.mapper.ProductMapper;
import com.livecoding.livecodingdto.model.Client;
import com.livecoding.livecodingdto.model.Product;
import com.livecoding.livecodingdto.repository.ClientRepo;
import com.livecoding.livecodingdto.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ClientRepo clientRepo;

   private final ProductRepo productRepo;
   private final ProductMapper productMapper;

   public ProductService (  ProductMapper productMapper,ClientRepo clientRepo , ProductRepo productRepo){
       this.clientRepo = clientRepo;
       this.productRepo = productRepo;
       this.productMapper = productMapper;
   }

   public ResponseProduct createProduct (RequestProduct dto){

       Client client = clientRepo.findById(dto.getIdClient())
               .orElseThrow(()-> new RuntimeException("client not exist !!"));

       Product product = new Product();

       product.setNom(dto.getNom());
       product.setClient(client);

       Product savedproduct = productRepo.save(product);

       return productMapper.toDto(savedproduct);

   }
    public ResponseProduct updateProduct (Long id, RequestProduct requestProduct) {

        Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not fond!"));

        product.setNom(requestProduct.getNom());

        Product saveproduct = productRepo.save(product);
        return  productMapper.toDto(saveproduct);
    }



      public List<ResponseProduct> getAllProducts(){
       return productRepo.findAll().stream()
               .map(product -> {

              ResponseProduct responseProduct = new ResponseProduct();
                 responseProduct.setNomProduit(product.getNom());

                 responseProduct.setNomClient(product.getClient().getNom());
                 return responseProduct;
               }).toList();
   }
}
