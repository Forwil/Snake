
/**
 * @author forwil(���ΰ 11091222 110641��)
 * @version 3.0 2012-12-30 
 * 
 */
public class Doors 
{
/**
 * �ŵ�����
 */
private int num=0;
/**
 * ��������
 * @return num
 */
public int getNum() 
{
	return num;
}
/**
 * ����
 */
public Body[][] body=null;

/**
 * �½���
 */
public Doors()
	{
	body=new Body[100][2];
	}
/**
 * ������ �½���
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
