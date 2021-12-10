class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:        
        wordLen = len(words[0])        
        wordCount = Counter(words)
        windowWordCount = defaultdict(int)
        validSubstringLen = wordLen * len(words)
        
        result = []
        for j in range(wordLen):
            left, leftWord = j, j
            windowWordCount = defaultdict(int)
            
            for i in range(left + wordLen, len(s) + wordLen, wordLen):
                currWord = s[i-wordLen: i]

                if currWord in wordCount:
                    windowWordCount[currWord] += 1
                    while windowWordCount[currWord] > wordCount[currWord]:
                        prevWord = s[left: left + wordLen]
                        windowWordCount[prevWord] -= 1
                        left += wordLen

                    if i - left == validSubstringLen:
                        result.append(left)
                else:
                    left = i
                    windowWordCount = defaultdict(int)

        return result
