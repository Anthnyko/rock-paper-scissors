import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RPSFrame extends JFrame implements ActionListener{
        // player buttons
        JButton rockButton, paperButton, scissorButton; // makes buttons global for button methods

        // will display the choice of the computer
        JLabel computerChoice;

        // will display the score pf the computer and player
        JLabel computerScoreLabel, playerScoreLabel;

        // backend obj
        RPSCode rockPaperScissor;

        public RPSFrame() { // creates the main frame for the game
                ImageIcon icon = new ImageIcon("Peter.jpg");
                this.setVisible(true);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setSize(450, 574 );
                this.setTitle("Rock Paper Scissors");
                this.setIconImage(icon.getImage());
                this.setLayout(null);
                this.setLocationRelativeTo(null);
                // initialize the backend obj
                rockPaperScissor = new RPSCode();
                addGuiComponents();
        }

        private void addGuiComponents() { // adds the gui for the game
                // computer score label
                computerScoreLabel = new JLabel("Computer: 0");
                // set x,y coords and width/height
                computerScoreLabel.setBounds(0, 43, 450, 30);
                // set font family to dialog, font-weight of bold, and font-size 26
                computerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
                // place the text in center
                computerScoreLabel.setHorizontalAlignment(JLabel.CENTER);
                // add to GUI
                add(computerScoreLabel);

                // computer choice label
                computerChoice = new JLabel("?");
                computerChoice.setBounds(175, 118, 98, 81);
                computerChoice.setFont(new Font("Dialog", Font.PLAIN, 18));
                computerChoice.setHorizontalAlignment(JLabel.CENTER);

                // black border
                computerChoice.setBorder(BorderFactory.createLineBorder(Color.black));
                add(computerChoice);

                // player score label
                playerScoreLabel = new JLabel("Player: 0");
                playerScoreLabel.setBounds(0,317,450,30);
                playerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
                playerScoreLabel.setHorizontalAlignment(JLabel.CENTER);
                add(playerScoreLabel);


                // player buttons

                // rock button
                rockButton = new JButton("Rock");
                rockButton.setBounds(40,387,105,81);
                rockButton.setFont(new Font("Dialog", Font.PLAIN, 18));
                rockButton.addActionListener(this);
                add(rockButton);

                // paper button
                paperButton = new JButton("Paper");
                paperButton.setBounds(165,387,105,81);
                paperButton.setFont(new Font("Dialog", Font.PLAIN, 18));
                paperButton.addActionListener(this);
                add(paperButton);

                // scissor button
                scissorButton = new JButton("Scissors");
                scissorButton.setBounds(290,387,105,81);
                scissorButton.setFont(new Font("Dialog", Font.PLAIN, 18));
                scissorButton.addActionListener(this);
                add(scissorButton);
        }

        // displays a message dialog which will show the winner and try again button
        private void showDialog(String message) {
                JDialog resultDialog = new JDialog(this,"Result", true); // dialog box pop up and does not allow user to click anywhere until closed.
                resultDialog.setSize(227,124);
                resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                resultDialog.setResizable(false);

                // message label
                JLabel resultLabel = new JLabel(message);
                resultLabel.setFont(new Font("Dialog", Font.BOLD, 18));
                resultLabel.setHorizontalAlignment(JLabel.CENTER);
                resultDialog.add(resultLabel, BorderLayout.CENTER);

                // try again button
                JButton tryAgainButton = new JButton("Try Again?");
                tryAgainButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                // reset computer choice
                                computerChoice.setText("?");

                                // close the dialog box
                                resultDialog.dispose();
                        }
                });
                resultDialog.add(tryAgainButton, BorderLayout.SOUTH); // adds the try again button to the dialog box

                resultDialog.setLocationRelativeTo(this);
                resultDialog.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                // get player choice
                String playerChoice = e.getActionCommand().toString();

                // play rock paper scissor and store result into string var
                String result = rockPaperScissor.playRockPaperScissor(playerChoice);

                // load computer's choice
                computerChoice.setText(rockPaperScissor.getComputerChoice());

                // update score
                computerScoreLabel.setText("Computer: " + rockPaperScissor.getComputerScore());
                playerScoreLabel.setText("Player: " + rockPaperScissor.getPlayerScore());

                // display result dialog
                showDialog(result);
        }
}
