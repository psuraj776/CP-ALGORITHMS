/*
g : adjacency list of graph
N : number of vertices

return a list containing the DFS traversal of the given graph
*/

class DFS_Traversal
{   ArrayList<Integer> result;
    boolean[] visited;
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N)
    {  visited=new boolean[N];
       result=new ArrayList<>();
       helper(g,0,N);
       return result;
       // add your code here
    }
    public void helper(ArrayList<ArrayList<Integer>> g, int temp){
        if(visited[temp]) return;
        result.add(temp);
        visited[temp]=true;
        for(int A:g.get(temp)){
            if(!visited[A]){
                helper(g,A);
            }
        }
    }
}
