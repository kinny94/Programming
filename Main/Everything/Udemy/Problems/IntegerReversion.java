class IntegerReversion {
    public static int reverse(int n) {
        
        int reverse = 0;
        int remainder = 0;

        while (n>0) {
            remainder = n % 10;
            n = n / 10;
            reverse = reverse * 10 + remainder;
        }

        return reverse;
    }
}