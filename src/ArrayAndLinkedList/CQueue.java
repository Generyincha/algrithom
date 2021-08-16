package ArrayAndLinkedList;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author ustbwjw
 * @create 2021-07-13 22:48
 */
public class CQueue {
    private Stack<Integer> stack,auxStack;

    public CQueue(){
        this.stack=new Stack<>();
        this.auxStack=new Stack<>();
    }

    public void appendTail(int value){
        stack.push(value);
    }

    public int deleteHead(){
        if(auxStack.empty()){
            if (stack.empty()) return -1;
            while (!stack.empty()){
                auxStack.push(stack.pop());
            }
        }

        return auxStack.pop();
    }



    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }

            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个，此时重复元素一定出现在 [1..4] 区间里
            if (cnt > mid) {
                // 重复元素位于区间 [left..mid]
                right = mid;
            } else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面区间 [mid + 1..right]
                left = mid + 1;
            }
        }
        return left;
    }

    public int findShortestSubArray(int[] nums) {

        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<Integer> maxLenList=new ArrayList();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                ArrayList<Integer> orDefault = map.getOrDefault(nums[i], null);
                orDefault.add(i);
                if (orDefault.size()>maxLenList.size())maxLenList=orDefault;
                map.put(nums[i], orDefault);
            }else{
                ArrayList<Integer> list1 = new ArrayList<>();
                list1.add(i);
                if (list1.size()>maxLenList.size())maxLenList=list1;
                map.put(nums[i], list1);
            }
        }
        return maxLenList.get(maxLenList.size()-1)-maxLenList.get(0)+1;
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]!=matrix[i-1][j-1]) return false;
            }
        }
        return true;
    }

    public int arrayNesting(int[] nums) {
        int res=0;
        //boolean[]  isVisited=new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            int temp=i;
            int start=nums[i];
            int count=0;
            if(start!=Integer.MAX_VALUE){
                while(start!=Integer.MAX_VALUE){
                    int temp1=start;
                    start=nums[start];
                    nums[temp]=Integer.MAX_VALUE;
                    temp=temp1;
                    count++;
                }
            }
            res=Math.max(res,count);

        }
        return res;
    }




}
