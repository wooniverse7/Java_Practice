package Section2.Stack.P4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Integer[] boxes1 = new Integer[]{5, 1, 4, 6};
//        System.out.println(paveBox(boxes1)); // 3

        Integer[] boxes2 = new Integer[]{5, 1, 4, 6, 3, 2, 4, 2};
        System.out.println(paveBox(boxes2)); // 5

    }
    public static int paveBox(Integer[] boxes) {
        // TODO:

        Queue<Integer> q = new LinkedList<>(Arrays.asList(boxes));
        ArrayList<Integer> arr = new ArrayList<>();

        int max = q.poll();
        int cnt = 1;

        while(!q.isEmpty()){
            // 뒤에 더 큰 숫자가 왔을 때 갱신
            int num = q.poll();
            if(max < num){
                max = num;
                //System.out.println("max = " + max);
                arr.add(cnt);
                //System.out.println("cnt = " + cnt);
                cnt = 1;
            }else{
                //q.poll();
                cnt += 1;
                //System.out.println("cnt " + cnt);
            }
        }
        arr.add(cnt);

        return Collections.max(arr);
    }
}



