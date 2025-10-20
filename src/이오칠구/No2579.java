package 이오칠구;

/**
 * BOJ 2579 · 계단 오르기
 * - 문제 요약: 연속 세 계단을 밟을 수 없다는 제약 아래에서 계단 점수의 합을 최대로 만든다.
 * - 알고리즘: 동적 계획법 (마지막 두 칸 선택 분기)
 * - 시간 복잡도: O(n)
 * - 공간 복잡도: O(n)
 * - 사용 이유: 직전 두 계단 선택 여부만 고려하면 제약을 자연스럽게 반영한 점화식을 만들 수 있다.
 * - 기타: n=1,2에 대한 기저값을 분리해 점화식이 안정적으로 동작하도록 했다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 계단 오르는 데는 다음과 같은 규칙이 있다.
 *
 * 1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
 * 2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
 * 3. 마지막 도착 계단은 반드시 밟아야 한다.
 * 따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.
 *
 * 각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.
 * */
public class No2579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T+1];
        for(int i = 1; i <= T; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] max = new int[T+1];
        max[1] = arr[1];
        if(T >= 2) max[2] = arr[1] + arr[2];
        for(int i = 3; i <= T; i++){
            max[i] = Math.max(max[i-2], max[i-3] + arr[i - 1])  + arr[i];
        }

        System.out.println(max[T]);
    }
}
