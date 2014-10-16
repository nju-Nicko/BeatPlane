package GameObject;

public class EnemyPlane_T2 extends Enemy{
	
	public EnemyPlane_T2(){
		super();
	}
	
	public EnemyPlane_T2(Position p){
		super(p,10,2);
		speed=3;
	}

}
