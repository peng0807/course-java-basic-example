package chapter5.example5_8;
enum Season {  // 可理解为：final class Season extends java.lang.Enum 
	// 定义枚举值，私有静态常量
	SPRING("春") {
		public Season nextSeason() {  // 实际上定义了一个Season类型的子类Season$1，而且子类实现了父类的nextSeason方法
			return SUMMER;
		}
	}, 
	SUMMER("夏"){
		public Season nextSeason() {
			return AUTUMN;
		}
	}, 
	AUTUMN("秋"){
		public Season nextSeason() {
			return WINTER;
		}
	}, 
	WINTER("冬"){
		public Season nextSeason() {
			return SPRING;
		}
	};
	// 可理解为 private static final Season SPRING = new Season("春");
	
	//可以定义其它的成员变量， 但成员变量名不应设为name，或者ordinal
	private String seasonName;
	
	Season(String seasonName) {	// 枚举类的构造方法必须是私有的。等同于 private Season(String seasonName)
		this.seasonName = seasonName;
	}
	
	// 可以定义其它的成员方法
	public String getSeasonName() {
		return this.seasonName;
	}
	
	public abstract Season nextSeason();
	
//	不应该对外提供set方法，否则会破坏枚举的本意
//	public void setSeasonName(String seasonName) {
//		this.seasonName = seasonName;
//	}
	 
}


public class TestEnum {
	public static void main(String[] args) {
		Season season = Season.SPRING;   
		// Season season = new Season("春"); 错误， 不能通过枚举类的构造方法初始化枚举对象
		//	season.setName("秋"); 错误，不应该设置枚举对象中的属性值  
		System.out.println(season);  // 调用了父类Enum中重写的toString()方法
		System.out.println(season.name());  // 调用了父类Enum中定义的name()方法，输出父类Enum中定义成员变量name
		System.out.println(season.ordinal()); // 调用了父类Enum中定义的ordinal()方法，输出父类Enum中定义的成员变量ordinal
		System.out.println(season.getSeasonName());
		
		//遍历枚举值
		Season[] values = Season.values();  // values是静态方法，是在代码编译时由编译器生成的。返回所有枚举值组成的数组
		for(Season s : values) {
			System.out.println(s.ordinal() + " : " + s.name());
		}
		
		for(int i=0; i<values.length; i++) {
			System.out.println(season);
			season = season.nextSeason();
		}
	}
}
