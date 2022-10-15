package systemClass.class15;

/**
 * @author: thirteenmj
 * @date: 2022-10-14 19:52
 */
public class Code02_NumberOfIslands {

    public static int numIslands3(char[][] board) {
        int isLands = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '1') {
                    isLands++;
                    infect(board, i, j);
                }
            }
        }
        return isLands;
    }

    private static void infect(char[][] board, int i, int j) {
        if (i < 0 || i > board.length || j < 0 || j > board[0].length) {
            return;
        }
        board[i][j] = '2';
        infect(board, i - 1, j);
        infect(board, i + 1, j);
        infect(board, i, j - 1);
        infect(board, i, j + 1);
    }
}
