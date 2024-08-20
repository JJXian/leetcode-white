package xian.bishi.zijie23.T2扑克牌同花顺;

import java.util.HashMap;
import java.util.Scanner;


class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        //4个花色对应的 map。map的 key放 牌的大小，value放张数
        HashMap<Integer, Integer> mapS = new HashMap<>();
        HashMap<Integer, Integer> mapH = new HashMap<>();
        HashMap<Integer, Integer> mapD = new HashMap<>();
        HashMap<Integer, Integer> mapC = new HashMap<>();
        for (int p = 0; p < n; p++) { //读入n行
            //获取每行的元素
            String str = sc.nextLine();
            String[] sp = str.split("\\ ");
//            牌大小
            int a = Integer.valueOf(sp[0]);
//            多少张
            int cnt = Integer.valueOf(sp[1]);
//            花色
            char c = sp[2].charAt(0);

            //加到对应 map 里。
            if (c == 'S') {
                mapS.put(a, mapS.getOrDefault(a, 0) + cnt);
            }
            if (c == 'H') {
                mapH.put(a, mapH.getOrDefault(a, 0) + cnt);
            }
            if (c == 'D') {
                mapD.put(a, mapD.getOrDefault(a, 0) + cnt);
            }
            if (c == 'C') {
                mapC.put(a, mapC.getOrDefault(a, 0) + cnt);
            }
        }

        //统计每个花色中同花顺的数量并加入到结果中
        long res = 0L;
        res = handle(mapS, res);
        res = handle(mapH, res);
        res = handle(mapD, res);
        res = handle(mapC, res);

        System.out.println(res);
    }

    /**
     * 以每个元素为开头 来算有没有同花顺。
     * 处理每个花色的同花顺
     */
    public static long handle(HashMap<Integer, Integer> map, long res) {
//        对于每种花色的牌，检查是否有从 i 开始的连续五张牌（i, i+1, i+2, i+3, i+4）。
//        计算这些牌中的最小数量 minCnt，表示最多能组成多少个同花顺。如果 minCnt 不为 0，
//        说明可以组成 minCnt 个同花顺，然后从 map 中减去这些牌的数量，并将 minCnt 加到 res 中。
        for (int i : map.keySet()) {
            int i1 = i + 1;
            int i2 = i + 2;
            int i3 = i + 3;
            int i4 = i + 4;

//            获得牌为i-i4的数量
            int minCnt = map.getOrDefault(i, 0);
            minCnt = Math.min(minCnt, map.getOrDefault(i1, 0));
            minCnt = Math.min(minCnt, map.getOrDefault(i2, 0));
            minCnt = Math.min(minCnt, map.getOrDefault(i3, 0));
            minCnt = Math.min(minCnt, map.getOrDefault(i4, 0));

            //连着的4个的张数不为0说明就有同花顺。记录结果并减去对应张数。
            if (minCnt != 0) {
//                minCnt为连续5张的最小牌数 意思这些牌足够且能构成同花顺
                res = res + minCnt;
//                把这些数量减去
                map.put(i, map.get(i) - minCnt);
                map.put(i1, map.get(i1) - minCnt);
                map.put(i2, map.get(i2) - minCnt);
                map.put(i3, map.get(i3) - minCnt);
                map.put(i4, map.get(i4) - minCnt);
            }
        }
        return res;
    }
}