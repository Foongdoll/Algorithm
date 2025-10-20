package 일일공사칠;

/**
 * BOJ 11047 · 동전 0
 * - 문제 요약: 동전 가치가 주어졌을 때 합계 K를 만들기 위한 최소 동전 수를 구한다.
 * - 알고리즘: 그리디 (내림차순 정렬 후 몫 계산)
 * - 시간 복잡도: O(N log N)
 * - 공간 복잡도: O(N)
 * - 사용 이유: 동전 가치가 배수 관계라서 큰 단위부터 사용하면 항상 최적해가 된다.
 * - 기타: K보다 큰 동전은 건너뛰고 헬퍼 메서드로 몫과 나머지를 반복 계산한다.
 */
import java.io.*;
import java.util.*;

/**
 * 동전의 개수와 각 동전의 값이 주어지고 만들어야하는 값 K 가 주어진다.
 * 최소한의 동전 개수를 활용하여 K를 만드시오.
 * */
public class No11047 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> token = new ArrayList<>();

        while(N-- > 0) {
            int v = Integer.parseInt(br.readLine());
            if(K < v) break;
            token.add(v);
        }

        token.sort(Comparator.comparingInt(Integer::intValue).reversed());
        int cnt = 0;
        sb.append(run(K, cnt, token)[1]);
        System.out.println(sb);
    }

    static int[] run(int K,int cnt, List<Integer> token) {
        for(int i : token) {
            if(K == 0) break;
            if(i > K) continue;
            cnt += K / i;
            K = K % i;
        }
        return new int[] {K, cnt};
    }
}