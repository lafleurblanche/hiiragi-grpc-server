package net.konohana.sakuya.hiiragi.config

import io.grpc.ServerBuilder
import io.grpc.protobuf.services.ProtoReflectionService
import org.lognet.springboot.grpc.GRpcServerBuilderConfigurer
import org.springframework.stereotype.Component

@Component
class GrpcBuildConfig : GRpcServerBuilderConfigurer() {
    override fun configure(serverBuilder: ServerBuilder<*>) {
        serverBuilder.addService(ProtoReflectionService.newInstance())
    }
}
