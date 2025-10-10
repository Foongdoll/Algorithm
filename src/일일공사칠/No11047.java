import java.io.*;
import java.util.*;

public class Main {
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