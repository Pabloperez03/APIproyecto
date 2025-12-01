package com.example.demo.service.impl;

import com.example.demo.persistence.model.Producto;
import com.example.demo.persistence.repository.ProductoRepository;
import com.example.demo.service.ProductoService;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public List<Producto> getAllProducto() {
        return productoRepository.findAll();
    }

    @Override
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Producto producto, Long id) {
        Producto productoDB = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id " + id));

        productoDB.setNombre(producto.getNombre());
        productoDB.setPrecio(producto.getPrecio());
        productoDB.setDescripcion(producto.getDescripcion());

        return productoRepository.save(productoDB);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Producto getProductobyid(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id " + id));
    }
}
