package flyball;

import javax.swing.JOptionPane;

public class move {

	Map map;
	boolean first=true;
	int v[]= {-3,0};//�����¡�������
	public move(Map map) {
		// TODO �Զ����ɵĹ��캯�����
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
		if(map.arr2D[map.bally/30][map.ballx/30])//���Ͻ�
		{
			if(map.arr2D[(map.bally+20)/30][(map.ballx)/30])//���½�Ҳ��
			{
				map.arr2D[(map.bally+20)/30][(map.ballx)/30]=false;
			}
			else//���½�û��
			v[0]=3;
			v[1]=3;
			map.arr2D[map.bally/30][map.ballx/30]=false;
		}
//		if(map.arr2D[map.bally/30][map.ballx/30]&&map.arr2D[(map.bally+20)/30][(map.ballx)/30])//���ϽǺ����½�
//		{
////			v[0]=3;
//			v[1]=3;
//			map.arr2D[map.bally/30][map.ballx/30]=false;
//			map.arr2D[(map.bally+20)/30][(map.ballx)/30]=false;
//		}
		
		
		
		if(map.arr2D[map.bally/30][(map.ballx+20)/30])//���Ͻ�
		{
			if(map.arr2D[(map.bally+20)/30][(map.ballx+20)/30])//���½�����
			{
				map.arr2D[(map.bally+20)/30][(map.ballx+20)/30]=false;
			}
			else//���½�û��
			v[0]=3;
			v[1]=-3;
			map.arr2D[map.bally/30][(map.ballx+20)/30]=false;
		}
//		if(map.arr2D[map.bally/30][(map.ballx+20)/30]&&map.arr2D[(map.bally+20)/30][(map.ballx+20)/30])//���ϽǺ����½�
//		{
////			v[0]=3;
//			v[1]=-3;
//			map.arr2D[map.bally/30][(map.ballx+20)/30]=false;
//			map.arr2D[(map.bally+20)/30][(map.ballx+20)/30]=false;
//		}
		if(map.arr2D[(map.bally+20)/30][(map.ballx+20)/30])//���½�
		{
			v[0]=-3;
			v[1]=-3;
			map.arr2D[(map.bally+20)/30][(map.ballx+20)/30]=false;
		}
		if(map.arr2D[(map.bally+20)/30][(map.ballx)/30])//���½�
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
