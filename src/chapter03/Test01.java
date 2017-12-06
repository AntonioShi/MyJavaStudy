package chapter03;

//niracler定义的学生类
class Student {
  private String name;
	private int score;
	
	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}

public class Test01 {

	public static void main(String[] args) {

		Student stu1 = new Student("劳和泽", 105);
		Student stu2 = new Student();

		System.out.println(stu1.toString());
		System.out.println(stu2.toString());
	}
}


















