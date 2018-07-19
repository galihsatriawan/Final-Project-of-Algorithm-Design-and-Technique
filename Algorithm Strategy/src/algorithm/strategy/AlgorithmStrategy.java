/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javafx.util.Pair;

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
    public static HashMap<String, GraphNode> dict_node = new HashMap();
    static HashMap<GraphEdge, Boolean> edge_visited = new HashMap<>();
    public static ArrayList<GraphNode> node_visited = new ArrayList<>();

    static ArrayList<GraphEdge> list_edge = new ArrayList<>();
    //Kumpulan Node
    public static ArrayList<GraphNode> kump_node = new ArrayList<>();

    // insert node
    static void insertKump_Node(GraphNode new_node) {
        kump_node.add(new_node);
        insertDict_Node(new_node.getNama(), new_node);
        
    }

    static void insertDict_Node(String new_key, GraphNode new_node) {
        dict_node.put(new_key, new_node);
    }

    static void insertEdgeDuaArah(String node1, String node2, double length) {
        // Cari node nya terlebih dahulu
        GraphNode node_1 = dict_node.get(node1);
        GraphNode node_2 = dict_node.get(node2);

        //Buat edge nya
        GraphEdge edge_baru1 = new GraphEdge(node_1, node_2, length);
        GraphEdge edge_baru2 = new GraphEdge(node_2, node_1, length);

        // Tambahkan ke daftar tetangga
        node_1.getKump_tetangga().add(edge_baru1);
        node_2.getKump_tetangga().add(edge_baru2);

        //tambahkan ke dictionary
        dict_edge.put(new Pair(node1, node2), edge_baru1);
        dict_edge.put(new Pair(node2, node1), edge_baru2);
        //Tambahkan ke list , karena dua arah maka yang dipakai 2 nya
        list_edge.add(edge_baru1);
        list_edge.add(edge_baru2);
        edge_visited.put(edge_baru2, Boolean.FALSE);
        edge_visited.put(edge_baru1, Boolean.FALSE);
        // Tambahkan banyaknya edge

    }

    //Mereset seluruh penanda edge
    static void reset_visited() {
        for (GraphEdge cur : list_edge) {
            edge_visited.replace(cur, Boolean.FALSE);
        }
    }

    static HashMap< Pair<String, String>, GraphEdge> dict_edge = new HashMap<>();

    //Mendapatkan edge
    static GraphEdge get_edge(String src, String dst) {
        return dict_edge.get(new Pair(src, dst));
    }

    //tandai berdasarkan source dan tujuan
    static void tandai_visited(GraphEdge edge) {
        edge_visited.replace(edge, Boolean.TRUE);
    }

    static void remove_visited(GraphEdge edge) {
        edge_visited.replace(edge, Boolean.FALSE);
    }

    //apakah sudah dikunjungi
    static boolean visited(GraphEdge edge) {
        return edge_visited.get(edge);
    }

    static void getListEdge(ArrayList<GraphEdge> listEdge, ArrayList<GraphNode> listNode) {
        for (int i = 0; i < listEdge.size(); i++) {
            GraphNode current = listNode.get(i);
            for (GraphEdge edge : current.getKump_tetangga()) {
                System.out.println("< " + edge.getSrc().getNama() + "-->" + edge.getDst().getNama() + " > jarak : " + edge.getDistance());
            }
        }
    }
    // ArrayList yang menyimpan track terbaik
    static ArrayList<GraphEdge> rute_terbaik = new ArrayList<>();
    static double jarak_tempuh_terbaik = Double.MAX_VALUE;
    static int banyak_node_visited = 0;

    static void hamilton(GraphEdge source, GraphNode dst, double panjang, ArrayList<GraphEdge> temp_rute) {
        //source.getDst = source yang sekarang
        if ((banyak_node_visited == kump_node.size()) && (source.getDst() == dst)) {
            if (panjang < jarak_tempuh_terbaik) {
                //System.out.println("nice "+panjang);
               // cetak_rute(temp_rute,panjang);
                jarak_tempuh_terbaik = panjang;
                rute_terbaik.clear();
                rute_terbaik.addAll(temp_rute);
            }
        } else {
            //Kunjungi seluruh anaknya
            for (GraphEdge i : source.getDst().getKump_tetangga()) {
                if (!visited(i)) {
                    temp_rute.add(i);
                    panjang += i.getDistance();
                    tandai_visited(i);
                    boolean tambah = false;
                    if(!node_visited.contains(i.getDst())){
                        tambah=true;
                        banyak_node_visited++;
                        node_visited.add(i.getDst());
                    }
                    hamilton(i, dst, panjang, temp_rute);
                    panjang -= i.getDistance();
                    temp_rute.remove(i);
                    remove_visited(i);
                    if(tambah){
                        banyak_node_visited--;
                        node_visited.remove(i.getDst());
                    }

                }
            }
        }
    }

    static void cetak_rute(ArrayList<GraphEdge> rute,double panjang) {
        System.out.println("Panjang Perjalanan : "+panjang);
        for (GraphEdge i : rute) {
            System.out.println(i.getSrc().getNama() + "-->" + i.getDst().getNama());
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here

        Scanner input = new Scanner(System.in);
        String ulang = "y";
        /*
        while (ulang.equals("y")) {
            System.out.println("================Menu==================");
            System.out.println("1. Cetak Seluruh Node dan Tetangganya");
            System.out.println("2. Tambah Node");
            System.out.println("3. Tambah Edge");
            System.out.println("4. Cari Semua Rute");
            System.out.println("5. Tampilkan Rute Terbaik");
            System.out.println("00. Keluar");
            System.out.println("======================================");

            System.out.print("Pilih : ");
            int pilih = input.nextInt();
            System.out.println("======================================");

                   switch(pilih){
                case 1:
                    System.out.println("Pilih Cetak Node");
                    System.out.println("Pilih Cetak Node");
                    System.out.println("Pilih Cetak Node");
                    break;
                case 2:
                    System.out.println("Pilih Tambah Node");
                    System.out.println("Pilih Tambah Node");
                    System.out.println("Pilih Tambah Node");
                    break;
                case 3:
                    System.out.println("Pilih Tambah Edge");
                    System.out.println("Pilih Tambah Edge");
                    System.out.println("Pilih Tambah Edge");
                    break;
                case 4:
                    System.out.println("Pilih Cari Rute");
                    System.out.println("Pilih Cari Rute");
                    System.out.println("Pilih Cari Rute");
                    break;
                case 5:
                    System.out.println("Pilih Tampil Rute Terbaik");
                    System.out.println("Pilih Tampil Rute Terbaik");
                    System.out.println("Pilih Tampil Rute Terbaik");
                    break;
                case 00:
                    System.out.println("Terimakasih !!");
                    System.exit(00);
                    break;
                default:
                    System.out.println("Pilihan yang anda masukkan salah");
            }
            System.out.println("=====================================");
            System.out.print("Apakah anda ingin mengulang (y/t)? ");
            ulang = input.next();
        }
         */
        //Sample Insert Node 
        GraphNode a = new GraphNode(0, "Malang");
        insertKump_Node(a);

        GraphNode b = new GraphNode(1, "Batu");
        insertKump_Node(b);

        GraphNode c = new GraphNode(2, "Kab Malang");
        insertKump_Node(c);

        GraphNode d = new GraphNode(3, "Kepanjen");
        insertKump_Node(d);

        //sample insert edge
        insertEdgeDuaArah("Batu", "Malang", 1);
        insertEdgeDuaArah("Batu", "Kab Malang", 3);
        insertEdgeDuaArah("Malang", "Kab Malang", 3);
        insertEdgeDuaArah("Malang", "Kepanjen", 3);
        insertEdgeDuaArah("Kepanjen", "Kab Malang", 3);

        //getListEdge(list_edge,kump_node);
        GraphEdge source = new GraphEdge(c, dict_node.get("Batu"), jarak_tempuh_terbaik);
        hamilton(source, dict_node.get("Batu"), 0, new ArrayList<>());
        cetak_rute(rute_terbaik,jarak_tempuh_terbaik);

    }

}
