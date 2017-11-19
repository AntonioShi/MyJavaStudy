package otherPeople;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

class RoseCanvas extends JPanel // �������
{
	private Color color; // ��ɫ

	public RoseCanvas(Color color) {
		this.setColor(color);
	}

	public void setColor(Color color) {
		this.color = color;
		this.repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(color); // ������ɫ
		g.fillOval(200, 100, 200, 200);
	}
}

public class RoseJFrame extends JFrame {
	private RoseCanvas canvas; // �Զ��廭�����
	private JPopupMenu popupMenu; // ����һ��JPopupMenu�˵�

	public RoseJFrame() {
		super("Բ");
		JPopupMenu.setDefaultLightWeightPopupEnabled(false);
		Dimension dim = getToolkit().getScreenSize(); // �����Ļ�ֱ���
		this.setBounds(dim.width / 4, dim.height / 4, dim.width / 2, dim.height / 2); // ���ھ���
		canvas = new RoseCanvas(Color.red); // �����Զ��廭�����
		add(canvas);
		popupMenu = new JPopupMenu(); // ��������JPopupMenu�˵���
		JMenuItem redItem = new JMenuItem("red");
		JMenuItem greenItem = new JMenuItem("green");
		JMenuItem yellowItem = new JMenuItem("yellow");
		greenItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setColor(Color.green);
			}
		});
		redItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setColor(Color.red);
			}
		});
		yellowItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setColor(Color.yellow);
			}
		});
		popupMenu.add(redItem);
		popupMenu.add(greenItem);
		popupMenu.add(yellowItem);
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String args[]) {
		new RoseJFrame();
	}
}