class GreatestCommonDivisor {

    public int gcdInteration(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }    

        return num1;
    }
    
    public int gcdRecursion(int num1, int num2) {
        if (num2 == 0) return num1;
        return gcdRecursion(num1, num1 % num2);  
    }
    public static void main(String[] args) {
        GreatestCommonDivisor gcd = new GreatestCommonDivisor();
        System.out.println(gcd.gcdInteration(2, 6));
        System.out.println(gcd.gcdRecursion(2, 6));
    }
}