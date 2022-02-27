import java.util.*;

public class EncryptionProgram {
	
	private Scanner scanner;
	private Random random;
	private ArrayList<Character> list;
	private ArrayList<Character> shuffledList;
	private char character;
	private String line;
	private char[] letters;
	
	EncryptionProgram(){
		
		scanner = new Scanner(System.in);
		random = new Random();
		list = new ArrayList();
		shuffledList = new ArrayList();;
		character = ' ';
		
		newKey();
		askQuestion();
	}
	
	private void askQuestion(){
		while(true){
			System.out.println("");
			System.out.println("**********************************************************");
			System.out.println("What would you like to do?");
			System.out.println("(N)ewKey, (G)etKey, (E)ncrypt, (D)ecrypt, (Q)uit");
			
			char response = Character.toUpperCase(scanner.nextLine().charAt(0));
			
			switch(response) {
			
			case 'N':
				newKey();
				break;
				
			case 'G':
				getKey();
				break;
				
			case 'E':
				encrypt();
				break;
				
			case 'D':
				decrypt();
				break;
			
			case 'Q':
				quit();
				break;
				
			default:
				System.out.println("Not a valid input.");
			}
		}
		
	}
	
	private void newKey() {
		
		character = ' ';
		list.clear();
		shuffledList.clear();
		
		for(int i=32;i<127;i++) {
			
			list.add(Character.valueOf(character));
			character++;
		}
		
		shuffledList = new ArrayList(list);
		Collections.shuffle(shuffledList);
		System.out.println("*A new key has been created.*");
	}
	
	private void getKey() {
		
		System.out.println("Base characters and key: ");
		for(Character x : list) {
			System.out.print(x);
		}
		
		System.out.println("");
		for(Character x : shuffledList) {
			System.out.print(x);
		}
	}
	
	private void encrypt() {
		System.out.println("Enter text to encrypt: ");
		String message = scanner.nextLine();
		
		letters = message.toCharArray();
		
		for(int i = 0;i<letters.length;i++) {
			for(int j = 0;j<list.size();j++) {
				if(letters[i] == list.get(j)) {
					letters[i] = shuffledList.get(j);
					break;
				}
			}
		}
		System.out.println("The encrypted text is:");
		
		for(char x : letters) {
			System.out.print(x);
		}
		System.out.println("");
	}
	
	private void decrypt() {
		System.out.println("Enter text to decrypt: ");
		String message = scanner.nextLine();
		
		letters = message.toCharArray();
		
		for(int i = 0;i<letters.length;i++) {
			
			for(int j = 0;j<shuffledList.size();j++) {
				if(letters[i] == shuffledList.get(j)) {
					letters[i] = list.get(j);
					break;
				}
			}
		}
		System.out.println("The decrypted text is:");
		
		for(char x : letters) {
			System.out.print(x);
		}
		System.out.println("");
	}
	
	private void quit() {
		System.out.println("Closing...");
		System.exit(0);
	}

}
