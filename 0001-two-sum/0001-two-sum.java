class Solution {
    public int[] twoSum(int[] nums, int target) {
        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++) {
        //         if(nums[i] + nums[j] == target)
        //             return new int[] {i ,j};

                    
        //         }
        //     }
        //     return new int [] {};


        Map<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0;i<nums.length;i++){
            int currsum = nums[i];
            int num= target - nums[i];

            if(hm.containsKey(num)){
                return new int[]{ 
                    hm.get(num),i};
            
                
            }else{
                hm.put(currsum,i);
            }
          
        }return new int[] {};
        }
    }
                    
        

        
    
