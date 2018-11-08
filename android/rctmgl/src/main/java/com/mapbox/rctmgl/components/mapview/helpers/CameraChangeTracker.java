package com.mapbox.rctmgl.components.mapview.helpers;

/**
 * Created by nickitaliano on 12/12/17.
 */

public class CameraChangeTracker {
    public static final int USER_GESTURE = 1; // defined in SDK as REASON_API_GESTURE
    public static final int USER_ANIMATION = 2; // defined in SDK as REASON_DEVELOPER_ANIMATION
    public static final int SDK = 3; // defined in SDK as REASON_API_ANIMATION
    public static final int EMPTY = -1;

    private int reason;
    private boolean isRegionChangeAnimated;
    private boolean regionChangeInProgress; // between WILL and DID change

    public void setReason(int reason) {
        this.reason = reason;
    }

    public void setRegionChangeAnimated(boolean isRegionChangeAnimated) {
        this.isRegionChangeAnimated = isRegionChangeAnimated;
    }

    public void setRegionChangeInProgress(boolean inProgress) {
        regionChangeInProgress = inProgress;
    }

    public boolean isUserInteraction() {
        return reason == USER_GESTURE || reason == USER_ANIMATION;
    }

    public boolean isAnimated() {
        return isRegionChangeAnimated;
    }

    public boolean isEmpty() {
        return reason == EMPTY;
    }

    public boolean isRegionChangeInProgress() {
        return regionChangeInProgress;
    }

    public void reset() {
        reason = EMPTY;
        isRegionChangeAnimated = false;
    }
}
