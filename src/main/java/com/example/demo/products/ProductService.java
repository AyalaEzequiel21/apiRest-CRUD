package com.example.demo.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    HashMap<String, Object> datos;
    private final ProductRepository productRepository;

@Autowired
public ProductService(ProductRepository productRepository){
    this.productRepository = productRepository;
}
    public List<Product> getProducts(){
        return this.productRepository.findAll();
    }

    public ResponseEntity<Object> newProduct(Product product) {
        Optional<Product> response = this.productRepository.findProductByName(product.getName());
        datos = new HashMap<>();
        if(response.isPresent() && product.getId()==null){
            datos.put("error", true);
            datos.put("message", "Este producto ya existe.");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }
        datos.put("message", "Se guardo con exito.");
        if(product.getId() != null){
            datos.put("message", "Se actualizo con exito.");
        }
        productRepository.save(product);
        datos.put("data",product);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> deleteProduct(Long id){
        datos = new HashMap<>();
        boolean exist = this.productRepository.existsById(id);
        if (!exist){
            datos.put("error", true);
            datos.put("message", "No existe un producto con ese ID");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }
        productRepository.deleteById(id);
        datos.put("message", "Producto eliminado");
        return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
    }
}
