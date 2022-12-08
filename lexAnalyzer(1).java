import java.util.regex.*;
import java.util.*;
import java.nio.file.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.io.Console;

//@SuppressWarnings("unchecked")

public class lexAnalyzer extends Main {

    static Queue<Integer> tokens = new LinkedList<Integer>(); //queue for tokens
    static HashMap<String,Integer> map = new HashMap<String, Integer>();
  
  public static void main(String[] args) throws IOException {
    //operational functions
    String word = null; //char array for defining words
    String[] varBank = new String[] {}; //should introduce list of claimed variables 
    
    map.put("keikaku", 0); //program header statement
    map.put("kedo", 00); //bool statement
    //variables are 1
    map.put("moshimo", 2); //if statement
    map.put("mata", 3); //else statement
    map.put("sentaku", 4); //switch statement
    map.put("joutai", 5); //case statement
    map.put("tame_ni", 6); //for loop
    
    map.put("ko", 7); //byte
    map.put("chuu", 8); //short
    map.put("dai", 9); //int
    map.put("koudai", 10); //float
    //11, 12, 13, and 14 are short, int, byte, and float values
		map.put("tsutsu", 15); //while loop
		map.put("suru", 16); //do command for while loop

    map.put("{", 17); //rt curly brace
    map.put("}", 18); //lf curly brace  
    map.put("(", 19); //rt circle brack 
		map.put(")", 20); //lf circle brack
		map.put("=", 21); //assertion
    map.put("+", 22); //addition
		map.put("-", 23); //subtraction
		map.put("*", 24); //multiplication
    map.put("/", 25); //division
		map.put("%", 26); //modulo
		map.put("[", 27); //rt box brack
    map.put("]", 28); //lf box brack
		map.put(",", 29); //comma
    map.put("<", 30); //lessthan
		map.put(">", 31); //gr8rthan
		map.put("<=", 32); //lessthaneq2
    map.put(">=", 33); //gr8rthaneq2
    map.put("!=", 34); //noequal
    map.put("==", 35); //isequal
    map.put("\"", 36); //quot8ion
		map.put(".", 37); //periodt
	
    map.put("|", 39); //pipe
    map.put(":", 40); //colon
    map.put("$", 45); //termination of loops/switch stmts
		map.put("@", 50); //termination of if stmt
    map.put(";", 55); //termination of assertions
    map.put("\\n", 60); //EOL character
    map.put("\u001a", 65); //EOD character
    //69 is an erroneous lexeme
    map.put(" ", 99); //space
    
    String test = null; //should init a lexeme to be categorized
    //regex pattern for digits and variables
    Pattern digit = Pattern.compile("([0-9]+[o,h,d,b]?)|([0-9]*[.].[0-9]*)"); //wholes or decimals, also accounts for hex, octal, and binary
    Pattern variable = Pattern.compile("[a-z]*[A-Za-z_]{6-8}"); //variables. must start with lowercase but can
    //include uppers, digits and underscores
    Matcher digi = digit.matcher(test); boolean isDigi = digi.find();
    Matcher vari = variable.matcher(test); boolean isVari = vari.find();
    //matchers to check regex, and booleans for tokenizing
    
    //set to actually take files
    //please copy code into a .txt file
    Path please = Path.of("/home/runner/Exam2/testA.txt");
    String code = Files.readString(please);

    for (int i=0; i < code.length(); i++){
      char c = code.charAt(i);
      if (c == '>'|| c == '<'|| c== '!'|| c== '='){
        char d = code.charAt(i+1);
        if (d == '='){
          word = word + String.valueOf(c) + String.valueOf(d); //combines chars into char array
          test = word;
          if (map.containsValue(test)) tokens.add(map.get(test)); 
          //if (map.containsValue(lex)) tokens.add(map.get(lex)); 
          else tokens.add(69);
          word = null;
        }
        else tokens.add(69);
      }
      //checks for 2-character operations first (those involving equivalence)
      else if (c == '{'|| c =='}'|| c =='('|| c == ')'||c == '+'||c =='-'||c == '*'||c == '/'|| c == '%'||c =='['||c == ']'||c == ','||c == '\\' ||c == '.'||c == '|'){
      test = word;
        if (map.containsValue(test)) tokens.add(map.get(test)); 
        else tokens.add(69);
        word = null;
      }
      //then checks for 1-character operations  
      else if (c != ' ') word = word + String.valueOf(c);
      //then checks for a whitespace to push a word character to a char array  
      else{
        test = String.valueOf(word);
        word = null;
        if (isDigi) {
         float dGt = Float.parseFloat(test);
          if (dGt < 127 && dGt > -128) tokens.add(11); //byte
          else if (dGt < 32768 && dGt > -32769) tokens.add(12); //short
          else if (dGt < 2147483647 && dGt > -2147483648) tokens.add(13); //int
          else tokens.add(14); //float
        }
        else if (isVari) {
          String[] temp = Arrays.copyOf(varBank,varBank.length +1);
          temp[varBank.length] = test;
          varBank = temp;
          //adds variable name to an String array of previously claimed vars
          tokens.add(2);
        }
        else if (map.containsValue(test)) tokens.add(map.get(test)); 
        else if (c == '\n') tokens.add(60); //adds EOL character into array
        else tokens.add(69); //69 is a "failure to convert lexeme" value and will be noted as such
      }
    }

    //for (int j=0; j <tokens.size(); j++){
    System.out.print("queue top is:" + tokens.peek());
    System.out.println(tokens.toString());
    System.out.println("jesus stop playin with me");
    //}
    
}
} 