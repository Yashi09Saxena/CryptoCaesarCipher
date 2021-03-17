
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
 private String Alphabet;
 private String ShiftedAlpha1;
 private String ShiftedAlpha2;
 private int mainkey1;
 private int mainkey2;
  public CaesarCipherTwo(int key1, int key2){
      Alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      ShiftedAlpha1= Alphabet.substring(key1)+ Alphabet.substring(0,key1);
      ShiftedAlpha2= Alphabet.substring(key2)+ Alphabet.substring(0,key2);
      mainkey1= key1;
      mainkey2= key2;
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
             char newChar;
            if(idx!=-1&&i%2==0)
            {
                newChar= ShiftedAlpha1.charAt(idx);
                if(Character.isLowerCase(currChar)) //currChar value never modify.
                {
                   newChar= Character.toLowerCase(newChar); 
                }
                encrypted.setCharAt(i,newChar);
            }
            if(idx!=-1&&i%2==1)
            {
                newChar= ShiftedAlpha2.charAt(idx);
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
    CaesarCipherTwo cc= new CaesarCipherTwo(26-mainkey1,26-mainkey2); 
    String result= cc.encrypt(input);
    return result;
  }
}
