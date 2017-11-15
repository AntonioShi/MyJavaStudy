package chapter03;

class Person {
	// 以下是私有属性，当然不能直接初始化
	protected String name;
	protected int age;

	// 关于构造方法的二三事
	public Person() {
		// TODO Auto-generated constructor stub
		System.out.println("这是无参构造方法");
	}
 
	public Person(int age) {
		this.setAge(age);
	}
	
	// 这还真方便,
	// 在eclipse中按住shift+alt+s选择 generate getters and setters 然后选择你要设置的属性 自动生成
	// get和set方法
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
		if (age >= 0 && age <= 120) {
			this.age = age;
		} else {
			System.err.println("年龄不合法,,,");
			//System.out.println输出有缓存，System.err.println是立即输出，可能在输出1或2，还没有输出换行时输出3。
		}
	}

}

// 这是一个学生类
class Student extends Person {
	public void introduce() {
		System.out.println("大家好，我叫" + this.name + "，今年" + this.age + "岁！！！");
	}
}

public class ObjectDemo {
	public static void main(String[] args) {
		Student stu = new Student();

		stu.setAge(19);
		stu.setName("李庭辉");
		stu.introduce();

		Person per = new Person(99999);
		
	}

}
