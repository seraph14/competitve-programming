class StreamChecker:        
    def __init__(self, words: List[str]):
        self.dictionary = TrieNode()
        self.current = self.dictionary
        
        for word in words:
            self.dictionary.insert(word[::-1])
        
        self.queries = []
        
    def query(self, letter: str) -> bool:
        self.queries.append(letter)
        
        word = self.queries
        return self.dictionary.search(word)
        
class TrieNode():
    def __init__(self):
        self.isEnd = False
        self.children = [None for _ in range(26)]

    def insert(self, word):
        current = self
        for letter in word:
            currIndex = ord(letter) - ord('a')
            if not current.children[currIndex]:
                current.children[currIndex] = TrieNode()
            current = current.children[currIndex]
        
        current.isEnd = True

    def search(self, word):
        current = self
        for i in range(len(word)-1, -1, -1):
            letter = word[i]
            currIndex = ord(letter) - ord('a')
            if current.children[currIndex]:
                current = current.children[currIndex]
            else:
                return False
            if current.isEnd: return True

        return current.isEnd

# Your StreamChecker object will be instantiated and called as such:
# obj = StreamChecker(words)
# param_1 = obj.query(letter)
