package br.com.store.backend.domain;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.modelmapper.ModelMapper;

/**
 * Common mapping methods.
 */
public abstract class AbstractServiceMapper {

	/**
	 * Get ModelMapper.
	 * @return modelMapper
	 */
	protected abstract ModelMapper getModelMapper();
	
	/**
	 * Map input bean to a new output bean.
	 * @param input Input bean
	 * @param outputClass Output bean class
	 * @return New output bean
	 */
	protected <I, O> O map(I input, Class<O> outputClass) {
		return getModelMapper().map(input, outputClass);
	}

	/**
	 * Map input bean to an existing output bean.
	 * @param input Input bean
	 * @param output Output bean
	 */
	protected <I, O> void map(I input, O output) {
		getModelMapper().map(input, output);
	}
		
	/**
	 * Map input beans to new output beans.
	 * @param inputs Input beans
	 * @param outputClass Output beans class
	 * @return New output beans
	 */
	protected <I, O> List<O> map(Collection<I> inputs, Class<O> outputClass) {
		List<O> outputs = new ArrayList<O>();
		for(I input : inputs) {
			O output = map(input, outputClass);
			outputs.add(output);
		}
		return outputs;
	}

	/**
	 * Map input beans to existing output beans.
	 * @param inputs Input beans
	 * @param outputs Output beans
	 * @param outputClass Output beans class
	 */
	protected <I, O> void map(Collection<I> inputs, Collection<O> outputs, Class<O> outputClass) {
		for(I input : inputs) {
			O output = map(input, outputClass);
			outputs.add(output);
		}
	}
	
}
