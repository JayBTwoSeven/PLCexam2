import java.util.*;
import java.nio.file.*;
import java.io.IOException;

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
   //you would take in int array from lex analyzer
   //and you would run the token array by calling
   //the start method. Should parse recursively.
    
    
    
    }

  void start(int[] arr, int index){
    int offset;
    if (arr[index] != 0)
    index++;
    else {
      int nTkn = index+1;
      if (arr[nTkn] == 19){
        System.out.print("<START> invoked \n");
        offset = statement(arr,nTkn+1);
    }
      else System.out.print ("ERROR in code.");
        exit();
    }
  }
  int statement(int[] arr, int index){
    int offset;
    int nTkn = index+1;
    if (arr[index] == 99)
    index++;
    else {
      if (arr[nTkn] == 6){
        System.out.print("<FORLP> invoked \n");
        
        offset = f_loop(arr,nTkn);
        return offset;
      }
      else if (arr[nTkn] == 15){
        System.out.print("<WHILELP> invoked \n");
        
        offset = wh_loop(arr,nTkn);
        return offset;
      }
      else if (arr[nTkn] == 1){
        System.out.print("<Variable> detected \n");
        
        var(arr,nTkn);
        return offset;
      }
      else if (arr[nTkn] == 2){
        System.out.print("<IFSTMNT> invoked \n");
        
        offset = if_stmnt(arr,nTkn);
        return offset;
      }
      else if (arr[nTkn] == 4){
        System.out.print("<SWITCH> invoked \n");
        
        offset = swtch(arr,nTkn);
        return offset;
      }
      else System.out.print ("ERROR in code.");
        exit();
    }
  }
  int f_loop(int[] arr, int index){
    int offset;
    int nTkn = index+1;
    if (arr[index] == 99){
      if (arr[nTkn] == 19){
        System.out.print("<left parenthesis> invoked \n");
        nTkn++;
        f_loop(arr,nTkn);
        return offset;
      }
      else if (arr[nTkn] == 7){
        System.out.print("<variable type:BYTE> invoked \n");
        nTkn++;
        type(arr,nTkn);
        return offset;
      }
      else if (arr[nTkn] == 8){
        System.out.print("<variable type:SHORT> invoked \n");
        nTkn++;
        type(arr,nTkn);
        return offset;
      }
      else if (arr[nTkn] == 9){
        System.out.print("<variable type:INT> invoked \n");
        nTkn++;
        type(arr,nTkn);
        return offset;
      }
      else if (arr[nTkn] == 10){
        System.out.print("<variable type:FLOAT> invoked \n");
        nTkn++;
        type(arr,nTkn);
        return offset;
      }
      else if (arr[nTkn] == 00){
        System.out.print("<BOOLEAN> invoked \n");
        nTkn++;
        bool(arr,nTkn);
        return offset;
        }
      else if (arr[nTkn] == 1){
        System.out.print("<Variable> detected \n");
        var(arr,nTkn);
        return offset;
        }
      }  
      else System.out.print ("ERROR in code.");
        exit();
    }
  int wh_loop(int[]arr, int index){
    
  }
  int swtch(int[]arr, int index){
    
  }
  int swtcse(int[]arr, int index){
    
  }
  int if_stmnt(int[]arr, int index){
    
  }
  int var(int[]arr, int index){
    
  }
  int assrt(int[]arr, int index){
    
  }
  int type(int[]arr, int index){
    
  }
  int onePrecExp(int[]arr, int index){
    
  }
  int twoPrecExp(int[]arr, int index){
    
  }
  int thrPrecExp(int[]arr, int index){
    
  }
  int bool(int[]arr, int index){
    int offset;
    int nTkn = index+1;
    if(arr[index] == 1){
      var(arr,nTkn)
    }
  }
  int equlv(int[]arr, int index){
    int offset;
    int nTkn = index+1;
    if (arr[nTkn] != 30 && arr[nTkn] != 31 && arr[nTkn] != 32 && arr[nTkn] != 33 && arr[nTkn] != 34 && arr[nTkn] != 35){
      System.out.print ("ERROR in code.");
        exit();
    }
    else offset = nTkn;
    return offset;
  }
}