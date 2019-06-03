/*
 * Copyright 2015 the original author or authors.
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
package com.wl4g.devops.scm.client.configure.watch;

import java.io.IOException;

import org.springframework.scheduling.annotation.Scheduled;

import com.wl4g.devops.scm.client.configure.refresh.ScmContextRefresher;

/**
 * Timing refresh watcher
 * 
 * @author Wangl.sir <983708408@qq.com>
 * @version v1.0 2019年5月1日
 * @since
 */
public class TimingRefreshWatcher extends AbstractRefreshWatcher implements Runnable {

	public TimingRefreshWatcher(ScmContextRefresher refresher) {
		super(refresher);
	}

	@Override
	protected void doStart() {
		//
		// Ignore operation.
		//
	}

	@Override
	@Scheduled(initialDelayString = "${spring.cloud.devops.scm.client.watch.init-delay:120000}", fixedDelayString = "${devops.config.watch.delay:10000}")
	public void run() {
		if (log.isInfoEnabled()) {
			log.info("Synchronizing refresh from configuration center ...");
		}

		if (running.get()) {
			try {
				super.doExecute(this, null, "Task watch event.");
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	@Override
	public void close() throws IOException {
		//
		// Ignore operation.
		//
	}

}