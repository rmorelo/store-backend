package br.com.store.infrastructure.profiling.descriptor;

import org.perf4j.aop.Profiled;

/**
 * Descriptor de Profile para Boolean
 */
public class BooleanProfilingDescriptor implements ProfilingDescriptor {

    public boolean canDescribe(Object parameter, String methodName, Profiled profiled) {
        return (parameter instanceof Boolean);
    }

    public String describeShortLog(Object parameter) {
        return parameter.toString();
    }

}
