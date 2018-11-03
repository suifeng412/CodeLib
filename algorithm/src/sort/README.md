# 选择排序
>简介  

最简单的一个排序算法。  
首先，找到数组中最小的一个元素；  
其次，将它和数组中的第一个元素交换为位置；  
再次，在剩下的元素中找到最小的元素，与数组中的第二个元素交换位置；  
如此往复，直到将整个数组排序。

> 特点   

运行时间和输入数组状态无关，不管输入的数组是否有序又要遍历这么多次去排序。  

> 时间复杂度  

N²/2

> 实现代码

```
public static void sort(Comparable[] a) {
     int n = a.length;
     for (int i = 0; i < n; i++) {
         int min = i;
         for (int j = i+1; j < n; j++) {
            if (less(a[j], a[min])) min = j;
        }
        exch(a, i, min);
    }
}
```

# 插入排序  
> 简介  

将一个元素插入到左边已有序的数组中，此时需要给插入的元素腾出位置，将大于新插元素的所有元素向右移动一位。  
与选择排序最大的不同在于：   
* 插入排序遍历左边已有序的元素，找到合适的位置插入；
* 选择排序则遍历右边无序的元素，找到最小的元素放入左边末尾。  
这样将会导致两种排序的不同性能，插入排序所需的时间取决于输入的元素的初始位置。   

> 代码实现

```
public static void sort(Comparable[] a) {
	int n = a.length;
	for (int i = 0; i < n; i++) {
    	for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
       		exch(a, j, j-1);
       	}
   }
}
```
![image](https://raw.githubusercontent.com/suifeng412/CodeLib/master/algorithm/public/2018-10-03_112340.jpg)


# 希尔排序
> 简介

基于插入排序的一种优化版本排序  
与基础插入排序不同的是，它将数据分割成多个，各自进行排序整合。（以间隔h的方式进行）  
![image](https://raw.githubusercontent.com/suifeng412/CodeLib/master/algorithm/public/2018-10-04_163048.jpg)


# 归并排序
> 简介

将一个要排序的数组递归地将它分成两半分别排序，然后将结果归并成为一个大数组。  
主要缺点就是需要额外的空间与N成正比    
![image](https://raw.githubusercontent.com/suifeng412/CodeLib/master/algorithm/public/2018-10-05_162422.jpg)  
扩展：  
在使用归并排序的时候，可以采用选择、插入等排序方法将数组分割进行排序，最后才归整理。

















