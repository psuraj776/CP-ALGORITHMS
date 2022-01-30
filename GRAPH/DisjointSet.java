class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] ds = new int[n+1];
        for(int i=1;i<=n;i++){
            ds[i] = i;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1){
                    int par_a = find(i+1, ds);
                    int par_b = find(j+1, ds);
                    if(par_a != par_b){
                        ds[par_b] = par_a;
                    }
                }
            }
        }
        int countAns = 0;
        for(int i=1;i<=n;i++){
            if(ds[i] == i){
                countAns += 1;
            }
        }
        return countAns;
    }
    public int find(int n, int[] ds){
        if(n == ds[n]) return n;
        return find(ds[n], ds);
    }
}
