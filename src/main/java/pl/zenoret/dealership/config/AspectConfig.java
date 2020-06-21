package pl.zenoret.dealership.config;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {

  private final Logger logger = LoggerFactory.getLogger(AspectConfig.class);

  @Pointcut("execution(public * pl.zenoret.dealership.service.implementation..*(..))")
  public void publicMethodsInServices() {
  }

  @Before("publicMethodsInServices()")
  public void beforePublicMethods(JoinPoint joinPoint) {
    logger.info(String.format("Executing method: %s of service: %s", joinPoint.getSignature().getName(),
      joinPoint.getTarget().getClass().getName()));
    logger.info(String.format("Method parameters: %s",
      Arrays.stream(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining(", "))));
  }

  @AfterReturning(pointcut = "publicMethodsInServices()", returning = "result")
  public void afterReturningPublicMethods(JoinPoint joinPoint, Object result) {
    logger.info(String.format("Returning method: %s of service: %s", joinPoint.getSignature().getName(),
      joinPoint.getTarget().getClass().getName()));
    logger.info(String.format("with value: %s", result));
  }

  @AfterThrowing(pointcut = "publicMethodsInServices()", throwing = "e")
  public void afterThrowingPublicMethods(JoinPoint joinPoint, Exception e) {
    logger.error(String
      .format("An exception with message: %s has been thrown during execution of method: %s in service: %s",
        joinPoint.getSignature().getName(),
        joinPoint.getTarget().getClass().getName(), e.getMessage()));
  }
}
