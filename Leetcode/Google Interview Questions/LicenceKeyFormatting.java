import java.util.*;

import javax.naming.InitialContext;

class LicenceKeyFormatting{

    public String licenseKeyFormatting(String S, int K) {
        char[] str = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = str.length-1; i >= 0; ) {
            int j = i, count = 0;
            while (j >= 0 && count < K) {
                if (str[j] >= 'a' && str[j] <= 'z') {
                    sb.append((char)((str[j]-'a')+'A'));
                    count++;
                } else if (str[j] != '-') {
                    sb.append(str[j]);
                    count++;
                }
                j--;
            }
            sb.append('-');
            i = j;
        }
        int length = sb.length()-1;
        while (length >= 0 && sb.charAt(length) == '-') {
            length--;
        }
        sb.setLength(1+length);
        sb.reverse();
        return sb.toString();
    }
 
    public static void main(String[] args) {
        LicenceKeyFormatting obj = new LicenceKeyFormatting();
        System.out.println( obj.licenseKeyFormatting("2-4A0r7-4k", 3));
    }
}