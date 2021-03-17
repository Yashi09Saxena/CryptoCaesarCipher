
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 **/
public class CaesarCipher {
 private String Alphabet;
 private String ShiftedAlpha;
 private int mainkey;
 
 public CaesarCipher(int key){
      Alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      ShiftedAlpha= Alphabet.substring(key)+ Alphabet.substring(0,key);
      mainkey= key;
    }
 public String encrypt(String input){
     StringBuilder encrypted = new StringBuilder(input);
      for(int i=0;i<encrypted.length();i++)
        {
            char currChar= encrypted.charAt(i);
            char curr= currChar;//we keeping safe our currChar for lower case.
            if(Character.isLowerCase(currChar))
            {
               curr = Character.toUpperCase(currChar);  //if input is in lower case than update "curr" to upper case for getting the index in Alphabet String.
            }
            
            int idx = Alphabet.indexOf(curr);
            if(idx!=-1)
            {
                char newChar= ShiftedAlpha.charAt(idx);
                if(Character.isLowerCase(currChar)) //currChar value never modify.
                {
                   newChar= Character.toLowerCase(newChar); 
                }
                encrypted.setCharAt(i,newChar);
            }
                
        }
        return encrypted.toString();
    }
    public String decrypt(String input){
    CaesarCipher cc= new CaesarCipher(26-mainkey); 
    String result= cc.encrypt(input);
    return result;
    }
}
