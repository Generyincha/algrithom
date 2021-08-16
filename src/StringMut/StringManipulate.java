package StringMut;

import com.sun.deploy.util.StringUtils;

/**
 * @author ustbwjw
 * @create 2021-08-11 23:17
 */
public class StringManipulate {
    public boolean isContain(String s1,String s2){
        String a=s1+s1;
        boolean contains = a.contains(s2);
        if (contains==true) return true;
        else return false;
    }

    public String cyclicShift(String s,int k){
        int frontLen=k%(s.length());
        return s.substring(s.length() - frontLen, s.length()) + s.substring(0, s.length() - frontLen);

    }
    public int countSubstrings(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        int ans=0;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                if(s.charAt(j) == s.charAt(i) && (i - j < 2 || dp[j+1][i - 1])){
                    dp[j][i]=true;
                    ans++;
                }
            }
        }
        return ans;
    }
//    public int countSubstrings(String s) {
//        // 动态规划法
//        boolean[][] dp = new boolean[s.length()][s.length()];
//        int ans = 0;
//
//        for (int j = 0; j < s.length(); j++) {
//            for (int i = 0; i <= j; i++) {
//                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
//                    dp[i][j] = true;
//                    ans++;
//                }
//            }
//        }
//
//        return ans;
//    }

}
