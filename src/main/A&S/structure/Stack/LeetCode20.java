package Stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @desc: 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * @author: CuiShiHao
 **/
public class LeetCode20 {
    public static void main(String[] args) {
        String s = "()[";
        boolean res = isValid(s);
        System.out.println(res);
    }

    public static boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Character info = map.get(c);
            if (info == null) {
                stack.add(c);
            } else {
                if ( stack.isEmpty() || !stack.pop().equals(info)) {
                    return false;
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
