public class Loader {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        char[] letters1 = {'У', 'К', 'Е', 'Н', 'Х', 'В'};
        char[] letters2 = {'А', 'Р', 'О', 'С', 'М', 'Т'};
        String url1 = "res/numbers1.txt";
        String url2 = "res/numbers2.txt";

        NumberConstructor numberConstructor1 = new NumberConstructor(start, url1, letters1);
        NumberConstructor numberConstructor2 = new NumberConstructor(start, url2, letters2);

        numberConstructor1.start();
        numberConstructor2.start();
    }
}
