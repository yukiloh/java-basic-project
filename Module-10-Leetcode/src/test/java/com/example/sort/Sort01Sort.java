package com.example.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;


public class Sort01Sort {

    /**
     * 记录常用的一些排序方法
     * 所有排序的速度演示: https://www.bilibili.com/video/BV1kW411c743
     */
    @Test
    void testContext() {
        int[] arr = {53,2,1,4,33};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 1.选择排序
     * 遍历整个数组，选择最小/大的元素，移动至最左/右边，移动指针至下一位，继续循环直至完成排序
     */
    private int[] selectionSort(int[] arr) {
        for (int left = 0; left < arr.length - 1; left++) {         /*创建一个左指针和右指针*/
            int minOrder = left;
            for (int right = left + 1; right < arr.length; right++) {
                if (arr[minOrder] > arr[right]) {                   /*当最小数>右指针,则赋值最小数(序号)*/
                    minOrder = right;
                }
            }
            if (left != minOrder) {         /*如果最后获取的最小数不为本身(优化赋值),交换位置*/
                swap(arr,left,minOrder);
            }
        }
        return arr;
    }

    /**
     * 2.冒泡排序
     * 比较第n和n+1元素，如果n+1小于n，进行交换位置
     * 指针移动到最后位置后再次返回最初，再次进行冒泡
     * 对每个元素进行flag标记，已经完成排序得给与false
     */
    private int[] bubbleSort(int[] arr){
        if (arr.length <= 1) return arr;            //如果只有一个元素就不用排序了
        for (int i = 0; i < arr.length; ++i) {
            boolean flag = false;                   //如果没有交换任何元素,则表示交换完成

            //因为每次循环都会把最大的数换到末尾,所以每次可以少排序i个
            for (int j = 0; j < arr.length - i - 1; ++j) {
                //数组下标又是从0开始的，i下标后面已经排序的个数就得多减1，总结就是i增多少，j的循环位置减多少
                if (arr[j] > arr[j + 1]) {          //即这两个相邻的数是逆序的，交换
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;                       //没有数据交换，数组已经有序，退出排序
        }
        return arr;
    }


    /**
     * 3.插入排序
     * 每次添加一个新的元素,和现有列表进行比较，从尾部开始,如果大于该元素则交换位置；
     * 对大部分为有序、个别需要排序，或者已经排序的大数组衔接了一个小数组的情况，插入会比上2类排序方法快很多
     */
    private int[] insertionSort(int[] arr){
        for (int right = 1; right < arr.length; right++) {

            //提升temp的作用域,没必要在内层new
            int temp = arr[right];

            //做了一个左指针如果小于右指针的判断,就没必要进入循环
            for (int left = right-1; left >=0 && arr[left]> temp; left--) {
                if (arr[left+1] < arr[left]) {
                    arr[left+1] = arr[left];
                    arr[left] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 4.希尔排序
     * 按步长3h+1，把数组进行划分，每次对各个数组的第n号元素进行排序，最后再进行插入排序
     * 子数组排序后都是部分有序
     */
    private void shellSort(int[] arr) {
        int h = 1;
        while (h <= arr.length/3) {     //求数组中最大的3h+1；也可以使用质数作为间隔
            h = h*3 +1;
        }
//        for (int gap = arr.length/2; gap >0 ; gap /= 2) {           //原生希尔排序，每次对半开的排序
        for (int gap = h; gap >0 ; gap /= 2) {                      //改进版，每次取最大的3h+1，步进为二分之一
            for (int right = gap; right < arr.length; right++) {
                for (int left = right; left >gap -1; left -= gap) {
                    if (arr[left] < arr[left-gap]) {
                        int temp = arr[left-gap];
                        arr[left-gap] = arr[left];
                        arr[left] = temp;
                    }
                }
            }
        }
    }

    /**
     * 另一个别人的希尔排序
     * 严格按照定义来写的希尔排序
     */
    private void shellSort0(int[] a){
        int n=a.length;
        int i,j,k,gap;
        for(gap=n/2;gap>0;gap/=2){
            for(i=0;i<gap;i++){
                for(j=i+gap;j<n;j+=gap){
                    int temp = a[j];
                    for(k=j-gap;k>=0 && a[k]>temp;k-=gap){
                        a[k+gap]=a[k];
                    }
                    a[k+gap]=temp;
                }
            }
        }
    }


    /**
     * 5.快速排序
     * 取一个基准点pivot,使指针low和high依次向基准点移动,并保证pivot的左边都比基准值小,右边都大,当最后返回的low>high时终止迭代
     * 快排在乱序时候最效率，当数据完全相反或者已经很有序时并不有效
     */
    private int[] quickSort(int[] arr){
        doQuickSort(arr,0,arr.length);
        return arr;
    }

    //因为快排会调用递归,这里方便调用做了个内部的doMethod
    private void doQuickSort(int[] arr, int low, int high){
        //第一次传入时,low = 0，high = len-1
        if (low <= high) {
            int pivot = partition(arr,low,high);        //分割左右，返回基准点pivot
            doQuickSort(arr,low,pivot-1);           //进行递归，保证pivot左边都比pivot小，右边都大
            doQuickSort(arr,pivot+1,high);
        }
    }

    //进行高位和低位的区域划分
    private int partition(int[] arr, int low, int high) {
        //随机获取一个pivotIndex基准点序号,范围在low和high之间，最小值需要从low开始
        //nextInt(100)是不包含100的,所以此处+1
        int pivotIndex = new Random().nextInt(high-low+1)+low;
        int pivotValue = arr[pivotIndex];   //根据基准点序号获取基准点值
        swap(arr,pivotIndex,high);          //交换基准点和high的位置
        int savedPosition = high;           //保存high的位置
        high--;                             //high下降一位（原来的high位为pivot位）
        while (low <= high){                //当low未超过high时,进行交换判断
            if (arr[low] > pivotValue) {    //如果low>pivot,将low high交换,high位下降
                swap(arr,low,high);
                high--;
            }else low++;                    //其他情况low进位
        }
        swap(arr, low,savedPosition);       //全部排序完成后,将low位和原high位交换
        return low;
    }

    private void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }


    /**
     * 6.堆排序
     * 利用二叉树的特性进行排序
     * 完全二叉树: 所有节点都存在数据(即没有空节点的树)
     * 堆:满足为完全二叉树,且所有父节点大于其子节点(大顶堆的情况)
     * 每次将0位元素与length-1位元素交换位置,并取出len-1位的元素(max元素),然后进行堆调整heapify,重复直至排序完成
     */
    public int[] heapSort(int[] arr){
        buildHeap(arr,arr.length);                      //进行堆重构
        for (int i = arr.length-1 ; i >= 0 ; i--) {     //将root与末尾节点进行交换,抽取最后尾(max)并整理堆
            swap(arr,i,0);
            heapify(arr,i,0);                    //整理堆,此时数组长度由i决定(每次减少1)
        }
        return arr;
    }

    /**
     * 数组建堆(堆整理) heapify ,所有子树必须为堆,无法对乱序的堆进行排序
     * 一些公式: (i位数)
     * parent = (i - 1) / 2
     * c1 = 2i + 1
     * c2 = 2i + 2
     */
    private void heapify(int[] arr, int length, int parent) {
        //传入数组和需要整理的父节点.通过公式确立父子节点,然后进行大小判断+交换
        int c1 = 2 * parent + 1;
        int c2 = 2 * parent + 2;
        int max = parent;
        if (c1 < length && arr[c1] > arr[max]) {
            max = c1;
        }
        if (c2 < length && arr[c2] > arr[max]) {
            max = c2;
        }
        if (max != parent) {
            swap(arr,max,parent);
            heapify(arr,length,max);            //继续判断子节点(max已经被原来的c1/c2替换)
        }
    }

    //对每个子树进行堆整理
    private void buildHeap(int[] arr, int length){
        int lastNode = length -1;                   /*获取最后一个节点*/
        int lastParent = (lastNode - 1) / 2;        /*从而获取最后一个父节点*/
        for (int i = lastParent; i >= 0; i--) {     /*传入每个父节点,进行堆整理heapify*/
            heapify(arr,length,i);
        }
    }


    /**
     * 7.归并排序
     * 将数组进行分治(左和右),将他们会拆分为单个,最后进行排序合并
     * 比较直观的排序过程
     * https://img-blog.csdn.net/20180812233124752?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM2NDQyOTQ3/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70
     */
    private int[] mergeSort(int[] arr){
        doMergeSort(arr,0,arr.length-1);
        return arr;
    }

    //和快排一样,会进行递归,因此做了个doMethod
    private void doMergeSort(int[] arr, int left, int right){
        if (left < right) {                     //当只有一个元素值停止循环(left超过right)
            int mid = (left + right) /2;        //划分左右数组
            doMergeSort(arr,left,mid);          //堆左/右数组进行排序
            doMergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);          //合并数组
        }
    }

    //排序&合并数组数组(应该是某处复制的)
    private void merge(int[] a, int left, int mid, int right){
        int[] temp = new int[a.length];           //辅助数组

        //p1、p2是检测指针，k是存放指针
        int p1=left;
        int p2 = mid+1;
        int k=left;

        while(p1 <= mid && p2 <= right){
            if(a[p1] <= a[p2])
                temp[k++] = a[p1++];
            else
                temp[k++] = a[p2++];
        }

        while(p1<=mid) temp[k++] = a[p1++];        //如果第一个序列未检测完，直接将后面所有元素加到合并的序列中

        while(p2<=right) temp[k++] = a[p2++];

        for (int i = left; i <= right; i++)        //复制回原素组
            a[i] = temp[i];
    }

    /**
     * 8.梳排序 comb sort
     * 基于冒泡和希尔,对一定间隔的2个数进行排序.略
     */
}
