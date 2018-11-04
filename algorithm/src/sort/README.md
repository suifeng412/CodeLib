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

> 代码实现

```
	public static void sort(Comparable[] a) {
        int n = a.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ... 
        // 按照3x+1来对数组进行分段，找到最大分段数
        int h = 1;
        while (h < n/3) h = 3*h + 1; 

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
            h /= 3;
        }
    }
```

![image](https://raw.githubusercontent.com/suifeng412/CodeLib/master/algorithm/public/2018-10-04_163048.jpg)


# 归并排序
> 简介

将一个要排序的数组递归地将它分成两半分别排序，然后将结果归并成为一个大数组。  
主要缺点就是需要额外的空间与N成正比    

有序数组归并：  

> 实现代码

```
	public void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // 判断是否有序
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
        }

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
    }
```
![image](https://raw.githubusercontent.com/suifeng412/CodeLib/master/algorithm/public/2018-11-04_171725.jpg)

无序数组归并：  

> 代码实现  (自顶向下)

```
	public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
        assert isSorted(a);
    }
	private static void sort(Comparable[] a, int[] index, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, index, aux, lo, mid);
        sort(a, index, aux, mid + 1, hi);
        merge(a, index, aux, lo, mid, hi);
    }
```

![image](https://raw.githubusercontent.com/suifeng412/CodeLib/master/algorithm/public/2018-10-05_162422.jpg)  
扩展：  
在使用归并排序的时候，可以采用选择、插入等排序方法将数组分割进行排序，最后才归整理。

> 代码实现（自底向上）

先归并微型数组，在叠加继续归并。例如：先两两归并、再四四归并、再八八归并、一直循环下去

```
 	public static void sort(Comparable[] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];
        for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo < n-len; lo += len+len) {
                int mid  = lo+len-1;
                int hi = Math.min(lo+len+len-1, n-1);
                merge(a, aux, lo, mid, hi);
            }
        }
    }
```














