
/**
 * @author forwil(余锋伟 11091222 110641班)
 * @version 3.0 2012-12-30 
 * 
 */
public class Doors 
{
/**
 * 门的数量
 */
private int num=0;
/**
 * 返回数量
 * @return num
 */
public int getNum() 
{
	return num;
}
/**
 * 数组
 */
public Body[][] body=null;

/**
 * 新建门
 */
public Doors()
	{
	body=new Body[100][2];
	}
/**
 * 带参数 新建门
 * @param x0
 * @param y0
 * @param x1
 * @param y1
 */
public void addDoors(int x0,int y0,int x1,int y1)
	{
	
	body[num][1]=new Body(x1,y1);
	body[num][0]=new Body(x0,y0);
	num++;	
	
	}
}
