package Section2.Stack.P1;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution stack = new Solution();

        String[] actions = new String[]{"B", "C", "-1", "D", "A", "-1", "1", "-1", "-1"};
        String start = "A";

        System.out.println(new Solution().browserStack(actions, start));

    }
}

class Solution {
    public ArrayList<Stack> browserStack(String[] actions, String start) {
        Stack<String> prevStack = new Stack<>();
        Stack<String> nextStack = new Stack<>();
        Stack<String> current = new Stack<>();
        ArrayList<Stack> result = new ArrayList<>();

        current.push(start);

        // TODO:
        for (int i = 0; i < actions.length; i++) {
            // 새로운 페이지에 접속했을 경우
            if(!actions[i].equals("1") && !actions[i].equals("-1")){
                nextStack.clear();
                prevStack.push(current.pop());
                current.push(actions[i]);
            }
            // 뒤로 가기 버튼
            if(actions[i].equals("-1") && !prevStack.isEmpty()){
                // 현재 페이지를 pop하고 앞으로 가기에 push,
                // 과거 페이지 pop한 것을 현재 페이지에 push
                nextStack.push(current.pop());
                current.push(prevStack.pop());
            }
            // 앞으로 가기
            if(actions[i].equals("1")){
                if(nextStack.isEmpty()) continue;
                String next = nextStack.pop();
                String cur = current.pop();
                current.push(next);
                prevStack.push(cur);

            }
        }

//        System.out.println(prevStack);
//        System.out.println(current);
//        System.out.println(nextStack);
        result.add(prevStack);
        result.add(current);
        result.add(nextStack);

        return result;
    }
}
