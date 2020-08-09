import java.util.*;

public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sAnagram = s.toCharArray();
        char[] tAnagram = t.toCharArrray();

        Arrays.sort(sAnagram);
        Arrays.sort(tAnagram);

        return Arrays.equals(sAnagram, tAnagram);
    }
}