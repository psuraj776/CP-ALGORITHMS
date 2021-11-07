/*package whatever //do not write package name here */

import java.util.*;
import java.text.*;

class GFG {
    static int timer;
	public static void main (String[] args) {
	    timer = 0;
		int[][] edge = {
		  {1,8}, {1,0}, {0,7}, {0,5}, {7,10},
		  {10,6}, {5,2}, {5,9}, {5,3}, {3,9},
		  {9,4}
		};
		ArrayList<ArrayList<Integer>> G = new ArrayList<>();
		for(int i=0;i<=10;i++){
		    G.add(new ArrayList<>());
		}
		for(int[] A : edge){
		    G.get(A[0]).add(A[1]);
		    G.get(A[1]).add(A[0]);
		}
		boolean[] V = new boolean[11];
		int[] in = new int[11];
		int[] lo = new int[11];
		for(int i=0;i<=10;i++){
		    if(!V[i]){
		        dfs(i, V, in, lo, G, -1);
		    }
		}
	}
	public static void dfs(int node, boolean[] V, int[] in, int[] lo, ArrayList<ArrayList<Integer>> G, int p){
	    V[node] = true;
	    lo[node] = in[node] = timer++;
	    int children = 0;
	    for(int child : G.get(node)){
	        if(child == p) continue;
	        if(V[child]){
		   /*
		   here it signifies a backedge means child must be 
		   an ancester to node and might have 'in' time less than 'lo' of node
		   */
	           lo[node] = Math.min(lo[node], in[child]); 
	        }
	        else{
		    /*
		    signifies a forward edge means child is not visited
		    so lo[node] = Math.min(lo[node],lo[child])
		    */
	            dfs(child, V, in, lo, G, node);
	            lo[node] = Math.min(lo[node],lo[child]);
	            if(lo[child] >= in[node] && p != -1){
	                System.out.println("Bridge is "+node);
	            }
	            children++;
	        }
	    }
	    if(p==-1 && children>1){
	        System.out.println("Bridge is "+node);
	    }
	}
}
