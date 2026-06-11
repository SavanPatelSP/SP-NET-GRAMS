package org.telegram.spnet.achievements;

public class SPNetAchievement {

    private final String id;
    private final String title;
    private final String description;
    private boolean unlocked;

    public SPNetAchievement(
            String id,
            String title,
            String description
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.unlocked = false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void unlock() {
        unlocked = true;
    }
public String getStatus() {

    if (unlocked) {

        return "✅ Unlocked";

    }

    return "🔒 Locked";

}
}
