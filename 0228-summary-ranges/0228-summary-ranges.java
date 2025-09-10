class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list=new ArrayList<String>(); 
        if(nums.length == 0)
        {
            return list;
        }
        int current = nums[0];
         List<Integer> numbers =new ArrayList<Integer>(); 
         String result;
        for(int i = 0 ; i < nums.length ; i++)
        {
            
            if(current == nums[i])
            {
                
                numbers.add(current);
                if(i == nums.length -1 && !numbers.isEmpty())
                {
                    if(numbers.size() == 1)
                    {
                        result = String.valueOf(numbers.get(0));
                        list.add(result);
                    }else 
                    {
                        int start = numbers.get(0);
                        int end = numbers.get(numbers.size()-1);
                        result = String.valueOf(start)+"->"+String.valueOf(end); 
                        numbers.clear();
                       list.add(result);
                       break;
                    }
                   
                }
                current++;
            }else
            {
               if(numbers.size() == 1)
               {
                result = String.valueOf(numbers.get(0));
                list.add(result);
                numbers.clear();
                current = nums[i];
                numbers.add(current);
                current++;
               }else
               {
                 int start = numbers.get(0);
                int end = numbers.get(numbers.size()-1);
                result = String.valueOf(start)+"->"+String.valueOf(end);
                numbers.clear();
                list.add(result);
                current = nums[i];
                numbers.add(current);
                current++;
               }

                if(i == nums.length -1 && numbers.size() == 1)
                {
                     result = String.valueOf(numbers.get(0));
                    list.add(result);
                }

                


            }
        }

        return list;

    }
}