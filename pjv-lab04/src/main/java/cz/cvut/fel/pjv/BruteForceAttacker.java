package cz.cvut.fel.pjv;

public class BruteForceAttacker extends Thief {
    private char[] availableChars;
    private int passwordLength;

    @Override
    public void breakPassword(int sizeOfPassword) {
        availableChars = getCharacters();
        passwordLength = sizeOfPassword;
        testPassword("");
    }
    private boolean testPassword(String currentPassword){
        if(currentPassword.length() == passwordLength){
            if(tryOpen(currentPassword.toCharArray()))  return true; //check if opened
            return false;
        }
        int i = 0;
        while(i < availableChars.length){ //add chars until the length of available list
            if(testPassword(currentPassword + availableChars[i])) return true; //permutation with new character
            i++;
        }
        return false;
    }
}
