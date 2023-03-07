package io.github.fierg.server

import io.github.fierg.resources.PuzzleResource
import io.quarkus.scheduler.Scheduled
import org.jboss.logging.Logger
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class CronServer {

        private val log: Logger = Logger.getLogger(PuzzleResource::class.java)

        @Scheduled(cron = "{cron.expr}")
        fun cronJobWithExpressionInConfig() {
            log.info("Expecting new MQTT Message soon...")
        }
}