
public class Player {
	private String name;
	private int score;
	
	public Player(String name){
		this.name = name;
		int score = 0;
	}
	
	public Player(String name,int score){
		this.name 	= name;
		this.score 	= score;
	}
	
	public int getScore(){
		return score;
	}
	
	public String getName(){
		return name;
	}
	
	public void setScore(int newScore){
		score = newScore;
	}
	
	public void win(){
		score++;
	}
	
	
	
}
