package Section2.Stack.P4_1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer[] boxes1 = new Integer[]{5, 1, 4, 6};
        System.out.println(paveBox(boxes1)); // 3

        Integer[] boxes2 = new Integer[]{5, 1, 4, 6, 3, 2, 4, 2};
        System.out.println(paveBox(boxes2)); // 5

    }
    public static int paveBox(Integer[] boxes) {
        // TODO:

        Queue<Integer> queue = new LinkedList<>(Arrays.asList(boxes));

        int max=0;
        //앞사람 값 뽑아두기.(기준값용)
        while(!queue.isEmpty()){

            int fst=queue.poll();
            int count=1;

            int size=queue.size();
            for(int j=0; j<size; j++){
                if(fst >= queue.peek()){
                    queue.poll();
                    count++;
                }else{
                    break;
                }
            }

            if(count>max){
                max=count;
            }
        }
        return max;
    }
}



