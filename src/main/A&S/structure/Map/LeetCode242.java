package Map;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @desc: 242. 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * @author: CuiShiHao
 **/
public class LeetCode242 {
    public static void main(String[] args) {
        boolean result = isAnagram("rat", "car");
        System.out.println(result);
    }

    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap(26);
        // 遍历s插入map中
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer value = map.get(c);
            if (value != null) {
                map.put(c, value + 1);
            } else {
                map.put(c, 1);
            }
        }

        // 遍历t将原有map数据进行减法操作
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer value = map.get(c);
            if (value == null) {
                return false;
            } else {
                if (value == 1) {
                    map.remove(c);
                } else {
                    map.put(c, --value);
                }
            }
        }

        return map.size() == 0;
    }

    public static boolean isAnagram2(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);
    }
}
