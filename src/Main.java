import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Задание 1");
//         https://leetcode.com/problems/decode-the-message/
//        You are given the strings key and message, which represent a
//        cipher key and a secret message, respectively.
//        The steps to decode message are as follows:
//        Use the first appearance of all 26 lowercase English letters in key as the order of the substitution table.
//Align the substitution table with the regular English alphabet.
//Each letter in message is then substituted using the table.
//Spaces ' ' are transformed to themselves.
        task1();

        System.out.println("Задание 2");
//        https://leetcode.com/problems/sorting-the-sentence/
//        A sentence is a list of words that are separated by a single space
//        with no leading or trailing spaces. Each word consists of lowercase and
//        uppercase English letters.
//
//A sentence can be shuffled by appending the 1-indexed word position to each
// word then rearranging the words in the sentence.
//
//For example, the sentence "This is a sentence" can be shuffled as
// "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
//Given a shuffled sentence s containing no more than 9 words, reconstruct and
// return the original sentence.
        task2();

        System.out.println("Задание 3");
//        https://leetcode.com/problems/unique-morse-code-words/
//        International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:
//
//'a' maps to ".-",
//'b' maps to "-...",
//'c' maps to "-.-.", and so on.
//For convenience, the full table for the 26 letters of the English alphabet is
// given below:
//
//[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",
// "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-",
// "-.--","--.."]
//        Given an array of strings words where each word can be written as a
//        concatenation of the Morse code of each letter.
//
//For example, "cab" can be written as "-.-..--...", which is the concatenation
// of "-.-.", ".-", and "-...". We will call such a concatenation the
// transformation of a word.
//Return the number of different transformations among all words we have.
        task3();

        System.out.println("Задание 4");
//https://leetcode.com/problems/reverse-prefix-of-word/
//Given a 0-indexed string word and a character ch, reverse the segment of
// word that starts at index 0 and ends at the index of the first occurrence
// of ch (inclusive). If the character ch does not exist in word, do nothing.
//
//For example, if word = "abcdefd" and ch = "d", then you should reverse the
// segment that starts at 0 and ends at 3 (inclusive). The resulting string
// will be "dcbaefd".
//Return the resulting string.

        task4();

        System.out.println("Задание 5");
//https://leetcode.com/problems/determine-color-of-a-chessboard-square/
//You are given coordinates, a string that represents the coordinates of a
// square of the chessboard. Below is a chessboard for your reference.
//Return true if the square is white, and false if the square is black.
//
//The coordinate will always represent a valid chessboard square. The
// coordinate will always have the letter first, and the number second.

        task5();

        System.out.println("Задание 6");
//https://leetcode.com/problems/percentage-of-letter-in-string/
//Given a string s and a character letter, return the percentage of characters
// in s that equal letter rounded down to the nearest whole percent.
//Example 1:
//
//Input: s = "foobar", letter = "o"
//Output: 33
//Explanation:
//The percentage of characters in s that equal the letter 'o'
// is 2 / 6 * 100% = 33% when rounded down, so we return 33.

        task6();
    }
    public static void task1(){
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char [] key = "the quick brown fox jumps over the lazy dog"
                .replace( " ","")
                .toCharArray();
        char[] key1 =new char[alphabet.length];
        String message = "vkbs bs t suepuv";
        boolean find;
        int k = 0;
        for (int i = 0; i<key.length; i++) {
            find=false;
            for (int j = 0; j < i; j++)
                if (key[j] == key[i]) {find = true; break; }
            if (!find) {
                key1[k] = key[i];
                k++;
            }
        }
        String answer="";
        char c;
        for (int i = 0; i<message.length(); i++){
            c= message.charAt(i);
            if (c == ' ')
                answer+=c;
            else
                for (int j= 0; j< key1.length; j++)
                    if(c==key1[j])
                        answer+=alphabet[j];
        }
        System.out.println(answer);
    }
    public static void task2(){
        String s = "is2 sentence4 This1 a3";
        String [] word = s.split(" ");
        String [] wordNew = new String[word.length];
        for (int i = 0; i < word.length; i++){
            String word1 = word[i].substring(0,word[i].length()-1);
            int index= Integer.parseInt(String.valueOf(word[i].charAt(word[i].length()-1)));
            wordNew[index-1] = word1;
        }
        String originalS="";
        for (String st: wordNew)
            originalS+=st+" ";
        System.out.printf("%s ",originalS);
    }
    public static void task3(){
    Map <Character,String> morze = new TreeMap<>();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String[] morzeL = {".-","-...","-.-.","-..",".","..-.","--.","....","..",
                ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-",
                "..-","...-",".--","-..-","-.--","--.." };
        String[] words = {"gin","zen","gig","msg"};
        String[] wordsMorze = new String[words.length];
        for(int i=0; i<alphabet.length; i++)
            morze.put(alphabet[i],morzeL[i]);

        for (int i=0; i<words.length; i++){
            wordsMorze[i]="";
            for(int j = 0; j<words[i].length(); j++)
                wordsMorze[i]+=morze.get(words[i].charAt(j));
        }
        String cop = wordsMorze[1];
        int transformation = 1;
        for (int i = 0; i< wordsMorze.length; i++)
            if(!wordsMorze[i].equals(cop)){
                transformation++;
                cop=wordsMorze[i];
            }
        System.out.println("The number of different transformations " +
                "among all words we have: "+transformation);
    }
    public static void task4(){
        String word = "abcdefd";
        String wordOut = "";
        char ch='d';
        int index=word.indexOf(ch);
        for (int i = index; i>=0; i--)
            wordOut+=word.charAt(i);
        wordOut+=word.substring(index+1);
        System.out.println(wordOut);
    }
    public static void task5(){
        String abc = "abcdefgh";
        boolean color= false;
        String coordinates="a1";
        boolean square;
        Map <Character,Boolean> chessboard = new HashMap<>();
        for (int i = 0; i<abc.length(); i++) {
            chessboard.put(abc.charAt(i), color);
            color = !color;
        }
        char letter = coordinates.charAt(0);
        int index = Integer.parseInt(String.valueOf(coordinates.charAt(1)));
        if (index%2==0)
            square = !chessboard.get(letter);
        else
            square = chessboard.get(letter);

        System.out.println(square);
    }
    public static void task6(){
       String s = "foobar";
       char letter = 'o';
        int percent=0;
       Map <Character,Integer> string = new HashMap<>();
       for (int i = 0; i<s.length(); i++)
           string.merge(s.charAt(i), 1, (currentCount, notUsed) -> ++currentCount);
        if (string.containsKey(letter))
             percent = (string.get(letter)*100)/s.length();
        else
            percent = 0;
        System.out.println(percent);
    }
}
