package chapter4.example4_7;

public class ExceptionTest01 {
	static int[] a= {1,2,3};
	public static void main(String[] args){
		//没有捕获异常、处理异常
		for(int i=0;i<5;i++) {
			System.out.println(a[i]); //数组下标越界异常
		}
		System.out.println("注意：这条语句没有执行");
	}

}
