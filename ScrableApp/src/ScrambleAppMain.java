public class ScrambleAppMain{
    private String allPermutations;
/**
 * 
 * @param input Takes a word to show all permutations
 * @return Returns all the permutations of the input
 */
    public String generateAllPermutations(String input) {
        allPermutations = "";
        createPermutations(input, "");
        return allPermutations;
    }
/**
 * 
 * @param remaining Which chars are remaining
 * @param selected Which chars have already been used
 */
    public void createPermutations(String remaining, String selected) {
        if (remaining.isEmpty()) {
            allPermutations += selected + "\n";
        } else {
            for (int index = 0; index < remaining.length(); index++) {
                char currentChar = remaining.charAt(index);
                String newSelected = selected + currentChar;
                String newRemaining = remaining.substring(0, index) + remaining.substring(index + 1);
                createPermutations(newRemaining, newSelected);
            }
        }
    }

}