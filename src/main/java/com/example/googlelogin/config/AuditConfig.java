package com.example.googlelogin.config;

import com.example.googlelogin.constant.CommonConstant;
import com.example.googlelogin.model.CustomUserDetail;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Optional;
import java.util.UUID;

@Configuration
@EnableJpaAuditing
@EnableTransactionManagement
@Slf4j
public class AuditConfig implements AuditorAware<UUID> {
    @Override
    @NonNull
    public Optional<UUID> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetail defaultUserDetail) {
            return Optional.ofNullable(defaultUserDetail.getUser().getUsername() != null ? defaultUserDetail.getUser().getUserId() : null);
        }
        String userId = null;
        try {
            userId = MDC.get(CommonConstant.USERID);
            if (userId != null && !userId.isBlank() && !userId.equals(CommonConstant.SYSTEM)) {
                return Optional.of(UUID.fromString(userId));
            }
        } catch (Exception e) {
            log.info("Error when get Auditor: UserId " + userId + " from MDC " + e.getClass().getSimpleName() + " " + e.getMessage());
//            log.push(LogType.TRACING, "Error when get Auditor: UserId " + userId + " from MDC " + e.getClass().getSimpleName() + " " + e.getMessage());
        }
        return Optional.empty();
    }
}
