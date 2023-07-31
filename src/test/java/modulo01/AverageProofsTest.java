package modulo01;

import modulo01.builders.WeightedAverageProofBuilder;
import modulo01.domain.WeightedProofResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AverageProofsTest {

    @Test
    public void shouldReturnTheAverageWhenAListResultProofsIsPassed() {
        List<Double> proofsResults = Arrays.asList(8.0, 8.0, 7.0, 8.0);
        double average = AverageProofs.getAverageProofs(proofsResults);
        Assertions.assertEquals(7.75, average, 0.0);
    }

    @Test
    public void shouldReturnZeroWhenAnEmptyListResultProofsIsPassed() {
        List<Double> proofsResults = Arrays.asList();
        double average = AverageProofs.getAverageProofs(proofsResults);
        Assertions.assertEquals(0, average, 0.0);
    }

    @Test
    public void shouldReturnTheWeightedAverageWhenAValidProofResults() {
        List<WeightedProofResult> proofResults = new ArrayList<>();
        WeightedProofResult avaliacao1 = new WeightedAverageProofBuilder()
                .withProofWeight(2)
                .withProofName("Avaliação1")
                .withProofResult(7)
                .build();

        proofResults.add(avaliacao1);
        double average = AverageProofs.getWeightedAverageProofs(proofResults);
        Assertions.assertEquals(7, average, 0.0);
    }
}
