import java.util.*;

class SingleSourceShortestPathOnTree {
	public static void main (String[] args) {
		ArrayList<ArrayList<Integer>> g=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<6;i++){
		    g.add(new ArrayList<>());
		}
		g.get(0).add(1);
		g.get(1).add(0);
		g.get(1).add(2);
		g.get(2).add(1);
		g.get(2).add(3);
		g.get(3).add(2);
		g.get(3).add(4);
		g.get(4).add(3);
		g.get(4).add(5);
		g.get(5).add(4);
		boolean[] v=new boolean[6];
		int[] dist=new int[6];
		dfs_ssp(g,v,0,0,dist);
		for(int i=0;i<6;i++){
		    System.out.print(dist[i]+" ");
		}
		
	}
	public static void dfs_ssp(ArrayList<ArrayList<Integer>> g,boolean[] v,int node,int distt,int[] dist){
	    v[node]=true;
	    dist[node]=distt;
	    for(int i:g.get(node)){
	        if(!v[i]){
	            dfs_ssp(g,v,i,distt+1,dist);
	        }
	    }
	}
}
