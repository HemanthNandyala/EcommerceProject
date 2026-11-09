package com.hemanth.order.Service;


import com.hemanth.order.DTO.ProductRequestDTO;
import com.hemanth.order.Entity.Product;
import com.hemanth.order.Mapper.ProductMapper;
import com.hemanth.order.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.hemanth.order.DTO.ProductResposneDTO;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    public ProductResposneDTO addProduct(ProductRequestDTO requestDTO) {
        Product product = productMapper.toEntity(requestDTO);
        Product savedProduct=  productRepository.save(product);
        ProductResposneDTO response =  productMapper.toResponseDTO(savedProduct);
        return response;

    }
}
