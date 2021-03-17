/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipher {
    private int[] count(String s)
    {
        String alpha= "abcdefghijklmnopqrstuvwxyz";
        int[] count= new int[26];
        for(int k=0; k<s.length();k++)
        {
            char ch = Character.toLowerCase(s.charAt(k));
            int index= alpha.indexOf(ch);
            if(index!=-1)
            {
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
    public void simpleTest(){
        FileResource fr= new FileResource();
        String encrypt = fr.asString();
        CaesarCipher c= new CaesarCipher(15);
        String result1= c.encrypt(encrypt);
        System.out.println("The encrypted string: "+result1);
        String result2= c.decrypt(result1);
        System.out.println(("The decrypted string when encrypted key is known : "+result2));
        String result3= breakCaesarCipher(result1);
        System.out.println(("The decrypted string when encrypted key is unknown : "+result3));
    }
    public String breakCaesarCipher(String input){
      int[] freqs= count(input);
      int maxDex= maxIndex(freqs);// maxDex is index of higgest frequency alphabet
      int dkey= maxDex-4;         // distance from 'e' to mamimum occuring alphabet
      if(maxDex<4)
      {
          dkey= 26-(4-maxDex);
      }
      CaesarCipher cc= new CaesarCipher(dkey);
      String result3= cc.decrypt(input);
      return result3;
    }
    
}
