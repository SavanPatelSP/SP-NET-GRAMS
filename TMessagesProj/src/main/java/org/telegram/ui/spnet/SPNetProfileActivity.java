package org.telegram.ui.spnet;

import android.content.Context;
import android.widget.FrameLayout;

import org.telegram.ui.ActionBar.ActionBar;
import org.telegram.ui.ActionBar.BaseFragment;

public class SPNetProfileActivity extends BaseFragment {

    @Override
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        return true;
    }

    @Override
    public android.view.View createView(Context context) {

        actionBar.setTitle("SP NET Profile");
        actionBar.setBackButtonImage(
                org.telegram.messenger.R.drawable.ic_ab_back
        );

        FrameLayout frameLayout = new FrameLayout(context);

android.widget.TextView textView = new android.widget.TextView(context);
textView.setText("SP NET Profile\n\nBadge: NONE\nPremium: FREE");
textView.setTextSize(18);

frameLayout.addView(textView);

fragmentView = frameLayout;

return fragmentView;
    }
}

