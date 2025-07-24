package com.livecoding.livecodingdto.mapper;

import com.livecoding.livecodingdto.dto.RequestProduct;
import com.livecoding.livecodingdto.dto.ResponseProduct;
import com.livecoding.livecodingdto.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity (RequestProduct dto);

    @Mapping(source = "nom" ,target = ("nomProduit"))
    @Mapping(source = "client.nom" , target = "nomClient")
    ResponseProduct toDto (Product product);
}
