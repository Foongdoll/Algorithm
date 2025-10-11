package 일영영삼;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] qs = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            qs[i] = Integer.parseInt(br.readLine());
            if (qs[i] > max) max = qs[i];
        }

        int[] c0 = new int[Math.max(2, max + 1)];
        int[] c1 = new int[Math.max(2, max + 1)];
        c0[0] = 1; c1[0] = 0;
        c0[1] = 0; c1[1] = 1;
        for (int i = 2; i <= max; i++) {
            c0[i] = c0[i - 1] + c0[i - 2];
            c1[i] = c1[i - 1] + c1[i - 2];
        }

        for (int n : qs) {
            out.append(c0[n]).append(' ').append(c1[n]).append('\n');
        }
        System.out.print(out);
    }
}
