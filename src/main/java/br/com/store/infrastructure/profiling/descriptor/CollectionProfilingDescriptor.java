package br.com.store.infrastructure.profiling.descriptor;

import java.util.Collection;

import org.perf4j.aop.Profiled;

/**
 * Descriptor de Profile para Collections
 */
public class CollectionProfilingDescriptor implements ProfilingDescriptor {

    public boolean canDescribe(Object parameter, String methodName, Profiled profiled) {
        if (parameter instanceof Collection || parameter.getClass().isArray()) {
            return true;
        }
        return false;
    }

    public String describeShortLog(Object parameter) {

        String result;

        if (parameter.getClass().isArray()) {
            result = parameter.getClass().getSimpleName();

            Object[] list = (Object[]) parameter;
            result += appendSize(list.length);
        } else {
            result = parameter.getClass().getSimpleName();
            Collection<?> list = (Collection<?>) parameter;
            result += appendSize(list.size());
        }

        return result;
    }

    private String appendSize(Number size) {
        return "(" + size + ")";
    }
}
