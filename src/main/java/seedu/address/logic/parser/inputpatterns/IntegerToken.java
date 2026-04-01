package seedu.address.logic.parser.inputpatterns;

/**
 * A Token that takes in any integer
 * The range of valid integers are given by the Suppliers minValueSupplier and maxValueSupplier
 */
public class IntegerToken extends Token {

    private final int minValue;
    private final int maxValue;

    /**
     * @param minValue the minimum possible integer in this field
     * @param maxValue the maximum possible integer in this field
     */
    public IntegerToken(String id, int minValue, int maxValue) {
        super(id);
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    /**
     * Initializes an {@code IntegerToken} with maximum value of {@code Integer.MAX_VALUE}.
     * @param minValue the minimum possible integer in this field
     */
    public IntegerToken(String id, int minValue) {
        this(id, minValue, Integer.MAX_VALUE);
    }

    @Override
    public String getPreview() {
        return "[" + minValue + "..." + maxValue + "]";
    }

    @Override
    public boolean matches(String segment) {
        try {
            int value = Integer.parseInt(segment);

            if (value < minValue) {
                return false;
            }
            if (value > maxValue) {
                return false;
            }

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
