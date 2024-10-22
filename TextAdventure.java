import java.util.*;

public class TextAdventure 
{
  FancyConsole console;
  Scanner inScanner;
  Player ourHero;

  public TextAdventure()
  {
    console = new FancyConsole("Great Text Adventure!", 600, 600);
    inScanner = new Scanner(System.in);

    // feel free to change the player's starting values
    ourHero = new Player("Bob", 100, 0);
  }

  public void play()
  {
    String input;
    // start of adventure. You can change this if you like
    console.setImage("forest.jpg");

    // ask the user for their name.
    System.out.println("What is your name?\n");
    input = inScanner.nextLine();

    // Change ourHero's name
    ourHero.changeName(input);
    
    // describe the starting situation. Feel free to change this
    System.out.println("You wake up to find yourself in the middle of a forest. \nYou see what looks like a city in the distance. \nWhat would you like to do? \ncity: Go towards the city\nnap: Go back to sleep\n" + ourHero.getName() + ": ");

    // get user input and go to the appropriate zone based on their input
    input = inScanner.nextLine();
    if (input.equals("city")) {
      animals();
    } else if (input.equals("nap")) {
      nap();
    } else {
      System.out.println("Invalid input! Please choose again.");
      play();
    }
  }

  

  private void animals()
  {
    // change image
    console.setImage("animals.jpg");

    // describe the area/situation to the user. 
    // Give them options for choices.
    System.out.println("You walk towards the city and notice some animals along the way.");
    System.out.println("Something isn't right though.");
    System.out.println("They notice you. \nDo you fight them? \nfight: You attempt to fight the animals off\nrun: Run away\n" + ourHero.getName() + ": ");
    // Take action or go to another zone based on their choice
    String input = inScanner.nextLine();
    double chance = Math.random();
    if (input.equals("fight")) {
      if(chance>0.2){
        ourHero.defeatMonster();
        System.out.println("It was a close fight but you defeat the animals. \nDo you continue towards the city? \nyes: Go towards the city\nno: Follow your steps back to the forest\n" + ourHero.getName() + ": ");
        input = inScanner.nextLine();
        if (input.equals("yes")) {
          city();
        } else if (input.equals("no")) {
          forest();
        }
      } else {
        System.out.println("You perish in battle.");
        gameEnd();
      }
    }
    else if (input.equals("run")) {
      if(chance>0.2){
        System.out.println("You narrow escape the enraged animals. \nDo you continue towards the city? \nyes: Go towards the city\nno: Follow your steps back to the forest\n" + ourHero.getName() + ": ");
        input = inScanner.nextLine();
        if (input.equals("yes")) {
          city();
        } else if (input.equals("no")) {
          forest();
        }
      } else {
        System.out.println("The animals caught up, you perish.");
        gameEnd();
      }
    } 
    
  }


  private void forest()
  {
    // change image
    console.setImage("forest.jpg");

    // describe the area/situation to the user. 
    // Give them options for choices.
    System.out.println("You returned to the forest.");
    System.out.println("You encounter a magical wolf.");
    System.out.println("They speak to you.");
    System.out.println("Do you respond to them? \nyes: You talk to the wolf about your adventure so far\nno: You walk away, ignoring the wolf\n" + ourHero.getName() + ": ");
    String input = inScanner.nextLine();
    if(ourHero.getMonstersDefeated() > 0 && input.compareTo("no") == 0)
    {
      System.out.println("The wolf acknowledges your victory against the animals.");
      System.out.println("The wolf lets you go without problem.");
      System.out.println("You find a shack and decide to settle down.");
      gameEnd();
    } else if(input.compareTo("yes") == 0)
    {
      System.out.println("The wolf enjoys your story and gives you 10.0 gold");
      ourHero.setGold(10.0);
      System.out.println("The wolf tells you how to escape, you thank him.");
      gameEnd();
    } else 
    {
      System.out.println("The wolf devours you for your disrespect.");
      gameEnd();
    }
    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void nap()
  {
    // change image
    console.setImage("pumpkintrio.jpg");

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void city()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void treasure()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone6()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void gameEnd()
  {
    console.setImage("forest.jpg");
    System.out.println("You adventure comes to an end.");
    System.out.println("You defeated " + ourHero.getMonstersDefeated() + " monsters, and earned " + ourHero.getGold() + " gold.\n");
    inScanner.close();
  }
}