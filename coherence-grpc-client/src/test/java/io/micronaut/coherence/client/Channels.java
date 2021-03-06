/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.coherence.client;

import javax.inject.Named;
import javax.inject.Singleton;

import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.micronaut.context.annotation.Factory;

@Factory
public class Channels {
    /**
     * Create the default {@link Channel} bean.
     *
     * @return the default {@link Channel} bean
     */
    @Singleton
    @Named("default")
    public Channel defaultChannel() {
        return ManagedChannelBuilder.forAddress("127.0.0.1", 1408)
                .usePlaintext()
                .build();
    }
}
