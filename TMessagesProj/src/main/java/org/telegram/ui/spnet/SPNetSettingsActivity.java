package org.telegram.ui.spnet;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.telegram.ui.ActionBar.BaseFragment;

public class SPNetSettingsActivity extends BaseFragment {

    @Override
    public android.view.View createView(Context context) {

        actionBar.setTitle("SP-NET Settings");
        actionBar.setBackButtonImage(
                org.telegram.messenger.R.drawable.ic_ab_back
        );

        FrameLayout frameLayout = new FrameLayout(context);

        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(40,40,40,40);

        TextView tv = new TextView(context);
        tv.setText(
                "SP-NET Settings\n\n" +
                "• Show Badge\n" +
                "• Show Premium Status\n" +
                "• Show Referrals"
        );

        layout.addView(tv);
        frameLayout.addView(layout);

        fragmentView = frameLayout;
        return fragmentView;
    }
}

