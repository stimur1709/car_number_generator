import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class NumberConstructor extends Thread {
    private final long start;
    private final String url;
    private final char[] letters;

    public NumberConstructor(long start, String url, char[] letters) {
        this.start = start;
        this.url = url;
        this.letters = letters;
    }

    @Override
    public void run() {
        try (PrintWriter writer = new PrintWriter(url)
        ) {
            for (int regionCode = 1; regionCode < 100; regionCode++) {
                StringBuilder builder = new StringBuilder();
                for (int number = 1; number < 1000; number++) {
                    for (char firstLetter : letters) {
                        for (char secondLetter : letters) {
                            for (char thirdLetter : letters) {
                                builder.append(firstLetter);
                                builder.append(padNumber(number));
                                builder.append(secondLetter);
                                builder.append(thirdLetter);
                                builder.append(regionCode);
                                builder.append("\n");
                            }
                        }
                    }
                }
                writer.write(builder.toString());
            }

            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static String padNumber(int number) {
        String result = Integer.toString(number);
        if (result.length() == 2) {
            return "0" + result;
        }
        if (result.length() == 1) {
            return "00" + result;
        }
        return result;
    }

}