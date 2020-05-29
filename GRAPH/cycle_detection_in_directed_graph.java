class Solution {
    HashSet<Integer> white;
    HashSet<Integer> grey;
    HashSet<Integer> black;
    public boolean canFinish(int n, int[][] p) {
        white=new HashSet<>();
        grey=new HashSet<>();
        black=new HashSet<>();
        ArrayList<Integer>[] g = new ArrayList[n];
        for(int i=0;i<n;i++){
            g[i]=new ArrayList<>();
        }
        for(int[] a : p){
            g[a[0]].add(a[1]);
        }
        for(int i=0;i<n;i++){
            white.add(i);
        }
        for(int i=0;i<n;i++){
            if(dfs(i,g,white,grey,black)) return false;
        }
        return true;
    }
    public boolean dfs(int vertex,ArrayList<Integer>[] g,HashSet<Integer> white,HashSet<Integer> grey,HashSet<Integer> black){
        move(vertex,white,grey);
        for(int A:g[vertex]){
            if(black.contains(A)){
                continue;
            }
            if(grey.contains(A)){
                return true;
            }
            if(dfs(A,g,white,grey,black)){
                return true;
            }
        }
        move(vertex,grey,black);
        return false;
    }
    public void move(int vertex, HashSet<Integer> source, HashSet<Integer> dest){
        source.remove(vertex);
        dest.add(vertex);
    }
}
