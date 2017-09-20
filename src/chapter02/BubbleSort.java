package chapter02;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 8, 9, 4, 1, 5, 4, 7, 2, 4, 1, 3 };

		System.out.println("冒泡排序前：");
		printArray(arr);
		bubbleSort(arr);

		System.out.println("冒泡排序后：");
		printArray(arr);// 跟C一样是同一个数组啊
	}

	private static void bubbleSort(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}
		System.out.println("\n");
	}

}
