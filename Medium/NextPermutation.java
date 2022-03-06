package Medium;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 4, 2 };
        nextPermutation(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void nextPermutation(int[] nums) {
        int idx = -1;
        // step 1 -> find a[i] > a[i - 1] (find incline)
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                idx = i;
                break;
            }
        }
        // if array is in decending order
        if (idx == -1)
            reverseArray(nums, 0, nums.length - 1);
        else {
            int nearest = idx;
            // next nearest number to origin to inclined index [idx - 1]
            for (int i = idx; i < nums.length; i++) {
                if (nums[i] > nums[idx - 1] && nums[i] < nums[idx])
                    nearest = i;
            }
            // swap them
            int temp = nums[idx - 1];
            nums[idx - 1] = nums[nearest];
            nums[nearest] = temp;
            // reverse array from idx -> last
            reverseArray(nums, idx, nums.length - 1);
        }
    }

    public static void reverseArray(int[] nums, int i, int j) {
        for (; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}