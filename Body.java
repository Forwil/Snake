
/**
 * @author forwil(余锋伟 11091222 110641班)
 * @version 3.0 2012-12-30 
 * 
 */
import java.awt.Color;

public class Body {
/**
 * 坐标
 */
	private int x=0;
	private int y=0;
/**
 * 颜色	
 */
	private Color color=null;
/**
 * 新建
 * @param x
 * @param y
 */
	public Body(int x, int y)
	{
	this.x=x;
	this.y=y;
	}
/**
 * 新建
 */
	public Body()
	{
	}
/**
 * 带参量的新建
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
 * 返回x
 * @return x
 */
	public int getX() 
	{
		return x;
	}
/**
 * 设置x
 * @param x
 */
	public void setX(int x) 
	{
		this.x = x;
	}
/**
 * 返回y
 */
	public int getY() 
	{
		return y;
	}
/**
 * 设置y
 * @param y
 */
	public void setY(int y) 
	{
		this.y = y;
	}
/**
 *  返回颜色
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
}
