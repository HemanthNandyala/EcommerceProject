package com.hemanth.order.Service;

import com.hemanth.order.DTO.ProductRequestDTO;
import com.hemanth.order.DTO.ProductResposneDTO;

public interface ProductService {

    ProductResposneDTO addProduct(ProductRequestDTO requestDTO);


}
