package 일공구사;

/**
 * BOJ 1094 · 막대기
 * - 문제 요약: 64cm 막대를 잘라 길이 Xcm를 만들 때 필요한 최소 막대 개수를 구한다.
 * - 알고리즘: 그리디 + 이진수 관점
 * - 시간 복잡도: O(log X)
 * - 공간 복잡도: O(1)
 * - 사용 이유: 2의 거듭제곱 막대를 큰 것부터 사용하면 X의 이진 표현과 동일하게 최소 개수를 얻을 수 있다.
 * - 기타: 입력 상한이 64라서 2의 거듭제곱을 미리 구해두고 큰 조각부터 차감한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
 * 2 초	128 MB	41118	30603	25695	75.297%
 * 문제
 * 지민이는 길이가 64cm인 막대를 가지고 있다. 어느 날, 그는 길이가 Xcm인 막대가 가지고 싶어졌다. 지민이는 원래 가지고 있던 막대를 더 작은 막대로 자른다음에, 풀로 붙여서 길이가 Xcm인 막대를 만들려고 한다.
 *
 * 막대를 자르는 가장 쉬운 방법은 절반으로 자르는 것이다. 지민이는 아래와 같은 과정을 거쳐서 막대를 자르려고 한다.
 *
 * 지민이가 가지고 있는 막대의 길이를 모두 더한다. 처음에는 64cm 막대 하나만 가지고 있다. 이때, 합이 X보다 크다면, 아래와 같은 과정을 반복한다.
 * 가지고 있는 막대 중 길이가 가장 짧은 것을 절반으로 자른다.
 * 만약, 위에서 자른 막대의 절반 중 하나를 버리고 남아있는 막대의 길이의 합이 X보다 크거나 같다면, 위에서 자른 막대의 절반 중 하나를 버린다.
 * 이제, 남아있는 모든 막대를 풀로 붙여서 Xcm를 만든다.
 * X가 주어졌을 때, 위의 과정을 거친다면, 몇 개의 막대를 풀로 붙여서 Xcm를 만들 수 있는지 구하는 프로그램을 작성하시오.
 * */
public class No1094 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int[] ruler = new int[7];

        int cnt = 0;

        ruler[0] = 1;
        for(int i = 1; i < 7; i++) {
            ruler[i] = ruler[i-1] * 2;

            if(X == ruler[i]) cnt = 1;
        }
        if(cnt == 0) {
            for(int i = 6; i >= 0; i--) {
                if(X - ruler[i] >= 0) {
                    X = X - ruler[i];
                    cnt++;
                }
                if(X == 0) break;
            }
        }

        System.out.println(cnt);
    }
}