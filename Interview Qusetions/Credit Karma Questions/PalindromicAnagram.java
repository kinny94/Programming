class PalindromicAnagram{
      
    static final int No_of_chars = 256;

    static boolean canFormPalindrome( String str ){
        int[] count = new int[ No_of_chars ];
        for( int i=0; i<str.length(); i++ ){
            System.out.println( count[ str.charAt(i)]++ );
            count[ str.charAt(i)]++;
        }

        int odd = 0;
        for( int i=0;i<No_of_chars; i++ ){
            if(( count[i] & 1 ) != 0 ){
                odd++;
            }

            if( odd > 1 ){
                return false;
            }
        }

        return true;
    }
    public static void main(String args[])
    {
        System.out.println(canFormPalindrome("geeksforgeeks")
                               ? "Yes"
                               : "No");
        System.out.println(canFormPalindrome("geeksogeeks")
                               ? "Yes"
                               : "No");
    }
}