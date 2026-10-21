/*
 * Copyright (C) 2026 piko <https://github.com/crimera/piko>
 *
 * See the included NOTICE file for GPLv3 §7(b) terms that apply to this code.
 */

package app.crimera.patches.instagram.misc.distractionFree

import app.crimera.patches.instagram.misc.hookFlags.hookFlagsPatch
import app.crimera.patches.instagram.misc.settings.settingsPatch
import app.crimera.patches.instagram.utils.Constants.COMPATIBILITY_INSTAGRAM
import app.crimera.patches.instagram.utils.addFlags
import app.morphe.patcher.patch.bytecodePatch

@Suppress("unused")
val hideMetaAiPatch =
    bytecodePatch(
        name = "Hide Meta AI",
        description = "Hides Meta AI in the reels overflow menu, the reels description pills and search suggestions.",
        default = true,
    ) {
        compatibleWith(COMPATIBILITY_INSTAGRAM)
        dependsOn(settingsPatch, hookFlagsPatch)
        execute {
            addFlags("metaAiFlags")
        }
    }
