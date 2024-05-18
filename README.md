# practica5
## Esta es la 5 practica de el curso de Progamacion 2. En esta se busca conocer sobre las estructuras de datos y algoritmo de datos, usando grafos para encontrar el camino optimo de un vertice a otro. En esta practica hacemos una busqueda por anchura.

## Tabla de Contenidos

-[Instalacion](#instalacion)
-[Uso](#uso)
-[Ejemplos](#ejemplos)
-[Contribuciones](#contribuciones)
-[Licencias](#licencias)

## Instalacion
1. **Clonar repositorio**: 
Este codigo se compila y se ejecuta a traves de una interfaz o de una aplicacion de lector de codigo como VSC.

## Uso
1. **Test**:
Este trabajo fue construido con maven a traves de un desarrolo basado en pruebas, por lo que se requiere el uso de maven. si quiere probra diferentes posibilidades se necesita crear un test.

2. **Comandos**:

Los siguientes de usan en una terminal bash:

mvn package
mvn test


## Ejemplos

1.Un grafo de 4 vertices donde todos estan conectados entre si a excepcion de los dos que se quiere encontrar el camino y se quiere llegar de un vertice a otro. Se tiene que devolver todos los vertices recorridos en el camino mas optimo.

V1 -arista- V2,V3
V2 -arista- V3,V1,V4
V3 -arista- V4,V1,V2
V4 -arista- V1,V3,V2

Camino == [V1,V2 o V3,V4]

## Licencias

Este proyecto está licenciado bajo la licencia Apache 2.0 - vea el archivo [LICENSE](LICENSE) para más detalles.

