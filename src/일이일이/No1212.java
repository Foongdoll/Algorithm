package 일이일이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class No1212 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String n = br.readLine();

        for(int i = 0; i < n.length(); i++) {
            int a = Integer.parseInt(String.valueOf(n.charAt(i)));
            ArrayDeque<Integer> ad = new ArrayDeque<>();

            while (true) {

                ad.addFirst(a%2);
                a = a/2;
                if(a == 0) {
                    if(ad.size() == 1) {
                        ad.addFirst(0);
                        ad.addFirst(0);
                    } else if(ad.size() == 2) {
                        ad.addFirst(0);
                    }
                    break;
                }
            }

            for(int j = 0; j < 3; j++) sb.append(ad.poll());

        }
        int k = 0;
        while (k < sb.length() - 1 && sb.charAt(k) == '0') k++;
        System.out.println(sb.substring(k));

    }
}
