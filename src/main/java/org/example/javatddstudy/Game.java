package org.example.javatddstudy;

public class Game {

//    private int score;
    private int[] rolls = new int[21];
    private int currentRolls = 0;

    public void roll(int pins) {
//        score += pins;
        rolls[currentRolls++] = pins;
    }

    public Object score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex);
                frameIndex++;
            }
            else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            }
            else {
                score += rolls[frameIndex] + rolls[frameIndex+1];
                frameIndex += 2;
            }
        }
//        for (int i = 0; i < rolls.length; i++) {
//            if (rolls[i] + rolls[i+1] == 10) { //spare
//                score += rolls[i+2];
//            }
//            score += rolls[i];
//        }
        return score;
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex+2];
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex+1] + rolls[frameIndex+2];
    }

    private boolean isStike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex+1] == 10;
    }
}
