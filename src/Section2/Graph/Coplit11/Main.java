package Section2.Graph.Coplit11;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        boolean result = getDirections(new int[][]
                        {
                                {0, 1, 0, 0},
                                {0, 0, 1, 0},
                                {0, 0, 0, 1},
                                {0, 1, 0, 0}
                        },
                0,
                2
        );
        System.out.println(result);

        boolean result2 = getDirections(new int[][]
                        {
                                {0, 1, 0, 0, 0},
                                {0, 0, 0, 1, 0},
                                {0, 1, 0, 0, 0},
                                {0, 1, 1, 0, 0},
                                {1, 1, 1, 1, 0}
                        },
                1,
                4
        );
        System.out.println(result2); // false
    }


    public static boolean getDirections(int[][] matrix, int from, int to){

        //from에서 to까지 어떤 값이 되느냐..우움
        //들어온 matrix에 해당 행이 시작점으로 두고
        //갈수있는 열을 체크 to가 바로있으면 true바로 반환
        //to가 없으면
        //각 열을 다시 from에 넣고 체크
        //더이상 진입할수없는 열이면 즉 00000이면.false반환
        //나->나로 가진 않음.
        int[][] curMat = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {

        }

        //출발한 노드로는 다시 돌아가지 않는다.
        int size = matrix[0].length;

        if(matrix[from][to]==1) {
            return true; // 바로 연결되면 트루 반환
        }

//        while(true){
//
//        }
// 0 - 1 / 1 - 3 true
        for(int i=0; i<size; i++){
            //from에서 연결된 노드 찾아서
            //해당 노드를 from에 넣어서 재검색
            if(matrix[from][i]==1){
                matrix[from][i]=0;
                matrix[i][from]=0;
                from=i; // 다시 못돌아가게 0으로 만들어버림.
                return getDirections(matrix, from, to);
            }

        }
        return false;

    }
}
