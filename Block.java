
import java.awt.Color;
/**
 * @author forwil(余锋伟 11091222 110641班)
 * @version 3.0 2012-12-30 
 * 
 */

public class Block {
/**
 * 障碍数组
 */
public Body[] body=null;
/**
 * 可否通行
 */
private boolean can=false;
/**
 *障碍数
 */
private  int num=0;

/**
 * 返回长度
 * @return num
 */
public int getNum() {
	return num;
}

/**
 * 
 * @param can
 */
public Block(boolean can)
{
	body=new Body[1000];
	num=0;
	this.can=can;

}
/**
 * 重载
 * 
 * @param ms
 * @param color
 * @param mode
 */
public void newBlock(Snake ms,Color color,int mode)
	{
	// 0 is random renew a point
	if (mode ==0)
	{
		newBlock(ms,color);
	}
	//1 is let the new point in the last of the snake
	if (mode==1)
		{
		body[num]=new Body(ms.body[ms.getLength()].getX(),ms.body[ms.getLength()].getY(),color);
		}
	
	ms.isexist[body[num].getX()/10][body[num].getY()/10]=true;
	num++;
	}
/**
 * 新建一个障碍 
 * @param ms
 * @param color
 */
public void newBlock(Snake ms,Color color)
{
	//get the time
	long time = System.currentTimeMillis() % 483647;
	
	body[num]=new Body(10,20,color);

while (ms.isexist[body[num].getX()/10][body[num].getY()/10]==true)
	{
	body[num].setX(((body[num].getX()+(int )time+257993) % (Myframe.MAXX/10))*10);
	body[num].setY(((body[num].getY()+(int )time) % (Myframe.MAXY/10))*10);
	}

ms.isexist[body[num].getX()/10][body[num].getY()/10]=true;
num++;
}

public void addBlock(int x,int y,Color color)
{
	body[num]=new Body(x,y,color);
	num++;
}

/**
 * 返回can
 * @return can
 */
public boolean isCan() {
	return can;
}

/**
 * 设置can
 * @param can
 */
public void setCan(boolean can) {
	this.can = can;
}
}
