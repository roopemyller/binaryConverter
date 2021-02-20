
import java.util.HashMap;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;

public class binaryConverter{
    public static void main (String[] args){
        //reading the binary file and adding the linest to a hashmap        
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> map = fileToHashMap("C:/Users/27617515/Desktop/VSCode/BinaryMuunnin/binaryAlphabet.txt");
                        
        while(true){
            convertStringToBinary(askForString(sc), map);
            System.out.print("Continue? (yes/no): ");
            String answer = sc.nextLine();
            if(answer.equals("no")){
                break;
            }else{
                continue;
            }
        }    
        sc.close();        
    }

    public static void convertStringToBinary(String string, HashMap<String, String> map){        
        //String -> arraylist on words --> each word individually to binary to another arraylist --> print the arraylist
        String[] words = string.split(" ");

        ArrayList<String> binaryList = new ArrayList<>();

        for(String word : words){
            String binaryLetter = "";
            for(int i = 0; i < word.length(); i++){
                String binary = map.get(String.valueOf(word.charAt(i)));
                if(i == 0){
                    binaryLetter = binary;
                }else if(i + 1 == word.length()){
                    binaryLetter = binaryLetter + " " + binary + " ";
                }else{
                    binaryLetter = binaryLetter + " " + binary; 
                }               
            }
            binaryList.add(binaryLetter);
        }
        
        for(String binaryWord : binaryList){
            System.out.print(binaryWord);
        }        
    }

    public static String askForString(Scanner sc){
        //Scanner sc = new Scanner(System.in);
        System.out.print("Text: ");
        String text = sc.nextLine();
        System.out.println("");    
        return text;
    }


    public static HashMap<String, String> fileToHashMap(String filepath){
        HashMap<String, String> ltob = new HashMap<String, String>();
        try(Scanner sc = new Scanner(Paths.get(filepath))){
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] parts = line.split(" ");
                ltob.put(parts[0], parts[1]);                           
            }

        }catch(Exception e){
            System.out.println("Virhe: " + e.getMessage());
        }
        return ltob;
    }
}