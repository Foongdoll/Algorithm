package 일일칠이육;

/**
 * BOJ 11726 · 2×n 타일링
 * - 문제 요약: 2×n 격자를 도미노로 채우는 가짓수를 10007로 나눈 값을 구한다.
 * - 알고리즘: 동적 계획법 (현재 구현은 f(n)=f(n-1)+2f(n-2) 사용)
 * - 시간 복잡도: O(n)
 * - 공간 복잡도: O(1)
 * - 사용 이유: 두 이전 상태만으로 다음 값을 계산할 수 있어 상수 공간으로 전개할 수 있다.
 * - 기타: 11726의 정답 점화식은 f(n)=f(n-1)+f(n-2)이므로 검토가 필요하다.
 */

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
