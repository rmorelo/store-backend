package br.com.store.infrastructure.profiling.descriptor;

import org.perf4j.aop.Profiled;

public interface ProfilingDescriptor {

    boolean canDescribe(final Object parameter, final String methodName, final Profiled profiled);

    String describeShortLog(final Object object);

}
