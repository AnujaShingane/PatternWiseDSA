// Time Complexity
// Floyd Warshall -> O(n^3)
// because of 3 nested loops.
  
// Space: O(n^2)

public int[][] shortestDistance(int n , int[][] edges){
  int[][] matrix = new int[n][n];

  for(int[] arr : matrix){
    Arrays.fill(arr,(int)(1e9));
  }

  for(int i = 0 ; i < n ; i++){
     matrix[i][i] = 0; 
  }

  for(int[] edge : edges){
    int u = edge[0];
    int v = edge[1];
    int wt = edge[2];

    matrix[u][v] = wt;
    matrix[v][u] = wt;
  }

  for(int via = 0 ; via < n ; via++){
    for(int i = 0 ; i < n ; i++){
      for(int j = 0 ; j < n ; j++){
        matrix[i][j] = Math.min(matrix[i][j],matrix[i][via]+matrix[via][j]);
      }
    }
  }

  for(int i = 0 ; i < n ; i++){
    if(matrix[i][i]<0){
      System.out.println("This is negative cycle");
    }
  }

  return matrix;
  }
}
