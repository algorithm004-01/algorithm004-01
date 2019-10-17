/**
 * 在这里给出对类 Leetcode_42_436 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*; 
public class Leetcode_42_436
{
    public int trap(int[] height){
        int n = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        int index = 0;
        while(index < n){
            while(!stack.isEmpty() && height[index] > height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty()) break;
                int h = Math.min(height[stack.peek()], height[index]) - height[top];
                int dist = index - stack.peek() - 1;
                result += dist * h;
            }
            stack.push(index);
            index++;
    }
    return result;
  }
}
