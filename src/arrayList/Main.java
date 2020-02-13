package arrayList;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> b = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            b.add("b element " + i);
        }
        MyList<String> a = new MyArrayList<>();
        for (int i = 20; i > 0; i--) {
            a.add("a element " + i);
        }

        a.addAll(b);

        for (String s : a) {

            System.out.println(s);
        }
    }
}
