class GfG{
     static ArrayList<String> arr = new ArrayList<>();
     static int[] dx = {0,0,1,-1};
     static int[] dy = {1,-1,0,0};
     static char[] direction = {'R','L','D','U'};
     static boolean check(int x,int y,int n){
         if( (x < n && x >= 0) && (y < n && y >= 0) ){
             return true;
         }
         return false;
     }
     static void findroutedfs(int[][] m, int[][] v,String s,int n,int x,int y){
         if(x == n-1 && y == n-1 ){
             arr.add(s);
             return;
         }
         v[x][y] = 1;
         for( int i = 0; i < 4; i++ ){
             int newx = x + dx[i];
             int newy = y + dy[i];
             if( check(newx,newy,n) && v[newx][newy] == 0 && m[newx][newy] == 1 ){
                 findroutedfs(m,v,s+direction[i],n,newx,newy);
             }
         }
         v[x][y] = 0;
     }
     public static ArrayList<String> printPath(int[][] m, int n)
     {
         int[][] visited = new int[n][n];
         for( int i = 0; i < n; i++ ){
             for( int j = 0; j < n; j++ ){
                 visited[i][j] = 0;
             }
         }
         String route = "";
         arr.clear();
         findroutedfs(m,visited,route,n,0,0);
         Collections.sort(arr);
         return arr;
         
     }
}
