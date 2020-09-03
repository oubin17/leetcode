package com.ob.algorithm.array;

import java.util.*;

/**
 * @Author: oubin
 * @Date: 2020/9/3 15:50
 * @Description: 前k个高频元素
 */
public class TopKFrequent {

    public static void main(String[] args) {
        int[] array = new int[]{1,1,1,2,2,3};
        topKFrequent(array, 2);

    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList();
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length+1];
        for(int key : map.keySet()){
            // 获取出现的次数作为下标
            int i = map.get(key);
            if(list[i] == null){
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }

        // 倒序遍历数组获取出现顺序从大到小的排列
        for(int i = list.length - 1;i >= 0 && res.size() < k;i--){
            if(list[i] == null) {
                continue;
            }
            res.addAll(list[i]);
        }
        return res;
    }
}
