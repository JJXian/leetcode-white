# leetcode白板代码答案

## 贪心算法 GreedyAlgorithm
> 贪心算法

| 题目                                                         | 完成 | 难度 | 方法                                                         | 备注         |
| ------------------------------------------------------------ | ---- | ---- | ------------------------------------------------------------ | ------------ |
| [摆动序列](https://leetcode.cn/problems/wiggle-subsequence/) | ❌    | 中等 |                                                              |              |
| [跳跃游戏](https://leetcode.cn/problems/jump-game/description/) | ❌    | 中等 | 遍历更新能跳的最大范围，看看能不能到达终点                   |              |
| [跳跃游戏2](https://leetcode.cn/problems/jump-game-ii/description/) | ✅    | 中等 | range控制每次能跳的最大范围，确保每次跳最远，由范围出发      |              |
| [k次取反后的最大值](https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/description/) | ✅    | 简单 | 反复排序取反，确保每次都是取反的最小值，这样结果最大         |              |
| [加油站](https://leetcode.cn/problems/gas-station/description/) | ⭕️    | 中等 | 三个关键变量：总油量、总消耗量、当前能否到达下一站的油量     | 暴力法超时   |
| [分发糖果](https://leetcode.cn/problems/candy/description/)  | ⭕️    | 困难 | 遍历两次，从左往右 and 从右向左                              |              |
| [柠檬水找零](https://leetcode.cn/problems/lemonade-change/description/) | ✅    | 简单 |                                                              |              |
| [根据身高重建队列](https://leetcode.cn/problems/queue-reconstruction-by-height/) | ❌    | 中等 | 有k,h二维，贪心算法先确定一个纬度的顺序，然后考虑第二个纬度  |              |
| [用最少的箭射爆气球](https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/description/) | ⭕️    | 中等 | Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0])); 将二维数组按第一个元素排序 |              |
| [无重叠区间](https://leetcode.cn/problems/non-overlapping-intervals/submissions/539817665/) | ✅    | 中等 | 排序按照区间结束位置排序，这样才能保留更多的区间             | 注意排序方式 |
| [划分字母区间](https://leetcode.cn/problems/partition-labels/) | ❌    | 中等 | 统计一段中字母出现的最大下标，然后遍历过程中更新下标         |              |
| [合并区间](https://leetcode.cn/problems/merge-intervals/)    | ⭕️    | 中等 | 创建数组 new int[]{start,end} 赋初始值，return res.toArray(new int[res.size()][]); list转二维数组 |              |
|                                                              |      |      |                                                              |              |
|                                                              |      |      |                                                              |              |



