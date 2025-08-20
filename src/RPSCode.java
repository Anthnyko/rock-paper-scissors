import java.util.Random;

//backend
public class RPSCode {
    // all of the choices the computer can make
    private static final String[] computerChoices = {"Rock", "Paper", "Scissors"};

    public String getComputerChoice() {
        return computerChoice;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    // store the computer choice
    private String computerChoice;

    // store the scores
    private int computerScore, playerScore;

    // use random class to pick for computer
    private Random random;

    // constructor - initialize random obj
    public RPSCode() {
        random = new Random();
    }

    // call this method to begin game
    // playerChoice - choice made by player
    // this method returns the result of the game
    public String playRockPaperScissor(String playerChoice) {
        //generate computer choice
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];

        // store returning message for the result
        String result;

        // evaluate winner
        if (computerChoice.equals("Rock")) {
            if (playerChoice.equals("Paper")) {
                result = "Player Wins";
                playerScore++;
            } else if (playerChoice.equals("Scissors")) {
                result = "Computer Wins";
                computerScore++;
            } else {
                result = "Draw";
            }
        } else if (computerChoice.equals("Paper")) {
            if (playerChoice.equals("Scissors")) {
                result = "Player Wins";
                playerScore++;
            } else if (playerChoice.equals("Rock")) {
                result = "Computer Wins";
                computerScore++;
            } else {
                result = "Draw";
            }
        } else{
            if (playerChoice.equals("Rock")){
                result = "Player Wins";
                playerScore++;
            }else if(playerChoice.equals("Paper")){
                result = "Computer Wins";
                computerScore++;
            }else {
                result = "Draw";
            }
        }
        return result;
    }
}

