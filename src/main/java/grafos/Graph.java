package grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph<V>
{
    //Lista de adyacencia.
    private Map<V, Set<V>> adjacencyList = new HashMap<>();

     /** Añade el vértice ` v` al grafo.
      * @param v vértice a añadir.
      * @return true` si no estaba anteriormente y ` false` en caso contrario.*/
      public boolean addVertex(V v){
        if (adjacencyList.containsKey(v)) {
            return false;
        }
        adjacencyList.put(v,new HashSet<V>());

        return true; 
    }
    /**
    * Añade un arco entre los vértices ` v1` y ` v2` al grafo.
     *En caso de que no exista alguno de los vértices, lo añade también.
     * @param v1 el origen del arco.
     * @param v2 el destino del arco.
     * @return true` si no existía el arco y ` false` en caso contrario.*/
    public boolean addEdge(V v1, V v2){
        if (!adjacencyList.containsKey(v2)) {
            adjacencyList.put(v2, new HashSet<V>());
        }if (!adjacencyList.containsKey(v1)) {
            adjacencyList.put(v1, new HashSet<V>());
          
        }
        if(adjacencyList.get(v1).contains(v2)){
            return false;
        }
        adjacencyList.get(v1).add(v2);
        adjacencyList.get(v2).add(v1);
        return true; //Este código hay que modificarlo.
    }

    /******************************************************************* 
     * Obtiene el conjunto de vé rtices adyacentes a ` v`.
     * ** @param v vértice del que se obtienen los adyacentes.
     * * @return conjunto de vértices adyacentes.
    ******************************************************************/
    public Set<V> obtainAdjacents(V v) throws Exception{

        return adjacencyList.get(v); //Este código hay que modificarlo.
    }

    /******************************************************************* 
     * Comprueba si el grafo contiene el vértice dado.
     * @param v vértice para el que se realiza la comprobació n.
     * @return ` true` si ` v` es un vértice del grafo.
     * ******************************************************************/
    public boolean containsVertex(V v){
        if (adjacencyList.containsKey(v)) {
            return true;
        }
        return false; //Este código hay que modificarlo.
    }

    /******************************************************************* Método ` toString()` reescrito para la clase ` Grafo. java`.
     * @return una cadena de caracteres con la lista de* adyacencia.
     * ******************************************************************/
    @Override
    public String toString(){
        return "Devolviendo lista de vertices adjacientes"+adjacencyList; //Este código hay que modificarlo.
    }

    /*** 
     * Obtiene, en caso de que exista, el camino má s corto entre* ` v1` y ` v2`. En caso contrario, devuelve ` null`.
     * @param v1 el vértice origen.
     * @param v2 el vértice destino.
     * @return lista con la secuencia de vértices del camino más corto entre ` v1` y ` v2`*/
    public List<V> shortestPath(V v1, V v2){

        Queue<V> colaVertices = new LinkedList<>();
        Map<V,V> padres = new HashMap<>();
      

        if (!adjacencyList.containsKey(v1) & !adjacencyList.containsKey(v2)) {
            return null;
        }

        colaVertices.offer(v1);

        while (!colaVertices.isEmpty()) {
            V verticeActual = colaVertices.poll();
          

            if (verticeActual.equals(v2)) {
            Stack<V> pila = new Stack<>();
            List<V> camino = new ArrayList<>();
            
            pila.add(verticeActual);
            V verticePadre = padres.get(verticeActual);
            while (verticePadre != v1) {
               
                pila.add(verticePadre);
                verticePadre = padres.get(verticePadre);
            }
            pila.add(v1);
            while (!pila.isEmpty()) {
                V hijo = pila.pop();
                camino.add(hijo);
            }
            return camino;
               
            }
            for (V adyacente : adjacencyList.get(verticeActual)) {
                if (!padres.containsKey(adyacente) ) {
                    colaVertices.offer(adyacente);
                    padres.put(adyacente, verticeActual);
                }
            }
        }

        return null; 
    }

}
