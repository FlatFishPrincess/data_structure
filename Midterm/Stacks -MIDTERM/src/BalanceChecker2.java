import java.util.Stack;

public class BalanceChecker2 {

    public static boolean checkBalance(String str){

        boolean isPair = true;
        // get the string
        // then check the balance
        // ([{ ==> )]}
        // if opening, store a character in character stack,
        // if closing, pop a character then compare the popped character and the strChar

        Stack<Character> characterStack = new Stack<>();

        for(int i = 0; i<str.length(); i++){
            char strChar = str.charAt(i);
            switch (strChar){
                case '(' :
                case '[':
                case '{':
                    characterStack.push(strChar);
                    break;
                case ')':
                case ']':
                case '}':
                    // check if characterstack is empty
                    // if yes, not pair  // if not, pop the last character then compare it
                    if(characterStack.isEmpty()){
                        isPair = false;
                        break;
                    } else {
                        char poppedChar = characterStack.pop();
                        isPair = iscompare(poppedChar, strChar);
                    }
                    break;
            }
        }
        if(characterStack.size() > 0){
            isPair = false;
        }
        return isPair;
    }

    public static boolean iscompare(char stackChar, char nextChar){
        return (stackChar == '(' && nextChar == ')' || stackChar == '[' && nextChar == ']' || stackChar == '{' && nextChar == '}');
    }
}
