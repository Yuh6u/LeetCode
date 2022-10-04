import java.util.LinkedList;

public class MinAddToMakeValid921 {

    public int minAddToMakeValid(String s) {
        LinkedList<Character> linkedList = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (linkedList.isEmpty() || c == '(') 
                linkedList.add(c);
            else if (linkedList.getLast() == '(')
                linkedList.pollLast();
            else
                linkedList.add(c);
        }
        return linkedList.size();
    }

    public static void main(String[] args) {
        System.out.println(new MinAddToMakeValid921().minAddToMakeValid("())"));
    }
}
