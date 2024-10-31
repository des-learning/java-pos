import java.util.Optional;
import java.util.Scanner;

/**
 * abstract input integer process
 * this will loop the input process until blank or the valid number inputted
 * if default value is provided then when user input blank then default value
 * will be returned instead
 */
public class IntegerInput {
    private String prompt;
    private Integer defaultValue;

    public IntegerInput(String prompt) {
        this.prompt = prompt;
        this.defaultValue = null;
    }

    public IntegerInput(String prompt, int defaultValue) {
        this.prompt = prompt;
        this.defaultValue = defaultValue;
    }

    public Integer getInput() throws NumberFormatException {
        Scanner input = new Scanner(System.in);

        do {
            System.out.print(prompt);
            String nextLine = input.nextLine();
            if (nextLine.isBlank()) {
                return defaultValue;
            }

            try {
                return Integer.parseInt(nextLine);
            } catch (NumberFormatException e) {
            }
        } while (true);
    }
}
