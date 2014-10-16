package GameObject;

//‘… Ø¿‡
public class Stone extends Plane{
	
	public int kind;
	public boolean alive;
	
	public Stone(){
		super();
		kind=-1;
		alive=true;
	}
	
	public Stone(Position pos,int kind){
		super(pos);
		this.kind=kind;
		alive=true;
	}

}
