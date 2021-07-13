import java.util.*;

class Test {
	public static void main (String[] args) {
		ArrayList<ArrayList<Integer>> g=new ArrayList<ArrayList<Integer>>();
		int n=6;
		for(int i=0;i<6;i++){
		    g.add(new ArrayList<Integer>());
		}
		//g.get(0).add(2);
		g.get(0).add(3);
		g.get(1).add(3);
		//g.get(2).add(0);
		g.get(3).add(1);
		g.get(3).add(4);
		g.get(3).add(5);
		g.get(4).add(3);
		g.get(4).add(5);
		g.get(5).add(3);
		g.get(5).add(4);
		int component=0;
		boolean[] v=new boolean[6];
		for(int i=0;i<6;i++){
		    if(!v[i]){
		        dfs(g,v,i);
		        component++;
		    }
		}
		System.out.println("Number of connected component is "+component);
	}
	public static void dfs(ArrayList<ArrayList<Integer>> g,boolean[] v,int node){
	    v[node]=true;
	    for(int child:g.get(node)){
	        if(!v[child]){
	            dfs(g,v,child);
	        }
	    }
	}
}
