/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.impl;

import org.apache.camel.CamelContainer;
import org.apache.camel.Endpoint;
import org.apache.camel.EndpointResolver;
import org.apache.camel.util.FactoryFinder;
import org.apache.camel.util.ObjectHelper;

/**
 * A default implementation of {@link org.apache.camel.EndpointResolver}
 *
 * @version $Revision$
 */
public class DefaultEndpointResolver<E> implements EndpointResolver<E> {
    static final private FactoryFinder endpointResolverFactory = new FactoryFinder("META-INF/services/org/apache/camel/EndpointResolver/");
    
    public Endpoint<E> resolve(CamelContainer container, String uri) {
    	String splitURI[] = ObjectHelper.splitOnCharacter(uri, ":");
    	if( splitURI == null )
    		throw new IllegalArgumentException("Invalid URI, it did not contain a scheme: "+uri);
    	EndpointResolver resolver;
		try {
			resolver = (EndpointResolver) endpointResolverFactory.newInstance(splitURI[0]);
		} catch (Throwable e) {
			throw new IllegalArgumentException("Invalid URI, no EndpointResolver registered for scheme : "+splitURI[0], e);
		}

		return resolver.resolve(container, uri);
		
		// EndpointResolvers could be more recusive in nature if we resolved the reset of the of the URI 
		//return resolver.resolve(container, splitURI[1]);
    }

}
