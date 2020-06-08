package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Other01Sort {
    /*排序的一点笔记*/

    /*1.选择排序*/
    /*遍历整个数组，选择最小/大的元素，移动至最左/右边，移动指针至下一位，再次遍历选取最小/大...*/

    /*2.冒泡*/
    /*比较第n和n+1元素，如果n+1小于n，进行交换位置，指针移动到最后位置后再次返回最初，再次进行冒泡；可以对每个元素进行flag标记，已经完成排序得给与false*/

    /*3.插入排序*/
    /*每次添加一个新的元素,和现有列表进行比较，从尾部开始,如果大于该元素则交换位置；*/
    /*对大部分为有序、个别需要排序，或者已经排序的大数组衔接了一个小数组的情况，插入会比上2类排序方法快很多*/

    /*4.希尔排序*/
    /*按步长3h+1，把数组进行划分，每次对各个数组的第n号元素进行排序，最后再进行插入排序*/
    /*子数组排序后都是部分有序*/

    /*5.快速排序*/
    /*取一个基准点pivot，使指针low和high依次向基准点移动，保证pivot的左边都比基准值小，右边都大。迭代，当最后返回的low>high时终止迭代*/

    /*6.堆排序*/   /*heapSort*/
    /*完全二叉树:没有节点为空树;堆:满足为完全二叉树;满足所有父节点大于其子节点(大顶堆的情况)*/
    /*每次将0位元素与length-1位元素交换位置,并取出len-1位的元素(max元素),然后进行堆调整heapify;重复直至排序完成*/

    /*7.归并排序*/  /*mergeSort*/
    /*将数组进行分治(左和右),最终会拆分为单个,最后进行排序合并*/

    /*8.梳排序 comb sort*/
    /*基于冒泡和希尔,对一定间隔的2个数进行排序;此处略过*/



    @Test
    /*使用了2个linkedList的集合*/
    public void selectionSort01(){
        /*创建原始集合*/
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(9,1, 4, 3, 7,8, 2,6,100,200,101,102,202,303,20,25));
        LinkedList<Integer> complete = new LinkedList<>();  /*创建完成后的结果数组*/
        while (linkedList.size()>0){                        /*遍历集合，当全部remove完后结束*/
            Integer min = linkedList.peekFirst();           /*设置初始min为第一个元素*/
            int minOrder = 0;
            for (int i = 1; i < linkedList.size(); i++) {   /*从集合中找出最小数，和他的序号*/
                if (linkedList.get(i) < min) {
                    min = linkedList.get(i);
                    minOrder = i;
                }
            }
            complete.add(min);              /*给完成数组添加最小数*/
            linkedList.remove(minOrder);    /*删除原集合该当序号的数*/
        }
        System.out.println(complete);
    }

    @Test
    /*只使用一个list*/
    public void selectionSort02(){
        /*创建原始集合*/
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(9,1, 4, 3, 7,8, 2,6,100,200,101,102,202,303,20,25));
        int point = 0;          /*初始指针位置*/
        while (point < linkedList.size()) {
            Integer max = linkedList.get(point);             /*初始化最大值max*/
            int maxOrder = point ;                           /*获取max的序号*/
            int maxPoint = point +1;                         /*设置寻找最大值指针的位置*/
            while (maxPoint < linkedList.size()) {           /*遍历寻找最大值和序号*/
                if (linkedList.get(maxPoint) > max) {
                    max = linkedList.get(maxPoint);
                    maxOrder = maxPoint;
                }
                maxPoint++;
            }
            linkedList.remove(maxOrder);                    /*依据最大值序号移除max*/
            linkedList.push(max);                           /*添加至头*/
            point++;
        }
        System.out.println(linkedList);
    }

    /*使用数组，大概是02的1/4时间*/
    public void selectionSort03(int[] arr) {
//        System.out.println(Arrays.toString(arr));       /*排序前*/
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
    }

    /*冒泡排序*/
    @Test
    public void bubbleSort01(){
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(9,10, 4, 3, 7,8, 2,6,100,200,1,101,102,202,303,20,25));
        int minOrder = 0;                               /*最小值的序号*/
        Integer min = linkedList.get(minOrder);         /*最小值*/
        int maxOrder = 0;                               /*最大值的序号*/
        int max = linkedList.get(maxOrder);             /*最大值*/
        while ((maxOrder != linkedList.size()-1) || minOrder != 0){     /*当最大值的序号不在尾，或最小值不在头，进行遍历*/
            int left = 0;                                               /*左指针*/
            int right = left+1;                                         /*右指针*/
            while (right <linkedList.size()){                           /*遍历整个list*/
                if (linkedList.get(left) > linkedList.get(right)) {     /*如果左指针大于右指针，两者交换*/
                    Integer swap = linkedList.get(right);
                    linkedList.set(right,linkedList.get(left));
                    linkedList.set(left,swap);
                    if (min >= linkedList.get(left)) {                  /*如果最小/大值大等于左/右指针，则赋值&序号*/
                        min = linkedList.get(left);
                        minOrder = left;
                    }
                    if (max <= linkedList.get(right)){
                        max = linkedList.get(right);
                        maxOrder = right;
                    }
                }
                left++;
                right++;
            }
            System.out.println(linkedList);
        }

    }

    /*使用数组*/
    @Test
    public void bubbleSort02(){
        int[] arr = {9,  4, 3, 7, 8, 2, 6, 100, 1,200, 101, 102, 202, 303, 20, 25};
        Boolean flag = true;
        while (flag == true){
            int left;
            int right = 0;
            int min = arr.length/2;
            int max = arr.length/2;
            for (left = 0; left < arr.length - 1; left++) {
                for (right = left+1; right < arr.length; right++) {
                    if (arr[right] < arr[left]) {
                        int temp = arr[right];
                        arr[right] = arr[left];
                        arr[left] = temp;
                    }
                    min = arr[min]>arr[left] ? left:min;
                    max = arr[max]<arr[right] ? right:max;
                }
            }
            if (max == arr.length-1 && min == 0) {
                flag = false;
                System.out.println(Arrays.toString(arr));
            }

        }
    }

    /*用flag判断是否有交换*/
    public void bubbleSort03(int[] arr){
        if (arr.length <= 1) return;                        //如果只有一个元素就不用排序了
        for (int i = 0; i < arr.length; ++i) {
            // 提前退出冒泡循环的标志位,即一次比较中没有交换任何元素，这个数组就已经是有序的了
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; ++j) {        //此处你可能会疑问的j<n-i-1，因为冒泡是把每轮循环中较大的数飘到后面，
                // 数组下标又是从0开始的，i下标后面已经排序的个数就得多减1，总结就是i增多少，j的循环位置减多少
                if (arr[j] > arr[j + 1]) {        //即这两个相邻的数是逆序的，交换
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;//没有数据交换，数组已经有序，退出排序
        }
    }



    /*插入排序*/    /*优化后*/
    public void insertionSort(int[] arr){
        for (int right = 1; right < arr.length; right++) {
            int temp = arr[right];                                              /*提升temp的作用域,没必要在内层new*/
            for (int left = right-1; left >=0 && arr[left]> temp; left--) {     /*做了一个左指针如果小于右指针的判断,就没必要进入循环*/
                if (arr[left+1] < arr[left]) {
                    arr[left+1] = arr[left];
                    arr[left] = temp;
                }
            }
        }
    }


    /*希尔排序*/
    public void shellSort(int[] arr) {
        int h = 1;
        while (h <= arr.length/3) {     /*求数组中最大的3h+1；也可以使用质数作为间隔*/
            h = h*3 +1;
        }
//        for (int gap = arr.length/2; gap >0 ; gap /= 2) {                 /*原生希尔排序，每次对半开的排序*/
        for (int gap = h; gap >0 ; gap /= 2) {                              /*改进版，每次取最大的3h+1，步进为二分之一*/
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

    /*另一个别人的希尔排序*/      /*严格按照定义来写的希尔排序*/
    private void shellSort00(int[] a){
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


    /*快排在乱序时候较有效率，当数据为纯反或者已经很有序时并不有效*/
    public void quickSort01(int[] arr,int low,int high){        /*初始值默认low = 0，high = len-1（总共5个元素，最后位置为4）*/
        if (low >= high) {return;}                  /*递归终止的条件，当low和high相等/或大于*/

        int pivot = partition(arr,low,high);        /*分割左右函数，返回基点pivot*/
        quickSort01(arr,low,pivot-1);           /*进行递归，保证pivot左边都比pivot小，右边都大*/
        quickSort01(arr,pivot+1,high);
    }

    private int partition(int[] arr, int low, int high) {
        /*随机获取一个pivotIndex基点序号*/
        Random random = new Random();
        /*范围在low和high之间，最小值需要从low开始 ※r.nI(100)是不包含100的,所以此处+1*/
        int pivotIndex = random.nextInt(high-low+1)+low;
        int pivotValue = arr[pivotIndex];              /*根据基点序号获取基点值*/
        swap(arr,pivotIndex,high);                     /*交换基点和high的位置*/
        int savedPosition = high;                      /*保存high的位置，*/
        high--;                                        /*high下降一位（原来的high位为pivot位）*/
        while (low <= high){                /*当low未超过high时,进行交换判断*/
            if (arr[low] > pivotValue) {    /*如果low>pivot,将low high交换,high位下降*/
                swap(arr,low,high);
                high--;
            }else low++;                    /*其他情况low进位*/
        }
        swap(arr, low,savedPosition);       /*全部排序完成后low的最高位和原high位(现pivot位)交换位置,返回low(pivot位)*/
        return low;
    }

    private void swap(int[] arr, int low, int high) {       /*交换low和high的位置*/
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }



    /*堆排序*/
    public void heapSort(int[] arr){
        buildHeap(arr,arr.length);                      /*进行堆重构*/
        for (int i = arr.length-1 ; i >= 0 ; i--) {     /*将root与末尾节点进行交换,抽取最后尾(max)并整理堆*/
            swap(arr,i,0);
            heapify(arr,i,0);                    /*整理堆,此时数组长度由i决定(每次减少1)*/
        }
    }


    /*一些公式:
     * parent = (i - 1) / 2          i:位数
     * c1 = 2i + 1
     * c2 = 2i + 2
     * */
    /*堆整理heapify*/      /*所有子树必须为堆,无法对乱序的堆进行排序*/
    private void heapify(int[] arr, int length, int parent) {
//        int[] arr = {4,10,3,5,1,2};           /*供测试用的数据,子数为堆*/
        /*传入数组和需要整理的父节点
        * 通过公式确立父子节点,然后进行大小判断,并交换交换后*/
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
            heapify(arr,length,max);            /*继续判断子节点(max已经被原来的c1/c2替换)*/
        }

    }

    /*对每个子树进行堆整理,重构一个乱序的堆*/
    private void buildHeap(int[] arr, int length){
        int lastNode = length -1;                   /*获取最后一个节点*/
        int lastParent = (lastNode - 1) / 2;        /*从而获取最后一个父节点*/
        for (int i = lastParent; i >= 0; i--) {     /*传入每个父节点,进行堆整理heapify*/
            heapify(arr,length,i);
        }
    }



    /*归并排序*/
    /*先无限进行拆分为最小单位,然后进行合并排序*/
    /*直观反映排序的图
    * https://img-blog.csdn.net/20180812233124752?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM2NDQyOTQ3/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70*/
    public void mergeSort(int[] arr,int left,int right){
        if (left < right) {                     /*当只有一个元素值停止循环(left超过right)*/
            int mid = (left + right) /2;        /*划分左右数组*/
            mergeSort(arr,left,mid);            /*堆左/右数组进行排序*/
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);          /*合并数组*/
        }
    }

    /*排序&合并数组数组*/
    public void merge(int []a,int left,int mid,int right){
        int []tmp=new int[a.length];                //辅助数组
        int p1=left,p2=mid+1,k=left;                //p1、p2是检测指针，k是存放指针
        while(p1<=mid && p2<=right){
            if(a[p1]<=a[p2])
                tmp[k++]=a[p1++];
            else
                tmp[k++]=a[p2++];
        }
        while(p1<=mid) tmp[k++]=a[p1++];        //如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while(p2<=right) tmp[k++]=a[p2++];
        for (int i = left; i <=right; i++)      //复制回原素组
            a[i]=tmp[i];
    }




    /*测试各种排序的速度*/
    @Test
    public void testArr(){

        for (int i2 = 0; i2 < 10; i2++) {
            int range = 20000;
            int [] arr = new int[range];
            for (int i = 0; i < range; i++) {
                int anInt = new Random().nextInt(range);
                arr[i] = anInt;
            }
            System.out.println("length: "+arr.length);

            long l1 = System.currentTimeMillis();
            selectionSort03(arr);
//            insertionSort(arr);
//            shellSort(arr);
//            shellSort00(arr);
//            quickSort01(arr,0,arr.length-1);
//            heapSort(arr);
//            mergeSort(arr,0,arr.length-1);
            long l2 = System.currentTimeMillis();
            long insertionCost = l2-l1;
            System.out.println("cost: "+insertionCost);
            if (i2 == 49) {
                System.out.println(Arrays.toString(arr));
            }
        }
    }



}
