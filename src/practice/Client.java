package practice;

import java.io.*;
import java.net.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/*
 * 这个算是客户端吧
 * */
public class Client {

	public static void main(String[] args) throws Exception {
		// 新建一个登录的UI界面
		new LoginUI();
	}
}

/*
 * TCP客户端
 */
class LoginUI extends JFrame implements ActionListener {

	// 定义登录界面的组件
	JButton loginButton, registeredButton, exitButton = null;// 按钮
	JPanel usernamePanel, passwordPanel, buttonPanel = null; // 面板
	JTextField username, password = null;// 帐号密码的文本框
	JLabel usernameLabel, passwordLabel = null;// 帐号密码的标签

	public LoginUI() {
		// 新建登录，退出，注册按钮
		loginButton = new JButton("登录");
		registeredButton = new JButton("注册");
		exitButton = new JButton("退出");

		// 设置监听
		loginButton.addActionListener(this);
		registeredButton.addActionListener(this);
		exitButton.addActionListener(this);

		// 新建帐号密码的标签
		usernameLabel = new JLabel("用户名：");
		passwordLabel = new JLabel("密  码：");

		// 新建帐号密码的文本框
		username = new JTextField(10);
		password = new JTextField(10);

		// 新建三个面板
		usernamePanel = new JPanel();
		passwordPanel = new JPanel();
		buttonPanel = new JPanel();

		// 面板1中,添加帐号有关，
		usernamePanel.add(usernameLabel);
		usernamePanel.add(username);

		// 面板2中,添加密码有关，
		passwordPanel.add(passwordLabel);
		passwordPanel.add(password);

		// 面板3中,按钮有关，
		buttonPanel.add(loginButton);
		buttonPanel.add(registeredButton);
		buttonPanel.add(exitButton);

		// 添加这三个面板到窗口
		this.add(usernamePanel);
		this.add(passwordPanel);
		this.add(buttonPanel);

		// 窗口有关配置
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("注册登录界面");// 窗口名
		this.setLayout(new GridLayout(3, 1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 200, 300, 180);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// 监听各个按钮
		if (e.getActionCommand() == "退出") {
			System.exit(0);// 退出
		} else if (e.getActionCommand() == "登录") {
			try {
				this.login();// 调用登录方法
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getActionCommand() == "注册") {
			this.Regis();// 调用注册方法
		}

	}

	// 注册方法
	public void Regis() {
		this.dispose(); // 关闭当前界面
		new RegisteredUI(); // 打开新界面
	}

	public void login() throws Exception {
		final int PORT = 7788;
		Socket client = new Socket(InetAddress.getLocalHost(), PORT);
		OutputStream os  = client.getOutputStream();
		os.write(("1").getBytes());//表示注册还是登录
		os.write(("username").getBytes());//用户名标记
		os.write(username.getText().getBytes());//用户名
		os.write(("password").getBytes());//密码标记
		os.write(password.getText().getBytes());//密码
		
		InputStream is = client.getInputStream();
		byte[] buf = new byte[1024];
		int len = is.read(buf);
		System.out.println(new String(buf, 0, len));
		client.close();
	}
}

/*
 * 注册界面。
 */
class RegisteredUI extends JFrame implements ActionListener {

	// 定义组件
	JPanel usernamePanel, passwordPanel, buttonPanel = null; // 面板
	JLabel usernameLabel, passwordLabel;
	JTextField username, password;
	JButton blackButton, registeredButton;

	public RegisteredUI() {
		// 初始化组件
		usernameLabel = new JLabel(" 请输入用户名：");
		username = new JTextField(10);
		passwordLabel = new JLabel(" 请输入密码：");
		password = new JTextField(10);

		blackButton = new JButton("返回");
		registeredButton = new JButton("注册");
		blackButton.addActionListener(this);
		registeredButton.addActionListener(this);

		// 新建三个面板
		usernamePanel = new JPanel();
		passwordPanel = new JPanel();
		buttonPanel = new JPanel();

		// 面板1中,添加帐号有关，
		usernamePanel.add(usernameLabel);
		usernamePanel.add(username);

		// 面板2中,添加密码有关，
		passwordPanel.add(passwordLabel);
		passwordPanel.add(password);

		// 面板3中,按钮有关，
		buttonPanel.add(blackButton);
		buttonPanel.add(registeredButton);

		// 添加这三个面板到窗口
		this.add(usernamePanel);
		this.add(passwordPanel);
		this.add(buttonPanel);

		// 窗口有关配置
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("注册界面");
		this.setLayout(new GridLayout(3, 1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 200, 300, 180);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "返回") {
			this.dispose();
			new LoginUI();

		} else if (e.getActionCommand() == "注册") {
			try {
				this.registered();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/*
	 * 注册的方法
	 */
	public void registered() throws Exception {
		// 调用注册方法/先检查要注册的用户名是否存在
		final int PORT = 7788;//定义服务器的端口号
		Socket client = new Socket(InetAddress.getLocalHost(), PORT);
		OutputStream os  = client.getOutputStream();
		os.write(("2").getBytes());//表示注册还是登录
		os.write(("username").getBytes());//用户名标记
		os.write(username.getText().getBytes());//用户名
		os.write(("password").getBytes());//密码标记
		os.write(password.getText().getBytes());//密码
		
		InputStream is = client.getInputStream();
		byte[] buf = new byte[1024];
		int len = is.read(buf);
		System.out.println(new String(buf, 0, len));
		client.close();
	}
}
