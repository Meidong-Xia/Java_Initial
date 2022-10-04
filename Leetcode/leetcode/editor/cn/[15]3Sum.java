/**
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 

 Notice that the solution set must not contain duplicate triplets. 

 
 Example 1: 
 Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
 Example 2: 
 Input: nums = []
Output: []
 Example 3: 
 Input: nums = [0]
Output: []
 
 
 Constraints: 

 
 0 <= nums.length <= 3000 
 -10⁵ <= nums[i] <= 10⁵ 
 
 Related Topics 数组 双指针 排序 👍 4163 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = nums.length;
        if(n<3) return ans;
        // 将a+b+c=0 改成 a+b = -c
        // 对b进行遍历，每次c的取值只多了一个b
        // 为了满足互不相同的条件，首先要对数组进行排序
        Arrays.sort(nums);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
