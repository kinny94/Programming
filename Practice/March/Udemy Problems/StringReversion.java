class StringReversion {

    public String reverseString(String s) {
        int lengthOfText = s.length();
        StringBuilder reversedString = new StringBuilder();

        for (int i=lengthOfText-1; i>=0; i--) {
            reversedString.append(s.charAt(i));
        }

        return reversedString.toString();
    }

    public static void main(String[] args) {
        StringReversion rv = new StringReversion();
        System.out.println(rv.reverseString("hello"));
    }
}