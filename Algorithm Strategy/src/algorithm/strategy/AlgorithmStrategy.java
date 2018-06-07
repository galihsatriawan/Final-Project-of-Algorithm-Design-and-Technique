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
    
    public HashMap<String,GraphNode> dict_node = new HashMap();
    
    //Kumpulan Node
    public ArrayList<GraphNode> kump_node = new ArrayList<>();
    
    // insert node
    void insertKump_Node(GraphNode new_node){
        this.kump_node.add(new_node);
    }
    
    void insertDict_Node(String new_key, GraphNode new_node){
        this.dict_node.put(new_key, new_node);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
