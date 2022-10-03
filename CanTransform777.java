public class CanTransform777 {



    public boolean canTransform(String start, String end) {
        int index = 0, length = start.length();
        while (index < length) {
            char s = start.charAt(index);
            char e = end.charAt(index);
            if (start.charAt(index) == end.charAt(index)) {
                index++;
                continue;
            }
            if (s == 'X') {
                if (e == 'R')
                    return false;
                int ptr = index + 1;
                int offset = -1;
                while (ptr < length) {
                    int c = start.charAt(ptr);
                    if (c == end.charAt(ptr) && c != 'R') {
                        ptr++;
                        continue;
                    }if (start.charAt(ptr) == 'X' && end.charAt(ptr) == 'L')
                        offset--;
                    else if (start.charAt(ptr) == 'L' && end.charAt(ptr) == 'X') {
                        offset++;
                        if (offset > 0)
                            return false;
                    }else
                        break;
                    ptr++;
                }
                if (offset == 0) {
                    index = ptr;
                    continue;
                }
            } else if (s == 'R') {
                if (e == 'L')
                    return false;
                int ptr = index + 1;
                int offset = -1;
                while (ptr < length) {
                    int c = start.charAt(ptr);
                    if (c == end.charAt(ptr) && c != 'L') {
                        ptr++;
                        continue;
                    }
                    if (start.charAt(ptr) == 'R' && end.charAt(ptr) == 'X')
                        offset--;
                    else if (start.charAt(ptr) == 'X' && end.charAt(ptr) == 'R') {
                        offset++;
                        if (offset > 0)
                            return false;
                    }else
                        break;
                    ptr++;
                }
                if (offset == 0) {
                    index = ptr;
                    continue;
                }
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CanTransform777().canTransform("XXXXXLXXXLXXXX", "XXLXXXXXXXXLXX"));
    }


}
