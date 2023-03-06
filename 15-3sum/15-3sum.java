class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++){
            if(i!=0 && nums[i] == nums[i-1])
                continue;
            
            int left = i+1, right = nums.length-1;
            
            while(left < right){
                int sum = nums[i]+nums[left]+nums[right];
                
                if(sum == 0){
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[left]);
                    cur.add(nums[right]);
                    ans.add(cur);
                    // ans.add(Arrays.asList(new int[]{nums[i], nums[left], nums[right]}));
                    left++;
                    right--;
                    while(left < right && nums[left]==nums[left-1]){
                        left++;
                    }
                    while(left < right && nums[right]==nums[right+1]){
                        right--;
                    }
                }
                else if(sum >0)
                    right--;
                else
                    left++;
            }
        }
        return ans;
    }
}