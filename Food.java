
/**
 * @author forwil(���ΰ 11091222 110641��)
 * @version 3.0 2012-12-30 
 * 
 */
public class Food {
/**
 * ���������
 */
public Body body=null;
/**
 * �½�ʳ��
 * @param x
 * @param y
 */
	public Food(int x,int y)
	{
	body=new Body(x,y);
	}
/**
 * �����µ�ʳ��
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