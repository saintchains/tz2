import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class MemoryUsageTest {
    public class MemoryUsageAnalyzer {
        public void analyzeMemoryUsage(int[] data) {
            int[] newArray = new int[data.length * 2];
        }

        public int[] generateNumbers(int size) {
            return new int[size];
        }
    }
    @Test
    public void testMemoryUsage() {
        MemoryUsageAnalyzer analyzer = new MemoryUsageAnalyzer();

        int[] input = analyzer.generateNumbers(1000000);

        long initialMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        analyzer.analyzeMemoryUsage(input);

        long finalMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        long memoryUsed = finalMemory - initialMemory;
        assertTrue("Требуемая память меньше 10 МБ", memoryUsed < 10 * 1024 * 1024);
    }
}
