package ArrayAndLinkedList;

import org.junit.Test;

import java.util.*;

/**
 * @author ustbwjw
 * @create 2021-07-16 21:32
 */
public class AlgrithomTest {

    @Test
    public void test1(){

        StringDecoder stringDecoder = new StringDecoder();
//        String a="100[leetcode]";
//        String string = stringDecoder.decodeString(a);
//        System.out.println(string);

        ListNode listNode=new ListNode(5);
        ListNode listNode1=new ListNode(6);
        ListNode listNode2=new ListNode(1);
        ListNode listNode3=new ListNode(8);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        ListNode listNode11=new ListNode(4);
        ListNode listNode12=new ListNode(1);
        listNode.next=listNode1;
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;

        listNode11.next=listNode12;
        listNode12.next=listNode3;

        ListNode headA=listNode11;
        ListNode headB=listNode;
        ListNode intersectionNode = stringDecoder.getIntersectionNode(headB, headA);
        System.out.println(intersectionNode.val);


    }

    @Test
    public void test2(){
        StringDecoder stringDecoder = new StringDecoder();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next=listNode1;
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;

        stringDecoder.oddEvenList(listNode);
        ListNode temp=listNode;
        while(temp!=null){
            System.out.println(temp.val);
            temp=temp.next;
        }


    }


    @Test
    public void test3(){
        int[][] arr=new int[][]{{1,5,9}, {10,11,13},{12,13,15}};
        StringDecoder stringDecoder = new StringDecoder();
        int i = stringDecoder.kthSmallest(arr, 8);
        System.out.println(i);


    }

    @Test
    public void test4(){

        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        Integer orDefault = integerIntegerHashMap.getOrDefault(1, 0);
        System.out.println(orDefault);
    }

    @Test
    public void test5(){
        int[] nums = {1, 2, 2, 3, 1};
        CQueue cQueue = new CQueue();
        int shortestSubArray = cQueue.findShortestSubArray(nums);
        System.out.println(shortestSubArray);

    }

    @Test
    public void test6(){
        CQueue cQueue = new CQueue();
        int[][] matrix = new int[][]{{18}, {16}};
        boolean result = cQueue.isToeplitzMatrix(matrix);
        System.out.println(result);
    }

    @Test
    public void test7(){
        CQueue cQueue = new CQueue();
        int[] ints = {0, 1, 2};
        int i = cQueue.arrayNesting(ints);
        System.out.println(i);
    }
}
