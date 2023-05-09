package test;

import java.util.*;

public class Q22_OpenParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        findCombination(result, 0, n, "");

        return result;
    }

    public void findCombination(List<String> result, int count, int remaining, String s) {
        if (count == 0 && remaining == 0) {
            result.add(s);
        } else {
            if (remaining > 0) {
                findCombination(result, count + 1, remaining - 1, s + "(");
            }
            if (count > 0) {
                findCombination(result, count - 1, remaining, s + ")");
            }
        }

    }

    // With String Builder
    public List<String> generateParenthesis1(int n) {
        List<String> result = new ArrayList<String>();
        findCombination1(result, 0, n, new StringBuilder());

        return result;
    }

    public void findCombination1(List<String> result, int count, int remaining, StringBuilder sb) {
        if (count == 0 && remaining == 0) {
            result.add(sb.toString());
        } else {
            if (remaining > 0) {
                sb.append("(");
                findCombination1(result, count + 1, remaining - 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (count > 0) {
                sb.append(")");
                findCombination1(result, count - 1, remaining, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }

    public static void main(String[] args) {

    }
}
