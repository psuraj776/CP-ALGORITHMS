/*
*  g[]: adj list of the graph
*  N : number of vertices
*/
class Traversal {
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) {
        ArrayList<Integer> result=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        boolean[] is_Visited = new boolean[N];
        q.add(0);
        is_Visited[0]=true;
        while(!q.isEmpty()){
            int temp=q.poll();
            result.add(temp);
            for(int A : g.get(temp)){
                if(is_Visited[A]==false){
                    is_Visited[A]=true;
                    q.add(A);
                }
            }
        }
        return result;
    }
/*
* if we need to print the shortest path. Note : Unweighted Graph.
*/
/*
*  g[]: adj list of the graph
*  N : number of vertices
*/
      
/*      
class Traversal {
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) {
        ArrayList<Integer> BFS_result=new ArrayList<>();
        ArrayList<Integer> Path_result=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        boolean[] is_Visited = new boolean[N];
        int[] source_node = new int[N];
        int[] destination_node = new int[N];
        q.add(0);
        is_Visited[0]=true;
        source_node[0]  = -1;
        while(!q.isEmpty()){
            int temp=q.poll();
            BFS_result.add(temp);
            for(int A : g.get(temp)){
                if(is_Visited[A]==false){
                    is_Visited[A]=true;
                    q.add(A);
                    destination_node[A] = destination_node[temp]+1;
                    parent_node[A] = temp;
                }
            }
        }
        if (!is_Visited[source]) {
            System.out.print("No source");
            
        } 
        else {
            for (int v = source; v != -1; v = parent_node[v]){
                Path_result.add(v);
            }
            Collections.reverse(Path_result);
        }
        return Path_result;
        
    }
}
*/      
