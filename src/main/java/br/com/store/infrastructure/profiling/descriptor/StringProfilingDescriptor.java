package br.com.store.infrastructure.profiling.descriptor;

import org.perf4j.aop.Profiled;

/**
 * Descriptor de Profile para Collections
 */
public class StringProfilingDescriptor implements ProfilingDescriptor {

    public boolean canDescribe(Object parameter, String methodName, Profiled profiled) {
        if (parameter instanceof String) {
            return true;
        }
        return false;
    }

    public String describeShortLog(Object parameter) {

        String result;

        result = parameter.toString();


        return result;
    }


}
