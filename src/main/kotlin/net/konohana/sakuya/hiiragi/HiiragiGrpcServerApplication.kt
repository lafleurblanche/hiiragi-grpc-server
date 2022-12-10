package net.konohana.sakuya.hiiragi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HiiragiGrpcServerApplication

fun main(args: Array<String>) {
    runApplication<HiiragiGrpcServerApplication>(*args)
}
