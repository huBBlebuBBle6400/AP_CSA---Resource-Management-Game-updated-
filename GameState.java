public class GameState {
    private boolean characterChanged;
    private int daysSinceLastLandPurchase;
    
    public GameState() {
        this.characterChanged = false;
        this.daysSinceLastLandPurchase = 0;
    }
    
    public boolean hasCharacterChanged() {
        return characterChanged;
    }
    
    public void setCharacterChanged(boolean changed) {
        this.characterChanged = changed;
    }
    
    public int getDaysSinceLastLandPurchase() {
        return daysSinceLastLandPurchase;
    }
    
    public void incrementDaysSinceLastLandPurchase() {
        this.daysSinceLastLandPurchase++;
    }
    
    public void resetDaysSinceLastLandPurchase() {
        this.daysSinceLastLandPurchase = 0;
    }
}