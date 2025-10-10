package 일일공사칠;
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