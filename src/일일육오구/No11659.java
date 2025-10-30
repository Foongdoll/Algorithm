package 일일육오구;

/**
 * BOJ 11659 · 구간 합 구하기 4
 * - 문제 요약: 수열과 구간 합 쿼리가 주어졌을 때 각 구간 합을 빠르게 구한다.
 * - 알고리즘: 누적합 (Prefix Sum)
 * - 시간 복잡도: O(N + M)
 * - 공간 복잡도: O(N)
 * - 사용 이유: 누적합을 한 번 계산해두면 쿼리를 상수 시간에 처리할 수 있다.
 * - 기타: 1-based 인덱스를 사용해 prefix[end] - prefix[start-1] 형태로 즉시 합을 구한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
 * */
public class No11659 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합 계산
        int[] prefix = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(prefix[end] - prefix[start - 1]).append("\n");
        }

        System.out.print(sb);
    }
}
