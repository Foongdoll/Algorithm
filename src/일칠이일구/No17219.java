package 일칠이일구;

/**
 * BOJ 17219 · 비밀번호 찾기
 * - 문제 요약: 사이트 주소와 비밀번호가 주어지면 쿼리마다 대응 비밀번호를 찾아 출력한다.
 * - 알고리즘: 해시맵
 * - 시간 복잡도: O(N + M)
 * - 공간 복잡도: O(N)
 * - 사용 이유: 주소를 키로 저장하면 각 쿼리를 한 번의 조회로 해결할 수 있다.
 * - 기타: StringBuilder로 결과를 모아 출력 비용을 줄였다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No17219 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> address = new HashMap<>();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            address.put(st.nextToken(), st.nextToken());
        }

        while (M-- > 0) {
            sb.append(address.get(br.readLine())).append("\n");
        }

        System.out.println(sb);
    }
}
