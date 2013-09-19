
/**
 * @author forwil(余锋伟 11091222 110641班)
 * @version 3.0 2012-12-30 
 * 
 */
import javax.swing.*;

public class Myframe extends JFrame implements Runnable{
/**刷新率 {@value}*/
	public static final int RENEW = 10;
/**窗体宽度 {@value}*/
	public static final int MAXX=400;
/**窗体长度 {@value}*/
	public static final int MAXY=300;
/**游戏界面*/
	public static State1 state1=null;
/**游戏窗体*/
	public static Myframe MF=null;
/**
 * 程序入口
 * @param args
 */
	public static void main(String[] args) {
		
		int n=0;
		//input the gamemode
		n = Integer.parseInt(JOptionPane.showInputDialog("输入模式:1为闯关模式，0为free模式"));
		//if illegal then reinput
	
		while (n!=0 && n!=1)
			{
			n = Integer.parseInt(JOptionPane.showInputDialog("输入有误，请重新输入:1为闯关模式，0为free模式。"));
			}
	
		//new a frame
		MF = new Myframe();
		state1=new State1(n);
		Thread t1=new Thread(MF);
		t1.start();
		Thread t0=new Thread(state1);		
		t0.start();
		MF.add(state1);	
		
		//set can see
		MF.setVisible(true);
		
	}
	
/**
 * 初始化
 */
	public Myframe()
	{
		this.setSize(MAXX+17, MAXY+130);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Snake!v3.0");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}


/**
 * 设置刷新率
 */
public void run() {
	
	while(true)
	{
		try
		{
			Thread.sleep(RENEW);
			
		}catch(Exception e) {};
		//repaint the window
		this.repaint();
		
		
	}
	
}
}