-- Crear la base de datos
CREATE DATABASE TiendaDb;

-- Usar la base de datos
USE TiendaDb;

-- Crear la tabla producto
CREATE TABLE producto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    precio DECIMAL(10,2)
);
