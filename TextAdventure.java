import java.util.*;

import javax.lang.model.util.ElementScanner6;

public class TextAdventure 
{
  FancyConsole console;
  Scanner inScanner;
  Player ourHero;

  public TextAdventure()
  {
    console = new FancyConsole("Great Text Adventure!", 600, 600);
    inScanner = new Scanner(System.in);

    ourHero = new Player("Bob", 100, 0);
  }

  public void play()
  {
    String input;
    console.setImage("forest.jpg");
    System.out.println("What is your name?\n");
    input = inScanner.nextLine();
    ourHero.changeName(input);
    System.out.println("You wake up to find yourself in the middle of a forest. \nYou see what looks like a city in the distance. \nWhat would you like to do? \ncity: Go towards the city\nnap: Go back to sleep\n" + ourHero.getName() + ": ");
    input = inScanner.nextLine();
    if (input.equals("city")) 
    {
      animals();
    } else if (input.equals("nap")) 
    {
      nap();
    } else 
    {
      System.out.println("Invalid input! Please choose again.");
      play();
    }
  }

  

  private void animals()
  {
    console.setImage("animals.jpg");
    System.out.println("You walk towards the city and notice some animals along the way.");
    System.out.println("Something isn't right though.");
    System.out.println("They notice you. \nDo you fight them? \nfight: You attempt to fight the animals off\nrun: Run away\n" + ourHero.getName() + ": ");
    String input = inScanner.nextLine();
    double chance = Math.random();

    if (input.equals("fight")) 
    {
      if(chance>0.2)
      {
        ourHero.defeatMonster();
        System.out.println("It was a close fight but you defeat the animals. \nDo you continue towards the city? \nyes: Go towards the city\nno: Follow your steps back to the forest\n" + ourHero.getName() + ": ");
        input = inScanner.nextLine();
        if (input.equals("yes")) 
        {
          city();
        } else if (input.equals("no")) 
        {
          forest();
        } else 
        {
          System.out.println("Not an option, please choose again");
          animals();
        }
      } else 
      {
        System.out.println("You perish in battle.");
        gameEnd();
      }
    }
    else if (input.equals("run")) 
    {
      if(chance>0.2)
      {
        System.out.println("You narrow escape the enraged animals. \nDo you continue towards the city? \nyes: Go towards the city\nno: Follow your steps back to the forest\n" + ourHero.getName() + ": ");
        input = inScanner.nextLine();
        if (input.equals("yes")) 
        {
          city();
        } else if (input.equals("no")) 
        {
          forest();
        } else 
        {
          System.out.println("Not an option, please choose again");
          animals();
        }
      } else 
      {
        System.out.println("The animals caught up, you perish.");
        gameEnd();
      }
    } else 
    {
      System.out.println("Not an option, please choose again");
      animals();
    }
    
  }


  private void forest()
  {
    console.setImage("forest.jpg");
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
  }

  private void city()
  {
    console.setImage("pumpkin.png");
    System.out.println("You enter the city.");
    System.out.println("You encounter dangerous pumpkins.");
    System.out.println("They try to attack you.");
    System.out.println("Do you fight back? \nyes: You fight back\nno: You run away\n" + ourHero.getName() + ": ");
    String input = inScanner.nextLine();

    if(ourHero.getMonstersDefeated() > 0 && input.compareTo("no") == 0)
    {
      System.out.println("You escape running with the newfound strength from your previous battles.");
      System.out.println("You realize how dangerous the world is and decide to stop exploring.");
      System.out.println("You settle in a shack you found while running.");
      gameEnd();
    } else if(ourHero.getMonstersDefeated() > 0 && input.compareTo("yes") == 0 )
    {
      System.out.println("You easily defeat the pumpkins with the skills you learned from previous battles.");
      System.out.println("You find 5.0 gold on one of the pumpkins");
      ourHero.setGold(5.0);
      ourHero.defeatMonster();
      System.out.println("You also find a map telling you how to escape.");
      gameEnd();
    } else
    {
      System.out.println("The pumpkins easily overpower you due to your inexperience.");
      gameEnd();
    }
  }

  private void nap()
  {
    console.setImage("graveyard.jpg");
    System.out.println("You awake in a graveyard in your dreams.");
    System.out.println("You notice mountains and an ocean in the distance.");
    System.out.println("Where do you explore? \nmountains: You journey to the mountains\nocean: You go towards the ocean\n" + ourHero.getName() + ": ");
    String input = inScanner.nextLine();

    if(input.compareTo("mountains") == 0)
    {
      mountains();
    } else if(input.compareTo("ocean") == 0)
    {
      ocean();
    } else 
    {
      System.out.println("Not an option, please choose again");
      nap();
    }
  }

  private void mountains()
  {
    console.setImage("mountains.jpg");
    System.out.println("You encounter another traveler.");
    System.out.println("They tell you to travel with them to be safer");
    System.out.println("Do you follow them? \nyes: You travel together\nno: You continue on your own\n" + ourHero.getName() + ": ");
    String input = inScanner.nextLine();

    if(input.compareTo("yes") == 0)
    {
      System.out.println("You encounter a bear.");
      System.out.println("You easily overpower the bear with your new found friend.");
      System.out.println("You find 10.0 gold on the bear and split it.");
      ourHero.setGold(5.0);
      ourHero.defeatMonster();
      System.out.println("You arrive at the mountains and settle in a village");
      gameEnd();
    } else if(input.compareTo("no") == 0)
    {
      System.out.println("You encounter a bear.");
      System.out.println("You regret going alone.");
      gameEnd();
    } else 
    {
      System.out.println("Not an option, please choose again");
      mountains();
    }
  }

  private void ocean()
  {
    console.setImage("ocean.jpg");
    System.out.println("You arrive at the ocean and see a ship.");
    System.out.println("You join the crew.");
    System.out.println("A sea monster attacks the ship at sea.");
    System.out.println("Do you help fight the monster? \nyes: You get on the cannon and shoot the monster\nno: You cower in fear\n" + ourHero.getName() + ": ");
    String input = inScanner.nextLine();
    double chance = Math.random();
    boolean unlucky = chance < 0.2;
    
    if(input.compareTo("yes") == 0)
    {
      if(!unlucky)
      {
        System.out.println("You barely defeat the sea monster with your crew.");
        System.out.println("You are awarded 15.0 gold for your bravery and help.");
        ourHero.setGold(15.0);
        ourHero.defeatMonster();
        System.out.println("You decide to stay on the ship with your newfound crew.");
        gameEnd();
      } else 
      {
        System.out.println("Despite your help, the ship is defeated");
        System.out.println("As you slowly sink, you are glad you at least found some friends before the end.");
        gameEnd();
      }
    } else if(input.compareTo("no") == 0)
    {
      System.out.println("Your ship is capsized by the monster");
      System.out.println("You regret not being brave enough to help.");
      gameEnd();
    } else 
    {
      System.out.println("Not an option, please choose again");
      ocean();
    }
  }

  private void gameEnd()
  {
    System.out.println("You adventure comes to an end.");
    System.out.println("You defeated " + ourHero.getMonstersDefeated() + " monsters, and earned " + ourHero.getGold() + " gold.\n");
    inScanner.close();
  }
}