package br.com.store.backend.infrastructure.profiling;

import java.util.LinkedList;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.perf4j.aop.AbstractJoinPoint;
import org.perf4j.aop.AgnosticTimingAspect;
import org.perf4j.aop.Profiled;
import org.perf4j.log4j.Log4JStopWatch;

import br.com.store.backend.infrastructure.exception.CustomRuntimeException;
import br.com.store.backend.infrastructure.profiling.descriptor.ProfilingDescriptor;
import br.com.store.backend.infrastructure.tracking.Tracker;

public class Profiling extends AgnosticTimingAspect {

    public static final String ENDPOINT = "endpoint";
    public static final String APPLICATION = "application";
    public static final String SERVICE = "service";
    public static final String REPOSITORY = "repository";

    private LinkedList<ProfilingDescriptor> descriptors = new LinkedList<>();

    public LinkedList<ProfilingDescriptor> getDescriptors() {
        return descriptors;
    }

    public Object doPerfLogging(final ProceedingJoinPoint pjp, final Profiled profiled) throws Throwable {

        final String methodName = pjp.getSignature().toShortString();

        final boolean enabled = isEnabled(methodName, profiled);

        if (enabled) {
            return runProfiledMethod(newJoinPoint(pjp, methodName), profiled, newStopWatch(profiled.logger(), profiled.level()));
        } else {
            return pjp.proceed();
        }
    }

    protected AbstractJoinPoint newJoinPoint(final ProceedingJoinPoint pjp, final String method) {

        return new AbstractJoinPoint() {

            public Object proceed() throws Throwable {
                return pjp.proceed();
            }

            public Object getExecutingObject() {
                return pjp.getThis();
            }

            public Object[] getParameters() {
                return pjp.getArgs();
            }

            public String getMethodName() {
                return method;
            }
        };
    }

    protected Log4JStopWatch newStopWatch(final String loggerName, final String levelName) {
        Level level = Level.toLevel(levelName, Level.INFO);
        return new Log4JStopWatch(Logger.getLogger(loggerName), level, level);
    }

    /**
     * Liga/desliga o profiling. Esse método deve ser sobrescrito por cada
     * implementação, para que cada sistema possa definir suas próprias
     * políticas de liga/desliga. O valor padrão é desligado.
     */
    public boolean isEnabled(final String name, final Profiled profiled) {
        return true;
    }

    /**
     * Adiciona um descriptor a lista.
     */
    public void addDescriptor(ProfilingDescriptor descriptor) {
        descriptors.add(descriptor);
    }

    /**
     * Cria mensagem que será logada.
     */
    @Override
    protected String getStopWatchMessage(Profiled profiled, AbstractJoinPoint joinPoint, Object result, Throwable exception) {

        StringBuilder message = new StringBuilder();

        String layer = profiled.level();
        message.append("LAYER=");
        message.append(layer);
        message.append(",");

        if (result != null) {
            message.append("RESULT=");
            message.append(sanitize(describe(result, joinPoint.getMethodName(), profiled)));
        } else {
            message.append("RESULT=null");
        }

        if (joinPoint.getParameters() != null) {
            message.append(",");

            for (int i = 0; i < joinPoint.getParameters().length; i++) {

                Object parameter = joinPoint.getParameters()[i];
                message.append("PARAM");
                message.append(i);
                message.append("=");
                message.append(sanitize(describe(parameter, joinPoint.getMethodName(), profiled)));

                if (i < joinPoint.getParameters().length - 1) {
                    message.append(",");
                }
            }
        }

        String tracker = Tracker.getString(Tracker.REQUEST);
        message.append(",REQUEST=");
        message.append(tracker);

        if (profiled.level().equals("endpoint")) {

            String validation = Tracker.getString(Tracker.VALIDATION_VERSION);
            message.append(",VALIDATION=");
            message.append(validation);

            String ip = Tracker.getString(Tracker.IP);
            message.append(",IP=");
            message.append(ip);
        }

        if (exception != null) {
            message.append(",EXCEPTION=");
            message.append(exception.getClass().getSimpleName());
            message.append(",MSG=");
            message.append(exception.getMessage());

            if (exception instanceof CustomRuntimeException) {
                message.append(",CODE=");
                CustomRuntimeException exc = (CustomRuntimeException) exception;
                message.append(exc.getCode());
            }

        }

        return message.toString();
    }

    /**
     * Formata o parametro para a exibição.
     */
    protected String describe(final Object parameter, final String methodName, final Profiled profiled) {

        if (parameter == null) {
            return "<null>";
        }

        for (ProfilingDescriptor descriptor : descriptors) {
            if (descriptor != null && descriptor.canDescribe(parameter, methodName, profiled)) {
                return descriptor.describeShortLog(parameter);
            }
        }

        return parameter.getClass().getSimpleName();
    }

    /**
     * Sanitiza a string, removendo caracteres inválidos. É necessário para
     * efetuar o parser do log corretamente no KeyValueLayout.
     */
    protected String sanitize(String str) {
        if (str != null) {
            return str.replaceAll("\\[", "{").replaceAll("\\]", "}");
        }
        return null;
    }
}
