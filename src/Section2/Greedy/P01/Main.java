package Section2.Greedy.P01;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = new int[]{42, 25, 60, 73, 103, 167};
        int box = 187;

        System.out.println(new Solution().movingStuff(arr, box));
    }
}

// 가장 가벼운 짐 2개씩 나르는게 효율적인게 아니라 가장 가벼운 짐과 박스에 들어가는 가장 무거운 짐을 한 박스에 넣어 옮기는게 가장 효율적임
// 박스의 무게를 꽉 채워서
class Solution {
    public int movingStuff(int[] stuff, int limit) {
        int twoStuff = 0;
        // 짐을 무게순으로 오름차순 정렬
        Arrays.sort(stuff);
        // 가장 가벼운 짐의 인덱스
        int leftIdx = 0;
        // 가장 무거운 짐의 인덱스
        int rightIdx = stuff.length - 1;

        while(leftIdx < rightIdx) {
            // 가장 가벼운 짐과 무거운 짐의 합이 limit 보다 작거나 같으면 2개를 한번에 나를 수 있다
            if(stuff[leftIdx] + stuff[rightIdx] <= limit) {
                // 다음 짐을 확인하기 위해 가장 가벼운 짐과 무거운 짐을 가리키는 인덱스를 옮겨주고
                // 한번에 2개 옮길 수 있는 개수를 +1 해준다
                leftIdx++;
                rightIdx--;
                twoStuff++;
            } else {
                // 위 조건에 맞지 않는 경우는 한번에 한 개만 나를 수 있는 경우이기 때문에
                // 가장 무거운 짐의 인덱스만 옮겨준다
                // 그래서 가장 가벼운 짐 하나를 기준에 두고 옮김
                rightIdx--;
            }
            // leftIdx와 rightIdx가 만나면 더 이상 나를 짐이 없다는 것
            // 끝
        }
        // 전체 짐의 개수에서 한번에 2개를 나를 수 있는 경우를 빼 주면 총 필요한 박스의 개수를 구할 수 있다
        return stuff.length - twoStuff;
    }

    public int movingStuff2(int[] stuff, int limit) {
        int cnt = 0;
        Arrays.sort(stuff);
        // 가장 가벼운 짐의 인덱스
        int leftIdx = 0;
        // 가장 무거운 짐의 인덱스
        int rightIdx = stuff.length - 1;

        while(leftIdx <= rightIdx) {
            if(stuff[leftIdx] + stuff[rightIdx] <= limit) {
                leftIdx++;
                rightIdx--;
                cnt++;
            } else {
                cnt++;
                rightIdx--;
            }
            // 1개 옮기는 경우도 같이 구함
            // 단, 마지막 1개를 구해야 해서 등호가 필요하다.
        }
        return cnt;
    }
}
