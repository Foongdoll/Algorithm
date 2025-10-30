package 일이오일;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 알파벳 소문자로 이루어진 단어를 가지고 아래와 같은 과정을 해 보려고 한다.
 * 먼저 단어에서 임의의 두 부분을 골라서 단어를 쪼갠다. 즉, 주어진 단어를 세 개의 더 작은 단어로 나누는 것이다. 각각은 적어도 길이가 1 이상인 단어여야 한다. 이제 이렇게 나눈 세 개의 작은 단어들을 앞뒤를 뒤집고, 이를 다시 원래의 순서대로 합친다.
 * 예를 들어,
 * 단어 : arrested
 * 세 단어로 나누기 : ar / rest / ed
 * 각각 뒤집기 : ra / tser / de
 * 합치기 : ratserde
 * 단어가 주어지면, 이렇게 만들 수 있는 단어 중에서 사전순으로 가장 앞서는 단어를 출력하는 프로그램을 작성하시오.
 * */
public class No1251 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int n = word.length();

        String best = null;

        for (int i = 1; i <= n - 2; i++) {        // 첫 컷: 1..n-2
            for (int j = i + 1; j <= n - 1; j++) { // 둘째 컷: i+1..n-1
                String a = new StringBuilder(word.substring(0, i)).reverse().toString();
                String b = new StringBuilder(word.substring(i, j)).reverse().toString();
                String c = new StringBuilder(word.substring(j)).reverse().toString();

                String cand = a + b + c;
                if (best == null || cand.compareTo(best) < 0) {
                    best = cand;
                }
            }
        }

        System.out.println(best);
    }
}
