/**
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
package org.apache.camel.component.undertow.springboot;

import org.apache.camel.component.undertow.UndertowHttpBinding;
import org.apache.camel.util.jsse.SSLContextParameters;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * The undertow component provides HTTP-based endpoints for consuming and
 * producing HTTP requests.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@ConfigurationProperties(prefix = "camel.component.undertow")
public class UndertowComponentConfiguration {

    /**
     * To use a custom HttpBinding to control the mapping between Camel message
     * and HttpClient.
     */
    @NestedConfigurationProperty
    private UndertowHttpBinding undertowHttpBinding;
    /**
     * To configure security using SSLContextParameters
     */
    @NestedConfigurationProperty
    private SSLContextParameters sslContextParameters;
    /**
     * Whether the component should resolve property placeholders on itself when
     * starting. Only properties which are of String type can use property
     * placeholders.
     */
    private Boolean resolvePropertyPlaceholders = true;

    public UndertowHttpBinding getUndertowHttpBinding() {
        return undertowHttpBinding;
    }

    public void setUndertowHttpBinding(UndertowHttpBinding undertowHttpBinding) {
        this.undertowHttpBinding = undertowHttpBinding;
    }

    public SSLContextParameters getSslContextParameters() {
        return sslContextParameters;
    }

    public void setSslContextParameters(
            SSLContextParameters sslContextParameters) {
        this.sslContextParameters = sslContextParameters;
    }

    public Boolean getResolvePropertyPlaceholders() {
        return resolvePropertyPlaceholders;
    }

    public void setResolvePropertyPlaceholders(
            Boolean resolvePropertyPlaceholders) {
        this.resolvePropertyPlaceholders = resolvePropertyPlaceholders;
    }
}