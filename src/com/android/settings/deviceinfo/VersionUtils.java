
package com.android.settings.deviceinfo;

import android.os.SystemProperties;

public class VersionUtils {
    public static String getCerberusVersion(){
        return SystemProperties.get("org.cerberus.version.display","");
    }
}
