# Free-Cupon-MELI (Challange)
Mercado Libre está implementando un nuevo beneficio para los usuarios que más usan la plataforma con un cupón de cierto monto gratis que les permitirá comprar tantos ítems marcados como favoritos sea posible, siempre que no excedan el monto del cupón.

-----------------------
# URLs

### 1. Maximizar uso del cupon:
 - URL: ec2-13-58-232-228.us-east-2.compute.amazonaws.com:8080/free-cupon-MELI/cupon

# Consideraciones y Arquitectura de la aplicación

- Para el desarrollo del punto.2 se consideró la creación de una base de datos postgres, donde se pudiera guardar los elementos "canjeados".
- Se asume que una vez se haya consumio el endpoint utilizado para máximar el uso del cupon, los elementos devueltos son los elementos que se van a canjear.

 - ### Draft de arquitectura
