import java.util.Scanner;
import java.util.Random;

class Conversation implements Chatbot {

  // Attributes 
  int count;
  /**
   * Constructor 
   */
  Conversation() {
    count = 0;
  }

  String[] responses = {"Uh-huh.", "Go on...", "Interesting!", "Please continue."};
  String[] transcript;

  private int randomize() {
    Random rand = new Random();
    int number = rand.nextInt(4);
    return number;
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    Scanner input = new Scanner(System.in);
    System.out.println("Hello! How many rounds of conversation would you like?");
    int rounds = input.nextInt();
    int scriptLength = rounds + 1;
    transcript = new String[scriptLength];
    input.nextLine();
    System.out.println("Great! Let's chat.");
    transcript[0] = "Great! Let's chat.";
    for (int i = 1; i < scriptLength; i = i + 2) {
      String inputString = input.nextLine();
      transcript[i] = inputString;
      String response = respond(inputString);
      transcript[i + 1] = response;
      System.out.println(response);
      ++count;
    }
    input.close();





  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    for (int i = 0; i < transcript.length; i ++) {
      System.out.println(transcript[0]);
    }
    System.out.println("Goodbye!");
    
  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */

  public String respond(String inputString) {
    String mirroredString = inputString;
    if (mirroredString.contains("I ")) {
      mirroredString = mirroredString.replace("I ", "you ");
    } else if (mirroredString.contains("you ") || mirroredString.contains("You")){
      mirroredString = mirroredString.replace("you ", "I ");
      mirroredString = mirroredString.replace("You", "I");
    };
    if (mirroredString.contains(" are") || mirroredString.contains("Are")) {
      mirroredString = mirroredString.replace(" are", " am");
      mirroredString = mirroredString.replace("Are", "Am ");
    } else if (mirroredString.contains(" am ") || mirroredString.contains("Am")) {
      mirroredString = mirroredString.replace(" am ", " are ");
      mirroredString = mirroredString.replace("Am ", "Are ");
    }
    if (mirroredString.contains("your") || mirroredString.contains(("Your"))) {
      mirroredString = mirroredString.replace("your", "my");
      mirroredString = mirroredString.replace("Your", "My");
    } else if (mirroredString.contains(" my ") || mirroredString.contains("My")) {
      mirroredString = mirroredString.replace(" my ", " your ");
    }
    if (mirroredString.contains("myself") || mirroredString.contains("Myself")) {
      mirroredString.replace("myself", "yourself");
      mirroredString.replace("Myself", "Yourself");
    } else if (mirroredString.contains("yourself") || mirroredString.contains("Yourself")) {
      mirroredString.replace("yourself", "myself");
      mirroredString.replace("Yourself", "Myself");
    }
    if (mirroredString.equals(inputString)) {
      int random = randomize();
      String cannedString = responses[random]; 
      return cannedString;     
    } else {
        if (mirroredString.contains("?")) {
          return mirroredString;
        } else if (mirroredString.contains(".")) {
          mirroredString = mirroredString.replace(".", "?");
        } else {
          mirroredString += "?";
        }
        return mirroredString;
    }
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();
  }
}
