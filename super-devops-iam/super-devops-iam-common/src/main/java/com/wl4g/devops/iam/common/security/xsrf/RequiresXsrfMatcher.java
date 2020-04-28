/*
 * Copyright 2017 ~ 2025 the original author or authors. <wanglsir@gmail.com, 983708408@qq.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wl4g.devops.iam.common.security.xsrf;

import static java.util.Arrays.asList;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpMethod;

import static org.springframework.http.HttpMethod.*;

/**
 * {@link RequiresXsrfMatcher}
 *
 * @author Wangl.sir <wanglsir@gmail.com, 983708408@qq.com>
 * @version v1.0 2020年4月27日
 * @since
 */
final class RequiresXsrfMatcher implements XsrfMatcher {

	/**
	 * Allowed http methods.
	 */
	private final Set<HttpMethod> allowedMethods = new HashSet<>(asList(GET, HEAD, TRACE, OPTIONS));

	/**
	 * Matches is xsrf request.
	 * 
	 * @param request
	 * @return
	 */
	public boolean matches(HttpServletRequest request) {
		return !this.allowedMethods.contains(valueOf(request.getMethod()));
	}

}