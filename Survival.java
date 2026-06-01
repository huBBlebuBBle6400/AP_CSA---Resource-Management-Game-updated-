
public class Survival{

  // Instance variables
  private int yearsSurvived;
  private double lifeHealth;
  private double money;
  private double wage;
  private boolean isAlienated;
  private int morale;
  private double adaptability;
  private int acresLandOwned;
  
  // NEW instance variables for features
  private String characterName;
  private boolean hasLivestock;
  private int consecutiveLandPurchases;

  // Static variables
  public static final int INITIAL_YEARS_SURVIVED = 2;
  public static final double INITIAL_LIFE_HEALTH = 100.00;
  public static final double INITIAL_MONEY = 1000.00;
  public static final double INITIAL_WAGE = 150.00;
  public static final boolean INITIAL_IS_ALIENATED = false;
  public static final int INITIAL_MORALE = 60;
  public static final double INITIAL_ADAPTABILITY = 50.00;
  public static final int INITIAL_ACRES_LAND_OWNED = 30;

  public static final int MAX_YEARS_SURVIVED = 50;
  public static final double MIN_LIFE_HEALTH = 0.00;
  public static final double MIN_MONEY = 0.00;
  public static final int MIN_MORALE = 15;
  public static final double MIN_ADAPTABILITY = 10.00;
  
  // NEW constant for character switching
  public static final double CHARACTER_SWITCH_REQUIREMENT = 75.0;

  // Constructors
  public Survival() {
    this.yearsSurvived = INITIAL_YEARS_SURVIVED; 
    this.lifeHealth = INITIAL_LIFE_HEALTH;
    this.money = INITIAL_MONEY;
    this.wage = INITIAL_WAGE;
    this.isAlienated = false;
    this.morale = INITIAL_MORALE;
    this.adaptability = INITIAL_ADAPTABILITY;
    this.acresLandOwned = INITIAL_ACRES_LAND_OWNED;
    this.hasLivestock = false;
    this.consecutiveLandPurchases = 0;
    this.characterName = "";
  }

  public Survival(int yearsSurvived, double lifeHealth, double money, double wage, 
                  boolean isAlienated, int morale, double adaptability, int acresLandOwned) {
    this.yearsSurvived = yearsSurvived; 
    this.lifeHealth = lifeHealth;
    this.money = money;
    this.wage = wage;
    this.isAlienated = isAlienated;
    this.morale = morale;
    this.adaptability = adaptability;
    this.acresLandOwned = acresLandOwned;
    this.hasLivestock = false;
    this.consecutiveLandPurchases = 0;
    this.characterName = "";
  }

  public Survival(double wage, int acresLandOwned) {
    this.yearsSurvived = 2; 
    this.lifeHealth = 100.00;
    this.money = 1000.00;
    this.wage = wage;
    this.isAlienated = false;
    this.morale = 60;
    this.adaptability = 50.00;
    this.acresLandOwned = acresLandOwned;
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
    this.lifeHealth += amount;
    if (this.lifeHealth > 100.0) {
      this.lifeHealth = 100.0;
    }
    System.out.println("Life health increased by " + amount + "! Current: " + this.lifeHealth);
  }

  // Getters
  public int getYearsSurvived() {
    return yearsSurvived;
  }
  
  public double getLifeHealth() {
    return lifeHealth;
  }
  
  public double getMoney() {
    return money;
  }
  
  public double getWage() {
    return wage;
  }
  
  public boolean isAlienated() {
    return isAlienated;
  }
  
  public int getMorale() {
    return morale;
  }
  
  public double getAdaptability() {
    return adaptability;
  }
  
  public int getAcresLandOwned() {
    return acresLandOwned;
  }

  // Setters
  public void setYearsSurvived(int yearsSurvived) {
    this.yearsSurvived = yearsSurvived;
    if (yearsSurvived >= MAX_YEARS_SURVIVED) {
      this.yearsSurvived = MAX_YEARS_SURVIVED;
    }
    if (yearsSurvived < 0) {
      this.yearsSurvived = 0;
    }
  }
  
  public void setLifeHealth(double lifeHealth) {
    this.lifeHealth = lifeHealth;
    if (lifeHealth < MIN_LIFE_HEALTH) {
      this.lifeHealth = MIN_LIFE_HEALTH;
    }
    if (lifeHealth > 100.0) {
      this.lifeHealth = 100.0;
    }
  }
  
  public void setMoney(double money) {
    this.money = money;
    if (money < MIN_MONEY) {
      this.money = MIN_MONEY;
    }
  }
  
  public void setWage(double wage) {
    this.wage = wage;
  }
  
  public void setIsAlientated(boolean isAlienated) {
    this.isAlienated = isAlienated;
  }
  
  public void setMorale(int morale) {
    this.morale = morale;
    if (morale < MIN_MORALE) {
      this.morale = MIN_MORALE;
    }
  }
  
  public void setAdaptability(double adaptability) {
    this.adaptability = adaptability;
    if (adaptability < MIN_ADAPTABILITY) {
      this.adaptability = MIN_ADAPTABILITY;
    }
  }
  
  public void setAcresLandOwned(int acresLandOwned) {
    this.acresLandOwned = acresLandOwned;
  }

  // Adders - FIXED: Make sure these all exist
  public void addYearsSurvived(int amount) {
    setYearsSurvived(yearsSurvived + amount);
  }
  
  public void addLifeHealth(double amount) {
    setLifeHealth(lifeHealth + amount);
  }
  
  // Overloaded addMoney methods
  public void addMoney(double amount) {
    setMoney(money + amount);
  }
  
  public void addMoney(int amount) {
    addMoney((double) amount);
  }
  
  public void addWage(double amount) {
    setWage(this.wage + amount);
  }
  
  public void addMorale(int amount) {
    setMorale(morale + amount);
  }
  
  public void addAdaptability(double amount) {
    setAdaptability(adaptability + amount);
  }
  
  public void addAcresLandOwned(int amount) {
    setAcresLandOwned(acresLandOwned + amount);
  }

  // Instance methods
  public String toString() {
    return "Years Survived: \t\t" + yearsSurvived +
      "\nLife Health: \t\t" + lifeHealth + 
      "\nMoney: \t\t" + money +
      "\nWage: \t\t" + wage +
      "\nAlienated: \t\t" + isAlienated +
      "\nMorale Index: \t\t" + morale +
      "\nAdaptability Index: \t\t" + adaptability +
      "\nLand Owned (acres): \t\t" + acresLandOwned;
  }

  public boolean areObjectsEqual(Survival anotherSurvival) {
    return this.yearsSurvived == anotherSurvival.yearsSurvived &&
      this.lifeHealth == anotherSurvival.lifeHealth &&
      this.money == anotherSurvival.money &&
      this.wage == anotherSurvival.wage &&
      this.isAlienated == anotherSurvival.isAlienated &&
      this.morale == anotherSurvival.morale &&
      this.adaptability == anotherSurvival.adaptability &&
      this.acresLandOwned == anotherSurvival.acresLandOwned;
  }
}