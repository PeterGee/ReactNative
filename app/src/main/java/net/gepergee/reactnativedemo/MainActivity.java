package net.gepergee.reactnativedemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import com.facebook.react.ReactActivity;


public class MainActivity extends ReactActivity {
    private int OVERLAY_PERMISSION_REQ_CODE = 0x001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
            }
        }
    }

    @Override
    protected String getMainComponentName() {
        return "ReactNativeDemo";
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Settings.canDrawOverlays(this)) {
                    // SYSTEM_ALERT_WINDOW permission not granted...
                }
            }
        }
    }
}
