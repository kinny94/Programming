import jdk.nashorn.internal.ir.BreakableNode;
import java.util.*;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

class ValidParenthisis{

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for( int i=0; i<s.length(); i++){
            char x = s.charAt(i);

            switch(x){
                case ')':
                    if(!stack.isEmpty()){
                        if( stack.peek() == '('){
                            stack.pop();
                        }else{  
                            return false;
                        } 
                    }else{
                        return false;
                    }
                    break;

                case '}':
                    if(!stack.isEmpty()){
                        if( stack.peek() == '{'){
                            stack.pop();
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                    
                    break;

                case ']':
                    if( !stack.isEmpty()){
                        if( stack.peek() == '['){
                            stack.pop();
                        }else{
                            return false;
                        }
                        break;
                    }else{
                        return false;
                    }
                    
                default:
                    stack.push(x);
                    break;
            }
        }

        if( stack.empty() ){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        ValidParenthisis obj = new ValidParenthisis();
        System.out.println(obj.isValid("]"));
    }
}
