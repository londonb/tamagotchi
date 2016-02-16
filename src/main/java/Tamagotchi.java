public class Tamagotchi {
  private String mName;
  private int mFoodLevel;
  private int mSleepLevel;
  private int mActivity;
  private int mHealth;
  private final int MAX_FOOD = 10;
  private final int MAX_SLEEP = 10;
  private final int MAX_ACTIVITY = 10;
  private final int MAX_HEALTH = 10;

  public Tamagotchi(String name) {
    mName = name;
    mFoodLevel = 8;
    mSleepLevel = 8;
    mActivity = 8;
    mHealth = 20;
  }

  public String getName() {
    return mName;
  }
  public int getFoodLevel() {
    return mFoodLevel;
  }
  public int getSleepLevel() {
    return mSleepLevel;
  }
  public int getActivityLevel() {
    return mActivity;
  }
  public int getHealthLevel() {
    return mHealth;
  }

  public void timePasses() {
    doRandomEvent();
    mFoodLevel--;
    mSleepLevel--;
    mActivity--;
    mHealth--;
  }

  public void doRandomEvent() {

    switch((int)(Math.random()*10)) {
      case 6: mFoodLevel--;
      case 5: mSleepLevel--;
      case 4: mSleepLevel++;
      case 3: mHealth--;
      case 2: mActivity++;
      case 1: mActivity--;
      default: break;
    }
  }

  public boolean isAlive() {
    return mHealth > 0;
  }

  public int feed() {
    if (mFoodLevel == MAX_FOOD) {
      mHealth--;
      mSleepLevel--;
    } else {
      mFoodLevel++;
    }
    return mFoodLevel;
  }

  public int nap() {
    if (mSleepLevel == MAX_SLEEP) {
      mHealth--;
      mActivity--;
    } else {
      mSleepLevel++;
    }
    return mSleepLevel;
  }

  public int play() {
    if (mActivity == MAX_ACTIVITY) {
      mHealth--;
      mFoodLevel--;
    } else {
      mActivity++;
    }
    return mActivity;
  }
}
