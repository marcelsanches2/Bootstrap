package com.bootstrap.util;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;

/**
 * Created by tpinho on 7/21/15.
 */
public final class AlertUtils {

    private AlertUtils() {
    }

    public static void showMessage(final View view, final int message) {
        showMessage(view, view.getResources().getString(message), null, null);
    }

    public static void showMessage(final View view, final String message) {
        showMessage(view, message, null, null);
    }

    public static void showMessage(final View view, final String message, final String actionText, final View.OnClickListener actionListener) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .setActionTextColor(Color.WHITE);
        snackbar.setCallback(new Snackbar.Callback() {
            @Override
            public void onShown(Snackbar snackbar) {
                snackbar.getView().setContentDescription(message);
                snackbar.getView().sendAccessibilityEvent(AccessibilityEvent.TYPE_ANNOUNCEMENT);
            }
        });
        snackbar.setAction(actionText, actionListener);

        View snackBarView = snackbar.getView();
        TextView tvSnack = (TextView)
                snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        tvSnack.setMaxLines(3);

        snackbar.show();
    }

//    public static void showMessageWithAction(final View view, final String message, final String actionTitle, View.OnClickListener listener) {
//       Snackbar.make(view, message, Snackbar.LENGTH_LONG).setAction(actionTitle, listener).setDuration(Snackbar.LENGTH_LONG).show();
//    }

}