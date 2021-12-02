/*package whatever //do not write package name here */

import java.util.*;
import java.text.*;

class KosaRaju {
    static ArrayList<Integer> ar;
    static ArrayList<ArrayList<Integer>> res;
	public static void main (String[] args) {
	    int N = 7;
		int[][] edge = {
		  {1,2}, {2,3}, {3,1}, {4,3}, {5,4},
		  {5,6}, {6,7}, {7,5}
		};
		ArrayList<ArrayList<Integer>> G = new ArrayList<>();
		ArrayList<ArrayList<Integer>> Gr = new ArrayList<>();
		for(int i=0;i<=N;i++){
		    G.add(new ArrayList<>());
		    Gr.add(new ArrayList<>());
		}
		for(int[] A : edge){
		    G.get(A[0]).add(A[1]);
		    Gr.get(A[1]).add(A[0]);
		}
		boolean[] V = new boolean[N+1];
		ar = new ArrayList<>();
		for(int i=1;i<=N;i++){
		    if(!V[i]){
		        helper(G,V,i);
		        ar.add(i);
		    }
		}
		res = new ArrayList<>();
		int len = ar.size();
		for(int i=len-1;i>=0;i--){
		    if(V[ar.get(i)]){
		        helper1(Gr, V, ar.get(i), new ArrayList<>());
		    }
		}
		System.out.println(res);
	}
	public static void helper(ArrayList<ArrayList<Integer>> G, boolean[] V, int node){
	    V[node] = true;
	    for(int child : G.get(node)){
	        if(!V[child]){
	            helper(G, V, child);
	            ar.add(child);
	        }
	    }
	}
	public static void helper1(ArrayList<ArrayList<Integer>> Gr, boolean[] V, int node, ArrayList<Integer> temp){
	    V[node] = false;
	    temp.add(node);
	    for(int child : Gr.get(node)){
	        if(V[child]){
	            helper1(Gr, V, child, temp);
	        }
	    }
	    if(!temp.isEmpty()) res.add(new ArrayList<>(temp));
	    temp.clear();
	}
}
