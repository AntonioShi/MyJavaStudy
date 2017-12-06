package experiment03;

/*
 * 
Project: The Triangle Class

Problem Description:
Design a class named Triangle that extends GeometricObject. The class contains: 
Three double data fields named side1, side2, and side3 with default values 1.0 to denote three sides of the triangle.
A no-arg constructor that creates a default triangle.
A constructor that creates a triangle with the specified side1, side2, and side3.
The accessor methods for all three data fields. 
A method named getArea() that returns the area of this triangle.
A method named getPerimeter() that returns the perimeter of this triangle.
A method named toString() that returns a string description for the triangle. 

For the formula to compute the area of a triangle, see Exercise 5.19. The toString() method is implemented as follows:

return "Triangle: side1 = " + side1 + " side2 = " + side2 +
  " side3 = " + side3;

Design the classes Triangle and GeometricObject. Implement the class. 
Write a test program that creates a Triangle object with sides 1, 1.5, 1, color yellow and filled true, 
and displays the area, perimeter, color, and whether filled or not. 

有关计算三角形面积的公式，请参阅练习5.19。 
s=1/2(a+b+c) 
三角形ABC面积S=√[s(s-a)(s-b)(s-c)] 

设计三角形和几何对象。实施类
编写一个测试程序，创建一个三角形对象，边长为1，1.5，1，颜色为黄色，填充为真，
并显示区域，周长，颜色以及是否填充。


 * */

public class Test01 {

	public static void main(String[] args) {

		Triangle triangle = new Triangle(1, 1.5, 1);
		triangle.setColor("yellow");
		triangle.setFilled(true);

		System.out.println("The color is " + triangle.getColor());
		System.out.println("The filled is " + triangle.isFilled());
		System.out.println("The area is " + triangle.getArea());
		System.out.println("The perimeter is " + triangle.getPerimeter());
		System.out.println(triangle);
	}

}

// 几何类
class GeometricObject {

	protected String color; // 颜色
	protected boolean filled; // 是否填充

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}
}

// 三角形类
class Triangle extends GeometricObject {
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;

	public Triangle(double side1, double side2, double side3) {
		super();
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	// 获得面积的方法
	public double getArea() {

		double s = (side1 + side2 + side3) / 2;
		System.out.println(s);
		double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));

		return area;
	}

	// 获得周长的方法
	public double getPerimeter() {
		return side1 + side2 + side3;
	}

	@Override
	public String toString() {
		return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
	}
}
