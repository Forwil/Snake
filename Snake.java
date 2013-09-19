
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * @author forwil(余锋伟 11091222 110641班)
 * @version 3.0 2012-12-30 
 * 
 */
public class Snake  implements  KeyListener{
	
	/**
	 * 最大速度刷新率{@value}
	 */
	static final int MAXSPEED = 10;
	/**
	 * 徐晓速度刷新率{@value}
	 */
	static final int MINSPEED = 100;
	/**
	 * 最大长度
	 */
	static final int MAXLENGTH = 1000;
	
	/**长度*/
	private int length=0; 
	/**速度*/
	private int speed=100;
	/**死亡标记*/
	private boolean isalive=false;
	/**方向*/
	private int direct=0;
	/**身体数组*/
	public Body[] body=new Body[MAXLENGTH];
	/**蛇的尺寸*/
	private int size=10;
	/**颜色*/
	private Color color=Color.BLUE;
	/**通行数组*/
	boolean[][] isexist = new boolean[Myframe.MAXX/10+5][Myframe.MAXY/10+5];
	/**能否蜕皮*/
	private boolean dlens=true;
	/**下次方向*/
	public int newdirect=1;

	/**
	 * 新建一只蛇 带蜕皮设定
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
 * 新建一只蛇，
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
 * 设置无法通行
 * @param x
 * @param y
 */
	public void inpoint(int x, int y)
	{
		isexist[x][y]=true;
	}
	
/**
 * 设置能通行
 * @param x
 * @param y
 */
	public void outpoint(int x, int y)
	{
		isexist[x][y]=false;
	}
	
/**
 * 返回长度
 * @return length
 */
	public int getLength() 
	{
		return length;
	}
	
/**
 * 设置长度
 * @param length
 */
	public void setLength(int length) 
	{
		this.length = length;
	}
	
/**
 * 返回速度
 * @return speed
 */
	public int getSpeed() 
	{
		return speed;
	}
	
/**
 * 设置速度
 * @param speed
 */
	public void setSpeed(int speed) 
	{
		this.speed = speed;
	}
	
/**
 * 返回死亡标记
 * @return isalive
 */
	public boolean getIsalive() 
	{
		return isalive;
	}
	

/**
 * *设置死亡标记
 * 
 * @param isalive
 */
 
	public void setIsalive(boolean isalive) 
	{
		this.isalive = isalive;
	}
	
/**
 * 返回方向
 * @return direct
 */
	public int getDirect() 
	{
		return direct;
	}

/**
 * 设置方向
 * 0 为 上
 * 1 为 右
 * 2 为 下
 * 3 为 左
 * @param direct
 */
	public void setDirect(int direct) 
	{
		this.direct = direct;
	}

/**
 * 返回大小
 * @return size
 */
	public int getSize() 
	{
		return size;
	}

/**
 * 设置大小
 * @param size
 */
	public void setSize(int size) 
	{
		this.size = size;
	}

/**
 * 返回颜色
 * @return color
 */
	public Color getColor() 
	{
		return color;
	}

/**
 * 设置颜色	
 * @param color
 */
	public void setColor(Color color) 
	{
		this.color = color;
	}
	
	
/**
 * 蜕皮
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
 * 加速
 */
	public void pspeed()
	{
	if (speed-10>=Myframe.RENEW && speed-10>=MAXSPEED)
	speed-=10;	
	}
/**
 * 减速
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