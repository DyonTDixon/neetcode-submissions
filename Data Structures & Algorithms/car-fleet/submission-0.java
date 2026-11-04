class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        // Create a 2D array to pair each car's position with its speed
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        
        // Sort the cars by position in descending order (closest to target first)
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
        
        Stack<Double> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            // Calculate time: (target - position) / speed
            // We cast to double for accurate division (e.g., 9 / 2 = 4.5)
            double currentTime = (double) (target - cars[i][0]) / cars[i][1];
            
            // Push the current car's time onto the stack
            stack.push(currentTime);
            
            // If this car's time is <= the car ahead of it, it caught up!
            // Pop it off because it merges into the fleet ahead.
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }
        
        // The number of distinct times left in the stack is the number of fleets
        return stack.size();
    }
}