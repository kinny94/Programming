package questions.leetcode;

class FindTheKthLuckyNumber {
    public String kthLuckyNumber(int k) {
        k = k + 1;

        String binary = Integer.toBinaryString(k);
        String result = binary.substring(1);

        result = result.replace('0', '4').replace('1', '7');

        return result;
    }
}