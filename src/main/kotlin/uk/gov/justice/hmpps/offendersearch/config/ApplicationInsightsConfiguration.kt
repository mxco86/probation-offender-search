package uk.gov.justice.hmpps.offendersearch.config

import com.microsoft.applicationinsights.TelemetryClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.context.annotation.Conditional
import org.springframework.context.annotation.Configuration
import org.springframework.core.type.AnnotatedTypeMetadata

/**
 * Application insights now controlled by the spring-boot-starter dependency.  However when the key is not specified
 * we don't get a telemetry bean and application won't start.  Therefore need this backup configuration.
 */
@Configuration
class ApplicationInsightsConfiguration {
  @Bean
  @Conditional(AppInsightKeyAbsentCondition::class)
  fun telemetryClient(): TelemetryClient {
    return TelemetryClient()
  }

  class AppInsightKeyAbsentCondition : Condition {
    override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
      val telemetryKey = context.environment.getProperty("appinsights.instrumentationkey")
      return telemetryKey.isNullOrBlank()
    }
  }
}
