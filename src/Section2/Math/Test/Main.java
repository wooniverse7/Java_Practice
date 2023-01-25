package Section2.Math.Test;

public class Main {

    public static void main(String[] args) {
        // 6개 중 3개를 뽑음
        int n = 6;
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] output = new int[n]; // 출력 결과 저장
        boolean[] visited = new boolean[n];

        perm(arr, output, visited, 0, n, 3);
    }

    //순열 (순서있게 배열)
    // 순서를 지키면서 n 개중에서 r 개를 뽑는 경우
    // 사용 예시: perm(arr, output, visited, 0, n, 3);
    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        // 탈출문
        if (depth == r) {
            print(output, r);
            return;
        }

        for (int i=0; i<n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                output[depth] = 0; // 이 줄은 없어도 됨
                visited[i] = false;;
            }
        }
    }

    // 배열 출력
    static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}