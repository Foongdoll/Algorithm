package 일일칠이육;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

 아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.
 * */
public class No11726 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        final int MOD = 10007;

        if (n == 1) { System.out.println(1); return; }
        if (n == 2) { System.out.println(3); return; }

        int a = 1; // f(1)
        int b = 3; // f(2)
        for (int i = 3; i <= n; i++) {
            int c = (b + 2 * a) % MOD; // f(i) = f(i-1) + 2*f(i-2)
            a = b;
            b = c;
        }
        System.out.println(b % MOD);
    }
}
