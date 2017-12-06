package chapter04;

class Student {
	protected String name;// 姓名
	protected int age;// 年龄

	// 构造函数
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void show() {
		System.out.println("name = " + name + ", age = " + age);
	}

	// 各种get,set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

class Undergraduate extends Student {

	protected String degree;// 学位

	public Undergraduate(String name, int age, String degree) {
		super(name, age);
		this.degree = degree;
	}

	public void show() {
		System.out.println("name = " + name + ", age = " + age + ", degree = " + degree);
	}
}

public class Test01 {
	public static void main(String[] args) {
		Student stu = new Student("许克祥", 20);
		stu.show();
		Undergraduate und = new Undergraduate("李庭輝", 20, "軟件工程");
		und.show();
	}

}
