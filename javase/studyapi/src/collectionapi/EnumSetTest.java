package collectionapi;

import java.util.*;

/*
 * EnumSet
 * 是一个专门为枚举类设计的集合类
 * EnumSet中所有元素都必须是指定枚举类型的枚举值，该枚举类型在创建EnumSet时显式、或隐式地指定
 * EnumSet的集合元素也是有序的
 * 它们以枚举值在Enum类内的定义顺序来决定集合元素的顺序
 * 
 * 
 * */
public class EnumSetTest {
	public static void main(String args[]) {
		testEnum();
	}
	
	public static void testEnum() {
		//创建一个EnumSet集合，集合元素就是Season枚举类的全部枚举值
        EnumSet<Season> es1 = EnumSet.allOf(Season.class);
        //输出[SPRING,SUMMER,FALL,WINTER]
        System.out.println(es1);

        //创建一个EnumSet空集合，指定其集合元素是Season类的枚举值。
        EnumSet<Season> es2 = EnumSet.noneOf(Season.class); 
        //输出[]
        System.out.println(es2); 
        //手动添加两个元素
        es2.add(Season.WINTER);
        es2.add(Season.SPRING);
        //输出[SPRING,WINTER]
        System.out.println(es2);

        //以指定枚举值创建EnumSet集合
        EnumSet<Season> es3 = EnumSet.of(Season.SUMMER , Season.WINTER); 
        //输出[SUMMER,WINTER]
        System.out.println(es3);

        EnumSet<Season> es4 = EnumSet.range(Season.SUMMER , Season.WINTER); 
        //输出[SUMMER,FALL,WINTER]
        System.out.println(es4);

        //新创建的EnumSet集合的元素和es4集合的元素有相同类型，
        //es5的集合元素 + es4集合元素 = Season枚举类的全部枚举值
        EnumSet<Season> es5 = EnumSet.complementOf(es4); 
        //输出[SPRING]
        System.out.println(es5);
	}
}

enum Season
{
    SPRING,SUMMER,FALL,WINTER
}