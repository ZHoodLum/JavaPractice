package arithmetic.easy;

/**
 * @author：ZDY
 * @Date：Created in 20210330
 * @Description:解题思路 通过观察和思考可得到：
 * <p>
 * 1.最终答案中，第1个值不用变，第n个值是参数中数组第1到第n个值的和
 * 2.不用新开一个数组，直接在原数组中操作即可
 * 3.只用一次遍历，要得到第n个值，只需要用第n-1个值加上第n个值即可
 */
public class RunningSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        runningSum(nums);
    }

    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
