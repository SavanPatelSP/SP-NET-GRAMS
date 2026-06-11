package org.telegram.ui.spnet;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.telegram.spnet.achievements.SPNetAchievement;
import org.telegram.spnet.achievements.SPNetAchievementManager;
import org.telegram.ui.ActionBar.BaseFragment;

public class SPNetAchievementsActivity extends BaseFragment {

    @Override
    public android.view.View createView(Context context) {

        actionBar.setTitle("Achievements");

        ScrollView scrollView =
                new ScrollView(context);

        LinearLayout layout =
                new LinearLayout(context);

        layout.setOrientation(
                LinearLayout.VERTICAL
        );

        scrollView.addView(layout);

        for (SPNetAchievement achievement :
                SPNetAchievementManager
                        .getInstance()
                        .getAchievements()) {

            TextView item =
                    new TextView(context);

item.setText(
        achievement.getTitle() +
        "\n" +
        achievement.getDescription() +
        "\n" +
        achievement.getStatus()
);
            layout.addView(item);
        }

        fragmentView = scrollView;

        return fragmentView;
    }
}
