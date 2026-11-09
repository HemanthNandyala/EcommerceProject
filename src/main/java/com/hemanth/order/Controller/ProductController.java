package com.hemanth.order.Controller;


import com.hemanth.order.DTO.ProductRequestDTO;
import com.hemanth.order.DTO.ProductResposneDTO;
import com.hemanth.order.Entity.Product;
import com.hemanth.order.Service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/api/product")
    public ResponseEntity<ProductResposneDTO> addProduct(@Valid @RequestBody ProductRequestDTO requestDTO) {
        ProductResposneDTO resposne = productService.addProduct(requestDTO);
        return  ResponseEntity.status(202).body(resposne);
    }
}
