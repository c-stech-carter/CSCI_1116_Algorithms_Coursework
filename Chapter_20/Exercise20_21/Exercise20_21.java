/*
Author: Charles Carter
Date: 12/4/2024

Description: This is a test program that uses the generic method selectionSort to sort shapes
regardless of type using comparator, the comparator GeometricObjectComparator was provided by the assignment.

In the program it sorts an array of combined Circles and Rectangles, and
is invoked again to sort an array of Circles.


(All other classes bundled with this assignment were provided by the textbook Intro to Java)
*/

import java.util.Comparator;

public class Exercise20_21 {
    public static void main(String[] args) {
        GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
                new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
                new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
                new Circle(6.5), new Rectangle(4, 5)};

        Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                new Circle(3), new Circle(14), new Circle(12)};


        System.out.println("First list: 'list' of various shapes:");
        selectionSort(list, new GeometricObjectComparator());
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].getArea() + " ");
        }


        System.out.println("Second list: 'list' of Circles:");
        selectionSort(list1, new GeometricObjectComparator());
        for (int i = 0; i < list1.length; i++)
            System.out.println(list1[i].getArea() + " ");

        System.out.println();


    }


    //selectionSort Method
    public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
      for (int i = 0; i < list.length - 1; i++) {
        int minIndex = i;

        //Find the minimum element
        for (int j = i + 1; j < list.length; j++) {
          if (comparator.compare(list[j], list[minIndex]) < 0) {
            minIndex = j;
          }
        }
        //Swap minimum element with first element of the array
        if (minIndex != i) {
          E temp = list[minIndex];
          list[minIndex] = list[i];
          list[i] = temp;
        }
      }
    }
}

