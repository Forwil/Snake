
/**
 * @author forwil(���ΰ 11091222 110641��)
 * @version 3.0 2012-12-30 
 * 
 */
import java.awt.Color;

public class Body {
/**
 * ����
 */
	private int x=0;
	private int y=0;
/**
 * ��ɫ	
 */
	private Color color=null;
/**
 * �½�
 * @param x
 * @param y
 */
	public Body(int x, int y)
	{
	this.x=x;
	this.y=y;
	}
/**
 * �½�
 */
	public Body()
	{
	}
/**
 * ���������½�
 * @param x
 * @param y
 * @param color
 */
	public Body(int x, int y,Color color)
	{
	this.x=x;
	this.y=y;
	this.color=color;
	}
/**
 * ����x
 * @return x
 */
	public int getX() 
	{
		return x;
	}
/**
 * ����x
 * @param x
 */
	public void setX(int x) 
	{
		this.x = x;
	}
/**
 * ����y
 */
	public int getY() 
	{
		return y;
	}
/**
 * ����y
 * @param y
 */
	public void setY(int y) 
	{
		this.y = y;
	}
/**
 *  ������ɫ
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
}
