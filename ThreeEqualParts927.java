import java.util.HashMap;
import java.util.LinkedList;

public class ThreeEqualParts927 {

    public int[] threeEqualParts(int[] arr) {
        String str1 = new String(), str2 = new String();
        HashMap<String, int[]> hashMap = new HashMap<>();
        LinkedList<String> linkedList = new LinkedList<>();
        int[] ones = new int[arr.length];
        StringBuilder stringBuilder = new StringBuilder();
        int stringBuilderSize = 0;

        for (int i = 0, ptr1 = 0, ptr2 = arr.length - 1; i < arr.length - 1; i++, ptr1++, ptr2--) {
            int e1 = arr[ptr1], e2 = arr[ptr2];

            // str1 is appended to last
            if (!str1.isEmpty() || (str1.isEmpty() && e1 != 0)) {
                str1 += e1;
            }

            // str2 is appended to head
            if (e2 == 1) {
                str2 = e2 + stringBuilder.substring(0, stringBuilderSize) + str2;
                stringBuilderSize = 0;
            }else {
                stringBuilderSize++;
                if (stringBuilder.length() < stringBuilderSize)
                    stringBuilder.append('0');
            }
            ones[ptr2] = stringBuilderSize;

            int[] val = hashMap.putIfAbsent(str1, new int[]{ptr1, 0});
            if (val != null && (str1.isEmpty() && ptr1 == 0 || !str1.isEmpty())) {
                linkedList.add(str1);
                val[0] = ptr1;
            }

            val = hashMap.putIfAbsent(str2, new int[]{0, ptr2});
            if (val != null) {
                if (stringBuilderSize <= 1)
                    linkedList.add(str2);
                val[1] = ptr2;
            }

        }

        String result = arr[0] + stringBuilder.substring(0, stringBuilderSize) + str2;

        if (linkedList.isEmpty())
            return new int[] {-1, -1};

        for(String str : linkedList) {
            int[] val = hashMap.get(str);
            int start = val[0] + 1;
            start += ones[start];
            int end = val[1] + ones[val[1]];
            String res = start >= end ? "" : result.substring(start, end);
            if (res.equals(str)){
                if (str.isEmpty())
                    return new int[] {val[0], end - 1};
                return new int[] {val[0], end};
            }else if (res.startsWith(str) && ones[val[1]] >= (res.length() - str.length())) {
                if (str.isEmpty())
                    return new int[] {val[0], end - 1};
                return new int[] {val[0], end - res.length() + str.length()};
            }
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] result = new ThreeEqualParts927().threeEqualParts(new int[] {0,0,0,0,0});
        System.out.println(result[0] + ", " + result[1]);
    }

}
