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
package io.micronaut.coherence;

import javax.inject.Inject;

import com.oracle.coherence.inject.Name;

import com.tangosol.net.Cluster;
import com.tangosol.net.Coherence;
import com.tangosol.net.Session;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@MicronautTest(propertySources = "classpath:sessions.yaml")
class CoherenceFactoryTest {

    @Inject
    Coherence coherence;

    @Inject
    Session defaultSession;

    @Inject
    @Name("test")
    Session testSession;

    @Inject
    Cluster cluster;

    @Test
    void shouldInjectCoherence() {
        assertThat(coherence, is(notNullValue()));
    }

    @Test
    public void shouldInjectSessions() {
        assertThat(defaultSession, is(notNullValue()));
        assertThat(defaultSession.getScopeName(), is(Coherence.DEFAULT_SCOPE));

        assertThat(testSession, is(notNullValue()));
        assertThat(testSession.getScopeName(), is("Test"));
    }

    @Test
    void shouldInjectCluster() {
        assertThat(cluster, is(notNullValue()));
        assertThat(cluster.getLocalMember().getClusterName(), is("test-cluster"));
        assertThat(cluster.getLocalMember().getRoleName(), is("test"));
    }
}