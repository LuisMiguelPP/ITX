# **E-commerce API**

Esta es una aplicación backend desarrollada en **Spring Boot**, diseñada para obtener los precios y tarifas de productos de una marca. La aplicación utiliza una base de datos en memoria H2 y proporciona una API REST documentada con Swagger. Además, implementa pruebas de comportamiento (BDD) mediante Cucumber.

---

## **Requisitos previos**

Antes de comenzar, asegúrate de tener los siguientes componentes instalados en tu máquina:

- **Java 21**
- **Maven 3.8+**

---

## **Instrucciones para construir y ejecutar la aplicación**

### **1. Construcción del proyecto**

Desde la raíz del proyecto, ejecuta el siguiente comando en tu terminal:

```bash
mvn clean package
```

### **2. Iniciar la aplicación**
```bash
java -jar ./target/ecommerce-1.0.0.jar
```

### **3. Pruebas de comportamiento**

```bash
./mvnw verify
```

## **Recursos habilitados**

### **1. Documentacion swagger de la API**

#### URL: http://localhost:8080/swagger-ui/index.html

### **2. BBDD H2**

#### URL: http://localhost:8080/h2-console/

#### JDBC URL: jdbc:h2:mem:ecommerceItx

#### User: sa

#### Password: pass
