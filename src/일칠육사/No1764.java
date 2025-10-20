package 일칠육사;

/**
 * BOJ 1764 · 듣보잡
 * - 문제 요약: 듣보잡 명단에서 두 목록에 모두 있는 이름을 찾아 사전순으로 출력한다.
 * - 알고리즘: 해시셋 + 정렬
 * - 시간 복잡도: O(N + M + K log K)
 * - 공간 복잡도: O(N + K)
 * - 사용 이유: 한 목록을 해시셋으로 저장하면 다른 목록을 탐색하면서 교집합을 상수 시간에 판별할 수 있다.
 * - 기타: 해시셋 용량을 미리 잡아 리사이즈를 줄이고 최종 목록을 정렬해 요구 조건을 충족한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * 듣도 못한 사람과 보도 못한 사람이 주어지면 듣도 보도 못한 사람을 찾는 문제
 * */
public class No1764 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cap = (int)(N / 0.75f) + 1;
        Set<String> noSpeak = new HashSet<>(cap);

        for (int i = 0; i < N; i++) {
            noSpeak.add(br.readLine());
        }

        List<String> both = new ArrayList<>(Math.min(N, M));
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (noSpeak.contains(s)) both.add(s);
        }

        Collections.sort(both);
        sb.append(both.size()).append('\n');
        for (String s : both) sb.append(s).append('\n');
        System.out.print(sb);
    }

}
