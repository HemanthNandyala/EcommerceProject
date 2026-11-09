package com.hemanth.order.Mapper;

import com.hemanth.order.DTO.ProductRequestDTO;
import com.hemanth.order.DTO.ProductResposneDTO;
import com.hemanth.order.Entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

     Product toEntity(ProductRequestDTO requestDTO);
     ProductResposneDTO toResponseDTO(Product product);
}
