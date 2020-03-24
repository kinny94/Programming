class DuplicatesInArray {

    // using hashmap is also O(N) but not in place
    public void solve(int[] array) {
        for (int i=0; i<array.length; i++) {
            if (array[Math.abs(array[i])] > 0) {
                array[Math.abs(array[i])] = -array[Math.abs(array[i])];
            } else {
                System.out.println(Math.abs(array[i]) + " is a repetition..");
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 2, 4, 3};
        DuplicatesInArray da = new DuplicatesInArray();
        da.solve(a);
    }
}