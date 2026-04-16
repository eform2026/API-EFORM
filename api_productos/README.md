# API de Productos

## Descripción

Esta es una API REST desarrollada con Spring Boot que permite gestionar productos y usuarios. La aplicación utiliza una base de datos MySQL para almacenar la información y proporciona endpoints para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre productos y usuarios.

## Tecnologías Utilizadas

- **Java**: Versión 21
- **Spring Boot**: Versión 4.0.3
- **Spring Data JPA**: Para la persistencia de datos
- **Spring Web MVC**: Para la creación de la API REST
- **MySQL**: Base de datos relacional
- **Maven**: Gestor de dependencias y construcción del proyecto
- **Hibernate**: ORM para el mapeo objeto-relacional

## Requisitos Previos

- Java 21 instalado
- MySQL Server ejecutándose en localhost:3306
- Maven instalado
- Una base de datos MySQL llamada `productos_api` creada

## Configuración de la Base de Datos

Asegúrate de tener MySQL instalado y ejecutándose. Crea la base de datos con el siguiente comando:

```sql
CREATE DATABASE productos_api;
```

La aplicación está configurada para conectarse con:
- Usuario: `root`
- Contraseña: `cielo`
- URL: `jdbc:mysql://localhost:3306/productos_api`

Si necesitas cambiar estas configuraciones, edita el archivo `src/main/resources/application.properties`.

## Instalación y Ejecución

1. Clona o descarga el proyecto en tu máquina local.

2. Navega al directorio raíz del proyecto:
   ```
   cd api_productos
   ```

3. Compila el proyecto con Maven:
   ```
   mvn clean compile
   ```

4. Ejecuta la aplicación:
   ```
   mvn spring-boot:run
   ```

   O ejecuta directamente con Java:
   ```
   java -jar target/api_productos-0.0.1-SNAPSHOT.jar
   ```

La aplicación estará disponible en `http://localhost:8080`.

## Endpoints de la API

### Productos

- **GET** `/api/productos`: Obtiene una lista de todos los productos.
- **GET** `/api/productos/{id}`: Obtiene un producto específico por su ID.
- **POST** `/api/productos`: Crea un nuevo producto. Envía un JSON con `nombre`, `precio` y opcionalmente `descripcion`.
- **PUT** `/api/productos/{id}`: Actualiza un producto existente. Envía un JSON con los datos a actualizar.
- **DELETE** `/api/productos/{id}`: Elimina un producto por su ID.

### Usuarios

- **GET** `/api/usuario`: Obtiene una lista de todos los usuarios.
- **GET** `/api/usuario/{id}`: Obtiene un usuario específico por su ID.
- **POST** `/api/usuario`: Crea un nuevo usuario. Envía un JSON con `rol`, `nombre` y opcionalmente `correo`.
- **PUT** `/api/usuario/{id}`: Actualiza un usuario existente. Envía un JSON con los datos a actualizar.
- **DELETE** `/api/usuario/{id}`: Elimina un usuario por su ID.

## Modelos de Datos

### Producto
```json
{
  "id": 1,
  "nombre": "Producto Ejemplo",
  "precio": 99.99,
  "descripcion": "Descripción del producto"
}
```

### Usuario
```json
{
  "id": 1,
  "rol": "ADMINISTRADOR",
  "nombre": "Juan Pérez",
  "correo": "juan@example.com"
}
```

Los roles disponibles para usuarios son: `ADMINISTRADOR` y `USUARIO`.

## Estructura del Proyecto

```
api_productos/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── co/sena/edu/cielo/api_productos/
│   │   │       ├── ApiProductosApplication.java          # Clase principal de Spring Boot
│   │   │       ├── controller/                            # Controladores REST
│   │   │       │   ├── ProductoController.java
│   │   │       │   └── UsuarioController.java
│   │   │       ├── exception/                             # Manejo de excepciones
│   │   │       │   ├── ErrorResponse.java
│   │   │       │   ├── GlobalExceptionHandler.java
│   │   │       │   └── RecursoNoEncontrado.java
│   │   │       ├── model/                                 # Entidades JPA
│   │   │       │   ├── Producto.java
│   │   │       │   └── Usuario.java
│   │   │       ├── repository/                            # Repositorios JPA
│   │   │       │   ├── ProductoRepository.java
│   │   │       │   └── UsuarioRepository.java
│   │   │       └── service/                               # Servicios de negocio
│   │   │           ├── ProductoService.java
│   │   │           └── UsuarioService.java
│   │   └── resources/
│   │       └── application.properties                     # Configuración de la aplicación
│   └── test/
│       └── java/
│           └── co/sena/edu/cielo/api_productos/
│               └── api_productos/
│                   └── ApiProductosApplicationTests.java  # Tests unitarios
├── target/                                                # Archivos compilados
├── pom.xml                                                # Configuración de Maven
├── mvnw                                                   # Wrapper de Maven para Unix
├── mvnw.cmd                                               # Wrapper de Maven para Windows
└── README.md                                              # Este archivo
```

## Manejo de Errores

La aplicación incluye un manejador global de excepciones que devuelve respuestas JSON estructuradas para errores comunes, como recursos no encontrados (404) o errores de validación (400).

## Pruebas

Para ejecutar las pruebas unitarias:

```
mvn test
```

## Contribución

Si deseas contribuir al proyecto:

1. Haz un fork del repositorio.
2. Crea una rama para tu feature (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y commits.
4. Envía un pull request.

## Licencia

Este proyecto es de demostración y no tiene una licencia específica asignada.

## Contacto

Para preguntas o soporte, contacta al desarrollador del proyecto.