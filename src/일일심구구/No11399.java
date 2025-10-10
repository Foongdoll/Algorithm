package 일일심구구;

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
