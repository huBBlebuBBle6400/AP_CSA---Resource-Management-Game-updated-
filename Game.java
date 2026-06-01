import java.util.Scanner;
import java.util.Random;

public class Game {

  private Scanner scan;
  private Survival player;
  private GameState gameState;
  private String currentPath; // "city" or "country"
  private String currentCharacter;
  private Random random;

  public Game() {
    this.scan = new Scanner(System.in);
    this.player = new Survival();
    this.gameState = new GameState();
    this.random = new Random();
  }

  public void run() {
    Util.clearConsole();
    System.out.println(StringArt.COVER_ART);
    System.out.println(StringConstants.GAME_DESCRIPTION);
    Util.pauseConsole();
    choosePathway();
  }

  private void choosePathway() {
    Util.clearConsole();
    System.out.println(StringConstants.SELECT_CLASS);
    System.out.println("1. " + StringConstants.SETTING_CITY);
    System.out.println("2. " + StringConstants.SETTING_COUNTRY);
    int choice = Util.enterInt(1, 2);

    if (choice == 1) {
      currentPath = "city";
      chooseCharacter1();
    } else if (choice == 2) {
      currentPath = "country";
      chooseCharacter2();
    }
  }

  private void chooseCharacter1() {
    Util.clearConsole();
    System.out.println(StringConstants.SELECT_CHARACTER);
    System.out.println("1. " + SurvivalFactory.SURVIVAL_PLAYER_1);
    System.out.println("2. " + SurvivalFactory.SURVIVAL_PLAYER_2);
    System.out.println("3. " + SurvivalFactory.SURVIVAL_PLAYER_3);
    int choice = Util.enterInt(1, 3);

    if (choice == SurvivalFactory.SURVIVAL_PLAYER_1_ID) {
      this.player = SurvivalFactory.player1();
      this.currentCharacter = "Jeffrey";
    } else if (choice == SurvivalFactory.SURVIVAL_PLAYER_2_ID) {
      this.player = SurvivalFactory.player2();
      this.currentCharacter = "Danny";
    } else if (choice == SurvivalFactory.SURVIVAL_PLAYER_3_ID) {
      this.player = SurvivalFactory.player3();
      this.currentCharacter = "Avery";
    }
    
    player.setCharacterName(currentCharacter);
    displayStats();
    Util.pauseConsole();
    playGame();
  }

  private void chooseCharacter2() {
    Util.clearConsole();
    System.out.println(StringConstants.SELECT_CHARACTER);
    System.out.println("1. " + SurvivalFactory2.SURVIVAL2_PLAYER_1);
    System.out.println("2. " + SurvivalFactory2.SURVIVAL2_PLAYER_2);
    System.out.println("3. " + SurvivalFactory2.SURVIVAL2_PLAYER_3);
    int choice = Util.enterInt(1, 3);

    if (choice == SurvivalFactory2.SURVIVAL2_PLAYER_1_ID) {
      this.player = SurvivalFactory2.player1();
      this.currentCharacter = "Joshua";
    } else if (choice == SurvivalFactory2.SURVIVAL2_PLAYER_2_ID) {
      this.player = SurvivalFactory2.player2();
      this.currentCharacter = "David";
    } else if (choice == SurvivalFactory2.SURVIVAL2_PLAYER_3_ID) {
      this.player = SurvivalFactory2.player3();
      this.currentCharacter = "Audrey";
    }
    
    player.setCharacterName(currentCharacter);
    displayStats();
    Util.pauseConsole();
    playGame2();
  }

  private void displayStats() {
    String stats = "";
    stats += TextColor.RED_BOLD + "\nCharacter: " + TextColor.RESET + currentCharacter;
    stats += TextColor.RED_BOLD + "\nYears Survived: " + TextColor.RESET + player.getYearsSurvived();
    stats += TextColor.WHITE_BOLD + "\nLife Health: " + TextColor.RESET + player.getLifeHealth();
    stats += TextColor.BLUE_BOLD + "\nMoney: $" + TextColor.RESET + player.getMoney();
    stats += TextColor.YELLOW_BOLD + "\nWage: $" + TextColor.RESET + player.getWage();
    stats += TextColor.YELLOW_BOLD + "\nAlienated: " + TextColor.RESET + player.isAlienated();
    stats += TextColor.BLUE_BOLD + "\nMorale Index: " + TextColor.RESET + player.getMorale();
    stats += TextColor.BLUE_BOLD + "\nAdaptability Index: " + TextColor.RESET + player.getAdaptability();
    stats += TextColor.YELLOW_BOLD + "\nLand Owned (in acres): " + TextColor.RESET + player.getAcresLandOwned();
    if (player.hasLivestock()) {
      stats += TextColor.GREEN_BOLD + "\nLivestock: Yes (+$20 per turn)" + TextColor.RESET;
    }
    System.out.println(stats);
  }

  private void playGame() {
    while (player.getMoney() > Survival.MIN_MONEY && 
           player.getMorale() > Survival.MIN_MORALE && 
           player.getAdaptability() > Survival.MIN_ADAPTABILITY && 
           player.getLifeHealth() > Survival.MIN_LIFE_HEALTH && 
           player.getYearsSurvived() < Survival.MAX_YEARS_SURVIVED) {
      currentDay();
      
      // Feature 4: Livestock gives money each turn
      if (player.hasLivestock()) {
        player.addMoney(20);
        System.out.println("Your livestock earned you $20!");
      }
    }
    endOfGame();
  }

  private void playGame2() {
    while (player.getMoney() > Survival.MIN_MONEY && 
           player.getMorale() > Survival.MIN_MORALE && 
           player.getAdaptability() > Survival.MIN_ADAPTABILITY && 
           player.getLifeHealth() > Survival.MIN_LIFE_HEALTH && 
           player.getYearsSurvived() < Survival.MAX_YEARS_SURVIVED) {
      currentDay2();
      
      if (player.hasLivestock()) {
        player.addMoney(20);
        System.out.println("Your livestock earned you $20!");
      }
    }
    endOfGame();
  }

  private void currentDay() {
    Util.clearConsole();
    displayStats();

    System.out.println("What are you going to do today?");
    System.out.println("1. Buy commercial products to help the factory");
    System.out.println("2. Buy 5 acres of land");
    System.out.println("3. Sell beer");
    System.out.println("4. Sell bread");
    System.out.println("5. Try to find a new job --> Go job hunting");
    System.out.println("6. Rest and recover health (New!)");
    System.out.println("7. Travel through time (Risky!)");
    
    // Feature 2: Character-specific choices
    if (currentCharacter.equals("Jeffrey")) {
      ChoiceManager.showJeffreyChoices(player, gameState);
    } else if (currentCharacter.equals("Danny")) {
      ChoiceManager.showDannyChoices(player);
    } else if (currentCharacter.equals("Avery")) {
      ChoiceManager.showAveryChoices(player);
    }
    
    // Feature 1: Character switching option
    if (player.getAdaptability() >= Survival.CHARACTER_SWITCH_REQUIREMENT && !gameState.hasCharacterChanged()) {
      System.out.println("\n8. CHANGE CHARACTERS (Adaptability high enough!)");
    }
    
    int choice = Util.enterInt(1, 8);
    
    // Feature 1: Handle character switching
    if (choice == 8 && player.getAdaptability() >= Survival.CHARACTER_SWITCH_REQUIREMENT && !gameState.hasCharacterChanged()) {
      switchCharacter();
      return;
    }
    
    // Feature 2: Handle special choices
    boolean specialChoiceHandled = ChoiceManager.handleCitySpecialChoice(choice, player, currentCharacter, gameState);
    
    if (!specialChoiceHandled) {
      // Regular choices
      if (choice == 1) {
        player.addMoney(50.00);
        player.addWage(15.00);
        player.addMorale(20);
        player.addAcresLandOwned(15);
        player.addLifeHealth(-10.00);
        player.addYearsSurvived(1);
        System.out.println("You bought commercial products! +$50, +$15 wage, +20 morale, +15 acres, -10 health");
      } 
      else if (choice == 2) {
        player.addAcresLandOwned(5);
        player.addMoney(-250.00);
        player.addMorale(35);
        player.addAdaptability(20.00);
        player.addLifeHealth(-5.00);
        player.addYearsSurvived(1);
        player.incrementConsecutiveLandPurchases();
        gameState.incrementDaysSinceLastLandPurchase();
        System.out.println("You bought land! +5 acres, -$250, +35 morale, +20 adaptability, -5 health");
        
        // Feature 4: Consequence for buying land 3 days in a row
        if (player.getConsecutiveLandPurchases() >= 3) {
          System.out.println(TextColor.RED_BOLD + "WARNING: The government is taxing your frequent land purchases!" + TextColor.RESET);
          player.addMoney(-150);
          System.out.println("You lost an additional $150 to taxes!");
          player.resetConsecutiveLandPurchases();
        }
      } 
      else if (choice == 3) {
        player.addMoney(300.00);
        player.addAcresLandOwned(-5);
        player.addLifeHealth(-15.00);
        player.addYearsSurvived(1);
        System.out.println("You sold beer! +$300, -5 acres, -15 health");
      } 
      else if (choice == 4) {
        player.addMoney(270.00);
        player.addMorale(40);
        player.addLifeHealth(-15.00);
        player.addYearsSurvived(1);
        System.out.println("You sold bread! +$270, +40 morale, -15 health");
      } 
      else if (choice == 5) {
        player.addAdaptability(20.00);
        player.addMorale(20);
        player.addLifeHealth(-5.00);
        player.addAcresLandOwned(17);
        player.addYearsSurvived(1);
        System.out.println("You went job hunting! +20 adaptability, +20 morale, -5 health, +17 acres");
      }
      else if (choice == 6) {
        // Feature 3: Increase life health
        player.increaseLifeHealth(15.00);
        player.addMorale(10);
        player.addYearsSurvived(1);
        System.out.println("You rested and recovered! +15 health, +10 morale");
      }
      else if (choice == 7) {
        // Feature 5: Time travel
        timeTravel();
      }
    }
    
    Util.pauseConsole();
    displayStats();
    
    if (player.getMoney() <= Survival.MIN_MONEY || player.getMorale() <= Survival.MIN_MORALE || 
        player.getAdaptability() <= Survival.MIN_ADAPTABILITY || player.getLifeHealth() <= Survival.MIN_LIFE_HEALTH || 
        player.getYearsSurvived() >= Survival.MAX_YEARS_SURVIVED) {
      endOfGame();
    }
  }

  private void currentDay2() {
    Util.clearConsole();
    displayStats();

    System.out.println("What are you going to do today?");
    System.out.println("1. Buy more materials for your farm");
    System.out.println("2. Buy more land for your farm");
    System.out.println("3. Buy beer");
    System.out.println("4. Sell wheat and bread");
    System.out.println("5. Try to find a new job --> Go job hunting");
    System.out.println("6. Rest and recover health (New!)");
    System.out.println("7. Travel through time (Risky!)");
    
    // Feature 2: Character-specific choices for country path
    if (currentCharacter.equals("Joshua")) {
      ChoiceManager.showJoshuaChoices(player);
    } else if (currentCharacter.equals("David")) {
      ChoiceManager.showDavidChoices(player);
    } else if (currentCharacter.equals("Audrey")) {
      ChoiceManager.showAudreyChoices(player);
    }
    
    // Feature 1: Character switching
    if (player.getAdaptability() >= Survival.CHARACTER_SWITCH_REQUIREMENT && !gameState.hasCharacterChanged()) {
      System.out.println("\n8. CHANGE CHARACTERS (Adaptability high enough!)");
    }
    
    int choice = Util.enterInt(1, 8);
    
    if (choice == 8 && player.getAdaptability() >= Survival.CHARACTER_SWITCH_REQUIREMENT && !gameState.hasCharacterChanged()) {
      switchCharacter();
      return;
    }
    
    boolean specialChoiceHandled = ChoiceManager.handleCountrySpecialChoice(choice, player, currentCharacter);
    
    if (!specialChoiceHandled) {
      if (choice == 1) {
        player.addMoney(-100.00);
        player.addMorale(20);
        player.addAcresLandOwned(5);
        player.addLifeHealth(-4.00);
        player.addAdaptability(10.00);
        player.addYearsSurvived(1);
        System.out.println("Bought materials! -$100, +20 morale, +5 acres, -4 health, +10 adaptability");
      } 
      else if (choice == 2) {
        player.addAcresLandOwned(5);
        player.addMoney(-250.00);
        player.addMorale(35);
        player.addAdaptability(10.00);
        player.addLifeHealth(-5.00);
        player.addYearsSurvived(1);
        player.incrementConsecutiveLandPurchases();
        System.out.println("Bought land! +5 acres, -$250, +35 morale, +10 adaptability, -5 health");
        
        if (player.getConsecutiveLandPurchases() >= 3) {
          System.out.println(TextColor.RED_BOLD + "WARNING: The government is taxing your frequent land purchases!" + TextColor.RESET);
          player.addMoney(-150);
          player.addAcresLandOwned(-2);
          System.out.println("You lost $150 and 2 acres to taxes!");
          player.resetConsecutiveLandPurchases();
        }
      } 
      else if (choice == 3) {
        player.addMoney(-300.00);
        player.addAdaptability(-25.25);
        player.addLifeHealth(-15.00);
        player.addMorale(10);
        player.addAcresLandOwned(-10);
        player.addYearsSurvived(1);
        System.out.println("Bought beer! -$300, -25 adaptability, -15 health, +10 morale, -10 acres");
      } 
      else if (choice == 4) {
        player.addMoney(270.00);
        player.addMorale(40);
        player.addLifeHealth(-0.50);
        player.addAcresLandOwned(17);
        player.addAdaptability(5.05);
        player.addYearsSurvived(1);
        System.out.println("Sold wheat and bread! +$270, +40 morale, -0.5 health, +17 acres, +5 adaptability");
      } 
      else if (choice == 5) {
        player.addAdaptability(-20.00);
        player.addMorale(20);
        player.addLifeHealth(-2.50);
        player.addAcresLandOwned(17);
        player.addYearsSurvived(1);
        System.out.println("Went job hunting! -20 adaptability, +20 morale, -2.5 health, +17 acres");
      }
      else if (choice == 6) {
        player.increaseLifeHealth(15.00);
        player.addMorale(10);
        player.addYearsSurvived(1);
        System.out.println("You rested and recovered! +15 health, +10 morale");
      }
      else if (choice == 7) {
        timeTravel();
      }
    }
    
    Util.pauseConsole();
    displayStats();
  }

  // Feature 1: Switch characters
  private void switchCharacter() {
    Util.clearConsole();
    System.out.println(TextColor.GREEN_BOLD + "You have the opportunity to change your identity and start fresh!" + TextColor.RESET);
    System.out.println("Your adaptability has allowed you to transform.\n");
    
    int oldYears = player.getYearsSurvived();
    
    if (currentPath.equals("city")) {
      System.out.println("Choose your new character:");
      System.out.println("1. Jeffrey (Balanced stats)");
      System.out.println("2. Danny (High morale, lower adaptability)");
      System.out.println("3. Avery (High adaptability, lower money)");
      int choice = Util.enterInt(1, 3);
      
      if (choice == 1) {
        this.player = SurvivalFactory.player1();
        this.currentCharacter = "Jeffrey";
      } else if (choice == 2) {
        this.player = SurvivalFactory.player2();
        this.currentCharacter = "Danny";
      } else {
        this.player = SurvivalFactory.player3();
        this.currentCharacter = "Avery";
      }
    } else {
      System.out.println("Choose your new character:");
      System.out.println("1. Joshua (Balanced farmer)");
      System.out.println("2. David (Land-focused)");
      System.out.println("3. Audrey (Money-focused)");
      int choice = Util.enterInt(1, 3);
      
      if (choice == 1) {
        this.player = SurvivalFactory2.player1();
        this.currentCharacter = "Joshua";
      } else if (choice == 2) {
        this.player = SurvivalFactory2.player2();
        this.currentCharacter = "David";
      } else {
        this.player = SurvivalFactory2.player3();
        this.currentCharacter = "Audrey";
      }
    }
    
    // Preserve years survived
    player.setYearsSurvived(oldYears);
    player.setCharacterName(currentCharacter);
    gameState.setCharacterChanged(true);
    
    System.out.println(TextColor.GREEN_BOLD + "\nYou have transformed into " + currentCharacter + " while keeping your " + oldYears + " years of experience!" + TextColor.RESET);
    Util.pauseConsole();
  }

  // Feature 5: Time travel
  private void timeTravel() {
    Util.clearConsole();
    System.out.println(TextColor.PURPLE_BOLD + "=== TIME TRAVEL ===\n" + TextColor.RESET);
    System.out.println("You've discovered a mysterious time portal!");
    System.out.println("Do you want to go:\n1. Into the future (+5 years)\n2. Into the past (-3 years, but stats change randomly)");
    int choice = Util.enterInt(1, 2);
    
    if (choice == 1) {
      // Travel to future
      int yearsJump = 5;
      player.addYearsSurvived(yearsJump);
      player.addLifeHealth(-20.00);
      player.addAdaptability(15.00);
      player.addMoney(300);
      System.out.println(TextColor.CYAN_BOLD + "\nYou jumped 5 years into the future!" + TextColor.RESET);
      System.out.println("Years survived: +" + yearsJump);
      System.out.println("Life health: -20");
      System.out.println("Adaptability: +15");
      System.out.println("Money: +$300");
    } else {
      // Travel to past - random stat changes
      int yearsBack = 3;
      player.addYearsSurvived(-yearsBack);
      
      // Random stat changes
      int randomHealth = random.nextInt(41) - 20; // -20 to +20
      int randomMoney = random.nextInt(601) - 300; // -300 to +300
      int randomMorale = random.nextInt(41) - 20; // -20 to +20
      int randomAdaptability = random.nextInt(31) - 15; // -15 to +15
      
      player.addLifeHealth(randomHealth);
      player.addMoney(randomMoney);
      player.addMorale(randomMorale);
      player.addAdaptability(randomAdaptability);
      
      System.out.println(TextColor.CYAN_BOLD + "\nYou traveled 3 years into the past!" + TextColor.RESET);
      System.out.println("Years survived: -" + yearsBack);
      System.out.println("Life health changed by: " + randomHealth);
      System.out.println("Money changed by: $" + randomMoney);
      System.out.println("Morale changed by: " + randomMorale);
      System.out.println("Adaptability changed by: " + randomAdaptability);
    }
    
    Util.pauseConsole();
  }

  private void endOfGame() {
    // Check if player won
    if (player.getYearsSurvived() >= Survival.MAX_YEARS_SURVIVED && 
        player.getLifeHealth() > Survival.MIN_LIFE_HEALTH &&
        player.getMoney() > Survival.MIN_MONEY &&
        player.getMorale() > Survival.MIN_MORALE &&
        player.getAdaptability() > Survival.MIN_ADAPTABILITY) {
      System.out.println(TextColor.GREEN_BOLD + "\n\n\nCONGRATULATIONS! You survived 50 years and built a new life in America!" + TextColor.RESET);
    } else {
      System.out.println("\n\n\n" + StringConstants.GAME_OVER);
    }
    
    Util.pauseConsole();

    System.out.println("What was your character's name?");
    String userName = scan.nextLine();
    if (userName.trim().isEmpty()) {
      userName = currentCharacter;
    }

    LeaderboardManager.record(userName, player.getYearsSurvived(), player.getLifeHealth());
    Util.clearConsole();
    LeaderboardManager.printResults();

    Util.pauseConsole();
    
    System.out.println("Would you like to play again? (y/n)");
    String playAgain = scan.nextLine().toLowerCase();
    if (playAgain.equals("y") || playAgain.equals("yes")) {
      this.player = new Survival();
      this.gameState = new GameState();
      this.random = new Random();
      run();
    } else {
      System.out.println("Thanks for playing!");
      System.exit(0);
    }
  }
}