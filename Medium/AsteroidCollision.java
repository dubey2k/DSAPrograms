package Medium;

import java.util.Arrays;

/*
We are given an array asteroids of integers representing asteroids in a row.
For each asteroid, the absolute value represents its size,
and the sign represents its direction (positive meaning right,
negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions.
If two asteroids meet, the smaller one will explode.
If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

*/

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] arr = { 2, 1 };
        int ar[] = asteroidCollision(arr);
        for (int i : ar) {
            System.out.println(i);
        }
    }

    // actual solution
    public static int[] asteroidCollision(int[] asteroids) {
        int[] s = new int[asteroids.length];
        int top = -1;
        for (int a : asteroids) {
            // Stack only contains asteroids going left or those going right but starting
            // from a more left position => No collision prob.
            if (a > 0)
                s[++top] = a;
            else {
                // Kill all smaller asteroids going right.
                while (top > -1 && s[top] > 0 && s[top] < -a)
                    top--;
                // If nearest asteroid is also going left or there's none, this asteroid can
                // keep moving left without any collision.
                if (top == -1 || s[top] < 0)
                    s[++top] = a;
                // If there's an asteroid going right of the same size, both die.
                else if (s[top] == -a)
                    top--;
            }
        }
        return Arrays.copyOf(s, top + 1);
    }

    // right soln if we don't care where the number is it'll go right (+ve) and left
    // (-ve)
    // public static int[] asteroidCollision(int[] asteroids) {
    // Stack<Integer> res = new Stack<Integer>();
    // for(int i = 0; i < asteroids.length; i++){
    // if(res.empty()){
    // res.push(asteroids[i]);
    // }
    // else if(checkSign(res.peek(),asteroids[i])){
    // res.push(asteroids[i]);
    // }else{
    // while(!res.empty()){
    // Integer val = res.peek();
    // if(Math.abs(val) > Math.abs(asteroids[i]))
    // break;
    // else if(Math.abs(val) == Math.abs(asteroids[i])){
    // res.pop();
    // break;
    // }
    // else{
    // res.pop();
    // res.push(asteroids[i]);
    // }
    // }
    // }
    // }
    // int result[] = new int[res.size()];
    // for(int i = res.size() - 1; i >= 0; i--){
    // result[i] = res.pop();
    // }
    // return result;
    // }
    // public static boolean checkSign(int i, int j){
    // if(i > 0 && j > 0)
    // return true;
    // return false;
    // }
}
