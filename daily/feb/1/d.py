class Solution:
    def earliestFullBloom(self, plant: List[int], grow: List[int]) -> int:
        n = len(plant)
        grow_plant = [(-grow[i], plant[i]) for i in range(n)]
        grow_plant.sort()

        earliest = plant_time = 0

        for i in range(n):
            earliest = max(earliest, plant_time + -grow_plant[i][0] + grow_plant[i][1])
            plant_time += grow_plant[i][1]

        return earliest 
