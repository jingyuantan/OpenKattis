package FroshWeek;

import java.util.Scanner;

public class FroshWeek {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String firstLine = sc.nextLine();
		String secondLine = sc.nextLine();
		String thirdLine = sc.nextLine();
		
		String[] f = firstLine.split("\\s+");
		String[] s = secondLine.split("\\s+");
		String[] t = thirdLine.split("\\s+");
		
		int noOfTask = Integer.parseInt(f[0]);
		int noOfIntervals = Integer.parseInt(f[1]);
		
		int[] taskTime = new int[noOfTask];
		int[] intervalTime = new int[noOfIntervals];
		
		for(int i=0;i<noOfTask;i++){
			taskTime[i] = Integer.parseInt(s[i]);
		}
		
		for(int i=0;i<noOfIntervals;i++){
			intervalTime[i] = Integer.parseInt(t[i]);
		}
		
		sort(taskTime, 0, taskTime.length-1);
		sort(intervalTime, 0, intervalTime.length-1);
		
		int counter = 0;
		int found = 0;
		for(int i=0;i<noOfIntervals;i++){
			if(counter < noOfTask){
				for(int j=counter;j<noOfTask;j++){
					if(taskTime[j] <= intervalTime[i]){
						counter++;
						found++;
						break;
					}
					else{
						counter++;
					}
				}
			}
			else{
				break;
			}
		}
		
		System.out.println(found);
		sc.close();
	}
	
	static void merge(int arr[], int l, int m, int r)
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
            if (L[i] >= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
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
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    static void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}
