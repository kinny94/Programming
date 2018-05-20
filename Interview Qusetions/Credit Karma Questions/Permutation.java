import java.util.*;

class Permutation{
    
    public void swap( int[] arr, int i, int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void permute( int[] arr, int i ){
        if( i == arr.length ){
            System.out.println(Arrays.toString(arr));
	        return;
        }

        for( int j=i; j<arr.length; j++ ){
            swap( arr, i, j );  // enumerates on index i
            permute( arr, i + 1 );  // recurse call
            swap( arr, i, j );  // backtracking
        }
    }
    
    public static void main(String[] args) {
        Permutation permutations = new Permutation();
		int[] arr = {1, 2, 3,4};
		permutations.permute(arr, 0);
    }
}