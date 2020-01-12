package Map;

import java.util.HashMap;

/**
 * @desc: Map
 * @author: CuiShiHao
 **/
public class LeetCode242 {
    public static void main(String[] args) {
        boolean result = isAnagram("rat","car");
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
}
