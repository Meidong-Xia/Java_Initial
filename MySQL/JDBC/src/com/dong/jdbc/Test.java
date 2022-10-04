package com.dong.jdbc;

/**
 * @author MeidongXia
 * @date 2022/3/1 20:44
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};

        search(nums,0);


    }
    public static int search(int[] nums, int target) {
        // 二分之后，每次依据正确顺序的地方判断

        int head = 0;
        int tail = nums.length - 1;

        while (head < tail) {

            int mid = (tail + head) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[0]) { // head,mid有序
                if (nums[head] <= target && target <= nums[mid]) {
                    tail = mid - 1;
                } else {
                    head = mid + 1;
                }
            } else { // mid,tail有序，因为必定有一个区间有序
                if (nums[mid] <= target && target <= nums[tail]) {
                    head = mid + 1;
                } else {
                    tail = mid - 1;
                }
            }


        }

        return -1;
    }
    }
