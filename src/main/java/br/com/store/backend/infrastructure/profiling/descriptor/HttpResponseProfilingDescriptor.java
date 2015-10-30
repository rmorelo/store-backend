package br.com.store.backend.infrastructure.profiling.descriptor;

import org.apache.http.HttpResponse;
import org.perf4j.aop.Profiled;

/**
 * Descriptor de Profile para URI
 */
public class HttpResponseProfilingDescriptor implements ProfilingDescriptor {

    public boolean canDescribe(Object parameter, String methodName, Profiled profiled) {
        return (parameter instanceof HttpResponse);
    }

    public String describeShortLog(Object parameter) {
        HttpResponse response = (HttpResponse) parameter;

        return "HttpResponse,status=" + response.getStatusLine().getStatusCode();

    }

}
