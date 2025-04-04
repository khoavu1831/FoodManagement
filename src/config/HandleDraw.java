package config;

public class HandleDraw {
    // Text colors
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLACK = "\u001B[30m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String RESET = "\u001B[0m";
    public static final String BRIGHT_RED = "\u001B[91m";

    // Text he thong
    public static final String SYSTEM_TXT = RED;
    public static final String TITLE_TXT = YELLOW;
    public static final String REPLY_TXT = GREEN;

    private HandleDraw() {
    }

    public static void handleDrawBoard(String str, String color) {
        System.out.printf("%s %s %n", "=".repeat(str.length()), RESET);
        System.out.printf("%s %s %s %n", color, str, RESET);
        System.out.printf("%s %s %n", "=".repeat(str.length()), RESET);
    }

    public static void handlePrintln(String str, String color) {
        System.out.printf("%s %s %s %n", color, str, RESET);
    }

    public static void handlePrint(String str, String color) {
        System.out.printf("%s %s %s", color, str, RESET);
    }

    public static void handleReplyTxt(String str) {
        handlePrint(">" + str + ": ", REPLY_TXT);
    }

    public static void handleSystemTxt(String str) {
        handlePrintln("<" + str + ">", SYSTEM_TXT);
    }

    public static void handleTitleList(String str1, String str2) {
        handlePrint("+ " + str1, PURPLE);
        handlePrintln(str2, WHITE);
    }

    public static void handleChildTitleList(String str1, String str2) {
        handlePrint("       " + str1, BLUE);
        handlePrintln(str2, WHITE);
    }

    public static void handleTitleYellowTxt(String str, int lineCount) {
        handlePrintln(" ".repeat(lineCount) + "<" + str.toUpperCase() + ">", YELLOW);
    }

    public static void handleEndline(int line) {
        for (int i = 0; i < line; i++) {
            System.out.println();
        }
    }

    public enum Country {
        VIETNAM("vietnam", "VND"),
        USA("usa", "USD"),
        JAPAN("japan", "JPY"),
        UK("uk", "GBP"),
        EU("eu", "EUR");

        private final String name;
        private final String currency;

        Country(String name, String currency) {
            this.name = name;
            this.currency = currency;
        }

        public String getName() {
            return name;
        }

        public String getCurrency() {
            return currency;
        }

        public static Country fromName(String name) {
            for (Country country : values()) {
                if (country.name.equalsIgnoreCase(name.trim())) {
                    return country;
                }
            }
            return null;
        }
    }

    public static void handleCurrency(String countryName) {
        Country country = Country.fromName(countryName);
        if (country != null) {
            handlePrintln(country.getCurrency(), CYAN);
        } else {
            handleSystemTxt("Loi don vi tien te: Khong tim thay quoc gia!");
        }
    }
}
