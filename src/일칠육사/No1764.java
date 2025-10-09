package 일칠육사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
