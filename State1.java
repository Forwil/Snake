
/**@author forwil (余锋伟 11091222 110641班)
 * @version 3.0 2012-12-30 
 * 增加掉尾巴功能
 * 增加传送门类
 *  
 */
import javax.swing.*;

import java.awt.*;

public class State1 extends JPanel implements Runnable {

/**最大过关需吃数，值为{@value}*/
public static final int  MAXPOINT=20;
/**递增吃数，值为{@value}*/
public static final int  FINISH=3;
/**蛇类*/
public static Snake ms=null;
/**实物类*/
public static Food mf=null;
/**障碍类*/
public static Block mb=null;
/**关卡数*/
public static int n=1;
/**临时锁*/
public static boolean k=true;
/**传送门类*/
public static Doors md=null;

/**
 * 初始进入的管卡。
 * 
 * @param x int 从第x关开始
 */

public State1(int x)
	{
	this.setBackground(Color.BLACK);
	n=x;
	// start default game mode
	State(n);
	}
/**
 * 调用弟x关
 * 
 * @param x int 关卡数
 * 
 */
public static void State(int x)
{
	
	Myframe.MF.removeKeyListener(ms);
//state0 for free mode	
if (x==0)
	{
	ms=new Snake(50,70,1,100,1,true);	
	mf=new Food(100,100);
	mb=new Block(true);
	md=new Doors();
	Myframe.MF.addKeyListener(ms);
	}

//state1 is very easy
if (x==1)
	{
	ms=new Snake(50,70,1,100,1);	
	mf=new Food(100,100);
	mb=new Block(true);
	md=new Doors();
	
	Myframe.MF.addKeyListener(ms);
//paint the map	
	for (int i=1;i<21;i++)
		addblock(10+i,15);
	}

//state2 
if (x==2)
	{
	ms=new Snake(60,80,1,100,1);	
	mf=new Food(100,100);
	Myframe.MF.addKeyListener(ms);
	mb=new Block(true);
	md=new Doors();
//paint state2
	for (int i=1;i<11;i++)
		addblock(i,11-i);		
	for (int i=1;i<11;i++)
		addblock(29+i,i);	
	for (int i=1;i<11;i++)
		addblock(13,20+i);
	for (int i=1;i<11;i++)
		addblock(28,20+i);
	for (int i=1;i<15;i++)
		addblock(13+i,20);
	}

//state3
if (x==3)
	{
	ms=new Snake(80,70,1,100,1);	
	mf=new Food(150,100);
	Myframe.MF.addKeyListener(ms);
	mb=new Block(true);
	md=new Doors();
//paint state3 map
	for (int i=0;i<11;i++)
		addblock(i,19);		
	for (int i=0;i<9;i++)
		addblock(18,i);	
	for (int i=1;i<11;i++)
		addblock(10,i+8);	
	for (int i=1;i<31;i++)
		addblock(10+i,9);
	for (int i=1;i<11;i++)
		addblock(20,9+i);
	for (int i=1;i<6;i++)
		addblock(15+i,20);
	for (int i=1;i<12;i++)
		addblock(15,19+i);
	}
	
//state 4
if (x==4)
	{
	ms=new Snake(50,50,1,100,1);	
	mf=new Food(140,130);
	md=new Doors();
	mb=new Block(true);
	Myframe.MF.addKeyListener(ms);
//paint state 4 map
	for(int i=0;i<20;i++)
	addblock(10+i,10);
	for(int i=0;i<15;i++)
	addblock(10,11+i);
	for(int i=0;i<15;i++)
	addblock(30,10+i);
	for(int i=0;i<20;i++)
	addblock(11+i,25);
	
	md.addDoors(200, 150, 350, 40);
	}
//state5
	if (x==5)
	{
	ms=new Snake(50,50,1,100,1);	
	mf=new Food(140,130);
	Myframe.MF.addKeyListener(ms);
	mb=new Block(true);
	md=new Doors();
//paint state5 map
	for (int i=0;i<18;i++)
		addblock(i,10);
	for (int i=0;i<23;i++)
		addblock(i+18,5);
	for (int i=0;i<6;i++)
		addblock(18,5+i);

	for (int i=0;i<23;i++)
		addblock(i,15);
	for (int i=0;i<18;i++)
		addblock(i+23,10);
	for (int i=0;i<6;i++)
		addblock(23,10+i);
	
	for (int i=0;i<28;i++)
		addblock(i,20);
	for (int i=0;i<13;i++)
		addblock(i+28,15);
	for (int i=0;i<6;i++)
		addblock(28,15+i);
	}
	
//state6
	if (x==6)
	{
	ms=new Snake(50,50,1,100,1);	
	mf=new Food(150,100);
	Myframe.MF.addKeyListener(ms);
	mb=new Block(true);
	md=new Doors();
//paint state6 map
	for (int i=1;i<8;i++)
		addblock(i-1,15-i);
	for (int i=1;i<8;i++)
		addblock(i-1,15+i);
	for (int i=0;i<8;i++)
		addblock(i+7,7+i);
	for (int i=0;i<9;i++)
		addblock(15-i,15+i);
	for (int i=0;i<9;i++)
		addblock(15+i,15);
	for (int i=0;i<16;i++)
		addblock(23+i,15-i);
	for (int i=0;i<16;i++)
		addblock(23+i,15+i);
	
		addblock(14,15);
		addblock(24,15);
	}

//state 7
	if (x==7)
	{
	ms=new Snake(50,50,1,100,1);	
	mf=new Food(130,150);
	Myframe.MF.addKeyListener(ms);
	mb=new Block(true);
	md=new Doors();
//paint state7
	for (int i=0;i<41;i++)
		addblock(i,0);
	for (int i=0;i<41;i++)
		addblock(i,31);
	for (int i=0;i<31;i++)
		addblock(0,i);
	for (int i=0;i<31;i++)
		addblock(40,i);
	for (int i=0;i<21;i++)
		addblock(10+i,10);
	for (int i=0;i<21;i++)
		addblock(10+i,20);
	for (int i=0;i<10;i++)
		addblock(20,11+i);
	}
//state 8
	if (x==8)
	{
	ms=new Snake(50,50,1,100,1);	
	mf=new Food(130,150);
	Myframe.MF.addKeyListener(ms);
	mb=new Block(true);
	md=new Doors();
//paint state8
	for (int i=0;i<41;i++)
		addblock(i,0);
	for (int i=0;i<41;i++)
		addblock(i,31);
	for (int i=0;i<31;i++)
		addblock(0,i);
	for (int i=0;i<31;i++)
		addblock(40,i);
	
	for (int i=0;i<21;i++)
		addblock(10+i,10);
	for (int i=0;i<21;i++)
		addblock(10+i,20);
	for (int i=0;i<10;i++)
		addblock(10,11+i);
	for (int i=0;i<10;i++)
		addblock(30,11+i);
	
	md.addDoors(200, 150, 350, 40);
		}
//state 9
	if (x==9)
	{
	ms=new Snake(50,50,1,100,1);	
	mf=new Food(250,200);
	Myframe.MF.addKeyListener(ms);
	mb=new Block(true);
	md=new Doors();
//paint state9
	
	for (int i=0;i<41;i++)
		addblock(i,0);
	for (int i=0;i<41;i++)
		addblock(i,31);
	for (int i=0;i<31;i++)
		addblock(0,i);
	for (int i=0;i<31;i++)
		addblock(40,i);
	for (int i=0;i<41;i++)
		addblock(i,15);
	for (int i=0;i<31;i++)
		addblock(20,i);
	
	md.addDoors(190, 80, 210, 80);
	md.addDoors(190, 240, 210, 240);
	md.addDoors(100, 140, 100, 160);
	md.addDoors(300, 140, 300, 160);
	}
	
//state 10
	if (x==10)
	{
	ms=new Snake(200,150,1,100,1);	
	mf=new Food(250,200);
	Myframe.MF.addKeyListener(ms);
	mb=new Block(true);
	md=new Doors();
//paint state10
		
	for (int i=0;i<11;i++)
		addblock(i,10);
	for (int i=0;i<11;i++)
		addblock(30+i,10);
	for (int i=0;i<11;i++)
		addblock(i,20);
	for (int i=0;i<11;i++)
		addblock(30+i,20);
	for (int i=0;i<11;i++)
		addblock(10,i);
	for (int i=0;i<11;i++)
		addblock(30,i);
	for (int i=0;i<11;i++)
		addblock(30,20+i);
	for (int i=0;i<11;i++)
		addblock(10,20+i);
	md.addDoors(190, 180, 350, 230);
	}

//state 11
if (x==11)
	{
	ms=new Snake(50,60,1,100,1);	
	mf=new Food(140,130);
	md=new Doors();
	mb=new Block(true);
	Myframe.MF.addKeyListener(ms);
//paint state 11 map
	for(int i=0;i<20;i++)
	addblock(10+i,10);
	for(int i=0;i<15;i++)
	addblock(10,11+i);
	for(int i=0;i<15;i++)
	addblock(30,10+i);
	for(int i=0;i<20;i++)
	addblock(11+i,25);
	
	for(int i=0;i<30;i++)
	addblock(5+i,5);
	for(int i=0;i<26;i++)
	addblock(5,5+i);
	for(int i=0;i<26;i++)
	addblock(35,5+i);
	md.addDoors(200, 150, 350, 40);
	}
if (x==12)
{
	ms=new Snake(50,40,1,100,1);	
	mf=new Food(130,130);	
	md=new Doors();
	mb=new Block(true);
	Myframe.MF.addKeyListener(ms);
//paint state 12 map
	for(int i=0;i<2;i++)
		addblock(15,13-i);
	for(int i=0;i<3;i++)
		addblock(15+i,11);
	for(int i=0;i<6;i++)
		addblock(18,11+i);
	for(int i=0;i<10;i++)
		addblock(18-i,17);
	for(int i=0;i<10;i++)
		addblock(8,17-i);
	for(int i=0;i<25;i++)
		addblock(8+i,7);
	for(int i=0;i<19;i++)
		addblock(32,8+i);
	for(int i=0;i<25;i++)
		addblock(31-i,26);
		addblock(7,27);
		addblock(8,27);

	}
if (x==13)
	{
	ms=new Snake(50,20,1,100,1);	
	mf=new Food(130,130);	
	md=new Doors();
	mb=new Block(true);
	Myframe.MF.addKeyListener(ms);
//paint state 13 map
	for(int i=0;i<20;i++)
		addblock(5,5+i);
	for(int i=0;i<20;i++)
		addblock(10,5+i);
	for(int i=0;i<20;i++)
		addblock(15,5+i);
	for(int i=0;i<20;i++)
		addblock(20,5+i);
	for(int i=0;i<20;i++)
		addblock(25,5+i);
	for(int i=0;i<20;i++)
		addblock(30,5+i);
	for(int i=0;i<20;i++)
		addblock(35,5+i);
	
	for(int i=0;i<5;i++)
		addblock(i+6,24);
	for(int i=0;i<5;i++)
		addblock(i+11,5);
	for(int i=0;i<5;i++)
		addblock(i+21,5);
	for(int i=0;i<5;i++)
		addblock(i+16,24);
	for(int i=0;i<5;i++)
		addblock(i+31,5);
	for(int i=0;i<5;i++)
		addblock(i+26,24);
	}

}

/**
 * 画出障碍物的图形
 * 
 * @param g 
 */
public void paintBlock(Graphics g)
	{
	
	for (int i=0;i<mb.getNum();i++)
		{
		g.setColor(mb.body[i].getColor());
		g.fillRect(mb.body[i].getX(), mb.body[i].getY(),10,10);
		g.setColor(Color.black);
		g.drawRect(mb.body[i].getX(), mb.body[i].getY(),10,10);
		}
	
	}

/**
 * 画出食物的图形，本游戏中为苹果
 * 
 * @param g
 */
public void paintFood(Graphics g)
	{
	
	g.setColor(Color.RED);
	g.fillOval(mf.body.getX()+3, mf.body.getY()+3, 6, 6);
	g.setColor(Color.YELLOW);
	g.drawOval(mf.body.getX()+2, mf.body.getY()+2, 8, 8);
	g.drawLine(mf.body.getX()+5, mf.body.getY()+3,mf.body.getX()+4, mf.body.getY()-2);
	
	}

/**
 * 画出蛇，本游戏中为黄头绿身体的蛇
 * 
 * @param g
 */
public void paintSnake(Graphics g)
	{
	
	for (int i=0; i < ms.getLength();i++)
		{
		g.setColor(Color.BLUE);
		g.drawRect(ms.body[i].getX(), ms.body[i].getY(), ms.getSize(), ms.getSize());
		if (i==0) g.setColor(Color.YELLOW);	else g.setColor(Color.GREEN);
		g.fillRect(ms.body[i].getX()+1, ms.body[i].getY()+1, ms.getSize()-1, ms.getSize()-1);
		}

	}

/**
 * 画出传送门
 * 
 * @param g
 */
public void paintDoors(Graphics g)
	{
	
	for (int i=0;i<md.getNum();i++)
		{
		g.setColor(new Color(100,i*50,0));
		g.fillRect(md.body[i][0].getX(), md.body[i][0].getY(),10,10);
		g.fillRect(md.body[i][1].getX(), md.body[i][1].getY(),10,10);	
		g.setColor(new Color(100,0,i*50));
		g.fillRect(md.body[i][0].getX()+2, md.body[i][0].getY()+2,6,6);
		g.fillRect(md.body[i][1].getX()+2, md.body[i][1].getY()+2,6,6);	
		g.setColor(Color.YELLOW);
		}
	}

/**
 * 画出提示信息
 * 
 * @param g
 */
public void paintInfo(Graphics g)
	{
	
	g.setColor(Color.white);
	g.drawString("Your Speed :   "+(100-ms.getSpeed())/10, 2, 370);
	
	g.drawString("Your Point    :   ", 2, 340);
	
	g.drawString("Your Length:   "+ms.getLength(), 2, 355);
	
	//g.drawString("Your NB:   "+mb.getNum(), 2, 370);
	g.setColor(Color.white);
//	g.drawString("x: "+ms.body[0].getX()+" y:"+ms.body[0].getY(),300,340);
	g.drawString(" All Copyright Reserved by Forwil 2012",200, 400);
	g.drawRect(0, 0, 410, 310);	
	
	g.setColor(Color.YELLOW);
	g.drawString("State:"+n, 2, 325);
	g.drawString("操作指南：WSAD分别为上下左右，JK分别为加速，减速。L为掉尾巴。", 2, 385);
	
	}

/**
 * 画出已得分数
 * 
 * @param g
 */
public void paintPoint(Graphics g)
	{
	
		for (int i=0;i< ms.getLength()-1;i++)
	
		{
		g.setColor(Color.RED);
		g.fillOval(80+i*10,332,6, 6);
		}
		
	g.setColor(Color.YELLOW);
	
	for (int i=0;i< getn()-1;i++)
		{
		g.drawOval(79+i*10, 331, 8, 8);
		g.drawLine(82+i*10, 332, 81+i*10, 327);
		}
	
	}

/**
 * 重写paint函数
 * 
 */
public void paint(Graphics g)
{
	
	super.paint(g);
	paintBlock(g);
	paintFood(g);
	paintSnake(g);
	paintSnake(g);
	paintDoors(g);
	paintInfo(g);
//if it is free mode we don't need point
	if (n!=0) paintPoint(g);
	
}

/**
 * 增加障碍
 * @param x 
 * @param y
 */
public static void addblock(int x, int y)
{
	
	mb.addBlock(x*10,y*10,Color.WHITE);	
	ms.inpoint(x,y);
}

/**
 * 根据当前关卡设置过关分数
 */
public static int getn()
{
	switch (n)
	{
	case 0:return 2147483647;
	case 1:return 4;
	case 2:return 6;
	case 3:return 8;
	case 4:return 10;
	case 5:return 12;
	case 6:return 14;
	default:return 2*(n+1);
	}
}

/*
 * 让蛇动起来
 * 
 * (non-Javadoc)
 * @see java.lang.Runnable#run()
 */
public void run() {
		
		while(true)
			{
				try
				{
					//in speed ms ,the snake wake up and md.body one point 
					Thread.sleep(ms.getSpeed());
				} 
				catch (Exception e) 
					{}
				//set the direct by the new direct
				ms.setDirect(ms.newdirect);
				
				//let the snake md.body foreward 
				for(int i=ms.getLength();i>=1;i--)
				{
					ms.body[i].setX(ms.body[i-1].getX());
					ms.body[i].setY(ms.body[i-1].getY());
				}
				
				//the last point must be remove out of body
				ms.outpoint(ms.body[ms.getLength()].getX()/10,ms.body[ms.getLength()].getY()/10);
				
				//accord to the direct ,desicce the first point md.body to
					switch (ms.getDirect())
				{
				//md.body up
				case 0:ms.body[0].setY(ms.body[0].getY()-ms.getSize()); break;
				//md.body right
				case 1:ms.body[0].setX(ms.body[0].getX()+ms.getSize()); break;
				//md.body down
				case 2:ms.body[0].setY(ms.body[0].getY()+ms.getSize()); break;
				//md.body left
				case 3:ms.body[0].setX(ms.body[0].getX()-ms.getSize()); break;
				}
				
				//in my game ,we let the board can be throught
				if (ms.body[0].getX()>Myframe.MAXX) ms.body[0].setX(0);
				if (ms.body[0].getX()<0) ms.body[0].setX(Myframe.MAXX);
				if (ms.body[0].getY()>Myframe.MAXY) ms.body[0].setY(0);
				if (ms.body[0].getY()< 0) ms.body[0].setY(Myframe.MAXY);
				
				//judge if the head is go into a door
				for(int i=0;i<md.getNum();i++)
					if (ms.body[0].getX()==md.body[i][0].getX() && ms.body[0].getY()==md.body[i][0].getY())
						{
						ms.body[0].setX(md.body[i][1].getX());
						ms.body[0].setY(md.body[i][1].getY());
						}
					else
						if (ms.body[0].getX()==md.body[i][1].getX() && ms.body[0].getY()==md.body[i][1].getY())
						{
						ms.body[0].setX(md.body[i][0].getX());
						ms.body[0].setY(md.body[i][0].getY());
						}
					
				
				//if we crack in to a food,we get the length ++
				if (ms.body[0].getX()==mf.body.getX() &&
						ms.body[0].getY()==mf.body.getY())
						{
							//let the point plus into my snake
							ms.inpoint(ms.body[ms.getLength()].getX()/10,ms.body[ms.getLength()].getY()/10);
							mf.newFood(ms.isexist);
							ms.setLength(ms.getLength()+1);
								
						}
				
				//if we crack in my body or in a store we dead
				if (ms.isexist[ms.body[0].getX()/10][ms.body[0].getY()/10])
					{
					//let the snake dead
					ms.setIsalive(false);
					//break of the game 
					if (k==true)
					{
					k=false;
					//ask the player to continue the game or not
					int option=JOptionPane.showConfirmDialog(null, "Game over!Do you want to Restart?");
					//if it is yes
					if (option==JOptionPane.YES_OPTION)
						{
						n=1;
						//restart the game
						State(n);
						k=true;
						}
					
					else break;
					}
					}
				
				//let the head into my snake
				ms.inpoint(ms.body[0].getX()/10,ms.body[0].getY()/10);
				
				//judge if we finish the state
				if (getn()<=ms.getLength())
				{
					
					State(++n);
				}
				
				
			}
		
	}
}
	
