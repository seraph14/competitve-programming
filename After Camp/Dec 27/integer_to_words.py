class Solution:
    def numberToWords(self, num: int) -> str:
        numbers = {
            0: "Zero", 1: 'One', 2: 'Two', 3: 'Three', 4: 'Four', 
            5: 'Five', 6: 'Six', 7: 'Seven', 8: 'Eight', 9: "Nine",
            10: 'Ten', 11: 'Eleven', 12: 'Twelve', 
            13: 'Thirteen', 14: 'Fourteen', 15: 'Fifteen', 
            16: 'Sixteen', 17: 'Seventeen', 18: 'Eighteen', 
            19: 'Nineteen', 20: 'Twenty', 30: 'Thirty', 
            40: 'Forty', 50: 'Fifty', 60: 'Sixty', 70: 'Seventy',
            80: 'Eighty', 90: 'Ninety', 100: 'Hundred', 
            1000: 'Thousand', 1000000: 'Million', 1000000000: 'Billion'
        }
        
        tens = [1000000000, 1000000, 1000, 1]
        
        def get_two_digit_word(result, num):
            if num == 0:
                return
            if num in numbers:
                result.append(numbers[num])
                return
            
            result.append(numbers[num - num%10])
            result.append(numbers[num%10])
                
        def get_three_digit_word(num, ten):
            result = [] 
            if num // 100 > 0:
                result.append(numbers[num // 100] + 
                              " " + numbers[100])  
                
            get_two_digit_word(result, num % 100)
            power_of_ten = " " + numbers[ten] if ten > 1 else ""
            if result:
                return " ".join(result) + power_of_ten
            return ""
        
        result = []
        for ten in tens:
            if num // ten > 0:
                result.append(get_three_digit_word(num // ten, ten))
            num = num % ten
        
        return " ".join(result) or "Zero"
