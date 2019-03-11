package chapter4.example4_7;


public class ExceptionTest03 {
	
	static int[] a= {1,2,3};
	
	public static void m() throws ArrayIndexOutOfBoundsException{
		for(int i=0;i<10;i++){
			if(i>=a.length)
				throw new ArrayIndexOutOfBoundsException();
			else
				System.out.println(a[i]);
		}
	}
	
	public static void main(String[] args) {
		//捕获异常、处理异常
		try {
			m(); // main()方法中捕获处理m()方法抛出的异常，
		} catch (ArrayIndexOutOfBoundsException e) {
			//e.printStackTrace(); //JRE默认的异常处理方式
			System.out.println("数组下标越界"); //自定义异常处理方式
		} finally {
			System.out.println("不管有没有发生异常，这里都会执行");
		}
		
		System.out.println("注意：这条语句执行了");
	}
	
}
