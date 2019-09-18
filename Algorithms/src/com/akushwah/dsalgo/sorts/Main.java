package com.akushwah.dsalgo.sorts;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int arr[] = new int[7];
        arr[0] = 20;
        arr[1] = 35;
        arr[2] = -15;
        arr[3] = 7;
        arr[4] = 55;
        arr[5] = 1;
        arr[6] = -22;

//        bubbleSort(arr);
//        selectionSort(arr);
//        insertionSort1(arr);
        insertionSort2(arr);
//        shellSort(arr);
//        insertionSortRecursive(arr);
    }



    public static void shellSort(int arr[]){
        int len = arr.length;
        for(int gap = len/2;gap>0;gap/=2){
            for (int i = gap; i < len; i++) {
                int newEle = arr[i];
                int j=i;
                while(j>= gap && arr[j-gap] >newEle){
                    arr[j] = arr[j-gap];
                    j -= gap;
                }
                arr[j] = newEle;
                Utils.printArray(arr);
            }
            System.out.println("*******");
            Utils.printArray(arr);
        }
        Utils.printArray(arr);
    }

    public static void insertionSort1(int arr[]){
        int len = arr.length;
        for (int i = 1; i <len ; i++) {
            for (int j = i; j >0 ; j--) {
                if(arr[j] > arr[j-1]){
                    break;
                }
                Utils.swap(arr,j,j-1);
            }
        }
        Utils.printArray(arr);
    }

    public static void insertionSort2(int arr[]){
        int len = arr.length;
        for (int i = 1; i <len ; i++) {
            int newEle = arr[i];
            int j;
            int k = 0;
            for (j = i; j >0 && arr[j-1] > newEle ; j--) {
                arr[j] = arr[j-1];
                System.out.println(++k);
            }
            arr[j] = newEle;
            Utils.printArray(arr);
        }
        Utils.printArray(arr);
    }

    public static void insertionSortRecur1(int arr[], int itemCount){
        if(itemCount < 2){
            return;
        }
        insertionSortRecur1(arr, itemCount-1);
        int newEle = arr[itemCount-1];
        int j;
        for (j = itemCount-1; j >0 && arr[j-1] > newEle ; j--) {
            arr[j] = arr[j-1];
        }
        arr[j] = newEle;
    }

    public static void insertionSortRecursive(int arr[]){
        int len = arr.length;
        insertionSortRecur1(arr,len);
        Utils.printArray(arr);
    }

    public static void selectionSort(int arr[]){
        int len = arr.length;
        for (int i = len-1; i >0 ; i--) {
            int largest = 0;
            for (int j = 1; j <=i; j++) {
                if(arr[j] > arr[largest]){
                    largest = j;
                }
            }
            Utils.swap(arr,largest,i);
        }
        Utils.printArray(arr);
    }
    
    public static void bubbleSort(int arr[]){
        int len = arr.length;
        for (int i= len-1;i>0;i--){
            for (int j=0;j<i;j++){
                if(arr[j] > arr[j+1]){
                    Utils.swap(arr,j, (j+1));
                }
                Utils.printArray(arr);
            }
        }
        Utils.printArray(arr);
    }


}
