
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        // Stack will store pairs of {temperature, index}
        Stack<int[]> stack = new Stack<>();
        
        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            
            // Your exact monotonic stack logic!
            // If today is warmer than the day at the top of the stack, 
            // pop it and calculate the waiting days.
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop();
                // res[past_index] = current_index - past_index
                res[pair[1]] = i - pair[1]; 
            }
            
            // Push today's temperature and index onto the stack to wait for a warmer day
            stack.push(new int[]{t, i});
        }
        
        return res;
    }
}