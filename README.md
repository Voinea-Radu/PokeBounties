# PokeBounties


## API Example
```java
public class ExampleClass {

    /**
     * Method used to access user progress for a specific quest in a day (the first quest today)
     * @param player The player to access
     */
    public void accessQuestProgress(Player player){
        Quest quest = QuestAPI.getQuest().quests.get(0);

        BountyUser user = BountyUser.getUser(player);
        user.getLevelOfQuest(quest);
    }

}
```

## API Methods
```
BountyUser#getUser(Player player)
BountyUser#getName()
BountyUser#getUUID()
BountyUser#finishLevel(Quest quest, EnumSpecies species, int level)
BountyUser#getLevelOfQuest(Quest quest)

QuestAPI#getGeneratedQuests()
QuestAPI#getQuest(String date)
QuestAPI#getQuest()
QuestAPI#getGeneratedDates()
```
