package testPackage;

import StringMut.StringManipulate;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ustbwjw
 * @create 2021-08-11 23:21
 */
public class StringTest {
    @Test
    public void test1(){
        StringManipulate isContainInCycle = new StringManipulate();
        String s1 = "AABCDEF";
        String s2 = "CDEFA";
        System.out.println(isContainInCycle.isContain(s1, s2));
    }
    @Test
    public void test2(){
        StringManipulate stringManipulate = new StringManipulate();
        String a = "aaaaa";
        System.out.println(stringManipulate.countSubstrings(a));


    }
}
