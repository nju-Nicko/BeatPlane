package GameObject;

public class EnemyPlane_T1 extends Enemy{
	
	public EnemyPlane_T1(){
		super();
	}
	
	public EnemyPlane_T1(Position p){
		super(p,1,1);
		speed=4;
	}
	
}
