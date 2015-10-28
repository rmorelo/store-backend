package br.com.store.infrastructure.profiling.descriptor;

import org.perf4j.aop.Profiled;

import java.net.URI;

/**
 * Descriptor de Profile para URI
 */
public class URIProfilingDescriptor implements ProfilingDescriptor {

    public boolean canDescribe(Object parameter, String methodName, Profiled profiled) {
        return (parameter instanceof URI);
    }

    public String describeShortLog(Object parameter) {
        URI uri = (URI) parameter;

        return "URI,host=" + uri.getHost() + ",path=" + uri.getPath();

    }

}
