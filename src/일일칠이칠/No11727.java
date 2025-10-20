package 일일칠이칠;

/**
 * BOJ 11727 · 2×n 타일링 2
 * - 문제 요약: 2×n 격자를 1×2, 2×1, 2×2 타일로 채우는 가짓수를 구한다.
 * - 알고리즘: 동적 계획법 (f(n)=f(n-1)+2f(n-2))
 * - 시간 복잡도: O(n)
 * - 공간 복잡도: O(1)
 * - 사용 이유: 타일 배치가 직전 두 상태에만 의존해 상수 공간으로 계산할 수 있다.
 * - 기타: 11726과 구조가 유사하지만 2×2 타일이 추가돼 점화식이 달라진다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
 *
 * 아래 그림은 2×17 직사각형을 채운 한가지 예이다.
 * */
public class No11727 {
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
