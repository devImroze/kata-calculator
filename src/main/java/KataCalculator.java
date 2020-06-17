public class KataCalculator {

    public int Add(String numbers) {

        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        int sum = 0;

        String[] values = numbers.split(",");

        for (String value : values) {
            value = value.trim();
            sum = sum + Integer.parseInt(value);
        }

        return sum;
    }
}
