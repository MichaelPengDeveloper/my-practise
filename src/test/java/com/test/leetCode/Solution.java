package com.test.leetCode;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wangpeng on 2017/11/6.
 */
public class Solution {

    /**
     *  Example:
     *  Given nums = [2, 7, 11, 15], target = 9,
        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].
     *
     * @param numbers
     * @param target
     * @return
     */

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i + 1;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,23,454,56};
        int[] ints = twoSum(nums, 24);
        for (int i = 0; i < ints.length; i++)
            System.out.println(ints[i]);
    }

}
