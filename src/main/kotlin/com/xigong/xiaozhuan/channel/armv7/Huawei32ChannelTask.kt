package com.xigong.xiaozhuan.channel.armv7

import com.xigong.xiaozhuan.channel.VersionParams
import com.xigong.xiaozhuan.channel.huawei.HuaweiChannelTask
import com.xigong.xiaozhuan.util.ApkInfo
import java.io.File
import kotlin.math.roundToInt

class Huawei32ChannelTask : HuaweiChannelTask() {

    override val channelName: String = "华为32"

    override val fileNameIdentify: String = "HUAWEI32"

    override suspend fun performUpload(
        file: File,
        apkInfo: ApkInfo,
        versionParams: VersionParams,
        progress: (Int) -> Unit
    ) {
        connectClient.uploadApk(file, apkInfo, clientId, clientSecret, versionParams, false) {
            progress((it * 100).roundToInt())
        }
    }
}