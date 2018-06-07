/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.strategy;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author root
 */
public class AlgorithmStrategy {

    /**
     * @param args the command line arguments
     */
    /*
        Dictionary Node :
        - dictionary disini digunakan untuk mempermudah mencari suatu node 
        dengan menggunakan string atau nama dari node tersebut
    */ 
    
    public static HashMap<String,GraphNode> dict_node = new HashMap();
    
    //Kumpulan Node
    public static ArrayList<GraphNode> kump_node = new ArrayList<>();
    
    // insert node
    static void insertKump_Node(GraphNode new_node){
        kump_node.add(new_node);
        insertDict_Node(new_node.getNama(), new_node);
    }
    
    static void insertDict_Node(String new_key, GraphNode new_node){
        dict_node.put(new_key, new_node);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        //Sample Insert Node 
        GraphNode a = new GraphNode(0, "Malang");
        insertKump_Node(a);
        
        GraphNode b = new GraphNode(1, "Batu");
        insertKump_Node(b);
        
        GraphNode c = new GraphNode(2, "Kab Malang");
        insertKump_Node(c);
        
        GraphNode d = new GraphNode(3, "Kepanjen");
        insertKump_Node(d);
        
        
    }
    
}
