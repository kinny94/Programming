import java.util.*;

class AcquireRequireStacks{

    public static void lockCheck(ArrayList<String> locks){

        Stack<String> locks_stack = new Stack<String>();

        for(int i=0; i<locks.size(); i++){
            String currentElement = locks.get(i);
        }
    }

    public static void main(String args){
        
        ArrayList<String> locks = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            locks.add(scan.nextLine());
        }

        lockCheck(locks);
    }
}