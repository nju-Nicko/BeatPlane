package GameObject;

public class Enemy extends Plane{
	
	public int life;
	public boolean alive;
	public int enemy_kind;
	public int speed;
	
	public Enemy(){
		super();
		life=0;
		alive=true;
		enemy_kind=-1;
		speed=0;
	}
	
	public Enemy(Position p,int life,int enemy_kind){
		super(p);
		this.life=life;
		alive=true;
		this.enemy_kind=enemy_kind;
		speed=0;
	}

}
