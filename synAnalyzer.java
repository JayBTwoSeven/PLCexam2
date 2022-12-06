import java.util.*;
import java.nio.file.*;
import java.io.IOException;

   /*
        <start>         --> keikaku ( <st8mnt> )
		
		<st8mnt>        --> <forlp><st8mnt> | <whllp><st8mnt> | <var><st8mnt> |
							<ifstmnt><st8mnt> | <swtch><swtchst> | <assert><st8mnt> | ε

    <forlp>         --> tame_ni (<type> <assert>; <boolexprs>; <exprs>) <st8mnt> $

    <whllp>         --> tsutsu (<boolexprs>) <st8mnt> $ | tsutsu (<boolexprs>) suru <st8mnt> $ 

		<swtch>         --> sentaku(id) <swtchst> $

		<swtchst>       --> joutai integer : <st8mnt> |ε

		<ifstmnt>       --> moshimo (<boolexprs>) <st8mnt> mata <st8mnt> @ 
							| moshimo (<boolexprs>) <st8mnt> @

		<var>           --> <type> id ; | <type> id = <exprs> ; 
		
		<assert>        --> id = <1pexprs> ;		

		<alpha>         --> a | b | c | ... | z | A | B | C | ... | Z 
		
		<type>          --> ko | chuu | dai | koudai

		<1pexprs>       --> <1pexprs> + <2pexprs> | <1pexprs> - <2pexprs> | <2pexprs>

    <2pexprs>       --> <2pexprs> * <exprs> | <2pexprs> / <exprs> | id | integer | % <exprs> | <exprs>

    <exprs>         -->  (<1pexprs>) | id | integer

		<boolexprs>     --> <1pexprs> <eqvlnce> <1pexprs>		

    <eqvlnce>       --> < | <= | == | > | >= | !=
      */
    
      //legacy code here
      /* Path parseThis = null;
        //Path.of("/home/runner/Exam2/testA.txt");
        //when you create the output file from lexAnalyzer, you'd grab it here
      String lexemes = Files.readString(parseThis);
      int lnNo = 1;
      String lnInc = "ln";
      int[] line = new int [] {60};
      //int[] arr = lexed;

      //insert call to print function for debug here
      
      for(int m=0; m < arr.length() - 1;m++){
        int token = arr[m];
        int pTkn = arr[m-1], nTkn = arr[m+1], n2T = arr[m+2], n3T = arr[m+3], n4T = arr[m+4];
        switch (token){
          case 0: //if program header
              if (nTkn != 19) System.out.print("ERROR in program header.");
              //if next token is not "(", returns error
              break;
          case 2: //if if stmnt
              if (nTkn != 19 && n2T != 1) System.out.print("ERROR in if statement or constant in if test");
              //if next token is not "(" or a variable name, returns error
              break;
          case 3: //if else statement
              if (nTkn != 19 && nTkn != 2) System.out.print("ERROR in else statement");
              //if next token is not "(" or "moshimo" ('if' equivalent), returns error
              break;
          case 4: //if switch statement
              if (nTkn != 19 && n2T != 1) System.out.print("ERROR in switch declarative statement");
              //if next token is not "(" or a variable name, returns error
              break;
          case 5: //if case statement
              if (nTkn != 8 && n2T != 40) System.out.print("ERROR in switch case statement");
              //if next token is not a digit type "dai" ('int' equivalent) or ":", returns error
              break;
          case 6: //if for loop
              if (nTkn != 19) System.out.print("ERROR in for loop");
              //if next token is not "(", returns error
              break;
          case 7: case 8: case 9: case 10: //if type for var declaration
              if (nTkn != 1) System.out.print("ERROR in variable statement");
              //if next token is not a variable name, returns error
              break;
          case 11: case 12: case 13: case 14: //if numerical value of the four types
              if (nTkn != 22 && nTkn != 23 && nTkn != 24 && nTkn != 25 && nTkn != 26 && nTkn != 28 &&
                  nTkn != 29 && nTkn != 30 && nTkn != 31 && nTkn != 32 && nTkn != 33 && nTkn != 34 &&
                  nTkn != 35 && nTkn != 39 && nTkn != 55)
                 System.out.print("ERROR in numerical assertion");
              //if number val is not followed by assertion, math op, equiv. expression, "]", "," or ";", returns error
              break;
          case 15: //if while loop
              if (nTkn != 19) System.out.print("ERROR in for loop");
              //if next token is not "(", returns error
              break;
          case 16: //if while loop
              if (pTkn != 20) System.out.print("ERROR in do-while loop");
              //if previous token is not ")", returns error
              break;
        }
      } */

public class synAnalyzer extends Main {
    public static void main (String[] args){
   
    
    
    
    }

  void start(int[] arr, int index){
    if (arr[index] != 0)
    index++;
    else {
      int nTkn = index+1;
      if (arr[nTkn] == 19)
      statement(arr,nTkn+1);
      
      else System.out.print ("")
        
    }
  }





}