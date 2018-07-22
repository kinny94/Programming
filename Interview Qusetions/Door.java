import java.util.Scanner;

class Door{

    private static boolean locked = true;
    private static boolean unlocked = false;

    private static boolean state1  = false;
    private static boolean state2 = false;
    private static boolean state3= false;


    private static String key = "123";

    public static boolean checkKey( String userKey ){

        if( userKey.length() == key.length() ){
            if( userKey.charAt(0) == key.charAt( 0 )){
                state1 = true;
            }else{

                return false;
            }

            if( state1 = true ){
                if( userKey.charAt( 1 ) == key.charAt( 1 )){
                    state2 = true;
                }else{
                    return false;
                }
            }

            if( state1 && state2 ){
                if( userKey.charAt( 2 ) == key.charAt( 2 )){
                    state3 = true;
                }else{
                    return false;
                }
            }

            if( state1 && state2 && state3 ){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner( System.in );
        System.out.println( "Enter your key: ");
        String userKey = scan.nextLine();
        if( checkKey( userKey )){
            System.out.println(" Door is unlocked! ");
        }else{
            System.out.println( "Invalid Key" );
            System.out.println(" Door is Locked! ");
        }  
    }
}