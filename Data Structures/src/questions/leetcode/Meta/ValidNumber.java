package questions.leetcode.Meta;

public class ValidNumber {
    public boolean isNumber(String s) {
        boolean decimalSeen = false;
        boolean numberSeen = false;
        boolean exponentSeen = false;

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                numberSeen = true;
            } else if (c == '+' || c == '-' ) {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == 'e' || c == 'E') {
                if (exponentSeen || !numberSeen) {
                    return false;
                }
                exponentSeen = true;
                numberSeen = false;
            } else if (c == '.') {
                if (decimalSeen || exponentSeen) {
                    return false;
                }
                decimalSeen = true;
            } else {
                return false;
            }
        }

        return numberSeen;
    }
}
