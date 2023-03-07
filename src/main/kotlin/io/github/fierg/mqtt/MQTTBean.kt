package io.github.fierg.mqtt

import io.github.fierg.resources.ExampleResource
import org.eclipse.microprofile.reactive.messaging.Incoming
import org.jboss.logging.Logger
import javax.enterprise.context.ApplicationScoped


@ApplicationScoped
class MQTTBean {

    private val log: Logger = Logger.getLogger(ExampleResource::class.java)

    @Incoming("Zahlenraetsel")
    fun receiveMQTT(byteArray: ByteArray){
        log.info("Received ${String(byteArray)}")
    }
}