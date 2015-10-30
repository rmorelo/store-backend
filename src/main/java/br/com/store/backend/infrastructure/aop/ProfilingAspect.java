package br.com.store.backend.infrastructure.aop;

import br.com.store.backend.infrastructure.profiling.Profiling;
import br.com.store.backend.infrastructure.profiling.descriptor.BooleanProfilingDescriptor;
import br.com.store.backend.infrastructure.profiling.descriptor.CollectionProfilingDescriptor;
import br.com.store.backend.infrastructure.profiling.descriptor.HttpResponseProfilingDescriptor;
import br.com.store.backend.infrastructure.profiling.descriptor.MapProfilingDescriptor;
import br.com.store.backend.infrastructure.profiling.descriptor.NumberProfilingDescriptor;
import br.com.store.backend.infrastructure.profiling.descriptor.ResponseJaxrsProfilingDescriptor;
import br.com.store.backend.infrastructure.profiling.descriptor.StringProfilingDescriptor;
import br.com.store.backend.infrastructure.profiling.descriptor.URIProfilingDescriptor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.perf4j.aop.Profiled;

/**
* Classe responsavél pelo log de Timing da aplicação.
*
* Cada tipo de objeto pode ser descrito no Splunk de acordo com {@link br.com.store.frontend.infrastructure.profiling.descriptor.ProfilingDescriptor} implementado
*/
@Aspect
public class ProfilingAspect extends Profiling {

    public ProfilingAspect() {
        super();

        super.addDescriptor(new CollectionProfilingDescriptor());
        super.addDescriptor(new MapProfilingDescriptor());
        super.addDescriptor(new NumberProfilingDescriptor());
        super.addDescriptor(new StringProfilingDescriptor());
        super.addDescriptor(new BooleanProfilingDescriptor());
        super.addDescriptor(new ResponseJaxrsProfilingDescriptor());
        super.addDescriptor(new URIProfilingDescriptor());
        super.addDescriptor(new HttpResponseProfilingDescriptor());        
    }

    @Around(value = "execution(* *(..)) && @annotation(profiled)", argNames = "pjp,profiled")
    public Object doPerfLogging(final ProceedingJoinPoint pjp, final Profiled profiled)
        throws Throwable {
        return super.doPerfLogging(pjp, profiled);
    }

    @Override
    public boolean isEnabled(String name, Profiled profiled) {
        return true;
    }
}
