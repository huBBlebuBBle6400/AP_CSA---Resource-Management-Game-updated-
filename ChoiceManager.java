public class ChoiceManager {
    
    // Jeffrey's special choices (City path)
    public static void showJeffreyChoices(Survival player, GameState gameState) {
        System.out.println("\n--- Special Opportunity for Jeffrey ---");
        System.out.println("6. Unionize the factory workers (Requires 70+ morale)");
        System.out.println("7. Invest in factory machinery (Requires $2000+)");
        if (gameState.getDaysSinceLastLandPurchase() >= 3) {
            System.out.println("8. Sell land to pay taxes (Government taxing you!)");
        }
    }
    
    // Danny's special choices (City path)
    public static void showDannyChoices(Survival player) {
        System.out.println("\n--- Special Opportunity for Danny ---");
        System.out.println("6. Start a small business (Requires 60+ adaptability)");
        System.out.println("7. Take night classes (Costs $500, +30 adaptability)");
    }
    
    // Avery's special choices (City path)
    public static void showAveryChoices(Survival player) {
        System.out.println("\n--- Special Opportunity for Avery ---");
        System.out.println("6. Learn English at community center (+20 morale, -$100)");
        System.out.println("7. Publish newspaper articles about immigrant rights");
    }
    
    // Joshua's special choices (Country path)
    public static void showJoshuaChoices(Survival player) {
        System.out.println("\n--- Special Opportunity for Joshua ---");
        System.out.println("6. Form farming cooperative (Requires 50+ acres)");
        System.out.println("7. Irrigate your land ($800, +15 adaptability)");
    }
    
    // David's special choices (Country path)
    public static void showDavidChoices(Survival player) {
        System.out.println("\n--- Special Opportunity for David ---");
        System.out.println("6. Raise livestock ($600, +20 money each turn)");
        System.out.println("7. Build a barn (+10 acres, -$400)");
    }
    
    // Audrey's special choices (Country path)
    public static void showAudreyChoices(Survival player) {
        System.out.println("\n--- Special Opportunity for Audrey ---");
        System.out.println("6. Start a farmers market (+$200, +15 morale)");
        System.out.println("7. Buy organic seeds (+30 adaptability, -$300)");
    }
    
    // Handle special choices for City path
    public static boolean handleCitySpecialChoice(int choice, Survival player, String characterName, GameState gameState) {
        switch(characterName) {
            case "Jeffrey":
                return handleJeffreyChoice(choice, player, gameState);
            case "Danny":
                return handleDannyChoice(choice, player);
            case "Avery":
                return handleAveryChoice(choice, player);
        }
        return false;
    }
    
    // Handle special choices for Country path - THIS IS THE METHOD YOU NEED
    public static boolean handleCountrySpecialChoice(int choice, Survival player, String characterName) {
        switch(characterName) {
            case "Joshua":
                return handleJoshuaChoice(choice, player);
            case "David":
                return handleDavidChoice(choice, player);
            case "Audrey":
                return handleAudreyChoice(choice, player);
        }
        return false;
    }
    
    // ========== HELPER METHODS FOR CITY PATH ==========
    
    private static boolean handleJeffreyChoice(int choice, Survival player, GameState gameState) {
        if (choice == 6 && player.getMorale() >= 70) {
            player.addMorale(30);
            player.addMoney(500);
            System.out.println("You unionized the workers! +30 morale, +$500");
            return true;
        } else if (choice == 7 && player.getMoney() >= 2000) {
            player.addMoney(-2000);
            player.addWage(50);
            player.addAdaptability(25);
            System.out.println("New machinery increased efficiency! +$50 wage, +25 adaptability");
            return true;
        } else if (choice == 8 && gameState.getDaysSinceLastLandPurchase() >= 3) {
            player.addMoney(-300);
            player.addAcresLandOwned(-5);
            System.out.println("Government taxed your land! Lost 5 acres and $300");
            gameState.resetDaysSinceLastLandPurchase();
            return true;
        }
        return false;
    }
    
    private static boolean handleDannyChoice(int choice, Survival player) {
        if (choice == 6 && player.getAdaptability() >= 60) {
            player.addMoney(1000);
            player.addMorale(20);
            player.addAdaptability(15);
            System.out.println("Your small business is thriving! +$1000, +20 morale");
            return true;
        } else if (choice == 7 && player.getMoney() >= 500) {
            player.addMoney(-500);
            player.addAdaptability(30);
            player.addMorale(15);
            System.out.println("Night classes improved your skills! +30 adaptability");
            return true;
        }
        return false;
    }
    
    private static boolean handleAveryChoice(int choice, Survival player) {
        if (choice == 6 && player.getMoney() >= 100) {
            player.addMoney(-100);
            player.addMorale(20);
            player.addAdaptability(10);
            System.out.println("Learning English helped you integrate! +20 morale");
            return true;
        } else if (choice == 7 && player.getMorale() >= 50) {
            player.addMorale(25);
            player.addMoney(300);
            System.out.println("Your articles are making a difference! +$300, +25 morale");
            return true;
        }
        return false;
    }
    
    // ========== HELPER METHODS FOR COUNTRY PATH ==========
    
    private static boolean handleJoshuaChoice(int choice, Survival player) {
        if (choice == 6 && player.getAcresLandOwned() >= 50) {
            player.addMoney(800);
            player.addMorale(25);
            System.out.println("Farming cooperative increased profits! +$800");
            return true;
        } else if (choice == 7 && player.getMoney() >= 800) {
            player.addMoney(-800);
            player.addAdaptability(15);
            player.addAcresLandOwned(10);
            System.out.println("Irrigation improved your land! +15 adaptability, +10 acres");
            return true;
        }
        return false;
    }
    
    private static boolean handleDavidChoice(int choice, Survival player) {
        if (choice == 6 && player.getMoney() >= 600) {
            player.addMoney(-600);
            player.setHasLivestock(true);
            System.out.println("You now have livestock! +$20 each turn");
            return true;
        } else if (choice == 7 && player.getMoney() >= 400) {
            player.addMoney(-400);
            player.addAcresLandOwned(10);
            System.out.println("New barn added 10 acres!");
            return true;
        }
        return false;
    }
    
    private static boolean handleAudreyChoice(int choice, Survival player) {
        if (choice == 6 && player.getMorale() >= 40) {
            player.addMoney(200);
            player.addMorale(15);
            System.out.println("Farmers market boosted sales! +$200, +15 morale");
            return true;
        } else if (choice == 7 && player.getMoney() >= 300) {
            player.addMoney(-300);
            player.addAdaptability(30);
            System.out.println("Organic seeds improved adaptability! +30");
            return true;
        }
        return false;
    }
}