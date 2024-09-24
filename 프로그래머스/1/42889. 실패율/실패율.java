import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] stages) {
        double[] failureRate = new double[N];  // Array to store failure rates for each stage
        int[] stageNumbers = new int[N];  // Array to store stage numbers

        // Calculate the failure rate for each stage
        for (int i = 0; i < N; i++) {
            int failedPlayers = 0;  // Number of players who failed at the current stage
            int reachedPlayers = 0;  // Number of players who reached the current stage

            // Count the players who reached and failed the current stage
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] >= i + 1) {
                    reachedPlayers++;  // Player reached this stage
                    if (stages[j] == i + 1) {
                        failedPlayers++;  // Player failed this stage
                    }
                }
            }

            // Calculate failure rate: only calculate if there are players who reached the stage
            if (reachedPlayers > 0) {
                failureRate[i] = (double) failedPlayers / reachedPlayers;
            } else {
                failureRate[i] = 0;
            }

            stageNumbers[i] = i + 1;  // Store stage number starting from 1
        }

        // Sort stages based on failure rate (Bubble Sort)
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (failureRate[j] < failureRate[j + 1]) {
                    // Swap if the current stage has a lower failure rate
                    double tempFail = failureRate[j];
                    failureRate[j] = failureRate[j + 1];
                    failureRate[j + 1] = tempFail;

                    int tempStage = stageNumbers[j];
                    stageNumbers[j] = stageNumbers[j + 1];
                    stageNumbers[j + 1] = tempStage;
                } else if (failureRate[j] == failureRate[j + 1] && stageNumbers[j] > stageNumbers[j + 1]) {
                    // If failure rates are equal, sort by stage number in ascending order
                    int tempStage = stageNumbers[j];
                    stageNumbers[j] = stageNumbers[j + 1];
                    stageNumbers[j + 1] = tempStage;
                }
            }
        }

        // Print the sorted stage numbers in English
        System.out.println("Sorted stage numbers based on failure rate:");
        for (int i = 0; i < stageNumbers.length; i++) {
            System.out.println("Stage " + stageNumbers[i] + " has failure rate: " + failureRate[i]);
        }

        return stageNumbers;  // Return sorted stage numbers
    }
}
