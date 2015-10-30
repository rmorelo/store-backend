package br.com.store.backend.infrastructure.profiling.descriptor;

import java.util.Map;

import org.perf4j.aop.Profiled;

/**
 * Descriptor de Profile para Map
 */
public class MapProfilingDescriptor implements ProfilingDescriptor {

  public MapProfilingDescriptor() {}

  public boolean canDescribe(Object parameter, String methodName, Profiled profiled) {
    if (parameter instanceof Map) {
      return true;
    }
    return false;
  }

  @SuppressWarnings("rawtypes")
public String describeShortLog(Object parameter) {

    Map map = (Map) parameter;

    String result = parameter.getClass().getSimpleName();
    result += appendSize(map.size());

    return result;
  }


  private String appendSize(Number size) {
    return "(" + size + ")";
  }
}
