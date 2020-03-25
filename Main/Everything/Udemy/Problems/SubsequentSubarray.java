class SubsequentSubarray {
    
    public int solve(int[] a) {
        
        if (a.length == 1) {
            return a[0];
        }

        int maxCounter = 1;
        int currentCounter = 1;
        int number = a[0];

        for (int i=1; i<a.length; i++) {

            if (a[i] == a[i-1]) {
                currentCounter += 1;
            }

            if(currentCounter > maxCounter) {
                maxCounter = currentCounter;
                number = a[i];
                System.out.println(currentCounter);
            }

            if (a[i] != a[i-1] && currentCounter > 0) {
                currentCounter = 1;
            }
        }
        
        return number;
    }
    public static void main(String[] args) {
        SubsequentSubarray algo = new SubsequentSubarray();
        int a[] = {0, 1, 2, 2, 4, 3, 4, 4, 4, 4, 2, 1, 3, 3};
        System.out.println(algo.solve(a));
    }
}