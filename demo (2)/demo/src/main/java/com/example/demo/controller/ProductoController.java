package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistence.model.Producto;
import com.example.demo.service.ProductoService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/producto")
@AllArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    // GET /api/v1/producto  -> lista de productos
    @GetMapping
    public ResponseEntity<List<Producto>> getAllProducto() {
        return ResponseEntity.ok(productoService.getAllProducto());
    }

    // GET /api/v1/producto/{id}  -> producto por id
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getAllProductobyid(@PathVariable Long id) {
        Producto producto = productoService.getProductobyid(id);

        if (producto == null) {               // si no existe, 404
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(producto);    // 200 OK
    }

    // POST /api/v1/producto  -> crear producto
    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        Producto creado = productoService.createProducto(producto);
        return ResponseEntity
                .status(HttpStatus.CREATED)    // 201 Created
                .body(creado);
    }

    // PUT /api/v1/producto/{id}  -> actualizar producto
    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto,
                                                   @PathVariable Long id) {

        Producto actualizado = productoService.updateProducto(producto, id);

        if (actualizado == null) {            // si no existe el id
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado); // 200 OK
    }

    // DELETE /api/v1/producto/{id}  -> borrar producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
