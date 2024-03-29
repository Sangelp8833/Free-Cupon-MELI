# Free-Cupon-MELI (Challange)
Mercado Libre está implementando un nuevo beneficio para los usuarios que más usan la plataforma con un cupón de cierto monto gratis que les permitirá comprar tantos ítems marcados como favoritos sea posible, siempre que no excedan el monto del cupón.

-----------------------
# URLs

### 1. Maximizar uso del cupon:
 - URL: ec2-13-58-232-228.us-east-2.compute.amazonaws.com:8080/free-cupon-MELI/cupon
 - URL: ec2-13-58-232-228.us-east-2.compute.amazonaws.com:8080/free-cupon-MELI/top-exchanged

# Consideraciones y Arquitectura de la aplicación

- Para la solución del primer punto se tomó como referencia el problema de la mochila o KnapSack.
- Para el desarrollo del punto.2 se consideró la creación de una base de datos postgres, donde se pudiera guardar los elementos "canjeados".
- Se asume que una vez se haya consumio el endpoint utilizado para máximar el uso del cupon, los elementos devueltos son los elementos que se van a canjear.

### Draft de arquitectura

![Draft_Meli](https://github.com/Sangelp8833/Free-Cupon-MELI/assets/84479574/0e1b6a0f-c678-4b7f-8c5b-a67b1402d2e3)


# Otra  información

### KnapSack Problem

En algoritmia, el problema de la mochila, comúnmente abreviado por KP es un problema de optimización combinatoria, es decir, que busca la mejor solución entre un conjunto finito de posibles soluciones a un problema.
Este algorimo tiene muchas variaciones y soluciones, pero la elegida para dar solución a este problema fue la solución recursiva, la cual tiene la siguiente forma,  

![image](https://github.com/Sangelp8833/Free-Cupon-MELI/assets/84479574/f40366f9-7326-4d55-88cc-5163bc7067dd)

y está sustentada como la posible mejor solución para este problema. [knapsack time complexity](https://medium.com/analytics-vidhya/knapsack-problem-7f05d0900db8).

### Performance Test

![image](https://github.com/Sangelp8833/Free-Cupon-MELI/assets/84479574/a47bcc5f-fd8c-4a80-bdf2-5656d120a1cd)


