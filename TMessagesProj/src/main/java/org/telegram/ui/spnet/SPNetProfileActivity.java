package org.telegram.ui.spnet;

import android.content.Context;
import android.widget.FrameLayout;

import org.telegram.spnet.SPNetUserData;
import org.telegram.spnet.SPNetUserManager;

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
SPNetUserData user =
        SPNetUserManager.getInstance().getUser(1L);
android.widget.LinearLayout layout = new android.widget.LinearLayout(context);
layout.setOrientation(android.widget.LinearLayout.VERTICAL);
layout.setPadding(40, 40, 40, 40);

android.widget.TextView title = new android.widget.TextView(context);
title.setText("SP NET Profile");
title.setTextSize(24);

android.widget.TextView identity = new android.widget.TextView(context);
identity.setText(
        "\nIDENTITY\nBadge: " + user.getBadge()
);

android.widget.TextView membership = new android.widget.TextView(context);
membership.setText(
        "\nMEMBERSHIP\nTier: " + user.getPremiumTier()
);
android.widget.TextView community = new android.widget.TextView(context);
community.setText(
        "\nCOMMUNITY\nReferrals: " +
        user.getReferralCount()
);
android.widget.TextView economy = new android.widget.TextView(context);
economy.setText(
        "\nECONOMY\n" +
        "Coins: " + user.getCoins() + "\n" +
        "Diamonds: " + user.getDiamonds()
);
android.widget.TextView account = new android.widget.TextView(context);
account.setText(
        "\nACCOUNT\n" +
        "User ID: " + user.getUserId() + "\n" +
        "Created: " +
        new java.util.Date(user.getCreatedAt())
);

layout.addView(title);
layout.addView(identity);
layout.addView(membership);
layout.addView(community);
layout.addView(economy);
layout.addView(account);

frameLayout.addView(layout);

fragmentView = frameLayout;

return fragmentView;
    }
}

