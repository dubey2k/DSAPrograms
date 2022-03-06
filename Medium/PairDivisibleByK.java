package Medium;

import java.util.HashMap;

/*
Given an array of integers arr of even length n and an integer k.

We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.

Return true If you can find a way to do that or false otherwise.

Input: arr = [1,2,3,4,5,10,6,7,8,9], k = 5
Output: true
Explanation: Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).

*/

public class PairDivisibleByK {

    public static void main(String[] args) {
        int[] arr = { 3, 8, 7, 2 };
        System.out.println(canArrange(arr, 10));
    }

    public static boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            int rem = i % k;
            // handle negative remainders -33 -> rem = 2 => -35 + 2
            if (rem < 0)
                rem += k;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        for (Integer rem : map.keySet()) {
            // check if
            // 1. target number odd, x = k - x => e.g. -> [10,5,15,3,{2},{7 -> remaining}]
            // 2. rem == 0 => e.g. -> [10,5,15,3,2,{5}]
            // it should be even
            if ((rem == 0 || (rem == k / 2 && k % 2 == 0))) {
                int val = map.get(rem);
                if (val % 2 != 0)
                    return false;
                else
                    continue;
            }
            int count = map.get(rem);
            int remCount = map.getOrDefault(k - rem, 0);
            if (count != remCount)
                return false;
        }
        return true;
    }
}
