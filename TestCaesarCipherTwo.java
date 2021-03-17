
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipherTwo {
 private String halfOfString(String message, int Start){
      StringBuilder sb= new StringBuilder();
      for(int k=Start;k<message.length();k++)
      {
         if(k%2==Start)
         {
             sb.append(message.charAt(k));
         }
      }
      return sb.toString();// halfOfString(“Qbkm Zgis”, 0)= “Qk gs” and halfOfString(“Qbkm Zgis”, 1) returns the String “bmZi”.
    }
 private int[] count(String s)
    {
        String alpha= "abcdefghijklmnopqrstuvwxyz";
        int[] count= new int[26];
        for(int k=0; k<s.length();k++)
        {
            char ch = Character.toLowerCase(s.charAt(k));
            int index= alpha.indexOf(ch);
            if(index!=-1){
                count[index]+=1;
            }  
        }
        return count;//it return the array of int having count of occurance of each alphabet in encrytped message
    }
 private int maxIndex(int[] vals)
    {
        int maxDex=0;
        for(int k=0;k<vals.length;k++)
        {
            if(vals[k]>vals[maxDex])
            {
                maxDex=k;
            }
        }
        return maxDex;// it returns maxmium occuring alphabet in encrypted message
    }
 private int getKey(String s)
    {
      int[] freqs= count(s);
      int maxDex= maxIndex(freqs);// maxDex is index of higgest frequency alphabet
      int dkey= maxDex-4;         // distance from 'e' to mamimum occuring alphabet
      if(maxDex<4)
      {
          dkey =26-(4-maxDex);
      }
      return dkey;//Then calculate the key used to encrypt each half String.
    }
 public void simpleTest(){
        FileResource fr= new FileResource();
        String encrypt = fr.asString();
        CaesarCipherTwo c= new CaesarCipherTwo(21,8);
        String encrypted= c.encrypt(encrypt);
        System.out.println("The encrypted string: "+encrypted);
        String decrypted= c.decrypt(encrypted);
        System.out.println(("The decrypted string when encrypted key is known : "+decrypted));
        String result3= breakCaesarCipher(encrypted);
        System.out.println(("The decrypted string when encrypted key is unknown : "+result3));
    }
 public String breakCaesarCipher(String input){
  
        String s1= halfOfString(input,0);
        String s2= halfOfString(input,1);
        int dkey1= getKey(s1);
        int dkey2= getKey(s2);
        CaesarCipherTwo cc= new CaesarCipherTwo(dkey1,dkey2);
        System.out.println("The key1: "+dkey1 +" The Key2 is: " +dkey2);
        String decrypt= cc.decrypt(input);
        return decrypt;
    }
}
