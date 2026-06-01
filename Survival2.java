public class Survival2 {

  // Instance variables
  private int yearsSurvived2;
  private double lifeHealth2;
  private double money2;
  private int morale2;
  private double adaptability2;
  private int acresLandOwned2;
  
  // NEW instance variables for features
  private String characterName;
  private boolean hasLivestock;
  private int consecutiveLandPurchases;

  // Static variables
  public static final int YEARS_SURVIVED_2 = 3;
  public static final double LIFE_HEALTH_2 = 100.00;
  public static final double MONEY_2 = 700.00;
  public static final int MORALE_2 = 70;
  public static final double ADAPTABILITY_2 = 45.00;

  public static final int MAX_YEARS_SURVIVED_2 = 50;
  public static final double MIN_LIFE_HEALTH_2 = 0.00;
  public static final double MIN_MONEY_2 = 0.00;
  public static final int MIN_MORALE_2 = 15;
  public static final double MIN_ADAPTABILITY_2 = 10.00;
  
  // NEW constant for character switching
  public static final double CHARACTER_SWITCH_REQUIREMENT = 75.0;

  // Default constructor
  public Survival2() {
    this.yearsSurvived2 = 2;
    this.lifeHealth2 = 100.00;
    this.money2 = 1000.00;
    this.morale2 = 60;
    this.adaptability2 = 50.00;
    this.acresLandOwned2 = 20;
    this.hasLivestock = false;
    this.consecutiveLandPurchases = 0;
    this.characterName = "";
  }

  // Constructor that initializes all variables
  public Survival2(int yearsSurvived2, double lifeHealth2, double money2, int morale2, 
                   double adaptability2, int acresLandOwned2) {
    this.yearsSurvived2 = yearsSurvived2;
    this.lifeHealth2 = lifeHealth2;
    this.money2 = money2;
    this.morale2 = morale2;
    this.adaptability2 = adaptability2;
    this.acresLandOwned2 = acresLandOwned2;
    this.hasLivestock = false;
    this.consecutiveLandPurchases = 0;
    this.characterName = "";
  }

  // Initializes some variables (money and land owned)
  public Survival2(double money2, int acresLandOwned2) {
    this.yearsSurvived2 = 2;
    this.lifeHealth2 = 100.00;
    this.money2 = money2;
    this.morale2 = 60;
    this.adaptability2 = 50.00;
    this.acresLandOwned2 = acresLandOwned2;
    this.hasLivestock = false;
    this.consecutiveLandPurchases = 0;
    this.characterName = "";
  }

  // NEW getters and setters for features
  public String getCharacterName() {
    return characterName;
  }

  public void setCharacterName(String name) {
    this.characterName = name;
  }

  public boolean hasLivestock() {
    return hasLivestock;
  }

  public void setHasLivestock(boolean hasLivestock) {
    this.hasLivestock = hasLivestock;
  }

  public int getConsecutiveLandPurchases() {
    return consecutiveLandPurchases;
  }

  public void setConsecutiveLandPurchases(int purchases) {
    this.consecutiveLandPurchases = purchases;
  }

  public void incrementConsecutiveLandPurchases() {
    this.consecutiveLandPurchases++;
  }

  public void resetConsecutiveLandPurchases() {
    this.consecutiveLandPurchases = 0;
  }

  // NEW method to increase life health
  public void increaseLifeHealth(double amount) {
    this.lifeHealth2 += amount;
    if (this.lifeHealth2 > 100.0) {
      this.lifeHealth2 = 100.0;
    }
    System.out.println("Life health increased by " + amount + "! Current: " + this.lifeHealth2);
  }

  // Getters
  public int getYearsSurvived2() {
    return yearsSurvived2;
  }

  public double getLifeHealth2() {
    return lifeHealth2;
  }

  public double getMoney2() {
    return money2;
  }

  public int getMorale2() {
    return morale2;
  }

  public double getAdaptability2() {
    return adaptability2;
  }

  public int getAcresLandOwned2() {
    return acresLandOwned2;
  }

  // Setters
  public void setYearsSurvived2(int yearsSurvived2) {
    this.yearsSurvived2 = yearsSurvived2;
    if (yearsSurvived2 > MAX_YEARS_SURVIVED_2) {
      this.yearsSurvived2 = MAX_YEARS_SURVIVED_2;
    }
    if (yearsSurvived2 < 0) {
      this.yearsSurvived2 = 0;
    }
  }

  public void setLifeHealth2(double lifeHealth2) {
    this.lifeHealth2 = lifeHealth2;
    if (lifeHealth2 < MIN_LIFE_HEALTH_2) {
      this.lifeHealth2 = MIN_LIFE_HEALTH_2;
    }
    if (lifeHealth2 > 100.0) {
      this.lifeHealth2 = 100.0;
    }
  }

  public void setMoney2(double money2) {
    this.money2 = money2;
    if (money2 < MIN_MONEY_2) {
      this.money2 = MIN_MONEY_2;
    }
  }

  public void setMorale2(int morale2) {
    this.morale2 = morale2;
    if (morale2 < MIN_MORALE_2) {
      this.morale2 = MIN_MORALE_2;
    }
  }

  public void setAdaptability2(double adaptability2) {
    this.adaptability2 = adaptability2;
    if (adaptability2 < MIN_ADAPTABILITY_2) {
      this.adaptability2 = MIN_ADAPTABILITY_2;
    }
  }

  public void setAcresLandOwned2(int acresLandOwned2) {
    this.acresLandOwned2 = acresLandOwned2;
  }

  // Adders/Change methods
  public void addYearsSurvived2(int addYearsSurvived2) {
    setYearsSurvived2(yearsSurvived2 + addYearsSurvived2);
  }

  public void addLifeHealth2(double addLifeHealth2) {
    setLifeHealth2(lifeHealth2 + addLifeHealth2);
  }

  public void addMoney2(double addMoney2) {
    setMoney2(money2 + addMoney2);
  }

  public void addMorale2(int addMorale2) {
    setMorale2(morale2 + addMorale2);
  }

  public void addAdaptability2(double addAdaptability2) {
    setAdaptability2(adaptability2 + addAdaptability2);
  }

  public void addAcresLandOwned2(int addAcresLandOwned2) {
    setAcresLandOwned2(acresLandOwned2 + addAcresLandOwned2);
  }

  // For compatibility with Game.java that expects Survival type methods
  // These wrapper methods allow Survival2 to work with the same interface
  public int getYearsSurvived() {
    return yearsSurvived2;
  }

  public double getLifeHealth() {
    return lifeHealth2;
  }

  public double getMoney() {
    return money2;
  }

  public int getMorale() {
    return morale2;
  }

  public double getAdaptability() {
    return adaptability2;
  }

  public int getAcresLandOwned() {
    return acresLandOwned2;
  }

  public void addYearsSurvived(int amount) {
    addYearsSurvived2(amount);
  }

  public void addLifeHealth(double amount) {
    addLifeHealth2(amount);
  }

  public void addMoney(double amount) {
    addMoney2(amount);
  }

  public void addMorale(int amount) {
    addMorale2(amount);
  }

  public void addAdaptability(double amount) {
    addAdaptability2(amount);
  }

  public void addAcresLandOwned(int amount) {
    addAcresLandOwned2(amount);
  }

  public void setYearsSurvived(int years) {
    setYearsSurvived2(years);
  }

  public void setMoney(double money) {
    setMoney2(money);
  }

  public void setMorale(int morale) {
    setMorale2(morale);
  }

  public void setAdaptability(double adaptability) {
    setAdaptability2(adaptability);
  }

  public void setAcresLandOwned(int acres) {
    setAcresLandOwned2(acres);
  }

  // String representation
  public String toString() {
    return "Years Survived: \t\t" + yearsSurvived2 +
      "\nLife Health: \t\t" + lifeHealth2 +
      "\nMoney: \t\t" + money2 +
      "\nMorale Index: \t\t" + morale2 +
      "\nAdaptability Index: \t\t" + adaptability2 +
      "\nLand Owned (acres): \t\t" + acresLandOwned2;
  }
}