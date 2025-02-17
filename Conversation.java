import java.util.Scanner;

class Conversation implements Chatbot {

  // Attributes 
  int count
  /**
   * Constructor 
   */
  Conversation() {
    count = 0
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    Scanner input = new Scanner(System.in);
    System.out.println("Hello! How many rounds of conversation would you like?");
    Int rounds = input.nextInt();
    while (count < rounds);
      String inputString = input.nextString();
      respond(inputString);
      count += 1;
    System.out.println("Goodbye!");





  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {

  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    String returnString = "Go on..."; 
    return returnString; 
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();

  }
}
