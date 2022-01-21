
public class FirstMissingPositiveNumber{
    public static void main(String[] args){
        int[] arr = {3,4,-1,1};
		System.out.println(firstMissingPositive(arr));
    }
    public static int firstMissingPositive(int[] nums) {
        boolean isFirst = false;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] == 1)
                isFirst = true;
            else if(nums[i] > n || nums[i] <= 0){
                nums[i] = 1;
            }
        }
        for(int i = 0; i < n; i++){
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        if(!isFirst)
            return 1;
        for(int i = 0; i < n; i++){
            if(nums[i] > 0)
                return i + 1;
        }
        return n + 1;
    }
}