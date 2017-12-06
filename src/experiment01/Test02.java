/*题目2：
1.问题陈述:d
	写一个程序，询问用户的名、中间名和姓，并以用户的首字母做回应.
例子:
	输入: Andrew Lloyd Weber
	输出: ALW
2.总体计划
    • 首先要明确程序必需完成的主要功能. 
    • 在开发之前要知道我们要开发什么!
    • 任务:
        ◦ 取得用户的名、中间名和姓
        ◦ 抽取首字母形成字母组合
        ◦ 输出字母组合
3.开发步骤
    • 分两步:
        1. 从程序模版开始，添加代码获得输入
        2. 添加代码计算并显示组合字母
第1步设计
    • 程序只是说要取得用户的名字，但没有说怎么取得.
    • 在第1步设计里，我们得考虑怎样取得.
    • 使用 JOptionPane 输入
    • 输入形式选择 #1
	分别输入first, middle, and last names
    • 输入形式选择 #2
	一次性输入全部名字
    • 我们采用第 #2种方式，因为这种方式对用户来说更容易也更快 
第1步编码
		String name;
		name = JOptionPane.showInputDialog(null, "Enter your full name (first, middle, last):");
		JOptionPane.showMessageDialog(null, name);
第1步测试
    • 在测试阶段，我们运行程序并验证下面两点：
        ◦ 可以输入名字
        ◦ 正确地显示输入的名字
第2步设计
    • 因为程序设计技巧有限，因我们得做如下假设:
        ◦ 输入的字符串包含 first, middle, and last names
        ◦ first, middle, and last names 之间用空格隔开
    • 例如：
			John Quincy Adams		(okay)
			John Kennedy		(not okay)
			Harrison, William Henry  	(not okay)
    • 给定一个有效的输入，我们可以通过以下方式计算组合：
        ◦ 把输入的名字拆成 first, middle, and last
        ◦ 分别抽取出它们的首字母
        ◦ 把上面抽出的三个字母串接起来


第2步编码
		String name, first, middle, last, space, monogram;

		space = " ";
		// Input the full name
		name = JOptionPane.showInputDialog(null, "Enter your full name (first, middle, last): ");
		// Extract first, middle, and last names
		first = name.substring(0, name.indexOf(space));
		name = name.substring(name.indexOf(space) + 1, name.length());
		middle = name.substring(0, name.indexOf(space));
		last = name.substring(name.indexOf(space) + 1, name.length());
		// Compute the monogram
		monogram = first.substring(0, 1) + middle.substring(0, 1) + last.substring(0, 1);
		// Output the result
		JOptionPane.showMessageDialog(null, "Your 	monogram is " + monogram);

第2步测试
    • 在测试阶段，我们运行程序并验证对于所有有合法输入值，都能正确地显示字母组合.
    • 多运行几次，一次正确的运行是不够的，我们得多试几种不同的有效输入.

程序回顾
    • 程序员的工作还没有完.
    • 一旦开发出了可以运行的程序, 我们还得再仔细地看一下是否还有没考虑到的特性或都有没有提高的余地。 
    • 一个小建议
        ◦ 改进最初的提示以便用户知道合法的输入格式需要在first, middle, and last names之间加空格
*/ 

package experiment01;

import javax.swing.JOptionPane;

public class Test02 {

	public static void main(String[] args) {
		
		String name, first, middle, last, space, monogram;

		space = " ";
		// Input the full name
		name = JOptionPane.showInputDialog(null, "Enter your full name (first middle last): ");
		// Extract first, middle, and last names
		first = name.substring(0, name.indexOf(space));
		name = name.substring(name.indexOf(space) + 1, name.length());
		middle = name.substring(0, name.indexOf(space));
		last = name.substring(name.indexOf(space) + 1, name.length());
		// Compute the monogram
		monogram = first.substring(0, 1) + middle.substring(0, 1) + last.substring(0, 1);
		// Output the result
		JOptionPane.showMessageDialog(null, "Your monogram is " + monogram);
	}

}
