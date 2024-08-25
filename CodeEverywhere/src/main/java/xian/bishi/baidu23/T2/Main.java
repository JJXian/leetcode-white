package xian.bishi.baidu23.T2;

import java.util.Scanner;

/**
 * 小红的踏空斩
 * 测试用例；
 * 5
 * 2 3 4 2 3
 */
public class Main {
    static final int N = 1000010;
    static long[] f = new long[N];
    static long ans;

    public static void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            f[i] = sc.nextLong();
        }
        sc.close();

        ans = 0;
        for (int i = n - 2; i >= 1; i--) {
            if (f[i] >= 1 && f[i + 1] >= 2 && f[i + 2] >= 3) {
                long tmp = Math.min(f[i], Math.min(f[i + 1] / 2, f[i + 2] / 3));
                ans += 5L * tmp;

                f[i] -= tmp;
                f[i + 1] -= tmp * 2;
                f[i + 2] -= tmp * 3;

//                ans += f[i + 2];
//                f[i + 2] = 0;
            }
        }

        // 最后找到无法满足第二个技能条件的血量，加上即可。
        for (int i = 1; i <= n; i++) {
            ans += f[i];
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        solve();
    }
}