package Section2_Daily.Day18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // 31_powerSet
        ArrayList<String> output1 = powerSet2("abc");
        System.out.println(output1); // ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
        ArrayList<String> output2 = powerSet2("jjump");
        System.out.println(output2); // ["", "j", "jm", "jmp", "jmpu", "jmu", "jp", "jpu", "ju", "m", "mp", "mpu", "mu", "p", "pu", "u"]

    }

    // 31_powerSet
    public static ArrayList<String> powerSet2(String str) {
        // 필드 변수를 사용하면 테스트가 정상적으로 작동하지 않습니다.
        // 메서드 내부에서 값을 저장하고 활용해주세요.
        // TODO:

        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        ArrayList<Character> abc = new ArrayList<>();
        abc.add(ch[0]);
        for (int i = 1; i < ch.length; i++) {
            if(ch[i] == ch[i-1]) continue;
            abc.add(ch[i]);
        }
//        System.out.println(abc);

        String[] str2 = new String[abc.size()];
        for (int i = 0; i < str2.length; i++) {
            str2[i] = abc.get(i).toString();
        }
        System.out.println(Arrays.toString(str2));
        boolean[] visited = new boolean[str2.length];

        ArrayList<String> rst = new ArrayList<>();
        powerSetRec(str2, visited, str2.length, 0, rst);

        return rst;
    }

    static void powerSetRec(String[] str, boolean[] visited, int n, int idx, ArrayList<String> rst){
        if (idx == n) {
            print(str, visited, n, rst);
            return;
        }

        visited[idx] = false;
        powerSetRec(str, visited, n, idx + 1, rst);

        visited[idx] = true;
        powerSetRec(str, visited, n, idx + 1, rst);
    }

    static void print(String[] arr, boolean[] visited, int n, ArrayList<String> rst) {
        for (int i = 0; i < n; i++) {
            if (visited[i] == true)
                rst.add(arr[i]);
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static ArrayList<String> powerSet(String str) {

        // 정렬
        String deduplStr = deduplicated(str);
        Stack<String> stack = new Stack<>();

        ArrayList<String> result = new ArrayList<>();

        result = pickOrNot(stack, 0, deduplStr, result);
        // 오름차순으로 정렬
        Collections.sort(result);
        return result;
    };
    // 중복 제거를 위한 메서드를 작성합니다.
    public static String deduplicated(String str) {
        String result = "";
        //indexOf 메서드를 통해 중복여부를 확인합니다.
        for(int index = 0; index < str.length(); index++) {
            if(str.indexOf(str.charAt(index)) == index) {
                result += str.charAt(index);
            }
        }

        String[] sorted = result.split("");
        Arrays.sort(sorted);
        result = String.join(",", sorted).replaceAll(",", "");
        return result;
    }

    // 모든 조합을 검사하는 재귀 함수를 작성합니다.
    public static ArrayList<String> pickOrNot(Stack<String> stack, int idx, String subset, ArrayList<String> result) {
        // 재귀 함수이기 때문에 탈출 조건을 만듭니다.
        if(idx >= subset.length()) {
            // 만약, idx와 sideDishes의 길이가 같거나 크다면(마지막까지 검토한 경우) 스택을 문자열로 변환한 후, 해당 스택을 result에 넣어줍니다.
            result.add(stack.toString()
                    .replaceAll("\\[", "")
                    .replaceAll("]", "")
                    .replaceAll(",", "")
                    .replaceAll(" ", ""));
            return result;
        } else {
            // idx가 부분집합에 포함된 경우
            stack.push(Character.toString(subset.charAt(idx)));
            pickOrNot(stack, idx + 1, subset, result);

            // idx가 부분집합에 포함되지 않은 경우
            stack.pop();
            pickOrNot(stack, idx + 1, subset, result);
        }
        return result;
    }
}
