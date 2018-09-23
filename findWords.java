import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution20 {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    //0:up,1:down,2:left,3:right
    public List<String> findWords(char[][] board, String[] words) {
        ArrayList<String> res=new ArrayList<>();
        if (board == null || board[0].length == 0) return res;
        int rowlen = board.length;
        int colen = board[0].length;
        int[][] mark = new int[rowlen][colen];
        for (int k = 0; k < words.length; k++) {
            for (int i = 0; i < rowlen; i++) {
                for (int j = 0; j < colen; j++) {
                    if (aux(board, 0, mark, words[k], i, j)) res.add(words[k]);
                }
            }
        }
        HashSet<String> tmp=new HashSet<>(res);
        res=new ArrayList<>(tmp);
        return res;
    }


    //index means current should be processed
    // (x,y) means current one coordinate
    public boolean aux(char[][] board, int index, int[][] mark, String word, int x, int y) {
        if (index == word.length()) return true;
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || mark[x][y] == 1 || board[x][y] != word.charAt(index)) {
            return false;
        }
        mark[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            if (aux(board, index + 1, mark, word, x + dx[i], y + dy[i])) {
                mark[x][y]=0;
                return true;
            }
        }
        mark[x][y] = 0;
        return false;
    }
}
