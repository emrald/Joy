package com.example.abc.joy23final;

import android.view.ScaleGestureDetector;

/**
 * Created by TI A1 on 20-05-2017.
 */
public class OnPinchListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

    float startingSpan;
    float endSpan;
    float startFocusX;
    float startFocusY;
    ZoomableRelativeLayout mZoomableRelativeLayout;


    public boolean onScaleBegin(ScaleGestureDetector detector) {
        startingSpan = detector.getCurrentSpan();
        startFocusX = detector.getFocusX();
        startFocusY = detector.getFocusY();
        return true;
    }


    public boolean onScale(ScaleGestureDetector detector) {
        mZoomableRelativeLayout.scale(detector.getCurrentSpan()/startingSpan, startFocusX, startFocusY);
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector detector) {
        mZoomableRelativeLayout.restore();
    }
}
