package Section2.Greedy.P02;

public class Main {
    public static void main(String[] args) {
        int k = 4972;

        System.out.println(new Solution().partTimeJob(k));
    }
}

class Solution {
    public int partTimeJob(int k) {
        // TODO:
        // 큰 것부터 하나씩 넣어주면서 재귀 or 반복인데
        // 1원짜리가 있어서 각 동전들 숫자는 고정
        // 단순히 나누기 더하기
        int FH = k / 500;
        k %= 500;

        int OH = k / 100;
        k %= 100;

        int fifty = k / 50;
        k %= 50;

        int ten = k / 10;
        k %= 10;

        int five = k / 5;
        k %= 5;

        int one = k;

        return FH + OH + fifty + ten + five + one;
    }
}
