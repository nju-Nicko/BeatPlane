package GameObject;

import java.util.ArrayList;

//玩家的飞机
public class PlayerPlane extends Plane{
	
	//将允许玩家选择不同种类的飞机进行游戏
	public int kind;
	public ArrayList<Missile> shooted_missiles;
	public boolean alive;
	
	public PlayerPlane(){
		super();
		kind=-1;
		shooted_missiles=new ArrayList<Missile>();
		alive=true;
	}
	
	public PlayerPlane(Position pos,int kind){
		super(pos);
		this.kind=kind;
		shooted_missiles=new ArrayList<Missile>();
		alive=true;
	}

}
