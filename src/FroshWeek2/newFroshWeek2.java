package FroshWeek2;

import java.util.Scanner;

public class newFroshWeek2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int noOfStudent = sc.nextInt();
		int[] students = new int[noOfStudent];
		for(int i=0;i<noOfStudent;i++){
			students[i] = sc.nextInt();
		}
		int min = 0;
		min = sort(students, 0, students.length-1, min);
		System.out.println(min);
		sc.close();
	}
	
	static int merge(int arr[], int l, int m, int r, int min)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        //Create temp arrays
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        //Copy data to temp arrays
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
 
        //Merge
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
            	min += L.length - i;
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        //Copy remaining elements of L[] or R[]
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
        return min;
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    static int sort(int arr[], int l, int r, int min)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            min = sort(arr, l, m, min);
            min = sort(arr , m+1, r, min);
 
            // Merge the sorted halves
            min = merge(arr, l, m, r, min);
        }
		return min;
    }
}
