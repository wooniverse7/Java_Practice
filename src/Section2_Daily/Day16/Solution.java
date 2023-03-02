package Section2_Daily.Day16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

        // 25
        System.out.println(power(3, 40));

        // 26_treeDFS
//        tree root = new tree("1");
//        tree rootChild1 = root.addChildNode(new tree("2"));
//        tree rootChild2 = root.addChildNode(new tree("3"));
//        tree leaf1 = rootChild1.addChildNode(new tree("4"));
//        tree leaf2 = rootChild1.addChildNode(new tree("5"));
//        ArrayList<String> output = dfs(root);
//        System.out.println(output); // --> ["1", "2", "4", "5", "3"]

        // 27_treeBFS
//        tree root = new tree("1");
//
//        tree rootChild1 = root.addChildNode(new tree("2"));
//        tree rootChild2 = root.addChildNode(new tree("3"));
//        tree leaf1 = rootChild1.addChildNode(new tree("4"));
//        tree leaf2 = rootChild1.addChildNode(new tree("5"));
//        ArrayList<String> output = bfs(root);
//        System.out.println(output); // --> ["1", "2", "3", "4", "5"]

        // 28_balancedBrackets
        boolean output = balancedBrackets("[](){}");
        System.out.println(output); // --> true
        boolean output2 = balancedBrackets("[({})]");
        System.out.println(output2); // --> true
        boolean output3 = balancedBrackets("[(]{)}");
        System.out.println(output3); // --> false

        // 29_tiling
        System.out.println(tiling(2));
        System.out.println(tiling(1));
        System.out.println(tiling(5));

    }

    public static int tiling(int num) {
        // TODO:
        int[] dp = new int[num+2];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < num+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[num];
    }

    // 28_balancedBrackets
    public static boolean balancedBrackets(String str) {
        // 스택 혹은 스트링 빌더 사용
        // 처음에는 무조건 열린 괄호, 열렸을 때 다른 열린 건 ok, 다른 닫힌 건 false
        // 끝나고 스택이 남아있으면 false

        if(str.length() == 0) return true;
        if(str.length() == 1) return false;
        if(str.charAt(0) == ')' || str.charAt(0) == '}' || str.charAt(0) == ']')
            return false;

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(st.size() == 0 && (ch == ')' || ch == '}' || ch == ']')){
                return false;
            }

            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            if(ch == ')'){
                if(st.peek() == '(') st.pop();
                else return false;
            }
            if(ch == '}'){
                if(st.peek() == '{') st.pop();
                else return false;
            }
            if(ch == ']'){
                if(st.peek() == '[') st.pop();
                else return false;
            }
        }

        return true;
    }

    // 27_BFStree
    public static ArrayList<String> bfs(tree node) {
        // BFS는 큐가 기본
        Queue<tree> queue = new LinkedList<>();
        ArrayList<String> rst = new ArrayList<>(); // 순서를 출력할 배열, bfs와 상관없다.
        queue.add(node);

        while(!queue.isEmpty()){
            tree cur = queue.poll();

            rst.add(cur.getValue());

            // 자식 노드가 있으면 큐에 삽입
            if(cur.getChildrenNode() != null){
                queue.addAll(cur.getChildrenNode());
            }
        }

        return rst;
    }
//    public static ArrayList<String> bfs(tree node) {
//
//        Queue<tree> queue = new LinkedList<>();
//    ArrayList<String> values = new ArrayList<>();
//    queue.add(node);
//
//        while(queue.size() > 0) {
//            tree curNode = queue.poll();
//
//            values.add(curNode.getValue());
//
//            if(curNode.getChildrenNode() != null) {
//                queue.addAll(curNode.getChildrenNode());
//            }
//        }
//        return values;
//    }


    //아래 클래스의 내용은 수정하지 말아야 합니다.
    public static class tree {
        private String value;
        private ArrayList<tree> children;

        public tree(String data) {
            this.value = data;
            this.children = null;
        }

        public tree addChildNode(tree node) {
            if(children == null) children = new ArrayList<>();
            children.add(node);
            return children.get(children.size() - 1);
        }

        public String getValue() {      //현재 노드의 데이터를 반환
            return value;
        }

        public ArrayList<tree> getChildrenNode() {
            return children;
        }
    }

    // 26_treeDFS
    public static ArrayList<String> dfs(tree node) {
        ArrayList<String> al = new ArrayList<>();
        al.add(node.getValue()); // 현재의 노드 삽입

        // 자식 노드 깊이 우선 탐색
        if(node.getChildrenNode() != null){
            for (int i = 0; i < node.getChildrenNode().size(); i++) {
//                ArrayList<String> child = new ArrayList<>();
//                child = dfs(node.getChildrenNode().get(i));
                ArrayList<String> child = dfs(node.getChildrenNode().get(i)); // 핵심

                al.addAll(child);
            }
        }
        return al;
    }

    //아래 클래스의 내용은 수정하지 말아야 합니다.
//    public static class tree {
//        private String value;
//        private ArrayList<tree> children;
//
//        public tree(String data) {
//            this.value = data;
//            this.children = null;
//        }
//
//        // dfs로 자식 노드 다 삽입
//        public tree addChildNode(tree node) {
//            if(children == null) children = new ArrayList<>();
//            children.add(node);
//            return children.get(children.size() - 1);
//        }
//
//        public String getValue() {      //현재 노드의 데이터를 반환
//            return value;
//        }
//
//        public ArrayList<tree> getChildrenNode() {
//            return children;
//        }
//    }

    // 25번_pow
    static public long power(int base, int exponent) {

        long rst = 1;
        for (int i = 0; i < exponent; i++) {
            rst *= base;
            rst %= 94906249;
        }

        return rst;
    }

}
