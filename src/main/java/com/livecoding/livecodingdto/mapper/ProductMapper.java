package com.livecoding.livecodingdto.mapper;

import com.livecoding.livecodingdto.dto.ProduitRequestDto;
import com.livecoding.livecodingdto.dto.RespenseProduct;
import com.livecoding.livecodingdto.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "clientId" , target = "client.id")
    Product toEntity (ProduitRequestDto dto);


    @Mapping(source = "id" , target = "idP")
    @Mapping(source = "nom" , target = "nomProduit")
    @Mapping(source = "client.nom", target = "nomClient")
    RespenseProduct toDto(Product produit);
}
