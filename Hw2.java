import java.util.Arrays;

/**
  This code demonstrates a 3-ary heap sort
  @author Mark Santiago
 */
public class Hw2 
{
	private static int heapSize; //the size of the heap
	private static int largest; //the biggest value
	
	public static void main (String args[])
	{
		int[] data = new int[args.length];
		for (int i = 0; i < args.length; i++)
		{
			int element = Integer.parseInt(args[i]);
			data[i] = element;
		}
		heapSort(data);
		
		System.out.print("Final Sorted: ");
		for (int i = 0; i < data.length; i++)
		{
			System.out.print(data[i] + " ");
		}
	}
	
	/**
	  Arranges nodes and its subtrees to satisfy heap property.
	  @param data the array to sort
	  @param index the current value being used
	 */
	public static void maxHeapify(int[] data, int index)
	{
		int left = getLeftChildIndex(index); //value of the left child
		int right = getRightChildIndex(index); //value of the right child
		int middle = getMiddleChildIndex(index); //value of the middle child

		if (left <= heapSize && data[left] > data[index])
		{
			largest = left;
		}
		else
		{
			largest = index;
		}
		if (middle <= heapSize && data[middle] > data[largest])
		{
			largest = middle;
		}
		if (right <= heapSize && data[right] > data[largest])
		{
			largest = right;
		}
		if (largest != index)
		{
			int temp = data[index];
			data[index] = data[largest];
			data[largest] = temp;
			maxHeapify(data, largest);
		}
	}
	
	/**
	  Creates a new heap.
	  @param data the array being converted into a heap
	 */
	public static void buildMaxHeap (int[] data)
	{
		heapSize = data.length - 1;
		for (int i = heapSize / 3; i >= 0; i--)
		{
			maxHeapify(data, i);
		}
		
		System.out.print("After Build Heap: ");
		for (int i = 0; i < data.length; i++)
		{
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
	
	/**
	  Sorts an array.
	  @param data the array to sort
	 */
	public static void heapSort(int[] data)
	{
		buildMaxHeap(data);
		for (int i = heapSize; i > 0; i--)
		{
			int temp = data[0];
			data[0] = data[i];
			data[i] = temp;
			heapSize = heapSize - 1;
			maxHeapify(data, 0);
		}
	}
		
	/**
	  Returns the index of the parent.
	  @param index the index of a node in this heap
	  @return the value of the parent of the given node
	 */
	private static int getParentIndex(int index)
	{
		return index / 3;
	}
	
	/**
	  Return the index of the left child.
	  @param index the index of a node in this heap
	  @return the value of the left child of the given node
	 */
	private static int getLeftChildIndex(int index)
	{
		return 3 * index;
	}
	
	/**
	  Return the index of the middle child.
	  @param index the index of a node in this heap
	  @return the value of the middle child of the given node
	 */
	private static int getMiddleChildIndex(int index)
	{
		return 3 * index + 1;
	}
	
	/**
	  Return the index of the right child.
	  @param index the index of a node in this heap
	  @return the value of the right child of the given node
	 */
	private static int getRightChildIndex(int index)
	{
		return 3 * index + 2;
	}
}
