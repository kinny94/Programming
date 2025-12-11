package Problems.Leetcode;

public class SubstringMatchingPattern {
    public boolean hasMatch(String s, String p) {
        int index = p.indexOf('*');
        int prefixPos = s.indexOf(p.substring(0, index));
        int suffixPos = s.indexOf(p.substring(index + 1), prefixPos + index);
        if (prefixPos != -1 && suffixPos != -1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SubstringMatchingPattern smp = new SubstringMatchingPattern();
        System.out.println(smp.hasMatch("This is a text", "text"));
        System.out.println(smp.hasMatch("This is a text", "text*"));
        System.out.println(smp.hasMatch("This is a text", "text*text"));
        System.out.println(smp.hasMatch("This is a text", "text*text*"));
    }
}
