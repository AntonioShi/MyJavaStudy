package chapter03;

class Father{
	private String name = "zhangjun";
	
	class Child{
		public void introFather() {
			System.out.println("My father is "+name);
		}
	}
}

public class Test02{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Father.Child child = new Father().new Child();
		child.introFather();
	}
}

