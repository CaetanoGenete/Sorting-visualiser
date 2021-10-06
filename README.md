# Sorting-visualiser

<h2>Descriptions</h2>
Java step-by-step visualisation program, written in 2016, for various sorting methods.

<h2>Sorting methods included</h3>
<ul>
  <li><h3>Quick</h3></li>
  O(nlogn) algorithm based on swivelling values around a pivot.
  
  Recursive implementation:
  ```Java
            
  private static <T extends Comparable<T>> int swivel(T[] list, int min, int max) {
      T pivot = list[min--];
  
      while(true) {
          do {
              min++;
          } while(list[min].compareTo(pivot) < 0);

          do {
              max--;
          } while(list[max].compareTo(pivot) > 0);
  
          if(min >= max) 
              return max;

          T temp = list[min];
          list[min] = list[max];
          list[max] = temp;
      }
  }

  public static <T extends Comparable<T>> void quicksort(T[] list, int min, int max) {
      if(max - min > 1) {
          int pivot = swivel(list, min, max);
          quicksort(list, min, pivot);
          quicksort(list, pivot + 1, max);
      }   
  }
  ```
  
  <li><h3>Merge</h3></li>
  O(nlogn) divide and conquer sorting algorithm
  
  ```Java
  
  @SuppressWarnings("unchecked")
  private static <T> void divide(Comparable<T>[] orig, Comparable<T>[] helper, int min, int max, boolean parity) {
       if(max - min > 1) {
           int mid_point = (min + max)/2;
           divide(helper, orig, min, mid_point, !parity);
           divide(helper, orig, mid_point, max, !parity);
            
           int right = mid_point;
           int insert = min;
           while(min < mid_point && right < max) {
               if(helper[min].compareTo((T) helper[right]) < 0)
                   orig[insert++] = helper[min++];
               else
                   orig[insert++] = helper[right++];
            }
            
            for(int i = min; i < mid_point; i++)
            	   orig[insert++] = helper[i];
            
            for(int i = right; i < max; i++)
            	   orig[insert++] = helper[i];
            
            
        }
        else {
            if(parity)
                orig[min] = helper[min];
            else
                helper[min] = orig[min];
    
        }
    
  }
    
  public static <T extends Comparable<T>> void sort(T[] list, int min, int max) {
      @SuppressWarnings("unchecked")
      Comparable<T>[] helper =  new Comparable[list.length];
        
      divide((Comparable<T>[])list, helper, min, max, false);
  }
  
  ```
  <li><h3>Radix</h3></li>
  O(n) sorting algorithm that trades off space complexity for time, unsuitable for small datasets.
  <li><h3>Bitonic</h3></li>
  O(nlog<sup>2</sup>(n)) highly parallelisable sorting algorithm. 
  <li><h3>Bubble</h3></li>
  O(n<sup>2</sup>) brute force sorting algorithm but with great cache utilisation, suitable for small datasets.

</ul>
