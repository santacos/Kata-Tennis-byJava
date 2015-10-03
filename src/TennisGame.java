
public class TennisGame {
	private Player first;
	private Player second;
	//private int state;
	private String state;
		
	public TennisGame(Player first,Player second){
		this.first	= first;
		this.second = second;
		this.state 	= "Equal";
		//this.state 	= 0;
	}
	
	public TennisGame(Player first,Player second,int firstScore,int secondScore){
		this.first	= first;
		this.second = second;
		this.first.setScore(firstScore);
		this.second.setScore(secondScore);
		this.state 	= "Equal";
		//this.state 	= 0;
	}
	public void setScore(int firstScore,int secondScore){
		first.setScore(firstScore);
		second.setScore(secondScore);
		updateState();
	}
	
	public String getState() {
		return state;
	}

	public void firstPlayerWin() {
		first.win();
		updateState();
	}
	
	public void secondPlayerWin() {
		second.win();
		updateState();
	}

	private void updateState() {
		int firstScore = first.getScore();
		int secondScore = second.getScore();
		
		if (firstScore==secondScore){
			if(firstScore>2)state="Deuce";
			else state = "Equal";
		}
		
		else if (firstScore>=4 || secondScore>=4)state="Adventage";
		else state = "Playing";
	}
	
	

	public String getResult() {
		updateState();
		int firstScore = first.getScore();
		int secondScore = second.getScore();
		String result="";
		switch (state) {
			case "Equal":
				result = getScoreDescription(firstScore) + "-All";
				break;
			case "Deuce":
				result = "Deuce";
				break;
			case "Adventage":
				int diff = firstScore - secondScore;
				if(diff>=2) 
					result = first.getName()+" win!";
				else if(diff<=-2)
					result = second.getName()+" win!";
				else if(diff==1)
					result = first.getName()+" Adventage!";
				else if(diff==-1)
					result = second.getName()+" Adventage!";
				break;
			default:
				result = getScoreDescription(firstScore)+"-"+getScoreDescription(secondScore);
				break;
		}
		
		return result;
	}

	
	public String getScoreDescription(int score) {
		switch (score) {
			case 0:	return "Love"; 
			case 1:	return "Fifteen";
			case 2: return "Thirty";
			case 3: return "Forty";
			default: return null;
		}
	}
	
	
	

}
