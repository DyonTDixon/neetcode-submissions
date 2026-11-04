
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            // Check if the token is one of our four operators
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("-")) {
                // Order matters! The first popped value is the right operand.
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left - right);
            } else if (token.equals("/")) {
                // Order matters here too!
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left / right);
            } else {
                // If it's not an operator, it must be a number. 
                // Parse it and push it onto the stack.
                stack.push(Integer.parseInt(token));
            }
        }
        
        // The final result is the only item remaining in the stack
        return stack.pop();
    }
}