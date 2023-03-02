package Section2_Daily.Day21;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[][] room = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0}
        };
        int[] src = new int[]{4, 2};
        int[] dst = new int[]{2, 2};
        int output = robotPath(room, src, dst);
        System.out.println(output); // --> 8

    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static int robotPath(int[][] room, int[] src, int[] dst) {
        // TODO :

        Queue<int[]> Q = new LinkedList<>();
        room[src[0]][src[1]] = 1;

        int M = room.length;
        int N = room[0].length;
        visited = new boolean[M][N];

        Q.add(src);

        while(!Q.isEmpty()){
            int[] cur = Q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if(room[nx][ny] == 0 && !visited[nx][ny]) {
                    Q.add(new int[]{nx, ny});
                    room[nx][ny] += room[x][y] + 1;
                    visited[nx][ny] = true;
                }


            }
        }

        int x = dst[0];
        int y = dst[1];

        return room[x][y] - 1;
    }
}

class Solution {
    public int robotPath(int[][] room, int[] src, int[] dst) {
        // 로봇이 서 있는 위치를 1로 초기화하면 (다시 방문하지 않기 위해서),
        // 바로 옆 통로는 2가 된다.
        // 계산이 완료된 후에 최종값에 1을 빼주면 된다.
        room = aux(room.length, room[0].length, src, 1, room);

        return room[dst[0]][dst[1]] - 1;
    }

    public int[][] aux(int M, int N, int[] candi, int step, int[][] room) {
        // 현재 위치
        int row = candi[0];
        int col = candi[1];

        // 배열의 범위를 벗어난 경우
        if (row < 0 || row >= M || col < 0 || col >= N) return room;

        if (room[row][col] == 0 || room[row][col] > step) {
            room[row][col] = step;
        } else {
            // 장애물(1)이거나 이미 최소 시간(1)으로 통과가 가능한 경우
            return room;
        }

        // dfs로 4가지 방향에 대해 탐색을 한다.
        // 완전탐색을 해야하므로 bfs나 dfs가 큰 차이가 없다.
        // bfs의 경우 목적지에 도착하는 경우 탐색을 중단해도 되므로,
        // 약간 더 효율적이다.
        aux(M, N, new int[]{row + 1, col}, step + 1, room); // 상
        aux(M, N, new int[]{row - 1, col}, step + 1, room); // 하
        aux(M, N, new int[]{row, col - 1}, step + 1, room); // 좌
        aux(M, N, new int[]{row, col + 1}, step + 1, room); // 우

        return room;
    }
}