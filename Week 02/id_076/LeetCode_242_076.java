import org.apache.commons.lang3.StringUtils;
import tk.mybatis.mapper.util.Assert;

import java.util.Arrays;

/**
 * @author tangzhenhua
 * @description
 * @date 2019/10/27 20:10
 */
public class LeetCode_242_076 {


    public Boolean isAnagram(String s, String t) {

        if(StringUtils.isEmpty(s) || StringUtils.isEmpty(t)){
            return false;
        }

        if(s.length() != t.length()){
            return false;
        }

        char[] arrays = s.toCharArray();
        char[] arrayt = t.toCharArray();

        Arrays.sort(arrays);
        Arrays.sort(arrayt);

        return compair(arrays, arrayt);
    }

    private Boolean compair(char[] arrays, char[] arrayt) {
        boolean flag = true;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != arrayt[i]) {
                flag = false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        LeetCode_242_076 s = new LeetCode_242_076();
        boolean flag = s.isAnagram("str", "trs");
        Assert.isTrue(flag, "error");
    }
}
