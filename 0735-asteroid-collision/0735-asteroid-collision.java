class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length-1;

        for( int i=n; i>=0; i-- ){

            int canPush = 1;
            
            while( !stack.isEmpty() && stack.peek() < 0 && asteroids[i] > 0 ){
                if(  asteroids[i] == stack.peek()*-1){
                    canPush = 0;
                    stack.pop();
                    break;
                }else if( asteroids[i] < stack.peek()*-1 )
                {
                    canPush = 0;
                    break; 
                }else{
                    stack.pop();
                }
            }

            if( canPush == 1)
                stack.push(asteroids[i]);
        }

        int result[] = new int[stack.size()];
        for( int i=0; i<result.length; i++ ){
            result[i] = stack.pop();
        }

        return result;
    }
}