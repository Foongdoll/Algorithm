package 일일심구구;

/**
 * BOJ 11399 · ATM
 * - 문제 요약: 각 사람이 기다린 시간의 총합을 최소화하도록 인출 순서를 정한다.
 * - 알고리즘: 그리디 (정렬 + 누적합)
 * - 시간 복잡도: O(N log N)
 * - 공간 복잡도: O(N)
 * - 사용 이유: 짧은 시간이 먼저 오도록 정렬하면 누적 대기 시간이 최소화된다.
 * - 기타: 누적합을 계산해 각 사람이 기여하는 시간을 빠르게 합산한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 각 손님이 돈을 인출하는데 걸리는 분을 준 뒤 가장 최소한으로 모든 사람이 인출하는 분의 합을 구하면 됩니다.
 * */
public class No11399 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> minute = new ArrayList<>();
        while (N-- > 0) {
            minute.add(Integer.parseInt(st.nextToken()));
        }

        minute.sort(Comparator.comparingInt(Integer::intValue));

        int result = 0;
        int sum = 0;
        for(int m : minute){
            sum += m;
            result += sum;
        }

        System.out.println(result);
    }
}
