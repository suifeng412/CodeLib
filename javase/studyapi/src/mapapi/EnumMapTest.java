package mapapi;

import java.util.EnumMap;

/*
 * EnumMap
 * 
 * EnumMap是一个与枚举类一起使用的Map实现，EnumMap中的所有key都必须是单个枚举类的枚举值。
 * 创建EnumMap时必须显式或隐式指定它对应的枚举类。
 * EnumMap根据key的自然顺序(即枚举值在枚举类中的定义顺序)
 * 
 * 
 * 
 * */
public class EnumMapTest {
	public static void main(String[] args) {
		//创建一个EnumMap对象，该EnumMap的所有key
        //必须是Season枚举类的枚举值
        EnumMap<Season, String> enumMap = new EnumMap<Season, String>(Season.class);
        enumMap.put(Season.SUMMER , "夏日炎炎");
        enumMap.put(Season.SPRING , "春暖花开");
        System.out.println(enumMap);
	}
}

enum Season
{
    SPRING,SUMMER,FALL,WINTER
}