/*
 * Copyright (C) 2017 The MoKee Open Source Project
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

package com.cyanogenmod.settings.device;

import android.content.Context;

import org.mokee.internal.util.FileUtils;

class ButtonUtils {

    private static final int KEY_MASK_BACK = 0x02;
    private static final int KEY_MASK_APP_SWITCH = 0x10;

    static boolean isSliderSupported() {
        return FileUtils.fileExists(ButtonConstants.SLIDER_STATE_NODE);
    }

    static boolean isHardwareKeysSupported(Context context) {
        final int activeHardwareKeys = context.getResources().getInteger(
                com.android.internal.R.integer.config_deviceHardwareKeys);

        final boolean hasBack = (activeHardwareKeys & KEY_MASK_BACK) != 0;
        final boolean hasAppSwitch = (activeHardwareKeys & KEY_MASK_APP_SWITCH) != 0;

        return hasBack && hasAppSwitch;
    }

}
