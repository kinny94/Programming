import java.util.*;

class PalindromeOrNot{

    //NITIN
    //TINNIT
    public static boolean IsPalindromeOrNot( String s ){

        int n = s.length() / 2;
        for( int i=0; i<n; i++ ){
            if( !String.valueOf( s.charAt(i )).equals( String.valueOf( s.charAt( (s.length() - 1) - i  )))){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner( System.in );
        String s = scan.nextLine();
        System.out.println( IsPalindromeOrNot( s ) );
    }
}