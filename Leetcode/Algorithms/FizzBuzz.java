class Solution {
    public List<String> fizzBuzz(int n) {
       List<String> letters = new ArrayList<String>();
        
        for(int i=1; i<=n; i++){
            if(i%3 == 0 && i%5 != 0){
                letters.add("Fizz");
            }
            else if(i%5 == 0 && i%3 != 0){
                letters.add("Buzz");
            }
            else if((i%3 == 0) && (i%5 == 0)){
                letters.add("FizzBuzz");
            }else{
                letters.add(String.valueOf(i));
            }
        }
        
        return letters;
    }
}