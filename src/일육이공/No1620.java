package 일육이공;

/**
 * BOJ 1620 · 나는야 포켓몬 마스터 이다솜
 * - 문제 요약: 포켓몬 이름과 번호를 서로 변환하는 쿼리를 처리한다.
 * - 알고리즘: 해시맵 기반 양방향 매핑
 * - 시간 복잡도: O(N + M)
 * - 공간 복잡도: O(N)
 * - 사용 이유: 이름과 번호를 모두 키로 저장하면 양방향 조회를 상수 시간에 처리할 수 있다.
 * - 기타: 번호를 문자열로 저장해 같은 맵에서 관리하며 출력 순서를 유지한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 입력한 사전 내 이름과 순서대로 번호를 넣고, 번호를 넣으면 이름을 이름을 넣으면 번호를 출력하도록
 * */
public class No1620 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, String> dictionary = new HashMap<>();
        int dictionaryNumber = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        while (N-- > 0) {
            String input = br.readLine();
            dictionary.put(dictionaryNumber+"", input);
            dictionary.put(input, dictionaryNumber+"");
            dictionaryNumber++;
        }

        for(int i = 0; i < M; i++){
            String find = br.readLine();
            sb.append(dictionary.get(find)).append("\n");
        }
        System.out.println(sb);
    }
}
