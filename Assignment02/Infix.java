public class Infix {
    private static int nextIndex;
    private static char[] terminals;

    /**
     * Grabs CLI input and sends it to parser
     * @param args The string to be parsed
     */
    public static void main(String[] args) {
        String str = "+++12-835";
        if (args.length > 0) {
            str = args[0];
        }
        try {
            Infix parser = new Infix(str);
        } catch (Exception e) {
            System.out.print("error");
        }
    }

    /**
     * Constructor, sets up lookahaed character and starts parsing
     * @param terminals String of teriminals to parse
     * @throws Exception Terminals are incompatible with grammar
     */
    public Infix(String terminals) throws Exception {
        this.terminals = terminals.toCharArray();
        nextIndex = 0;
        list();

        // Failed to Parse Entire String by Applie the Root Production
        if (nextIndex != terminals.length()) {
            throw new Exception();
        }
    }

    /**
     * Production rule for lists
     * @throws Exception Terminals do not match production rule
     */
    private static void list() throws Exception {
        switch (terminals[nextIndex]) {
            case '+':
                match('+');
                System.out.print("(");
                list();
                System.out.print("+");
                list();
                System.out.print(")");
                break;
            case '-':
                match('-');
                System.out.print("(");
                list();
                System.out.print("-");
                list();
                System.out.print(")");
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                digit();
                break;
            default:
                throw new Exception();

        }

    }

    /**
     * Production rule for digits
     * @throws Exception Terminals do not match digit production rules
     */
    private static void digit() throws Exception {
        switch (terminals[nextIndex]) {
            case '0':
                match('0');
                System.out.print("0");
                break;
            case '1':
                match('1');
                System.out.print("1");
                break;
            case '2':
                match('2');
                System.out.print("2");
                break;
            case '3':
                match('3');
                System.out.print("3");
                break;
            case '4':
                match('4');
                System.out.print("4");
                break;
            case '5':
                match('5');
                System.out.print("5");
                break;
            case '6':
                match('6');
                System.out.print("6");
                break;
            case '7':
                match('7');
                System.out.print("7");
                break;
            case '8':
                match('8');
                System.out.print("8");
                break;
            case '9':
                match('9');
                System.out.print("9");
                break;
            default:
                throw new Exception();
        }
    }

    /**
     * Tests that the lookahead character is correct
     * @param s Expected character
     * @throws Exception Lookahead character is not as expected
     */
    private static void match(char s) throws Exception {
        if (s == terminals[nextIndex]) {
            nextIndex += 1; // We Don't Check for OOB Because an Out of Bounds Access Will Represent a Parsing Error Either Way
        }
        else {
            throw new Exception();
        }
    }
}
