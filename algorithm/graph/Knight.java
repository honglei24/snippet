public class Knight {

    /**
     * @param args
     */
    private final static int N = 5;
    // 下一个出口的8个位置的相对坐标
    private static int[][] nextPos = {{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2}};

    private static int[][] chessBoard = new int[N][N];
    public static void main(String[] args) {
        int posX = 0; //初始位置
        int posY = 0; //初始位置
        int count = 0;
        int nextExit = -1;
        chessBoard[posX][posX] = ++count;
        while (count < N * N) {
            nextExit = nextExit(posX, posY);
            if (nextExit <= -1 ) {
                System.out.println("no way");
                printChessBoard();
                System.exit(1);
            } else {
                posX += nextPos[nextExit][0];
                posY += nextPos[nextExit][1];
                chessBoard[posX][posY] = ++count;
            }
        }
        printChessBoard();
    }
    
    //找到出口最少的下一个出口
    public static int nextExit(int x, int y) {
        int result = -1;
        int nextPosX;
        int nextPosY;
        int minNext = 8;
        for (int i = 0; i < 8; i++) {
            nextPosX = x + nextPos[i][0];
            nextPosY = y + nextPos[i][1];
            if ( isInboard(nextPosX, nextPosY)) {
                if (chessBoard[nextPosX][nextPosY] == 0) {
                    if (countExit(nextPosX, nextPosY) < minNext) {
                        minNext = countExit(nextPosX, nextPosY);
                        result = i;
                    }
                }
            }
        }
        return result;
    
    }
    
    //计算出口数量
    public static int countExit(int x, int y){
        int count = -1;
        for (int i = 0; i < 8; i++) {
            if (isInboard(x + nextPos[i][0], y + nextPos[i][1])) {
                if (chessBoard[x + nextPos[i][0]][y + nextPos[i][1]] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
    
    //计算位置是否在棋盘内
    public static boolean isInboard(int posX, int posY) {
        return 0 <= posX && posX < N && 0 <= posY && posY < N;
    }
    
    //打印结果
    public static void printChessBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(chessBoard[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
