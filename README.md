# API REST – Gestión de Proyectos (2º DAM)

Proyecto realizado para la asignatura optativa de 2º de Desarrollo de Aplicaciones Multiplataforma (DAM).

Consiste en una **API REST en Spring Boot** que permite gestionar:
- Proyectos
- Desarrolladores
- Tecnologías
- Estados de los proyectos

Todos los datos se almacenan en una **base de datos MySQL** y se accede a ellos mediante endpoints REST siguiendo la arquitectura:

> **Controlador → Servicio → Repositorio (MVC)**

---

## Tecnologías utilizadas

- **Java 17**
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
- **Hibernate**
- **MySQL**
- **Maven**
- **YAML** para configuración
- **Postman** para pruebas
- **Git/GitHub** para control de versiones

---

## Base de datos

Nombre del esquema:

```sql
Proyectosdb
