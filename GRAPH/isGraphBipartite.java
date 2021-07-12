//Check if Graph is Bipartite
/*
Reference
https://cp-algorithms.com/graph/bipartite-check.html
*/

import java.util.*;

class BipartiteGraph {
	public static void main (String[] args) {
	    ArrayList<ArrayList<Integer>> g=new ArrayList<ArrayList<Integer>> ();
	    int n = 6;
	    for(int i=0;i<6;i++){
	        g.add(new ArrayList<Integer>());
	    }
	    g.get(0).add(1);
	    g.get(0).add(5);
	    g.get(0).add(2);
	    g.get(2).add(0);
	    g.get(1).add(0);
	    g.get(1).add(2);
	    g.get(2).add(1);
	    g.get(2).add(3);
	    g.get(3).add(2);
	    g.get(3).add(4);
	    g.get(4).add(3);
	    g.get(4).add(5);
	    g.get(5).add(0);
	    g.get(5).add(4);
	    boolean[] v=new boolean[6];
	    int[] color = new int[6];
	    for(int i=0;i<6;i++){
	        color[i]=-1;
	    }
	    boolean ans = isBipartite(g,v,color,0,0);
	    System.out.println(ans);
}
    public static boolean isBipartite(ArrayList<ArrayList<Integer>> g,boolean[] v,int[] color,int node,int c){
        v[node]=true;
        color[node]=c;
        for(int i:g.get(node)){
            if(!v[i]){
                if(!isBipartite(g,v,color,i,c^1)){
                    return false;
                }
            }
            else if(color[node]==color[i]) return false;
        }
        return true;
    }
}
