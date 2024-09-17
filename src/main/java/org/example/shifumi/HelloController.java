package org.example.shifumi;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Random;

public class ShifumiController {
    @FXML
    private Label scoreLabel;

    @FXML
    private Label resultLabel;

    private int playerScore = 0;
    private int computerScore = 0;
    private final String[] choices = {"pierre", "feuille", "ciseaux"};
    private final Random random = new Random();

    @FXML
    protected void PierreButtonClick() {
        playRound("pierre");
    }

    @FXML
    protected void FeuilleButtonClick() {
        playRound("feuille");
    }

    @FXML
    protected void CiseauxButtonClick() {
        playRound("ciseaux");
    }

    private void playRound(String playerChoice) {
        String computerChoice = choices[random.nextInt(choices.length)];
        resultLabel.setText("L'ordinateur a choisi : " + computerChoice);

        if (playerChoice.equals(computerChoice)) {
            resultLabel.setText(resultLabel.getText() + "\nC'est une égalité !");
        } else if (isPlayerWinner(playerChoice, computerChoice)) {
            resultLabel.setText(resultLabel.getText() + "\nVous avez gagné !");
            playerScore++;
        } else {
            resultLabel.setText(resultLabel.getText() + "\nL'ordinateur a gagné !");
            computerScore++;
        }

        updateScore();
    }

    private boolean isPlayerWinner(String playerChoice, String computerChoice) {
        return (playerChoice.equals("pierre") && computerChoice.equals("ciseaux")) ||
                (playerChoice.equals("feuille") && computerChoice.equals("pierre")) ||
                (playerChoice.equals("ciseaux") && computerChoice.equals("feuille"));
    }

    private void updateScore() {
        scoreLabel.setText("Score: Joueur " + playerScore + " - Ordinateur " + computerScore);
    }
}
