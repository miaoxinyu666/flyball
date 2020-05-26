package flyball;

import javax.swing.JOptionPane;

public class move {

	Map map;
	boolean first=true;
	int v[]= {-3,0};//先上下、后左右
	public move(Map map) {
		// TODO 自动生成的构造函数存根
		this.map=map;
		map.ballx=map.boatlocation+map.boatImage.getWidth(null)/2-10;
		map.bally=map.getHeight()-50;
	}
	
	public void fly() {
//		if(first)
		{
			map.bally+=v[0];
			map.ballx+=v[1];
		}
		
			Check(map.ballx,map.bally);
		
	}
	
	public void Check(int x,int y) {
		if(map.ballx<=0)
			v[1]=3;
		if(map.ballx>=1200-30)
			v[1]=-3;
		if(map.bally<=0)
			v[0]=3;
		if(map.bally>=750)
		{
			v[0]=v[1]=0;
			map.fly=false;
			map.die=true;
		


		}
			
		
		if(y<=300)
		{
		if(map.arr2D[map.bally/30][map.ballx/30])//左上角
		{
			if(map.arr2D[(map.bally+20)/30][(map.ballx)/30])//左下角也有
			{
				map.arr2D[(map.bally+20)/30][(map.ballx)/30]=false;
			}
			else//左下角没有
			v[0]=3;
			v[1]=3;
			map.arr2D[map.bally/30][map.ballx/30]=false;
		}
//		if(map.arr2D[map.bally/30][map.ballx/30]&&map.arr2D[(map.bally+20)/30][(map.ballx)/30])//左上角和左下角
//		{
////			v[0]=3;
//			v[1]=3;
//			map.arr2D[map.bally/30][map.ballx/30]=false;
//			map.arr2D[(map.bally+20)/30][(map.ballx)/30]=false;
//		}
		
		
		
		if(map.arr2D[map.bally/30][(map.ballx+20)/30])//右上角
		{
			if(map.arr2D[(map.bally+20)/30][(map.ballx+20)/30])//右下角又有
			{
				map.arr2D[(map.bally+20)/30][(map.ballx+20)/30]=false;
			}
			else//右下角没有
			v[0]=3;
			v[1]=-3;
			map.arr2D[map.bally/30][(map.ballx+20)/30]=false;
		}
//		if(map.arr2D[map.bally/30][(map.ballx+20)/30]&&map.arr2D[(map.bally+20)/30][(map.ballx+20)/30])//右上角和右下角
//		{
////			v[0]=3;
//			v[1]=-3;
//			map.arr2D[map.bally/30][(map.ballx+20)/30]=false;
//			map.arr2D[(map.bally+20)/30][(map.ballx+20)/30]=false;
//		}
		if(map.arr2D[(map.bally+20)/30][(map.ballx+20)/30])//右下角
		{
			v[0]=-3;
			v[1]=-3;
			map.arr2D[(map.bally+20)/30][(map.ballx+20)/30]=false;
		}
		if(map.arr2D[(map.bally+20)/30][(map.ballx)/30])//左下角
		{
			v[0]=-3;
			v[1]=-3;
			map.arr2D[(map.bally+20)/30][(map.ballx)/30]=false;
		}
		
		}
		
		if(map.bally>=map.getHeight()-50)
		{
			if(map.ballx-map.boatlocation>=0&&map.ballx-map.boatlocation<=map.boatImage.getWidth(null)/2)
			{
				v[0]=-3;
				v[1]=-3;
			}
			
			if(map.ballx-map.boatlocation>=map.boatImage.getWidth(null)/2&&map.ballx-map.boatlocation<=map.boatImage.getWidth(null))
			{
				v[0]=-3;
				v[1]=3;
			}
		}
		
	}
	
	
	
	
}
