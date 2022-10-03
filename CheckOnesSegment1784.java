public class CheckOnesSegment1784 {
    public boolean checkOnesSegment(String s) {
        char[] chars = s.toCharArray();
        boolean isConsecutive = false;
        int num = 0;
        for (char c: chars) {
            if (c == '0') 
                isConsecutive = false;
            else {
                if (!isConsecutive) {
                    num++;
                    if (num > 1)
                        return false;
                }
                isConsecutive = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CheckOnesSegment1784().checkOnesSegment("1110"));
    }
}
