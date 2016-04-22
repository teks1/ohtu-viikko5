package ohtu;

public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private String score;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    public String getScore() {
        this.score = "";
        if (m_score1 == m_score2) {
            laskeYkkosPelaajanPisteetJosTasaTilanne();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            josPisteitaYliNelja();
        } else {
            muuTilanne();
        }
        return this.score;
    }

    private void laskeYkkosPelaajanPisteetJosTasaTilanne() {
        if (m_score1 < 4) {
            haePisteString(m_score1);
            this.score += "-All";
        } else {
            this.score = "Deuce";
        }
    }

    private void josPisteitaYliNelja() {
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) {
            score = "Advantage player1";
        } else if (minusResult == -1) {
            score = "Advantage player2";
        } else if (minusResult >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
    }

    private void muuTilanne() {
        haePisteString(m_score1);
        this.score += "-";
        haePisteString(m_score2);
    }

    private void haePisteString(int tempScore) {
        switch (tempScore) {
            case 0:
                this.score += "Love";
                break;
            case 1:
                this.score += "Fifteen";
                break;
            case 2:
                this.score += "Thirty";
                break;
            case 3:
                this.score += "Forty";
                break;
        }
    }
}
