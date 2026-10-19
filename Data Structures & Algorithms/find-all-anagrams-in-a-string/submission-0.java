class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> best = new ArrayList<>();

        int k = p.length();

        if (k > s.length()) {
            return best;
        }

        // Count the frequency of characters in p
        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int count = k;

        while (right < s.length()) {
            char c = s.charAt(right);

            // Include the current character in the window
            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    count--;
                }
                map.put(c, map.get(c) - 1);
            }

            // Expand the window
            right++;

            // If window size exceeds k, remove the leftmost character
            if (right - left > k) {
                char removed = s.charAt(left);

                if (map.containsKey(removed)) {
                    map.put(removed, map.get(removed) + 1);

                    if (map.get(removed) > 0) {
                        count++;
                    }
                }

                left++;
            }

            // All required characters matched
            if (count == 0 && right - left == k) {
                best.add(left);
            }
        }

        return best;
    }
}