package Medium;

import java.util.Arrays;

/*
You are given an integer array nums and an integer k.
Append k unique positive integers that do not appear in nums to nums such that the resulting total sum is minimum.

Return the sum of the k integers appended to nums.

Input: nums = [1,4,25,10,25], k = 2
Output: 5
Explanation: The two unique positive integers that do not appear in nums which we append are 2 and 3.
The resulting sum of nums is 1 + 4 + 25 + 10 + 25 + 2 + 3 = 70, which is the minimum.
The sum of the two integers appended is 2 + 3 = 5, so we return 5.

*/
public class AppendInArray {

    public static void main(String[] args) {
        int[] arr = { 1, 4, 25, 10, 25 };
        System.out.println(minimalKSum(arr, 2));
    }

    public static long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length && k > 0; i++) {
            int pre = i == 0 ? 0 : nums[i - 1];
            int cur = nums[i];
            long diff = Math.min((long) k, Math.max((long) 0, cur - pre - 1));
            sum += (((pre + 1) + (pre + diff)) * diff) / 2;
            k -= diff;
        }
        int last = nums[n - 1];
        if (k > 0)
            sum += ((long) last + 1 + last + k) * k / 2;
        return sum;
    }

}
