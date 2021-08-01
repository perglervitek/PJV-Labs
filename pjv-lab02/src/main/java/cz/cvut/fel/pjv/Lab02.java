/*
 * File name: Lab06.java
 * Date:      2014/08/26 21:39
 * Author:    @author
 */

package cz.cvut.fel.pjv;

public class Lab02 {
   public void start(String[] args) {
      homework();
   }

   private void messagePrint(int index, double[] nums){
      double sDev = 0 ,avg = 0;
      for(int i = 0; i < index; i++){
         avg += nums[i];
      }
      avg = avg/index;
      for (int i = 0; i < index; i++){
         sDev+= Math.pow(nums[i] - avg, 2);
      }
      sDev = Math.sqrt(sDev / index);
      System.out.printf("%2d %.3f %.3f", index, avg, sDev);
      System.out.println();
   }

   private void homework(){
      TextIO textHandler;
      textHandler = new TextIO();
      double[] numArr =  new double[10];
      String row = "";
      int index=0 , rowNum = 0;
      while((row = textHandler.getLine()) != ""){
         rowNum++;
         if(textHandler.isDouble(row)){
            numArr[index] = Double.parseDouble(row);
            index++;
            if(index == 10){
               messagePrint(index, numArr);
               index = 0;
            }
         }else{
            System.err.println("A number has not been parsed from line " + rowNum);
         }
      }
      System.err.println("End of input detected!");
      if(index > 1){
         messagePrint(index, numArr);
      }
   }
}
