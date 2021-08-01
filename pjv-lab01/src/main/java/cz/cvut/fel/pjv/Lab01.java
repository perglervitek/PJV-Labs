package cz.cvut.fel.pjv;

import java.util.Scanner;

public class Lab01 {
   public void start(String[] args) {
     homework();
   }

   private static void homework(){
      String[][] operations = new String[][]{
              {"scitanec", "scitanec", "+"},
              {"mensenec", "mensitel", "-"},
              {"cinitel", "cinitel", "*"},
              {"delenec", "delitel", "/"}
      };
      Scanner scanner = new Scanner(System.in);
      System.out.println("Vyber operaci (1-soucet, 2-rozdil, 3-soucin, 4-podil):");
      int operation = scanner.nextInt();
      if(operation > 4 || operation < 1){
         System.out.println("Chybna volba!");
         scanner.close();
         return;
      }else{
         double number1 = 0, number2 = 0;
         System.out.println("Zadej " + operations[operation-1][0] + ": ");
         number1 = scanner.nextDouble();
         System.out.println("Zadej " + operations[operation-1][1] + ": ");
         number2 = scanner.nextDouble();

         if(operation == 4 && number2 == 0){
            System.out.println("Pokus o deleni nulou!");
            scanner.close();
            return;
         }
         int decimalNumbers = 0;
         System.out.println("Zadej pocet desetinnych mist: ");
         decimalNumbers = scanner.nextInt();
         if(decimalNumbers < 0){
            System.out.println("Chyba - musi byt zadane kladne cislo!");
            scanner.close();
            return;
         }
         double result = 0;
         switch(operations[operation-1][2]){
            case "+":
               result = number1 + number2;
               break;
            case "-":
               result = number1 - number2;
               break;
            case "*":
               result = number1 * number2;
               break;
            case "/":
               result = number1 / number2;
               break;
         }

         System.out.printf("%." + decimalNumbers + "f", number1);
         System.out.print(" " + operations[operation-1][2] + " ");
         System.out.printf("%." + decimalNumbers + "f", number2);
         System.out.print(" = ");
         System.out.printf("%." + decimalNumbers + "f", result);
         System.out.println();
      }
      scanner.close();
   }
}