import java.util.Arrays;
import java.util.HashMap;

public class TwoSum1 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int rest = target - nums[i];
            Integer result = map.get(nums[i]);
            if (result != null){
                return new int[]{result, i};
            }
            map.put(rest, i);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
