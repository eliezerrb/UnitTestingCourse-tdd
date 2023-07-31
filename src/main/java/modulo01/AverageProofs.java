package modulo01;

import modulo01.domain.WeightedProofResult;

import java.util.List;

public class AverageProofs {

    public static double getAverageProofs(List<Double> proofResults) {
        double sum = 0;
        for (Double result: proofResults) {
            sum += result;
        }

        int dividend = proofResults.size() > 0 ? proofResults.size() : 1;
        return sum / dividend;
    }

    public static double getWeightedAverageProofs(List<WeightedProofResult> proofResults) {
        double sum = 0;
        int dividend = 0;
        for (WeightedProofResult proof: proofResults) {
            sum += (proof.getResult() * proof.getWeight());
            dividend += proof.getWeight();
        }
        return sum / dividend;
    }
}
