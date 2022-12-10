package net.konohana.sakuya.hiiragi.controller

import net.konohana.sakuya.hiiragi.constant.OperatingKilometerConst
import net.konohana.sakuya.hiiragi.proto.HiiragiOperatingKilo
import net.konohana.sakuya.hiiragi.proto.HiiragiRWOperatingKiloServiceGrpcKt
import org.lognet.springboot.grpc.GRpcService

@GRpcService
class HiiragiOperatingKiloController
    : HiiragiRWOperatingKiloServiceGrpcKt.HiiragiRWOperatingKiloServiceCoroutineImplBase() {

    /**
     * 営業キロ取得
     */
    override suspend fun getHiiragiOperatingKilo(
        request: HiiragiOperatingKilo.GetHiiragiOperatingKiloRequest
    ): HiiragiOperatingKilo.GetHiiragiOperatingKiloResponse {
        return HiiragiOperatingKilo
            .GetHiiragiOperatingKiloResponse
            .newBuilder()
            .setHiiragiOperatingKilo(getHiiragiOperatingKilometer(request.hiiragiRWStaCode))
            .build()
    }

    /**
     * 営業キロを返却する
     */
    private fun getHiiragiOperatingKilometer(hiiragiRWStaCode: String) = when (hiiragiRWStaCode) {
        "RW0101" -> OperatingKilometerConst.OPERATING_KIRO_RW0101
        else -> "該当なし"
    }
}
