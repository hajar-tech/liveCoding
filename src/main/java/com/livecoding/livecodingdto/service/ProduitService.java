package com.livecoding.livecodingdto.service;

import com.livecoding.livecodingdto.dto.ProduitRequestDto;
import com.livecoding.livecodingdto.dto.RespenseProduct;
import com.livecoding.livecodingdto.mapper.ProductMapper;
import com.livecoding.livecodingdto.model.Client;
import com.livecoding.livecodingdto.model.Product;
import com.livecoding.livecodingdto.repository.ClientRepository;
import com.livecoding.livecodingdto.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;
    private final ClientRepository clientRepository;
    private final ProductMapper productMapper;
    public ProduitService(ProductMapper productMapper,ProduitRepository produitRepository, ClientRepository clientRepository){
        this.clientRepository = clientRepository;
        this.produitRepository = produitRepository;
        this.productMapper= productMapper;
    }

    public Product createProduct(ProduitRequestDto dto){

        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(()-> new RuntimeException("client not exist !!"));

        Product product = productMapper.toEntity(dto);
       // product.setNom(dto.getNom());
       product.setClient(client);

        return produitRepository.save(product);
    }


    public List<RespenseProduct> getAllProducts(){
    return produitRepository.findAll()
            .stream()
            .map(product -> productMapper.toDto(product))
            //.map(productMapper::toDto)
//        product -> {
//            RespenseProduct respenseProduct = new RespenseProduct();
//            respenseProduct.setIdP(product.getId());
//            respenseProduct.setNomProduit(product.getNom());
//            respenseProduct.setNomClient(product.getClient().getNom());

        .collect(Collectors.toList());
    }
}
