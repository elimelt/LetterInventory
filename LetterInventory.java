public class LetterInventory {
   private int[] counts;
   private int size;
   //A-Z 65-90
   //a-z 97-122
   public LetterInventory(String s) {
      this.counts = new int[26];
      this.size = 0;
      for (char c : s.toCharArray()) {
         if(Character.isLetter(c)){
            counts[charToAlphaIndex(c)]++;
            this.size++;
         }
      }
   }
   
   public int get(char c) {
      if (!Character.isLetter(c)) throw new IllegalArgumentException();
      return counts[(int)Character.toLowerCase(c)];
   }
   
   public void set(char letter, int value) {
      if (!Character.isLetter(letter)) throw new IllegalArgumentException();
      this.counts[charToAlphaIndex(letter)] = value;
   }
   
   public int size() {
      return this.size;
   }
   
   public boolean isEmpty() {
      return size == 0;
   }
   
   public String toString() {
      String out = "";
      for (int i = 0; i < 26; i++) {
         char currLetter = alphaIndexToChar(i);
         for (int j = 0; j < counts[i]; j++) {
            out+= "" + currLetter;
         }
      }
      return out;
   }
   
   public LetterInventory add(LetterInventory other) {
      LetterInventory output = new LetterInventory("");
      for (int i = 0; i < 26; i++) {
         output.set(alphaIndexToChar(i), this.counts[i] + other.get(alphaIndexToChar(i)));
      }
      
      return output;
   }
   
   public LetterInventory subtract(LetterInventory other) {
      LetterInventory output = new LetterInventory("");
      for (int i = 0; i < 26; i++) {
         int result = this.counts[i] + other.get(alphaIndexToChar(i));
         if (result < 0) return null;
         output.set(alphaIndexToChar(i), result);
      }
      
      return output;

   }
   
   /*----------------------------------------------*/
   
   //returns the index of a character in the alphabet (starting with a:0-z:25)
   public static int charToAlphaIndex(char c) {
      return (int) (Character.toLowerCase(c)) - 97;
   }
   
   public static char alphaIndexToChar(int i) {
      return (char) (i + 97);
   }
   
}