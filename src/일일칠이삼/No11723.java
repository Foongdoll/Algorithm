package 일일칠이삼;

/**
 * BOJ 11723 · 집합
 * - 문제 요약: 1부터 20까지의 정수 집합에 대한 추가, 삭제, 조회 연산을 구현한다.
 * - 알고리즘: 구현 (ArrayList 기반 집합 시뮬레이션)
 * - 시간 복잡도: O(연산 수 × 20)
 * - 공간 복잡도: O(20)
 * - 사용 이유: 원소 범위가 작아서 리스트만으로도 모든 연산을 충분히 빠르게 처리할 수 있다.
 * - 기타: removeAll과 contains를 사용해 중복을 제거하고 토글 동작을 단순화했다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * s 라는 집합에 들어오는 명령어에 맞춰 작업 수행
 * */
public class No11723 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String method = st.nextToken();
            int x = 0;
            if(st.hasMoreTokens()) x = Integer.parseInt(st.nextToken());
            switch (method) {
                case "add":
                    list.add(x);
                    break;
                case "remove":
                    remove(list,x);
                    break;
                case "check":
                    sb.append(list.contains(x) ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    toggle(list,x);
                    break;
                case "all":
                    list.clear();
                    for(int i = 1; i <= 20; i++){
                        list.add(i);
                    }
                    break;
                case "empty":
                    list.clear();
                    break;
            }
        }

        System.out.println(sb);

    }

    static void remove(List<Integer> list, int x){
        list.removeAll(Collections.singleton(x));
    }

    static void toggle(List<Integer> list, int x) {
        if (list.contains(x)) {
            remove(list, x);
        } else {
            list.add(x);
        }
    }
}
