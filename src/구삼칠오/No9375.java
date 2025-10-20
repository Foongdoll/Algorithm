package 구삼칠오;

/**
 * BOJ 9375 · 패션왕 신해빈
 * - 문제 요약: 의상 이름과 종류가 주어질 때, 하루에 최소 한 벌 이상 착용하면서 가능한 모든 코디 조합의 수를 구한다.
 * - 알고리즘: 해시맵과 곱셈 원리를 이용한 조합 계산
 * - 시간 복잡도: O(테스트케이스별 의상 수)
 * - 공간 복잡도: O(의상 종류 수)
 * - 사용 이유: 카테고리별 개수를 해시맵에 누적하면 조합을 직접 나열하지 않고도 경우의 수를 빠르게 계산할 수 있다.
 * - 기타: 테스트케이스마다 맵을 초기화하고 아무 것도 입지 않는 경우를 제외해 답을 도출한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No9375 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); // 옷 이름은 필요 없음
                String type = st.nextToken(); // 옷 종류
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int result = 1;
            for (int count : map.values()) {
                result *= (count + 1); // 해당 종류 안 입는 경우(+1)
            }

            System.out.println(result - 1); // 전부 안 입는 경우 제외
        }
    }
}
