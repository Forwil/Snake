
/**
 * @author forwil(���ΰ 11091222 110641��)
 * @version 3.0 2012-12-30 
 * 
 */
import javax.swing.*;

public class Myframe extends JFrame implements Runnable{
/**ˢ���� {@value}*/
	public static final int RENEW = 10;
/**������ {@value}*/
	public static final int MAXX=400;
/**���峤�� {@value}*/
	public static final int MAXY=300;
/**��Ϸ����*/
	public static State1 state1=null;
/**��Ϸ����*/
	public static Myframe MF=null;
/**
 * �������
 * @param args
 */
	public static void main(String[] args) {
		
		int n=0;
		//input the gamemode
		n = Integer.parseInt(JOptionPane.showInputDialog("����ģʽ:1Ϊ����ģʽ��0Ϊfreeģʽ"));
		//if illegal then reinput
	
		while (n!=0 && n!=1)
			{
			n = Integer.parseInt(JOptionPane.showInputDialog("������������������:1Ϊ����ģʽ��0Ϊfreeģʽ��"));
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
 * ��ʼ��
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
 * ����ˢ����
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