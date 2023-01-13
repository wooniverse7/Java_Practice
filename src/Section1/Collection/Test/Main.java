package Section1.Collection.Test;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(5);

        for (int i = 0; i < 10; i += 2) {
            al.add(i);
        }
        System.out.println(al.get(3));
        al.isEmpty();
        al.size();
        al.set(1, 5);
        System.out.println(al.get(1));
    }
}
