package GameObject;

//所有飞行器的超类
public class Plane {
	
	public Position position;
	
	public Plane(){
		position=new Position();
	}
	
	public Plane(Position pos){
		this.position=pos;
	}
     
}
