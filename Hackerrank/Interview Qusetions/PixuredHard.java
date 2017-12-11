import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.time.Instant;
import java.time.Duration;
import java.lang.Thread;

class PixuredHard{
    
    private static int count;

    public static void createPairs(double[] c, int[] used, int startIndex, int usedCount){
            
		if(usedCount == used.length){

            if(count >= 1000000){
                return;
            }

            if(used[0] >= 0 && used[1] > used[0] && used[1] < c.length){
                if( c[used[0]]*c[used[1]]  >= c[used[0]] + c[used[1]] ){
                    count++;
                    //System.out.println(Arrays.toString(used));
                }
            }

		}else{
			for(int i = startIndex; i < c.length; i++){
				used[usedCount] = i;
				createPairs(c, used, i+1, usedCount+1);
				used[usedCount] = -1;
			}
        }
	}

    public int solution(int[] a, int[] b){


        int number_of_elements = a.length;
        double c[] = new double[number_of_elements];
        int pairLength = 2;
        int used[] = new int[pairLength];
        Arrays.fill(used, -1);
        
        for(int i=0; i<number_of_elements; i++){
            c[i] =  a[i] + ( b[i] / (double) 1000000);
        }

        createPairs(c, used, 0, 0);

        return count;
    }


    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("How any elements?");
        int number_of_elements  = scan.nextInt();

        int a[] = new int[number_of_elements];
        int b[] = new int[number_of_elements];

        System.out.println("Enter elements for Array 1");
        for( int i=0; i<number_of_elements; i++ ){
            a[i] = scan.nextInt();
        }

        System.out.println("Enter elements for Array 2");
        for( int i=0; i<number_of_elements; i++ ){
            b[i] = scan.nextInt();
        }

        PixuredHard obj = new PixuredHard();

        //long startTime = System.nanoTime();
        
        Instant start = Instant.now();
        System.out.println(obj.solution(a, b));
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));
        //System.out.println(totalTime);
    }
}