package modulo01.domain;

public class WeightedProofResult {
    private double result;

    private int weight;

    private String name;

    public WeightedProofResult(String proofName) {
        this.name = proofName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
