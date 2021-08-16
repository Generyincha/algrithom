package ArrayAndLinkedList;

/**
 * @author ustbwjw
 * @create 2021-07-16 22:14
 */
public class StringDecoder {

    public String decodeString(String s) {
        String[] rescue = rescue(s, 0);
        return rescue[0];

    }

    public String[] rescue(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while (i < s.length()) {
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0')
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            else if (s.charAt(i) == '[') {
                String[] rescue = rescue(s, i + 1);
                i = Integer.parseInt(rescue[0]);

                while (multi > 0) {
                    res.append(rescue[1]);
                    multi--;
                }

            } else if (s.charAt(i) == ']') {
                return new String[]{String.valueOf(i), res.toString()};
            } else res.append(s.charAt(i));
            i++;
        }
        return new String[]{res.toString()};
    }

    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int current = T[i];
            if (current < 100) {
                for (int j = i + 1; j < length; j++) {
                    if (T[j] > current) {
                        result[i] = j - i;
                        break;
                    }
                }
            }
        }
        return result;
    }




    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {


        if(headA.next==null||headB.next==null){
            return null;
        }
        ListNode pa=headA;
        ListNode pb=headB;
        while(pa!=pb){
            pa= (pa==null?headB:pa.next);
            pb=(pb==null?headA:pb.next);


        }
        return pa;

    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode p1=head;
        ListNode p2=head.next;
        while(p2!=null&&p1.next!=null){
            if(p1.val!=p2.val){
                p1=p1.next;
                p2=p2.next;
            }else{
                while(p2!=null&&p1.val==p2.val){
                    if(p2.next==null){
                        p1.next=null;
                        return head;
                    }else{
                        p1.next=p2.next;
                        p2=p2.next;


                    }
                }

            }
        }
        return head;
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }

        int width = N / k, rem = N % k;

        ListNode[] ans = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = new ListNode(0), write = head;
            for (int j = 0; j < width + (i < rem ? 1 : 0); ++j) {
                write = write.next = new ListNode(cur.val);
                if (cur != null) cur = cur.next;
            }
            ans[i] = head.next;
        }
        return ans;
    }

    public ListNode oddEvenList(ListNode head) {
        if(head==null) return null;
        ListNode evenHead=head.next,oddHead=head,even=head.next,odd=head;
        while(even!=null&&even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return oddHead;
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m=mat.length;
        int n=mat[0].length;
        int x=m*n;
        if(x==r*c){
            int[][] ans=new int[r][c];
            for(int i=0;i<x;i++){
                ans[i/c][i%c]=mat[i/n][i%n];
            }
            return ans;
        }
        return mat;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int minCount=Math.min(matrix.length,matrix[0].length);
        for(int i=0;i<minCount;i++){
            boolean inRaw=binarySerch(matrix,i,false,target);
            boolean inCow=binarySerch(matrix,i,true,target);
            if(inRaw||inCow) return true;
        }
        return false;
    }


    public boolean binarySerch(int[][] matrix,int start,boolean vertical, int target){
        int lo=start;
        int hi=(vertical?matrix.length:matrix[0].length);
        int mid=0;
        while(lo<hi){
            mid=(lo+hi)/2;
            if(vertical){
                if(target>matrix[mid][start]){
                    lo=mid+1;
                }else if(target==matrix[mid][start]){
                    return true;
                }else{
                    hi=hi-1;
                }
            }else{
                if(target>matrix[start][mid]){
                    lo=mid+1;
                }else if(target==matrix[start][mid]){
                    return true;
                }else{
                    hi=hi-1;
                }

            }
        }
        return false;
    }

    public int kthSmallest(int[][] matrix, int k) {
        int count=0;
        int left=matrix[0][0];
        int row=matrix.length-1;
        int col=matrix[0].length-1;
        int right=matrix[row][col];
        while(left<right){

            int mid=(left+right)/2;

            count =findBiggerThanMid(row,col,mid,matrix);
            if(count<k){
                left=mid+1;
            }else {
                right=mid;

            }

        }
        return right;
    }

    public int findBiggerThanMid(int row,int col,int mid,int[][] matrix){
        int i=row;
        int j=0;
        int count=0;
        while(i>=0&&j<=col){
            if(matrix[i][j]<=mid){
                count+=i+1;
                j++;
            }else{
                i--;
            }
        }

        return count;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
