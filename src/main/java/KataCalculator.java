import java.util.List;
import java.util.ArrayList;

public class KataCalculator {

    public int Add(String numbers) {

        if (numbers == null || numbers.isEmpty()) return 0;

        checkIfContainsNegatives(numbers);

        int sum = 0;

        numbers = numbers.replaceAll("\\D+", ",");

        String[] values = numbers.split(",");

        for (String value : values) {

            if (value.isEmpty() || Integer.parseInt(value) > 1000) continue;

            value = value.trim();
            sum = sum + Integer.parseInt(value);
        }

        return sum;
    }

    private void checkIfContainsNegatives(String numbers) {
        List<Integer> negatives = new ArrayList<>();

        //check if there is any numeric value next to any minus sign
        for (int index = 0; index < numbers.length(); index++) {
            if (numbers.charAt(index) == '-' && isNumber(numbers.charAt(index + 1))) {
                negatives.add(getTheExactNumber(index, numbers));
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException(
                    "negatives not allowed "
                            +
                            String.join(",", negatives.toString()
                                    .replace("[", "")
                                    .replace("]", "")));
        }
    }

    private Integer getTheExactNumber(int indexOfMinus, String numbers) {

        String number = String.valueOf(numbers.charAt(indexOfMinus)) + numbers.charAt(indexOfMinus + 1);

        //check if there is any other digit after the *starting* digit
        for (int indexPostMinusAndDigit = indexOfMinus + 2; indexPostMinusAndDigit < numbers.length(); indexPostMinusAndDigit++) {
            if (isNumber(numbers.charAt(indexPostMinusAndDigit))) {
                number = number + numbers.charAt(indexPostMinusAndDigit);
            } else break;
        }

        return Integer.parseInt(number);
    }

    public boolean isNumber(Character number) {
        try {
            Integer.parseInt(number.toString());
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


}
