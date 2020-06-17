import java.util.List;
import java.util.ArrayList;

public class KataCalculator {

    List<Integer> negatives = new ArrayList<>();

    public int Add(String numbers) {

        if (numbers == null || numbers.isEmpty()) return 0;

        if (containsNegative(numbers)) throw new IllegalArgumentException(
                "negatives not allowed " + String.join(",", negatives.toString()));

        int sum = 0;

        numbers = numbers.replaceAll("\\D+", ",");

        numbers = trimSpecialCharactersFromBeginning(numbers);

        String[] values = numbers.split(",");

        for (String value : values) {

            if (Integer.parseInt(value) > 1000) continue;

            value = value.trim();
            sum = sum + Integer.parseInt(value);
        }

        return sum;
    }

    private boolean containsNegative(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            if (numbers.charAt(i) == '-' && isNumber(numbers.charAt(i + 1))) {

                String number;
                number = String.valueOf(numbers.charAt(i)) + numbers.charAt(i + 1);

                for (int j = i + 2; j < numbers.length(); j++){
                    if (isNumber(numbers.charAt(j))){
                        number = number + numbers.charAt(j);
                    }
                    else break;
                }

                negatives.add(Integer.parseInt(number));
            }
        }

        return !negatives.isEmpty();
    }

    private String trimSpecialCharactersFromBeginning(String numbers) {
        if (isNumber(numbers.charAt(0))) {
            return numbers;
        } else {
            numbers = numbers.substring(1);
            trimSpecialCharactersFromBeginning(numbers);
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
