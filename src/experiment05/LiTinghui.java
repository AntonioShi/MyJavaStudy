package experiment05;

import java.util.Scanner;
import java.util.zip.Checksum;

/*Project: Checking Password

Problem Description:
Some Websites impose certain rules for passwords. 
Write a method that checks whether a string is a valid password. 
Suppose the password rule is as follows:

A password must have at least eight characters.
A password consists of only letters and digits.
A password must contain at least two digits.

Write a program that prompts the user to enter a password and displays
 "valid password" if the rule is followed or "invalid password" otherwise.

Sample 1
Enter a string for password: wewew43x
valid password

Sample 2
Enter a string for password: 343a
invalid password
 * */

/**
 * 一个检查密码格式的类
 * 
 * @author niracler
 *
 */
public class LiTinghui {
	Scanner scanner;

	public static void main(String[] args) {
		LiTinghui liTinghui = new LiTinghui();
		liTinghui.scanner = new Scanner(System.in);
		
		while (true) {
			String password = liTinghui.scanner.nextLine();
			boolean isValid = liTinghui.checks(password);
			System.out.println(isValid?"valid password":"invalid password");
		}
		
	}
	
	public boolean checks(String password) {
		int numberChar = 0;
		int numberDigit = 0;
		int numberOthers = 0;

		for (int i = 0; i < password.length(); i++) {
			if ((password.charAt(i) >= 'a' && password.charAt(i) <= 'z')
					|| (password.charAt(i) == 'A' && password.charAt(i) <= 'Z'))
				numberChar++;
			else if (password.charAt(i) >= '0' && password.charAt(i) <= '9')
				numberDigit++;
			else
				numberOthers++;
		}

		return!((numberChar + numberDigit + numberOthers < 8) || (numberOthers > 0) || (numberDigit == 0)
				|| (numberChar == 0) || (numberDigit < 2));
	}

}
