class Solution {
    public String digitToWord(int digit) {
        switch (digit) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        return "";
    }
    
    public String tenToWord(int ten) {
        switch (ten) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
        }
        return "";
    }
    
    public String tensToWord(int tens) {
        switch (tens) {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
        }
        return "";
    }
    
    public String partToWord(int part) {
        switch (part) {
            case 3: return "Billion";
            case 2: return "Million";
            case 1: return "Thousand";
        }
        return "";
    }
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        
        int[] stage = new int[4];
        int stg = 0, tmp = 0, cnt = 0;
        while (num > 0) {
            if (cnt == 3) {
                stage[stg ++] = tmp;
                tmp = cnt = 0;
            }
            tmp = tmp + num % 10 * (int)Math.pow(10, cnt ++);
            num /= 10;
        }
        stage[stg ++] = tmp;
        
        List<String> ans = new ArrayList<String>();       
        for (int part = stg - 1; part >= 0; part --) {
            tmp = stage[part];
            int hun = tmp / 100;
            int ten = tmp % 100 / 10;
            int one = tmp % 10;
            
            if (hun > 0) {
                ans.add(digitToWord(hun));
                ans.add("Hundred");
            }
            if (ten == 1)
                ans.add(tensToWord(ten * 10 + one));
            else {
                if (ten > 1)
                    ans.add(tenToWord(ten));
                if (one > 0)
                    ans.add(digitToWord(one));
            }
            if (tmp > 0 && part > 0)
                ans.add(partToWord(part));
        }
        return String.join(" ", ans);
    }
}