
/**
 * @author forwil(余锋伟 11091222 110641班)
 * @version 3.0 2012-12-30 
 * 
 */
public class Food {
/**
 * 事物的身体
 */
public Body body=null;
/**
 * 新建食物
 * @param x
 * @param y
 */
	public Food(int x,int y)
	{
	body=new Body(x,y);
	}
/**
 * 生成新的食物
 * @param isexist
 */
	public  void newFood(boolean[][] isexist)
	{
	
	long time = System.currentTimeMillis() % 483647;
	
	body.setX(((this.body.getX()+(int )time) % (Myframe.MAXX/10))*10);
	body.setY(((this.body.getY()+(int )time+257993) % (Myframe.MAXY/10))*10);
	
	while (isexist[this.body.getX()/10][this.body.getY()/10]==true)
	{
		body.setX(((this.body.getX()+(int )time+257993) % (Myframe.MAXX/10))*10);
		body.setY(((this.body.getY()+(int )time) % (Myframe.MAXY/10))*10);
		//System.out.println("");
	}
		
	}
	
}