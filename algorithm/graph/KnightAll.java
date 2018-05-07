public class KnightAll {

    /**
     * @param args
     */
    private final static int N = 4;
    private final static int M = 5;
    // 下一个出口的8个位置的相对坐标
    private static int[][] nextPos = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
    
    private static int total = 0;
    static int prePosX; //下一个位置
    static int prePosY; //下一个位置
    public static void main(String[] args) {
        int[][] chessBoard = new int[N][M];
        int startX = 0;
        int startY = 0;
        chessBoard[startX][startY] = 1;
        find(startX, startY, 2, chessBoard);
//        for (int posX = 0; posX < N; posX++) {
//            for (int posY = 0; posY < N; posY++) {
//                int[][] chessBoard = new int[N][N];
//                find(posX, posY, 2, chessBoard);
//            }
//        }
        System.out.println(total);
    }
    
    public static void find(int x, int y, int dep, int[][] chessBoard) {
        int i, xx, yy;
        for (i = 0; i <= 7; i++) {
            xx = x + nextPos[i][0];
            yy = y + nextPos[i][1];
            // 判断新坐标是否出界，是否已走过
            if (isInboard(xx, yy) && chessBoard[xx][yy] == 0) {
                chessBoard[xx][yy] = dep;
                if (dep == N * M) {
                    total++;
                    printChessBoard(chessBoard);
                    System.out.println("##################################");
                } else {
                    // 从新坐标出发，递归下一层
                    find(xx, yy, dep + 1, chessBoard);
                }
                // 回溯，恢复未走标志
                chessBoard[xx][yy] = 0;
            }
        }
    }

    
    //计算位置是否在棋盘内
    public static boolean isInboard(int posX, int posY) {
        return 0 <= posX && posX < N && 0 <= posY && posY < M;
    }
    
    //打印结果
    public static void printChessBoard(int[][] chessBoard) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(chessBoard[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
