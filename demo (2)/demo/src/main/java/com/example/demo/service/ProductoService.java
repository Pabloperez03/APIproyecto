package com.example.demo.service;

import java.util.List;
import com.example.demo.persistence.model.Producto;

public interface ProductoService {

    List<Producto> getAllProducto();

    Producto getProductobyid(Long id);

    Producto createProducto(Producto producto);

    Producto updateProducto(Producto producto, Long id);

    void deleteProducto(Long id);
}
