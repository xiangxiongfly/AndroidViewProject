package com.example.app;

import android.view.MotionEvent;

public class Utils {
    public static String getEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return "down";
            case MotionEvent.ACTION_MOVE:
                return "move";
            case MotionEvent.ACTION_UP:
                return "up";
            case MotionEvent.ACTION_CANCEL:
                return "cancel";
        }
        return "";
    }

}
