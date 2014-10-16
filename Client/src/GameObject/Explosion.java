package GameObject;

public class Explosion extends Plane{
	
	public int life_time;
	
	public Explosion(){
		super();
		life_time=0;
	}
	
	public Explosion(Position p){
		super(p);
		life_time=10;
	}

}
