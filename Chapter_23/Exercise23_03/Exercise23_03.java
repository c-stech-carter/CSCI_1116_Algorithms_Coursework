/*
Author: Charles Carter
Date: 12/18/2024

Description: In this program the following two generic methods are defined using quickSort

public static <E extends Comparable<E>> void quickSort(E[] list)
public static <E> void quickSort(E[] list, Comparator<? super E> comparator)

The first method sorts the elements using the Comparable interface and the second uses the Comparator interface.

In the test program an array of Integer objects is sorted, and then an array of Circle objects is sorted using
a comparator defined in GeometricObjectComparator.
*/


import java.util.Comparator;

public class Exercise23_03 {
    public static void main(String[] args) {
        Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        quickSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }

        System.out.println();
        Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                new Circle(3), new Circle(14), new Circle(12)};
        quickSort(list1, new GeometricObjectComparator());
        for (int i = 0; i < list1.length; i++) {
            System.out.println(list1[i] + " ");
        }
    }

    //Method 1: Quicksort using Comparable
    public static <E extends Comparable<E>> void quickSort(E[] list) {
        quickSort(list, 0, list.length - 1);
    }

    public static <E extends Comparable<E>> void quickSort(E[] list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    private static <E extends Comparable<E>> int partition(E[] list, int low, int high) {
        E pivot = list[low];
        int left = low + 1;
        int right = high;

        while (left <= right) {
            while (left <= right && list[left].compareTo(pivot) <= 0) {
                left++;
            }
            while (left <= right && list[right].compareTo(pivot) > 0) {
                right--;
            }
            if (left < right) {
                swap(list, left, right);
            }
        }

        swap(list, low, right);
        return right;
    }

    //Method 2: Quick sort using Comparator
    public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
        quickSort(list, 0, list.length - 1, comparator);
    }

    private static <E> void quickSort(E[] list, int low, int high, Comparator<? super E> comparator) {
        if (low < high) {
            int pivotIndex = partition(list, low, high, comparator);
            quickSort(list, low, pivotIndex - 1, comparator);
            quickSort(list, pivotIndex + 1, high, comparator);
        }
    }

    private static <E> int partition(E[] list, int low, int high, Comparator<? super E> comparator) {
        E pivot = list[low];
        int left = low + 1;
        int right = high;

        while (left <= right) {
            while (left <= right && comparator.compare(list[left], pivot) <= 0) {
                left++;
            }
            while (left <= right && comparator.compare(list[right], pivot) > 0) {
                right--;
            }
            if (left < right) {
                swap(list, left, right);
            }
        }

        swap(list, low, right);
        return right;
    }


    //Utility to swap elements
    private static <E> void swap(E[] list, int i, int j) {
        E temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
