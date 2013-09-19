
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * @author forwil(���ΰ 11091222 110641��)
 * @version 3.0 2012-12-30 
 * 
 */
public class Snake  implements  KeyListener{
	
	/**
	 * ����ٶ�ˢ����{@value}
	 */
	static final int MAXSPEED = 10;
	/**
	 * �����ٶ�ˢ����{@value}
	 */
	static final int MINSPEED = 100;
	/**
	 * ��󳤶�
	 */
	static final int MAXLENGTH = 1000;
	
	/**����*/
	private int length=0; 
	/**�ٶ�*/
	private int speed=100;
	/**�������*/
	private boolean isalive=false;
	/**����*/
	private int direct=0;
	/**��������*/
	public Body[] body=new Body[MAXLENGTH];
	/**�ߵĳߴ�*/
	private int size=10;
	/**��ɫ*/
	private Color color=Color.BLUE;
	/**ͨ������*/
	boolean[][] isexist = new boolean[Myframe.MAXX/10+5][Myframe.MAXY/10+5];
	/**�ܷ���Ƥ*/
	private boolean dlens=true;
	/**�´η���*/
	public int newdirect=1;

	/**
	 * �½�һֻ�� ����Ƥ�趨
	 * @param x
	 * @param y
	 * @param length
	 * @param speed
	 * @param direct
	 * @param dlens
	 */
	public Snake(int x,int y,int length, int speed,int direct,boolean dlens)
	{
	this.length=length;
	this.speed=speed;
	this.newdirect=direct;
	this.isalive=true;
	this.dlens=dlens;
	
	for(int i=0;i<MAXLENGTH;i++) body[i]=new Body();
		
	for(int i=0;i<length;i++)
		{
		this.body[i].setX(x-i*size);
		this.body[i].setY(y);
		}
	
	for(int i=0;i<=Myframe.MAXX/10;i++)
	for(int j=0;j<=Myframe.MAXY/10;j++)
			outpoint(i,j);
	
	
	for(int i=0;i<length;i++)
		{
		inpoint(body[i].getX()/10,body[i].getY()/10);
		}
	
	}
	
/**
 * �½�һֻ�ߣ�
 * @param x
 * @param y
 * @param length
 * @param speed
 * @param direct
 */
	public Snake(int x,int y,int length, int speed,int direct)
	{
	this.length=length;
	this.speed=speed;
	this.direct=direct;
	this.isalive=true;
	
	for(int i=0;i<MAXLENGTH;i++) body[i]=new Body();
	
	
	for(int i=0;i<length;i++)
		{
		this.body[i].setX(x-i*size);
		this.body[i].setY(y);
		}
	
	for(int i=0;i<=Myframe.MAXX/10;i++)
	for(int j=0;j<=Myframe.MAXY/10;j++)
			outpoint(i,j);
	
	
	for(int i=0;i<length;i++)
		{
		inpoint(body[i].getX()/10,body[i].getY()/10);
		}
	
	}
	


/**
 * �����޷�ͨ��
 * @param x
 * @param y
 */
	public void inpoint(int x, int y)
	{
		isexist[x][y]=true;
	}
	
/**
 * ������ͨ��
 * @param x
 * @param y
 */
	public void outpoint(int x, int y)
	{
		isexist[x][y]=false;
	}
	
/**
 * ���س���
 * @return length
 */
	public int getLength() 
	{
		return length;
	}
	
/**
 * ���ó���
 * @param length
 */
	public void setLength(int length) 
	{
		this.length = length;
	}
	
/**
 * �����ٶ�
 * @return speed
 */
	public int getSpeed() 
	{
		return speed;
	}
	
/**
 * �����ٶ�
 * @param speed
 */
	public void setSpeed(int speed) 
	{
		this.speed = speed;
	}
	
/**
 * �����������
 * @return isalive
 */
	public boolean getIsalive() 
	{
		return isalive;
	}
	

/**
 * *�����������
 * 
 * @param isalive
 */
 
	public void setIsalive(boolean isalive) 
	{
		this.isalive = isalive;
	}
	
/**
 * ���ط���
 * @return direct
 */
	public int getDirect() 
	{
		return direct;
	}

/**
 * ���÷���
 * 0 Ϊ ��
 * 1 Ϊ ��
 * 2 Ϊ ��
 * 3 Ϊ ��
 * @param direct
 */
	public void setDirect(int direct) 
	{
		this.direct = direct;
	}

/**
 * ���ش�С
 * @return size
 */
	public int getSize() 
	{
		return size;
	}

/**
 * ���ô�С
 * @param size
 */
	public void setSize(int size) 
	{
		this.size = size;
	}

/**
 * ������ɫ
 * @return color
 */
	public Color getColor() 
	{
		return color;
	}

/**
 * ������ɫ	
 * @param color
 */
	public void setColor(Color color) 
	{
		this.color = color;
	}
	
	
/**
 * ��Ƥ
 * @return ture or false
 */
	public boolean dlen()
	{
		//if the snake real can delength
		if (length>=2)
		{
			outpoint(body[length-1].getX()/10,body[length-1].getY()/10);
			length=length-1;
			return true;
		}
		else return false;
	}
/**
 * ����
 */
	public void pspeed()
	{
	if (speed-10>=Myframe.RENEW && speed-10>=MAXSPEED)
	speed-=10;	
	}
/**
 * ����
 */
	public void dspeed()

	{
	if (speed+10<=MINSPEED)
	speed+=10;	
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		//change the direct of the snake 
		if ((arg0.getKeyCode()==KeyEvent.VK_UP ||
			 arg0.getKeyCode()==KeyEvent.VK_W) && direct!=2) newdirect=0;
		
		if ((arg0.getKeyCode()==KeyEvent.VK_RIGHT ||
			 arg0.getKeyCode()==KeyEvent.VK_D) && direct!=3) newdirect=1;
		
		if ((arg0.getKeyCode()==KeyEvent.VK_DOWN ||
			 arg0.getKeyCode()==KeyEvent.VK_S) && direct!=0) newdirect=2;
		
		if ((arg0.getKeyCode()==KeyEvent.VK_LEFT ||
			 arg0.getKeyCode()==KeyEvent.VK_A) && direct!=1) newdirect=3;
		
		//if we push j,we let the speed faster double
		if (arg0.getKeyCode()==KeyEvent.VK_J) pspeed();
		
		//if we push k,we let the speed slow double
		if (arg0.getKeyCode()==KeyEvent.VK_K) dspeed();
		
		//if we push l,we can delength the snake! that is interesting!
		if (arg0.getKeyCode()==KeyEvent.VK_L && dlens==true) 
			{
			if (dlen() )
				{
				// add the block to
				Myframe.state1.mb.newBlock(this,Color.WHITE,1);	

				}
			}

	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}