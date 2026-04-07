class Solution {

    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        // Step 1: basic validation
        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i) return "";
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] != lcp[j][i]) return "";
            }
        }

        char[] word = new char[n];
        for (int i = 0; i < n; i++) {
            word[i] = '$';
        }

        // Step 2: construct string
        for (int i = 0; i < n; i++) {

            // try to match with previous characters
            for (int j = 0; j < i; j++) {
                if (lcp[j][i] > 0) {
                    word[i] = word[j];
                    break;
                }
            }

            // assign smallest valid character
            if (word[i] == '$') {
                boolean[] forbidden = new boolean[26];

                for (int j = 0; j < i; j++) {
                    if (lcp[j][i] == 0 && word[j] != '$') {
                        forbidden[word[j] - 'a'] = true;
                    }
                }

                for (int c = 0; c < 26; c++) {
                    if (!forbidden[c]) {
                        word[i] = (char) ('a' + c);
                        break;
                    }
                }

                if (word[i] == '$') return "";
            }
        }

        String result = new String(word);

        // Step 3: verify using LCP
        return checkLCP(result, lcp) ? result : "";
    }

    public boolean checkLCP(String s, int[][] lcp) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int len = 0;

                while (i + len < n && j + len < n &&
                        s.charAt(i + len) == s.charAt(j + len)) {
                    len++;
                }

                if (lcp[i][j] != len) return false;
            }
        }
        return true;
    }
}
