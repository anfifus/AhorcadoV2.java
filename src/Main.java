import java.util.*;

public class Main {
    // private final static ArrayList<String> arrayLife = new ArrayList<String>(List.of("Easy", "Medium", "Hard"));

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        int lifeGame = 0;
        String secretWord = "";
        String userWord = "";

        int wordsQuantity = howManyWords();
        words = writeWords(wordsQuantity);
        secretWord = writeSecretWord(words, wordsQuantity);

        lifeGame = selectDificult();
        System.out.println("The secret word is " + secretWord);
        do {
            System.out.println("You number of life is " + lifeGame);
            char character = operationWriteWord();
            boolean isContain = operationIsContain(secretWord, character);
            if (isContain) {

                userWord = operationKnowWord(secretWord, character, userWord);

            } else {
                System.out.println("We don't have the character " + character);
                lifeGame--;
            }
        }
        while (lifeGame > 0 || secretWord.equals(userWord));

        finalMessage(lifeGame, userWord);


    }

    private static void finalMessage(int lifeGame, String userWord) {
        if (lifeGame == 0) {
            System.out.println("You lose your life is " + lifeGame);
        } else {
            System.out.println("You won your word is " + userWord);
        }
    }


    private static String operationKnowWord(String secretWord, char character, String userWord) {
        //StringBuffer userTempWord = new StringBuffer(userWord);
        char[] userTempWord = new char[secretWord.length()];
        int contSecretWord = 0;

        do {

            if (secretWord.charAt(contSecretWord) == character) {
                //System.out.println("Length " + userTempWord.length());
                System.out.println("Length " + userTempWord.length);

                //userTempWord.insert(contSecretWord,secretWord.charAt(contSecretWord));
                userTempWord[contSecretWord] += secretWord.charAt(contSecretWord);
                System.out.println("This is the word we are creating: " + userTempWord);
            }
           /* else if(userTempWord.length == contSecretWord){

                userTempWord.insert(contSecretWord,' ');

            }*/
            contSecretWord++;
        }
        while (contSecretWord < secretWord.length());
        return userTempWord;
    }

    private static boolean operationIsContain(String secretWord, char character) {
        boolean isContain = false;
        if (secretWord.contains(String.valueOf(character))) {
            isContain = true;
        } else {
            isContain = false;
        }
        return isContain;
    }

    private static char operationWriteWord() {
        System.out.println("Write the character");
        Scanner scan = new Scanner(System.in);
        char word = scan.next().charAt(0);
        return word;
    }

    private static String writeSecretWord(ArrayList<String> words, int wordsQuantity) {
        Random rand = new Random();
        return words.get(rand.nextInt(0, wordsQuantity));
    }

    private static int selectDificult() {
        System.out.println("Write the dificult you want");
        System.out.println("1 is easy" + "\n" + "2 is medium" + "\n" + "3 is hard");
        int dificulty;
        int lifeSelected = 0;
        Scanner scan = new Scanner(System.in);
        do {
            dificulty = scan.nextInt();
            if (dificulty == 1) {
                lifeSelected = 3;
            } else if (dificulty == 2) {
                lifeSelected = 2;
            } else if (dificulty == 3) {
                lifeSelected = 1;
            }
        }
        while (dificulty < 0 && dificulty > 4);
        return lifeSelected;
    }

    private static ArrayList<String> writeWords(int wordsQuantity) {
        int cont = 0;
        ArrayList<String> words = new ArrayList<>();
        System.out.println("Write the " + wordsQuantity + " words");
        Scanner scan = new Scanner(System.in);
        while (cont < wordsQuantity) {
            words.add(scan.next());
            cont++;
        }
        return words;
    }

    private static int howManyWords() {
        System.out.println("Write the quantity of words you want to put");
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
}
