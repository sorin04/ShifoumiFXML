package org.example.shifumi;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.Random;

public class HelloController {
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

    @FXML
    protected void ResetButtonClick() {
        resetGame();
    }

    private void playRound(String playerChoice) {
        String computerChoice = choices[random.nextInt(choices.length)];
        String result = "L'ordinateur a choisi : " + computerChoice + "\n";

        if (playerChoice.equals(computerChoice)) {
            result += "C'est une égalité !";
        } else if (isPlayerWinner(playerChoice, computerChoice)) {
            result += "Vous avez gagné !";
            playerScore++;
        } else {
            result += "L'ordinateur a gagné !";
            computerScore++;
        }

        resultLabel.setText(resultLabel.getText() + "\n" + result); // Ajout à l'historique
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

    private void resetGame() {
        playerScore = 0;
        computerScore = 0;
        scoreLabel.setText("Score: Joueur 0 - Ordinateur 0");
        resultLabel.setText("Faites votre choix : ");
    }
}
