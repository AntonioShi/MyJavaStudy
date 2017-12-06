package chapter04;

//形狀，的接口
interface Shape {
	double area(double parameter);
}

// 正方形类
class Square implements Shape {
	@Override
	public double area(double parameter) {
		// TODO Auto-generated method stub
		return (parameter * parameter);
	}

}

// 圆形类
class Circle implements Shape {
	@Override
	public double area(double parameter) {
		// TODO Auto-generated method stub
		return (parameter * parameter * 3.14159);
	}

}

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle cir = new Circle();
		System.out.println(cir.area(1));
		Square squ = new Square();
		System.out.println(squ.area(5));
	}

}
