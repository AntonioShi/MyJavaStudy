package chapter06;

import java.util.Random;

public class Test03 {

	public static void main(String[] args) {
		Random rand = new Random();
        int[] num = new int[5];
        for (int i = 0; i < num.length; i++) {
            num[i] = 20 + rand.nextInt(31);
            System.out.println(num[i]);
        }
	}

}
