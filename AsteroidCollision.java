import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args){
        int[] arr = {2,1};
		int ar[] = asteroidCollision(arr);
        for(int i : ar){
            System.out.println(i);
        }
    }
    //right soln if we don't care where the number is it'll go right (+ve) and left (-ve)
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> res = new Stack<Integer>();
        for(int i = 0; i < asteroids.length; i++){
            if(res.empty()){
                res.push(asteroids[i]);
            }
            else if(checkSign(res.peek(),asteroids[i])){
                res.push(asteroids[i]);
            }else{
                while(!res.empty()){
                    Integer val = res.peek();
                    if(Math.abs(val) > Math.abs(asteroids[i]))
                        break;
                    else if(Math.abs(val) == Math.abs(asteroids[i])){
                        res.pop();
                        break;
                    }
                    else{
                        res.pop();
                        res.push(asteroids[i]);
                    }
                }
            }
        }
        int result[] = new int[res.size()];
        for(int i = res.size() - 1; i >= 0; i--){
            result[i] = res.pop();
        }
        return result;
    }
    public static boolean checkSign(int i, int j){
        if(i > 0 && j > 0)
            return true;
        return false;
    }
}
