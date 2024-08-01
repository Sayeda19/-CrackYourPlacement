class Solution {
    public boolean backspaceCompare(String s, String t) {
        return process(s).equals(process(t));
    }
    
    // Helper method to process the string with backspaces
    private String process(String str) {
        StringBuilder sb = new StringBuilder();
        int backspaceCount = 0;
        
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == '#') {
                backspaceCount++;
            } else {
                if (backspaceCount > 0) {
                    backspaceCount--;
                } else {
                    sb.append(ch);
                }
            }
        }
        
        return sb.reverse().toString();
    }
}
