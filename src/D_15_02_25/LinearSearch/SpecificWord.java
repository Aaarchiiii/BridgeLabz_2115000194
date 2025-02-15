package D_15_02_25.LinearSearch;

public class SpecificWord {
    public static String Find(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence;
            }
        }
        return "Not Found";
    }
    public static void main(String[] args) {
        String[] sentences = {
                "Java is a powerful programming language.",
                "Linear search is simple but not always efficient.",
                "Data structures and algorithms are important.",
                "Practice makes a coder perfect."
        };
        String targetWord = "search";
        String result = Find(sentences, targetWord);
        System.out.println("Result: " + result);
    }
}
