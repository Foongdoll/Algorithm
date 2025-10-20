package 일영영삼;

/**
 * BOJ 1003 · 피보나치 함수
 * - 문제 요약: 재귀형 피보나치 함수가 0과 1을 몇 번 출력하는지 구한다.
 * - 알고리즘: 동적 계획법 (피보나치 호출 횟수 테이블)
 * - 시간 복잡도: O(요청된 n의 최댓값)
 * - 공간 복잡도: O(요청된 n의 최댓값)
 * - 사용 이유: 0과 1의 호출 횟수를 누적해두면 테스트케이스마다 상수 시간에 답을 구할 수 있다.
 * - 기타: StringBuilder로 출력 버퍼를 모아 I/O 비용을 줄였다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * fibonacci(3)을 호출하면 다음과 같은 일이 일어난다.
 *
 * fibonacci(3)은 fibonacci(2)와 fibonacci(1) (첫 번째 호출)을 호출한다.
 * fibonacci(2)는 fibonacci(1) (두 번째 호출)과 fibonacci(0)을 호출한다.
 * 두 번째 호출한 fibonacci(1)은 1을 출력하고 1을 리턴한다.
 * fibonacci(0)은 0을 출력하고, 0을 리턴한다.
 * fibonacci(2)는 fibonacci(1)과 fibonacci(0)의 결과를 얻고, 1을 리턴한다.
 * 첫 번째 호출한 fibonacci(1)은 1을 출력하고, 1을 리턴한다.
 * fibonacci(3)은 fibonacci(2)와 fibonacci(1)의 결과를 얻고, 2를 리턴한다.
 * 1은 2번 출력되고, 0은 1번 출력된다. N이 주어졌을 때, fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.*
 * */
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
