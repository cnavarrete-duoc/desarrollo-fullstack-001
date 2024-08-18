# API CRUD de Películas

Este proyecto es una API REST para la gestión de películas, desarrollado con Spring Boot. La API permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre un conjunto de películas.

## Características

- **Crear** una nueva película.
- **Leer** una lista de todas las películas o una película en específico por su ID.
- **Actualizar** los datos de una película existente.
- **Eliminar** una película.

## Requisitos

Antes de ejecutar el proyecto, asegúrate de tener instalados los siguientes componentes:

- [Java 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Spring Boot 2.7+](https://spring.io/projects/spring-boot)

## Instalación

1. Clona el repositorio en tu máquina local:

   ```bash
   git clone https://github.com/cnavarrete-duoc/desarrollo-fullstack-001.git
   ```

2. Ve al directorio del proyecto:

   ```bash
   cd desarrollo-fullstack-001
   ```

3. Compila el proyecto usando Maven:

   ```bash
   mvn clean install
   ```

## Ejecución

Puedes ejecutar la aplicación localmente con el siguiente comando:

```bash
mvn spring-boot:run
```

La API estará disponible en `http://localhost:8080`.

## Endpoints de la API

| Método | Endpoint              | Descripción                                      |
| ------ | --------------------- | ------------------------------------------------ |
| GET    | `/api/peliculas`      | Obtiene una lista de todas las películas.        |
| GET    | `/api/peliculas/{id}` | Obtiene los detalles de una película específica. |
| POST   | `/api/peliculas`      | Crea una nueva película.                         |
| PUT    | `/api/peliculas/{id}` | Actualiza los datos de una película existente.   |
| DELETE | `/api/peliculas/{id}` | Elimina una película por su ID.                  |

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.3.2**
- **Maven** (gestor de dependencias)
