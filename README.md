# Prueba Técnica QA Automation - RestAssured

## Descripción

Proyecto de automatización de pruebas API desarrollado con RestAssured, Java 17, Maven y JUnit 5 para validar los servicios de la API Restful Booker.

## Tecnologías

- Java 17
- Maven
- RestAssured
- JUnit 5

## Estructura del proyecto

```text
src
├── main
│   └── java
│       └── models
│           ├── AuthRequest.java
│           ├── AuthResponse.java
│           └── Booking.java
│
└── test
    └── java
        ├── base
        │   └── BaseTest.java
        ├── services
        │   ├── AuthService.java
        │   └── BookingService.java
        └── tests
            ├── AuthTest.java
            └── BookingTest.java
```

## Casos automatizados

### Auth

- Create Token (Happy Path)
- Create Token (Unhappy Path)

### Booking

- Get Booking
- Update Booking

## Validaciones realizadas

- Código de respuesta HTTP.
- Obtención del token de autenticación.
- Consulta de información de una reserva.
- Actualización de datos de una reserva.
- Validación de respuesta para credenciales inválidas.

## Instalación

Clonar el repositorio:

```bash
git clone https://github.com/davidtorres2601/restassured-booker-api.git
```

Instalar dependencias:

```bash
mvn clean install
```

## Ejecución

Ejecutar todas las pruebas:

```bash
mvn test
```

## Resultado esperado

```text
Tests run: 4
Failures: 0
Errors: 0
BUILD SUCCESS
```

## Autor

David Francys Torres Susanibar