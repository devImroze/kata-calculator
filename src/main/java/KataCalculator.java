public class KataCalculator {

    public int Add(String numbers) {

        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        int sum = 0;

        numbers = numbers.replaceAll("\\D+", ",");

        numbers = trimSpecialCharacters(numbers);

        String[] values = numbers.split(",");

        for (String value : values) {
            value = value.trim();
            sum = sum + Integer.parseInt(value);
        }

        return sum;
    }

    private String trimSpecialCharacters(String numbers) {
        if (isNumber(numbers.charAt(0))){
            return numbers;
        }
        else {
            numbers = numbers.substring(1);
            trimSpecialCharacters(numbers);
        }

        return numbers;
    }

    public boolean isNumber(Character number) {
        try {
            double d = Integer.parseInt(number.toString());
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
