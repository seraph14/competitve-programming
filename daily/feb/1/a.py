class Solution:
    def minimumRecolors(self, blocks: str, k: int) -> int:
        count = blocks[:k].count("B")
	minimum = k - count

	for i in range(k, len(blocks)):
		if blocks[i - k] == "B":
			count -= 1
		count += blocks[i] == "B"
		minimum = min(minimum, k - count)
	return minimum
