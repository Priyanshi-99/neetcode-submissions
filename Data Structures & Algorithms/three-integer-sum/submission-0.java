class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Since the array is sorted, no later triplet can sum to 0
            if (nums[i] > 0) {
                break;
            }

            // Avoid using the same first value more than once
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    // Need a larger sum
                    left++;
                } else if (sum > 0) {
                    // Need a smaller sum
                    right--;
                } else {
                    result.add(Arrays.asList(
                        nums[i],
                        nums[left],
                        nums[right]
                    ));

                    left++;
                    right--;

                    // Skip duplicate second values
                    while (left < right &&
                           nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }

        return result;

        
    }
}
