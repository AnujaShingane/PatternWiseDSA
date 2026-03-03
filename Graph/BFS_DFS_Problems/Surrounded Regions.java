class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0 ; i < m ; i++){
            if(board[0][i]=='O')dfs(0,i,n,m,board);
        }

        for(int j = 0 ; j < n ; j++){
            if(board[j][m-1]=='O')dfs(j,m-1,n,m,board);
        }

        for(int k = 0 ; k < m ; k++){
            if(board[n-1][k]=='O')dfs(n-1,k,n,m,board);
        }

        for(int l = 0 ; l < n ; l++){
            if(board[l][0]=='O')dfs(l,0,n,m,board);
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j]=='O')board[i][j]='X';
                if(board[i][j]=='Y')board[i][j]='O';
            }
        }
    }

    public void dfs(int r,int c,int n,int m,char[][] board){
        if(r<0 || r>=n || c<0 || c>=m || board[r][c]!='O')return;

        board[r][c] = 'Y';

        dfs(r+1,c,n,m,board);
        dfs(r-1,c,n,m,board);
        dfs(r,c+1,n,m,board);
        dfs(r,c-1,n,m,board);
    }
}
