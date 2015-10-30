package br.com.store.backend.infrastructure.profiling.descriptor;

import org.perf4j.aop.Profiled;

import javax.ws.rs.core.Response;

/**
 * Descriptor de Profile para Response
 */
public class ResponseJaxrsProfilingDescriptor implements ProfilingDescriptor {

    public boolean canDescribe(Object parameter, String methodName, Profiled profiled) {
        return (parameter instanceof Response);
    }

    public String describeShortLog(Object parameter) {
        Response response = (Response) parameter;

        return "Response,status=" + response.getStatus() + ",reason=" + response.getStatusInfo().getReasonPhrase();

    }

}
