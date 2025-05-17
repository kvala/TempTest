public class Q824GoatLatin {
    public String toGoatLatin(String sentence) {
           // Use a HashSet for efficient vowel checking.
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        // Split the sentence into words.  This is generally preferred for word manipulation.
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        // Iterate through the words.
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder newWord = new StringBuilder(word);

            // Check if the word starts with a vowel.
            if (vowels.contains(word.charAt(0))) {
                // If it starts with a vowel, append "ma".
                newWord.append("ma");
            } else {
                // If it starts with a consonant, move the first letter to the end and append "ma".
                char firstChar = newWord.charAt(0);
                newWord.deleteCharAt(0);
                newWord.append(firstChar).append("ma");
            }

            // Append "a" i+1 times.
            for (int j = 0; j < i + 1; j++) {
                newWord.append("a");
            }

            // Add the modified word to the result, followed by a space (unless it's the last word).
            result.append(newWord);
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        // Return the final Goat Latin sentence.
        return result.toString();   
    }
}
