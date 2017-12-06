/*题目1：
项目：计算未来投资价值
问题描述：
编写一份写入投资金额，年利率和年数的计划，并使用以下公式显示未来投资值：
并使用以下公式显示未来投资值：
futureInvestmentValue =
  投资额（x + 1），（1 + monthInterestRate）numberOfYears * 12
例如，如果输入数量1000，年利率3.25％，年数1，未来投资价值为1032.98。
提示：使用Math.pow（a，b）方法计算一个提高到b的幂。
这是一个示例运行：

样品1：
输入投资金额：1000
输入月利率：4.25
输入年数：1
累积值为1043.34

样品2：s
输入投资金额：1000
输入月利率：4.25
输入年数：1
累积值为1043.34 
*/

package experiment01;

import javax.swing.JOptionPane;

public class Test01 {

	public static void main(String[] args) {

		// 输入部分
		String str = JOptionPane.showInputDialog(null, "输入投资金额：");
		int investmentAmount = Integer.parseInt(str);
		str = JOptionPane.showInputDialog(null, "输入月利率：");
		double monthlyInterestRate = Double.parseDouble(str);
		str = JOptionPane.showInputDialog(null, "输入年数：");
		int numberOfYears = Integer.parseInt(str);

		// 运算部分
		double futureInvestmentValue = investmentAmount * Math.pow((1 + monthlyInterestRate * numberOfYears/1200), 12);

		// 输出部分
		System.out.println("积累值为" + futureInvestmentValue);
	}

}
