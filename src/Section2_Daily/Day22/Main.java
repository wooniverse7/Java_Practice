package Section2_Daily.Day22;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int K = 1;

        System.out.println(matrix[0][0]); // --> 1
        System.out.println(matrix[3][2]); // --> 15

        int[][] rotatedMatrix = rotateMatrix(matrix, K);
        System.out.println(rotatedMatrix[0][0]); // --> 13
        System.out.println(rotatedMatrix[3][2]); // --> 8

    }

    public static int[][] rotateMatrix(int[][] matrix, int K) {
        if(matrix == null || matrix.length == 0) return matrix;

        int N = matrix.length;

        int rotateNum = K % 4;

        if(rotateNum == 0) return matrix;

        int[][] rotated = matrix;


        for (int i = 0; i < rotateNum; i++) {
//            for(int row = 0; row < N; row++) {
//                for(int col = 0; col < N; col++) {
//                    rotated[row][col] = matrix[N - col - 1][row];
//                }
//            }
            rotated = rotate(rotated, N);
        }

        return rotated;
    }

    static int[][] rotate(int[][] matrix, int N){
        int[][] rotated = new int[N][N];

            for(int row = 0; row < N; row++) {
                for(int col = 0; col < N; col++) {
                    rotated[row][col] = matrix[N - col - 1][row];
                }
            }

        return rotated;
    }

    public static int[][] rotateMatrix2(int[][] matrix, int K) {
        //빈 배열일 경우
        if(matrix == null || matrix.length == 0) return matrix;

        int N = matrix.length;

        int rotateNum = K % 4;
        // 회전하지 않는다.
        if(rotateNum == 0) return matrix;
        // 홀수번 회전 시 M x N, 짝수번 회전 시 N x M
//        int[][] rotated = rotateNum % 2 == 1 ? new int[M][N] : new int[N][M];
        int[][] rotated = new int[N][N];

        for (int i = 0; i < rotateNum; i++) {
            for(int row = 0; row < N; row++) {
                for(int col = 0; col < N; col++) {
                    rotated[row][col] = matrix[N - col - 1][row];
                }
            }
        }
//        for(int row = 0; row < N; row++) {
//            for(int col = 0; col < N; col++) {
//                if(rotateNum == 1) {
//                    rotated[row][col] = matrix[N - col - 1][row];
//                } else if(rotateNum == 2) {
//                    rotated[row][col] = matrix[N - row - 1][N - col - 1];
//                } else {
//                    rotated[row][col] = matrix[col][N - row - 1];
//                }
//            }
//        }
        return rotated;
    }
}
