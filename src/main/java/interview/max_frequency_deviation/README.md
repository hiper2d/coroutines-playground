# Max Frequency Deviation

Given a string of lower English letters. For each possible distinct substring find a frequency deviation. Frequency deviation is the differency between the frequency of the most repated charecter and the frequency of the least repated characters.

For example,
String "aaab": deviation is 3 - 1 = 2
String "aabb": deviation is 2 - 2 = 0
String "a": deviation is 1 - 1 = 0

Return the maximum deviation for all possible substrings.

### Example 1
Input: "bbacccabab"
Output: 2
Explanation: Substrings "accc" and "ccca" have the max deviation which is 2

### Example 2:
Input: "aaaa"
Output: 0
Explanation: All possible substrings consist of the same character, so the deviation is always 0 
