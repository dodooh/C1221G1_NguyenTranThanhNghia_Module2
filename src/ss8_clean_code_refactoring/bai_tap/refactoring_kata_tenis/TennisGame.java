package ss8_clean_code_refactoring.bai_tap.refactoring_kata_tenis;

public class TennisGame {

    private static final String LOVE = "Love";
    private static final String FIFTEEN = "Fifteen";
    private static final String THIRTY = "Thirty";
    private static final String FORTY = "Forty";
    private static final String DEUCE = "Deuce";


    public static String getScore(String player1Name, String player2Name, int player1Score,
        int player2Score) {
        String result = "";
        boolean twoPlayerAreEqual = player1Score == player2Score;

        if (twoPlayerAreEqual) {
            if (player1Score != 4) {
                result += getPlayerScore(player1Score) + "-All";
            } else {
                result += DEUCE;
            }
        } else if (player1Score >= 4 || player2Score >= 4) {
            result += getBetterPlayer(player1Score, player2Score);
        } else {
            result += getPlayerScore(player1Score) + "-" + getPlayerScore(player2Score);
        }
        return result;
    }

    private static String getBetterPlayer(int player1Score, int player2Score) {
        int differentPlayer1VsPlayer2 = player1Score - player2Score;
        if (differentPlayer1VsPlayer2 == 1) {
            return "Advantage player1";
        } else if (differentPlayer1VsPlayer2 == -1) {
            return "Advantage player2";
        } else if (differentPlayer1VsPlayer2 >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private static String getPlayerScore(int score) {
        switch (score) {
            case 0:
                return LOVE;
            case 1:
                return FIFTEEN;
            case 2:
                return THIRTY;
            case 3:
                return FORTY;
        }
        return "";
    }
}
