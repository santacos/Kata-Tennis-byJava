import java.util.Map;

import junit.framework.TestCase;


public class TennisGameTest extends TestCase {
	Player first = new Player("a");
	Player second = new Player("b");
	TennisGame game = new TennisGame(first,second);
	
	
	public void createGameTennis() throws Exception{
		TennisGame game1 = new TennisGame(first,second);
		assertNotNull(game1);
		TennisGame game2 = new TennisGame(first,second,0,1);
		assertNotNull(game2);
	}
	
	public void stateGameTennis() throws Exception{
		assertEquals("Equal", game.getState());
		
		game.firstPlayerWin();
		assertEquals("Playing", game.getState());
	}
	
	public void resultAll() throws Exception{
		assertEquals("Love-All", game.getResult());
		game.setScore(1, 1);
		assertEquals("Fifteen-All", game.getResult());
		game.setScore(2, 2);
		assertEquals("Thirty-All", game.getResult());
	}
	
	public void FirstPlayerWin() throws Exception{
		for(int secondScore=0;secondScore<3;secondScore++){
			game.setScore(4,secondScore);
			assertEquals("a win!", game.getResult());
		}
		
		
		game.setScore(6,4);
		assertEquals("a win!", game.getResult());
	}
	
	public void SecondPlayerWin() throws Exception{
		for(int secondScore=0;secondScore<3;secondScore++){
			game.setScore(secondScore,4);
			assertEquals("b win!", game.getResult());
		}
		
		game.setScore(4,6);
		assertEquals("b win!", game.getResult());
		
	}
	
	public void FirstAdventage() throws Exception{
		game.setScore(5,4);
		assertEquals("a Adventage!", game.getResult());
		game.setScore(4,3);
		assertEquals("a Adventage!", game.getResult());
	}
	
	public void SecondAdventage() throws Exception{
		game.setScore(4,5);
		assertEquals("b Adventage!", game.getResult());
		game.setScore(3,4);
		assertEquals("b Adventage!", game.getResult());
	}
	
	public void DeuceResult() throws Exception{		
		game.setScore(3,3);
		assertEquals("Deuce", game.getResult());
		game.setScore(4,4);
		assertEquals("Deuce", game.getResult());
	}
	
	public void allPlaying() throws Exception{
		String[] text = {"Love","Fifteen","Thirty","Forty"};
		for(int firstScore=0;firstScore<3;firstScore++){
			for(int secondScore=firstScore+1;secondScore<4;secondScore++){
				game.setScore(firstScore,secondScore);
				String expect = text[firstScore]+"-"+text[secondScore];
				assertEquals(expect, game.getResult());
				
				game.setScore(secondScore,firstScore);
				expect =text[secondScore]+"-"+text[firstScore];
				assertEquals(expect, game.getResult());
			}
		}
		
	}
	
	
	
}
