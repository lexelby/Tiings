package tilings;

public class Pair<T1, T2> {
	private T1 p1;
	private T2 p2;
	public Pair(T1 t1, T2 t2){
		p1=t1; p2=t2;
	}
	T1 first(){ return p1; }
	T2 second(){ return p2; }
}
