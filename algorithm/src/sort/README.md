# 选择排序
>简介  

最简单的一个排序算法。  
首先，找到数组中的第一个元素；  
其次，将它和数组中的第一个元素交换为位置；  
再次，在剩下的元素中找到最小的元素，与数组中的第二个元素交换位置；  
如此往复，直到将整个数组排序。

> 特点   

运行时间和输入数组状态无关，不管输入的数组是否有序又要遍历这么多次去排序。  

> 时间复杂度  

N2/2


# 插入排序  
> 简介  

将一个元素插入到左边已有序的数组中，此时需要给插入的元素腾出位置，将大于新插元素的所有元素向右移动一位。  
与选择排序最大的不同在于：   
* 插入排序遍历左边已有序的元素，找到合适的位置插入；
* 选择排序则遍历右边无序的元素，找到最小的元素放入左边末尾。  
这样将会导致两种排序的不同性能，插入排序所需的时间取决于输入的元素的初始位置。   

```
public static void sort(Comparable[] a) {
	int n = a.length;
	for (int i = 0; i < n; i++) {
    	for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
       		exch(a, j, j-1);
       	}
       assert isSorted(a, 0, i);
   	}
   	assert isSorted(a);
}
```
![image](https://github.com/suifeng412/CodeLib/blob/master/algorithm/public/2018-10-03_112340.jpg)


# 希尔排序
> 简介

基于插入排序的一种优化版本排序  
与基础插入排序不同的是，它将数据分割成多个，各自进行排序整合。（以间隔h的方式进行）
![image](https://github.com/suifeng412/CodeLib/blob/master/algorithm/public/2018-10-04_163048.jpg)














