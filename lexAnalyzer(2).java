import java.util.regex.*;
import java.io.*;
import java.nio.file.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;

public class lexAnalyzer{

    static Queue<Integer> tokens = new LinkedList(); //queue for tokens
    static HashMap<String,Integer> map = new HashMap<String, Integer>();
  
  public static void main(String[] args) {
    //operational functions
    String word = null; //char array for defining words
    //static map == new HashMap<String, Integer>(); //this should introduce the hash table in theory

    map.put("keikaku", 0); //program header statement
    //digits are 1, variables are 2
    map.put("moshimo", 3); //if statement
    map.put("mata", 4); //else statement
    map.put("sentaku", 5); //switch statement
    map.put("joutai", 6); //case statement
    map.put("ko", 7); //short
    map.put("chuu", 8); //int
    map.put("dai", 9); //float
    map.put("koudai", 10); //long
		map.put("tame_ni", 14); //for loop
		map.put("tsutsu", 15); //while loop

    map.put("{", 16); //rt curly brace
    map.put("}", 17); //lf curly brace  
    map.put("(", 18); //rt circle brack 
		map.put(")", 19); //lf circle brack
		map.put("=", 20); //assertion
    map.put("+", 21); //addition
		map.put("-", 22); //subtraction
		map.put("*", 23); //multiplication
    map.put("/", 24); //division
		map.put("%", 25); //modulo
		map.put("[", 26); //rt box brack
    map.put("]", 27); //lf box brack
		map.put(",", 28); //comma
    map.put("<", 29); //lessthan
		map.put(">", 30); //gr8rthan
		map.put("<=", 31); //lessthaneq2
    map.put(">=", 32); //gr8rthaneq2
    map.put("!=", 33); //noequal
    map.put("==", 33); //isequal
    map.put("\"", 35); //quot8ion
		map.put(".", 36); //periodt
		map.put(" ", 37); //space
    map.put("|", 38); //pipe
    
    String parseThis,lex = null; //should init a lexeme to be categorized
    //regex pattern for digits and variables
    Pattern digit = Pattern.compile("([0-9]*[o,h,d,b]?)|([0-9]*[.].[0-9]*)"); //wholes or decimals, also accounts for hex, octal, and binary
    Pattern variable = Pattern.compile("[a-z]*[A-Za-z0-9_]*"); //variables. must start with lowercase but can
    //include uppers, digits and underscores
    Matcher digi = digit.matcher(lex); boolean isDigi = digi.find();
    Matcher vari = variable.matcher(lex); boolean isVari = vari.find();
    //matchers to check regex, and booleans for tokenizing
    
    //set to actually take files
    //please copy code into a .txt file
    Path yourcode = Path.of(".\testA.txt");
    String code = Files.readString(yourcode);

    for (int i=0; i < code.length(); i++){
      char c = code.charAt(i);
      if (c == '>'|| c == '<'|| c== '!'|| c== '='){
        char d = code.charAt(i+1);
        if (d == '='){
          word = word + String.valueOf(c) + String.valueOf(d); //combines chars into char array
          lex = word;
          if (map.containsValue(lex)) tokens.add(map.get(lex)); 
          else tokens.add(69);
          word = null;
        }
        else tokens.add(69);
      }
      //checks for 2-character operations first (those involving equivalence)
      else if (c == '{'|| c =='}'|| c =='('|| c == ')'||c == '+'||c =='-'||c == '*'||c == '/'|| c == '%'||c =='['||c == ']'||c == ','||c == '\\' ||c == '.'||c == '|'){
       lex = word;
        if (map.containsValue(lex)) tokens.add(map.get(lex)); 
        else tokens.add(69);
        word = null;
      }
      //then checks for 1-character operations  
      else if (c != ' ') word = word + String.valueOf(c);
      //then checks for a whitespace to push a word character to a char array  
      else{
        lex = String.valueOf(word);
        word = null;
        if (isDigi) tokens.add(1);
        else if (isVari) tokens.add(2);
        else if (map.containsValue(lex)) tokens.add(map.get(lex));  
        else tokens.add(69); //69 is a "failure to convert lexeme" value and will be noted as such
      }
    }

    for (int j=0; j <tokens.size(); j++){
      System.out.print(j + " ");
    }
}
} 