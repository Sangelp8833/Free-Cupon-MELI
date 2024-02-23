# Free-Cupon-MELI (Challange)
Mercado Libre está implementando un nuevo beneficio para los usuarios que más usan la plataforma con un cupón de cierto monto gratis que les permitirá comprar tantos ítems marcados como favoritos sea posible, siempre que no excedan el monto del cupón.

-----------------------
# URLs

### 1. Maximizar uso del cupon:
 - URL: ec2-13-58-232-228.us-east-2.compute.amazonaws.com:8080/free-cupon-MELI/cupon

# Consideraciones y Arquitectura de la aplicación

- Para la solución del primer punto se tomó como referencia el problema de la mochila o KnapSack.
- Para el desarrollo del punto.2 se consideró la creación de una base de datos postgres, donde se pudiera guardar los elementos "canjeados".
- Se asume que una vez se haya consumio el endpoint utilizado para máximar el uso del cupon, los elementos devueltos son los elementos que se van a canjear.

### Draft de arquitectura


# Otra  información

### KnapSack Problem

En algoritmia, el problema de la mochila, comúnmente abreviado por KP es un problema de optimización combinatoria, es decir, que busca la mejor solución entre un conjunto finito de posibles soluciones a un problema.
Este algorimo tiene muchas variaciones y soluciones, pero la elegida para dar solución a este problema fue la solución recursiva, la cual tiene la siguiente forma desde un punto de vista matemático y está sustentada como la posible mejor solución para este problema en el siguiente [Link](https://medium.com/analytics-vidhya/knapsack-problem-7f05d0900db8)

![image](https://github.com/Sangelp8833/Free-Cupon-MELI/assets/84479574/f40366f9-7326-4d55-88cc-5163bc7067dd)

