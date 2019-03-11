package chapter4.example4_7;

public class ExceptionTest05 {

	static int[] a= {1,2,3};
	
	public static void main(String[] args) {
		try {
			for(int i=0;i<3;i++) {
				System.out.println(a[i]); //数组下标越界异常
			}
			System.out.println(a[0]/0);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException");
			System.err.println(e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException ");
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception");
			System.err.println(e.getMessage());
		} 	
		
		while(true) {
			
		}
		
	}

}
