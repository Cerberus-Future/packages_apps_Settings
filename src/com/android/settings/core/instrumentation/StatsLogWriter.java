/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.core.instrumentation;

import android.app.settings.SettingsEnums;
import android.content.Context;
import android.util.Pair;
import android.util.StatsLog;

import com.android.settingslib.core.instrumentation.LogWriter;

public class StatsLogWriter implements LogWriter {

    @Override
    public void visible(Context context, int attribution, int pageId) {
        StatsLog.write(StatsLog.SETTINGS_UI_CHANGED /* Cerberus name */,
                attribution,
                SettingsEnums.PAGE_VISIBLE /* action */,
                pageId,
                null /* changedPreferenceKey */,
                0 /* changedPreferenceIntValue */);
    }

    @Override
    public void hidden(Context context, int pageId) {
        StatsLog.write(StatsLog.SETTINGS_UI_CHANGED /* Cerberus name */,
                SettingsEnums.PAGE_UNKNOWN /* attribution */,
                SettingsEnums.PAGE_HIDE /* action */,
                pageId,
                null /* changedPreferenceKey */,
                0 /* changedPreferenceIntValue */);
    }

    @Override
    public void action(Context context, int action, Pair<Integer, Object>... taggedData) {
        action(SettingsEnums.PAGE_UNKNOWN /* attribution */,
                action,
                SettingsEnums.PAGE_UNKNOWN /* pageId */,
                null /* changedPreferenceKey */,
                0 /* changedPreferenceIntValue */);
    }

    @Override
    public void action(Context context, int action, int value) {
        action(SettingsEnums.PAGE_UNKNOWN /* attribution */,
                action,
                SettingsEnums.PAGE_UNKNOWN /* pageId */,
                null /* changedPreferenceKey */,
                value /* changedPreferenceIntValue */);
    }

    @Override
    public void action(Context context, int action, boolean value) {
        action(SettingsEnums.PAGE_UNKNOWN /* attribution */,
                action,
                SettingsEnums.PAGE_UNKNOWN /* pageId */,
                null /* changedPreferenceKey */,
                value ? 1 : 0 /* changedPreferenceIntValue */);
    }

    @Override
    public void action(Context context, int action, String pkg) {
        action(SettingsEnums.PAGE_UNKNOWN /* attribution */,
                action,
                SettingsEnums.PAGE_UNKNOWN /* pageId */,
                pkg /* changedPreferenceKey */,
                1 /* changedPreferenceIntValue */);
    }

    @Override
    public void action(int attribution, int action, int pageId, String key, int value) {
        StatsLog.write(StatsLog.SETTINGS_UI_CHANGED /* cerberusName */,
                attribution,
                action,
                pageId,
                key,
                value);
    }
}
