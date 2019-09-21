
package com.android.settings.deviceinfo;

import android.os.SystemProperties;

public class VersionUtils {
    public static String getAtomVersion(){
        return SystemProperties.get("org.atom.version.display","");
    }
}
