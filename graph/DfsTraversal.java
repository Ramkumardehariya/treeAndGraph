import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;

class Graph2<T>{
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

    public void dfs(Set<T> st, T node){
        st.add(node);
        System.out.print(node+" ");

        List<T> values = map.get(node);
        if(values != null){
            for(T value : values){
                if(!st.contains(value)){
                    dfs(st, value);
                }
            }
        }
    }

    public void dfsTraversal(){

        Set<T> st = new HashSet<>();
        System.out.println("dfs traversal is: ");

        for(Map.Entry<T,List<T>> entry: map.entrySet()){
            
            if(!st.contains(entry.getKey())){
                dfs(st, entry.getKey());
            }

        }
    }

    public void printEdge(){
        map.forEach((key, value) -> {
            System.out.println(key+" -> "+value);
        });
    }
}


public class DfsTraversal {
    public static void main(String []args){
        Graph2<Integer> graph = new Graph2<Integer>();

        System.out.println("Undirected grph is: ");
        graph.addEdge(0, 1, true);
        graph.addEdge(1, 2, true);
        graph.addEdge(2, 4, true);
        graph.addEdge(4, 3, true);
        graph.addEdge(3, 0, true);
        graph.addEdge(2, 3, true);

        graph.printEdge();
        System.out.println();
        graph.dfsTraversal();
    }
}
