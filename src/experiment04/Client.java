package experiment04;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * 客户端的界面类
 * 
 * @author niracler
 *
 */
class Client extends JFrame implements ActionListener {
	BankSystem bankSystem;// 这就是银行系统
	// 定义界面的组件
	JButton inputGeneralButton, inputVipButton = null;// 按钮
	JPanel buttonPanel = null; // 面板
	JLabel timeLabel = null;// 帐号密码的标签

	public static void main(String[] args) {
		new Client();
	}

	/**
	 * 构造方法，构造窗口之类的
	 */
	public Client() {
		bankSystem = new BankSystem();

		// 新建登录，退出，注册按钮
		inputGeneralButton = new JButton("普通用户");
		inputVipButton = new JButton("vip用户");

		// 设置监听
		inputGeneralButton.addActionListener(this);
		inputVipButton.addActionListener(this);

		// 新建三个面板
		buttonPanel = new JPanel();

		// 面板3中,按钮有关，
		buttonPanel.add(inputGeneralButton);
		buttonPanel.add(inputVipButton);

		// 添加这三个面板到窗口
		this.add(buttonPanel);

		// 窗口有关配置
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("欢迎来到东莞理工银行");// 窗口名
		this.setLayout(new GridLayout(3, 1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 200, 300, 100);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// 监听拿票按钮,每每按到这个按钮就会执行一次
		if (e.getActionCommand() == "普通用户") {
			//入队
			bankSystem.inputGeneral();
			
		} else if (e.getActionCommand() == "vip用户") {
			//获取时间与票号
			bankSystem.inputVip();
		}
	}
}