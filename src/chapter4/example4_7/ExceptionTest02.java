package chapter4.example4_7;


public class ExceptionTest02 {
	
	static int[] a= {1,2,3};
	
	public static void main(String[] args) {
		//捕获异常、处理异常
		try {
			for(int i=0;i<5;i++) {
				System.out.println(a[i]); //数组下标越界异常
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			//e.printStackTrace(); //JRE默认的异常处理方式
			System.out.println("数组下标越界"); //自定义异常处理方式
		} finally {
			System.out.println("不管有没有发生异常，这里都会执行");
		}
		
		System.out.println("注意：这条语句执行了");
	}

}
