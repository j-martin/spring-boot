/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.context.embedded;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Tests for {@link ServletListenerRegistrationBean}.
 * 
 * @author Dave Syer
 */
public class ServletListenerRegistrationBeanTests {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private ServletContextListener listener = Mockito.mock(ServletContextListener.class);

	@Mock
	private ServletContext servletContext;

	@Before
	public void setupMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void startupWithDefaults() throws Exception {
		ServletListenerRegistrationBean<ServletContextListener> bean = new ServletListenerRegistrationBean<ServletContextListener>(
				this.listener);
		bean.onStartup(this.servletContext);
		verify(this.servletContext).addListener(this.listener);
	}

}