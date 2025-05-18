public class Q408_Valid_Word_Abbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int idx1 = 0, idx2 = 0;

        while (idx1 < word.length() && idx2 < abbr.length()) {

            if (word.charAt(idx1) == abbr.charAt(idx2)) {
                idx1++;
                idx2++;
            } else if (!Character.isDigit(abbr.charAt(idx2))) {
                return false;
            } else {
                int num = 0;
                while (idx2 < abbr.length() && Character.isDigit(abbr.charAt(idx2))) {

                    // Stupid test case
                    if (num == 0 && abbr.charAt(idx2) == '0')
                        return false;

                    num = num * 10 + (abbr.charAt(idx2) - '0');
                    idx2++;
                }
                idx1 += num;
            }
        }
        return idx1 == word.length() && idx2 == abbr.length();
    }

    public static void main(String[] args) {
        Q408_Valid_Word_Abbreviation s = new Q408_Valid_Word_Abbreviation();
        System.out.println(s.validWordAbbreviation("internationalization", "i12iz4n"));
    }
}
