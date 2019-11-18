package hello;

import com.foresee.platform.logging.audit.AuditLoggerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventBusConfigure {

    @Bean
    public AuditLoggerService getAuditLoggerService() {
        return auditableEvent -> {
            // do nothing
        };
    }
}
