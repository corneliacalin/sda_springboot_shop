package com.sda.corneliacalin.webshop.service;

import com.sda.corneliacalin.webshop.model.Product;
import com.sda.corneliacalin.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {
    private final ProductRepository productRepository;

@Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Transactional
    public void save(Product product){
    productRepository.save(product);


    }
    public List<Product> findAll(){

//    return new ArrayList<Product>((Collection<? extends Product>) productRepository.findAll());
        return StreamSupport.stream(productRepository.findAll().spliterator(),false).collect(Collectors.toList());


    }

    public Optional<Product> findById(Long productId){
    return productRepository.findById(productId);

    }

    public void delete(Long id) {
    Optional<Product> product=productRepository.findById(id);
    if (product.isPresent()){
        productRepository.delete(product.get());
    }
    else { throw new IllegalArgumentException("product not found");


    }

    }
}
