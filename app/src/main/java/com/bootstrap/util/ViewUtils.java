package com.bootstrap.util;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;

import com.bootstrap.R;


/**
 * Created by Marcel Sanches on 10/11/2015.
 */
public class ViewUtils {

    public static void showKeyboard(final Context context, final View view) {
        getInputMethod(context).toggleSoftInputFromWindow(view.getApplicationWindowToken(), InputMethodManager.SHOW_IMPLICIT, 0);
    }

    public static void hideKeyboard(final Context context, final View view) {
        getInputMethod(context).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private static InputMethodManager getInputMethod(final Context context) {
        return (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    public static void shakeViewAnimation(final View view) {
        Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.shake);
        view.startAnimation(animation);
    }

    public static TransformationMethod getPasswordTransformationMethod() {
        return new CustomPasswordTransformationMethod();
    }

    public static class CustomPasswordTransformationMethod extends PasswordTransformationMethod {
        private char DOT = '\u2022';

        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return new PassCharSequence(source);
        }

        @Override
        public void onFocusChanged(View view, CharSequence sourceText, boolean focused, int direction, Rect previouslyFocusedRect) {

        }

        class PassCharSequence implements CharSequence {

            private final CharSequence charSequence;

            public PassCharSequence(final CharSequence charSequence) {
                this.charSequence = charSequence;
            }

            @Override
            public char charAt(final int index) {
                return DOT;
            }

            @Override
            public int length() {
                return charSequence.length();
            }

            @Override
            public CharSequence subSequence(final int start, final int end) {
                return new PassCharSequence(charSequence.subSequence(start, end));
            }
        }
    }


    public static void showCircularProgressbar(Context context, View view) {
        if (view != null) {
            View progress = view.findViewById(R.id.circular_progress_bar);
            progress.setAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_in));
            if (progress != null) {
                progress.setVisibility(View.VISIBLE);
            }
        }
    }


    public static void hideCircularProgressbar(Context context, View view) {
        if (view != null) {
            View progress = view.findViewById(R.id.circular_progress_bar);
            progress.setAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_out));
            if (progress != null) {
                progress.setVisibility(View.GONE);
            }
        }
    }


}
