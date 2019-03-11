package chapter2.example2_3;

public class TestBasicDataType {
	public static void main(String[] args) {
		int x = 10;
		long y = 10L;	// 因为整数值常量10默认是int类型，所以要在后面加L，表示是long类型常量
		float z = 10.1F;	// 因为浮点数值常量10.1默认是double类型，所以要在后面在F，表示是float类型常量
		x = (int)y;	// 需要强制转换，无数据溢出。
		x = (int)z;	// 需要强制转换，有数据溢出，精度丢失。
		y = (long)z;		// 虽然long类型比float类型占用的存储空间更大，但是float类型的取值范围比long类型更大，所以需要强制转换
		y = x;	// 可以自动转换
		z = x;	// 可以自动转换
		byte b1=1;
		byte b2=2;
		byte b3=(byte)(b1+b2); 	 // b1和b2会先自动转换为int类型再进行运算，运算的结果也是int类型，所以需要强制转换
		x = b3;
	}
}
