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
  
  ```Java
  
  final static int INT_SIZE = 4;
	
  final static byte BYTE_BIT_COUNT = 8;
  final static short DIGITS_COUNT = 1 << BYTE_BIT_COUNT;
  
  private static int get_digit(int[] array, int index, int divisor) {
	  final short BYTE_MASK = 0xFF;
		
	  return (array[index] >> divisor) & BYTE_MASK;
  }
	
  public static void radix_sort(int[] array) {
	  int[] result = new int[array.length];
	  int[] counts = new int[DIGITS_COUNT];
		
	  int divisor = 0;
      for(int radix = 0; radix < INT_SIZE; radix++) {
          for(short i = 0; i < counts.length; i++)
              counts[i] = 0;
			
          for(int i = 0; i < array.length; i++)
              counts[get_digit(array, i, divisor)]++;
			
          for(short i = 0; i < counts.length - 1; i++)
              counts[i + 1] += counts[i];
			
          for(int i = array.length - 1; i >= 0; i--)
              result[counts[get_digit(array, i, divisor)]-- - 1] = array[i];
			
          int[] temp = array;
          array = result;
          result = temp;
			
          divisor += BYTE_BIT_COUNT;
      }
  }
  ```
  
  <li><h3>Bitonic</h3></li>
  O(nlog<sup>2</sup>(n)) highly parallelisable sorting algorithm. 
  <li><h3>Bubble</h3></li>
  O(n<sup>2</sup>) brute force sorting algorithm but with great cache utilisation, suitable for small datasets.
  
  ```Java
  public static <T extends Comparable<T>> void bubble_sort(T[] array, int min, int end) {
      for(int i = min; i < end; i++) {
          boolean sorted = true;
          for(int j = min; j < end - i - 1; j++) {
              if(array[j].compareTo(array[j + 1]) > 0) {
                  sorted = false;
					
                  T temp = array[j];
                  array[j] = array[j + 1];
                  array[j + 1] = temp;
              }
          }
			
          if(sorted) return;
      }
  }
  
  ```

</ul>
