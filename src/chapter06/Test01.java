package chapter06;

public class Test01 {

	public static void main(String[] args) {
		
		String string = "HelloWorld";
		StringBuffer buffer = new StringBuffer();//最后的输出对象
		char [] ch = string.toCharArray();//将字符串对象转化为字符数组方便操作
		
		//从最后一个字母开始遍历
		for (int i = ch.length - 1; i >= 0; i--) {
			if (ch[i] >= 'A' && ch[i] <= 'Z') {
				buffer.append(String.valueOf(ch[i]).toLowerCase());//这是一个静态的将ch[i]变成小写并返回的函数
			}
			else {
				buffer.append(String.valueOf(ch[i]).toUpperCase());//这是一个静态的将ch[i]变成小写并返回的函数
			}
		}
		
		System.out.println(buffer.toString());
	}

}
