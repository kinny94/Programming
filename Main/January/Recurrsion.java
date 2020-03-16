class Recurrsion {
    public static void main(String[] args) {
        Recurrsion recurrsionTool = new Recurrsion();
        System.out.println(recurrsionTool.getTriangularNumber(6));
        System.out.println(recurrsionTool.getFactorial(6));
    }

    public int getTriangularNumber(int number) {
        if (number == 1) { 
            return 1;
        } else {
            int result = number + getTriangularNumber(number - 1);
            return result;
        }
    }

    public int getFactorial(int number) {
        if (number == 1) {
            return 1;
        } else {
            int result = number * getFactorial(number - 1);
            return result;
        }
    }
}