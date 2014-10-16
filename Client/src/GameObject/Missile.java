package GameObject;

public class Missile {
	
	public Position pos;
	public boolean alive;
	
	public Missile(){
		pos=new Position(0,0);
		alive=true;
	}
	
	public Missile(int x,int y){
		pos=new Position(x,y);
		alive=true;
	}
	
	public Missile(Position position){
		pos=position;
		alive=true;
	}

}
