import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

class Graph<T>{
    Map<T,List<T>> map = new HashMap<>();

    public void addVertex(T s){
        map.put(s, new LinkedList<>());
    }

    public void addEdge(T u, T v, boolean undirected){
        if(!map.containsKey(u)){
            addVertex(u);
        }
        if(!map.containsKey(v)){
            addVertex(v);
        }

        map.get(u).add(v);

        if(undirected == true){
            map.get(v).add(u);
        }
    }

    public void getVertex(){
        System.out.println("The total vertex is: "+map.keySet().size());
    }

    public void getEdge(boolean undirected){
        int count = 0;

        for(T t : map.keySet()){
            count += map.get(t).size();
        }

        if(undirected == true){
            count /= 2;
        }
        System.out.println("The total edges is: "+count);
    }

    public void hasEdge(T u, T v){
        if(map.get(u).contains(v)){
            System.out.print("yes edge is present: "+u+" -> "+v);
        }
        else{
            System.out.print("There is no any edge between "+u+" and "+v);
        }
    }
    public void hasVertex(T u){
        if(map.containsKey(u)){
            System.out.println("yes "+u+" is a vertex ");
        }
        else{
            System.out.println("This is not a vertex ");
        }
    }
    public void neighbours(T u){
        if(map.containsKey(u)){
            System.out.print("The all neighbours is: "+u +" -> ");
            for(T t: map.get(u)){
                System.out.print(t+", ");
            }
        }
        else{
            System.out.println("This is not a vertex and no neibours ");
        }
    }

    public void printEdge(){
        map.forEach((key, value) -> {
            System.out.println(key+" -> "+value);
        });
    }
}


public class GraphImplementation {

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<Integer>();


        // System.out.println("Undirected grph is: ");
        // graph.addEdge(0, 1, true);
        // graph.addEdge(1, 2, true);
        // graph.addEdge(2, 4, true);
        // graph.addEdge(4, 3, true);
        // graph.addEdge(3, 0, true);
        // graph.addEdge(2, 3, true);

        // graph.printEdge();
        // graph.getVertex();
        // graph.getEdge(true);
        // graph.hasEdge(1, 2);
        // System.out.println();
        // graph.hasVertex(4);
        // graph.neighbours(3);
        // System.out.println();

        System.out.println("Directed graph is: ");
        graph.addEdge(1, 2, false);
        graph.addEdge(1, 4, false);
        graph.addEdge(2, 3, false);
        graph.addEdge(5, 4, false);
        graph.addEdge(4, 3, false);
        graph.addEdge(5, 3, false);

        graph.printEdge();
        graph.getVertex();
        graph.getEdge(false);
        graph.hasEdge(3, 4);
        System.out.println();
        graph.hasVertex(5);
        graph.neighbours(1);
    }
}
