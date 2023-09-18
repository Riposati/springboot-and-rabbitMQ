package br.com.gustavo.producer.controllers;

import br.com.gustavo.producer.services.ProductService;
import dtos.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<String> produces(@RequestBody ProductDTO productDTO){
        productService.createProduct(productDTO);
        return ResponseEntity.status(CREATED).build();
    }
}
