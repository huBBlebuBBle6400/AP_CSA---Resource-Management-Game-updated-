public class SurvivalFactory2 {

  // Player 1 - Joshua
  public static final String SURVIVAL2_PLAYER_1 = "Joshua";
  public static final int SURVIVAL2_PLAYER_1_ID = 1;
  public static final int SURVIVAL2_PLAYER_1_INITIAL_YEARS_SURVIVED = 2;
  public static final double SURVIVAL2_PLAYER_1_INITIAL_LIFE_HEALTH = 100.00;
  public static final double SURVIVAL2_PLAYER_1_INITIAL_MONEY = 1000.00;
  public static final double SURVIVAL2_PLAYER_1_INITIAL_WAGE = 150.00;
  public static final int SURVIVAL2_PLAYER_1_INITIAL_MORALE = 60;
  public static final double SURVIVAL2_PLAYER_1_INITIAL_ADAPTABILITY = 50.00;
  public static final int SURVIVAL2_PLAYER_1_INITIAL_ACRES_LAND_OWNED = 20;

  // Player 2 - David
  public static final String SURVIVAL2_PLAYER_2 = "David";
  public static final int SURVIVAL2_PLAYER_2_ID = 2;
  public static final int SURVIVAL2_PLAYER_2_INITIAL_YEARS_SURVIVED = 2;
  public static final double SURVIVAL2_PLAYER_2_INITIAL_LIFE_HEALTH = 100.00;
  public static final double SURVIVAL2_PLAYER_2_INITIAL_MONEY = 700.00;
  public static final double SURVIVAL2_PLAYER_2_INITIAL_WAGE = 110.00;
  public static final int SURVIVAL2_PLAYER_2_INITIAL_MORALE = 75;
  public static final double SURVIVAL2_PLAYER_2_INITIAL_ADAPTABILITY = 30.00;
  public static final int SURVIVAL2_PLAYER_2_INITIAL_ACRES_LAND_OWNED = 30;

  // Player 3 - Audrey
  public static final String SURVIVAL2_PLAYER_3 = "Audrey";
  public static final int SURVIVAL2_PLAYER_3_ID = 3;
  public static final int SURVIVAL2_PLAYER_3_INITIAL_YEARS_SURVIVED = 2;
  public static final double SURVIVAL2_PLAYER_3_INITIAL_LIFE_HEALTH = 100.00;
  public static final double SURVIVAL2_PLAYER_3_INITIAL_MONEY = 864.00;
  public static final double SURVIVAL2_PLAYER_3_INITIAL_WAGE = 84.00;
  public static final int SURVIVAL2_PLAYER_3_INITIAL_MORALE = 64;
  public static final double SURVIVAL2_PLAYER_3_INITIAL_ADAPTABILITY = 70.00;
  public static final int SURVIVAL2_PLAYER_3_INITIAL_ACRES_LAND_OWNED = 32;

  public static Survival player1() {
    Survival player = new Survival(SURVIVAL2_PLAYER_1_INITIAL_YEARS_SURVIVED,
                                   SURVIVAL2_PLAYER_1_INITIAL_LIFE_HEALTH,
                                   SURVIVAL2_PLAYER_1_INITIAL_MONEY,
                                   SURVIVAL2_PLAYER_1_INITIAL_WAGE,
                                   false,
                                   SURVIVAL2_PLAYER_1_INITIAL_MORALE,
                                   SURVIVAL2_PLAYER_1_INITIAL_ADAPTABILITY,
                                   SURVIVAL2_PLAYER_1_INITIAL_ACRES_LAND_OWNED);
    player.setCharacterName(SURVIVAL2_PLAYER_1);
    return player;
  }
  
  public static Survival player2() {
    Survival player = new Survival(SURVIVAL2_PLAYER_2_INITIAL_YEARS_SURVIVED,
                                   SURVIVAL2_PLAYER_2_INITIAL_LIFE_HEALTH,
                                   SURVIVAL2_PLAYER_2_INITIAL_MONEY,
                                   SURVIVAL2_PLAYER_2_INITIAL_WAGE,
                                   false,
                                   SURVIVAL2_PLAYER_2_INITIAL_MORALE,
                                   SURVIVAL2_PLAYER_2_INITIAL_ADAPTABILITY,
                                   SURVIVAL2_PLAYER_2_INITIAL_ACRES_LAND_OWNED);
    player.setCharacterName(SURVIVAL2_PLAYER_2);
    return player;
  }
  
  public static Survival player3() {
    Survival player = new Survival(SURVIVAL2_PLAYER_3_INITIAL_YEARS_SURVIVED,
                                   SURVIVAL2_PLAYER_3_INITIAL_LIFE_HEALTH,
                                   SURVIVAL2_PLAYER_3_INITIAL_MONEY,
                                   SURVIVAL2_PLAYER_3_INITIAL_WAGE,
                                   false,
                                   SURVIVAL2_PLAYER_3_INITIAL_MORALE,
                                   SURVIVAL2_PLAYER_3_INITIAL_ADAPTABILITY,
                                   SURVIVAL2_PLAYER_3_INITIAL_ACRES_LAND_OWNED);
    player.setCharacterName(SURVIVAL2_PLAYER_3);
    return player;
  }
}