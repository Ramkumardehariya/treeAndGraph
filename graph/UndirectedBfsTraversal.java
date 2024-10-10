import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;

class Graph1<T>{
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

    void bfsTraversal(){
        
    }

    public void printEdge(){
        map.forEach((key, value) -> {
            System.out.println(key+" -> "+value);
        });
    }
}


public class UndirectedBfsTraversal {
    public static void main(String []args){
        Graph1<Integer> graph = new Graph1<Integer>();

        System.out.println("Undirected grph is: ");
        graph.addEdge(0, 1, true);
        graph.addEdge(1, 2, true);
        graph.addEdge(2, 4, true);
        graph.addEdge(4, 3, true);
        graph.addEdge(3, 0, true);
        graph.addEdge(2, 3, true);

        graph.printEdge();
        graph.bfsTraversal();
    }
}
