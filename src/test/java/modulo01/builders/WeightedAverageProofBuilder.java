package modulo01.builders;

import modulo01.domain.WeightedProofResult;

public class WeightedAverageProofBuilder {

    private String proofName;
    private int weight;
    private double result;

    public WeightedAverageProofBuilder(){
        super();
    }

    public WeightedAverageProofBuilder withProofName(String proofName) {
        this.proofName = proofName;
        return this;
    }

    public WeightedAverageProofBuilder withProofResult(double proofResult) {
        this.result = proofResult;
        return this;
    }

    public WeightedAverageProofBuilder withProofWeight(int proofWeight) {
        this.weight = proofWeight;
        return this;
    }

    public WeightedProofResult build() {
        WeightedProofResult proofResult = new WeightedProofResult(this.proofName);
        proofResult.setWeight(this.weight);
        proofResult.setResult(this.result);
        return proofResult;
    }
}
