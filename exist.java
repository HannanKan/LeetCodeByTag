public class Solution19 {
    int[] dx={-1,1,0,0};
    int[] dy={0, 0,-1,1};
    //0:up,1:down,2:left,3:right
    public boolean exist(char[][] board, String word) {
        if(board==null|| board[0].length==0) return false;
        int rowlen=board.length;
        int colen=board[0].length;
        int[][] mark=new int[rowlen][colen];
        for(int i=0;i<rowlen;i++){
            for(int j=0;j<colen;j++){
                if(aux(board,0,mark,word,i,j)) return true;
            }
        }
        return false;
    }
    //index means current should be processed
    // (x,y) means current one coordinate
    public boolean aux(char[][] board,int index, int[][] mark,String word,int x,int y){
        if(index==word.length()) return true;
        if(x<0||y<0||x>=board.length||y>=board[0].length||mark[x][y]==1||board[x][y]!=word.charAt(index)){
            return false;
        }
        mark[x][y]=1;
        for(int i=0;i<4;i++){
            if(aux(board,index+1,mark,word,x+dx[i],y+dy[i])) return true;
        }
        mark[x][y]=0;
        return false;
    }
}
