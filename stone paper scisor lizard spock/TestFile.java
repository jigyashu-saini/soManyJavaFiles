import static org.junit.jupiter.api.Assertions.*; 

import org.junit.jupiter.api.Test;

class TestFile { 

	@Test
	void test() {
		int result = stonePaperScissorsLizardSpockSivakumar.findWinner("stone", "stone");
		assertEquals(0, result);
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("stone", "paper");
		assertEquals(2, result);
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("stone", "scissors");
		assertEquals(1, result);
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("stone", "spock");
		assertEquals(2, result);
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("stone", "lizard");
		assertEquals(1, result);
		
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("paper", "stone");
		assertEquals(1, result);
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("paper", "paper");
		assertEquals(0, result);
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("paper", "scissors");
		assertEquals(2, result);
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("paper", "spock");
		assertEquals(1, result);
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("paper", "lizard");
		assertEquals(2, result);
		
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("scissors", "stone");
		assertEquals(2, result);
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("scissors", "paper");
		assertEquals(1, result);
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("scissors", "scissors");
		assertEquals(0, result);
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("scissors", "spock");
		assertEquals(2, result);
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("scissors", "lizard");
		assertEquals(1, result);
		
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("spock", "stone");
		assertEquals(1, result);
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("spock", "paper");
		assertEquals(2, result);
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("spock", "scissors");
		assertEquals(1, result);
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("spock", "spock");
		assertEquals(0, result);
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("spock", "lizard");
		assertEquals(2, result);
		
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("lizard", "stone");
		assertEquals(2, result);
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("lizard", "paper");
		assertEquals(1, result);
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("lizard", "scissors");
		assertEquals(2, result);
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("lizard", "spock");
		assertEquals(1, result);
		result = stonePaperScissorsLizardSpockSivakumar.findWinner("lizard", "lizard");
		assertEquals(0, result);

	}

}
