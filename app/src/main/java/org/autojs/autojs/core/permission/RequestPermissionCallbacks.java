package org.autojs.autojs.core.permission;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class RequestPermissionCallbacks {

    private final List<OnRequestPermissionsResultCallback> mCallbacks = new ArrayList<>();

    public void addCallback(OnRequestPermissionsResultCallback callback) {
        mCallbacks.add(callback);
    }

    public boolean removeCallback(OnRequestPermissionsResultCallback callback) {
        return mCallbacks.remove(callback);
    }

    public boolean onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (mCallbacks.isEmpty()) {
            return false;
        }
        for (OnRequestPermissionsResultCallback callback : mCallbacks) {
            callback.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
        return true;
    }
}
