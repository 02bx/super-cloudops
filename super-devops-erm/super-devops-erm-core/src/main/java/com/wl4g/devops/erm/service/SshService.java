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
package com.wl4g.devops.erm.service;

import com.wl4g.devops.common.bean.erm.Ssh;
import com.wl4g.devops.page.PageModel;

import java.util.List;

/**
 * @author vjay
 */
public interface SshService {

	PageModel page(PageModel pm, String name);

	List<Ssh> getForSelect();

	void save(Ssh ssh);

	Ssh detail(Integer id);

	void del(Integer id);

	void testSSHConnect(Integer hostId, String sshUser, String sshKey, Integer sshId) throws Exception, InterruptedException;
}