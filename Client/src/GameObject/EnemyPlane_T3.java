package GameObject;

public class EnemyPlane_T3 extends Enemy{
	
	public EnemyPlane_T3(){
		super();
	}
	
	public EnemyPlane_T3(Position p){
		super(p,16,3);
		speed=2;
	}
	
}
