import java.io.*;
import java.util.*;

public class SpanishToEnglish {
   public static void main(String[] args) throws Exception{
   
   String key = "";
   String val = "";
   boolean first = true;
   
   Map<String, String> map = new TreeMap<String, String>();
   String fileName = "lab08a.dat";
   Scanner file = new Scanner(new File(fileName));
   int count = 0;
   
   int length = file.nextInt();
   
   file.nextLine();
   while(file.hasNext()){
      String line = file.nextLine();
         for(int i = 0; i < line.length(); i++){
         String letter = line.substring(i, i+1);
         if(letter.equals(" ")){
            first = false;
         }
         if(first){
            key += letter;
         } else {
            if(!(letter.equals(" "))){
            val += letter;
            }
      }
      
   }
      if(count >= length-1){
         break;
      }
      map.put(key, val);
      first = true;
      key = "";
      val = "";
      count++;
   }
   System.out.println();
   System.out.println(map);
   System.out.println();
   
    String ans = "";
    while(file.hasNext()){
       String line = file.nextLine();
       for(int i = 0; i < line.length()-1; i++){
          String word = "";
          while(i<line.length() && line.charAt(i) != ' '){
             word += line.substring(i, i+1);
             i++;
          }
          
          ans =  ans + map.get(word) + " "; 
       }
       System.out.println(ans);
       ans = "";
    }
   
   
   
}

   

}