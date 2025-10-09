package 일일칠이삼;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No11723 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String method = st.nextToken();
            int x = 0;
            if(st.hasMoreTokens()) x = Integer.parseInt(st.nextToken());
            switch (method) {
                case "add":
                    list.add(x);
                    break;
                case "remove":
                    remove(list,x);
                    break;
                case "check":
                    sb.append(list.contains(x) ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    toggle(list,x);
                    break;
                case "all":
                    list.clear();
                    for(int i = 1; i <= 20; i++){
                        list.add(i);
                    }
                    break;
                case "empty":
                    list.clear();
                    break;
            }
        }

        System.out.println(sb);

    }

    static void remove(List<Integer> list, int x){
        list.removeAll(Collections.singleton(x));
    }

    static void toggle(List<Integer> list, int x) {
        if (list.contains(x)) {
            remove(list, x);
        } else {
            list.add(x);
        }
    }
}
