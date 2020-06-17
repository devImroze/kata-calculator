public class KataCalculator {

    public int Add(String numbers) {

        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        int sum = 0;

        String[] values = numbers.split(",");

        for (String value : values) {
            sum = sum + Integer.parseInt(value);
        }

        return sum;
    }
}
