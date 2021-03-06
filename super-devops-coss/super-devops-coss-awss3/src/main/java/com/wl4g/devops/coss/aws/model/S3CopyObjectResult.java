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
package com.wl4g.devops.coss.aws.model;

import java.util.Date;

import com.wl4g.devops.coss.model.CopyObjectResult;

public class S3CopyObjectResult extends CopyObjectResult {

	/** The time this object expires, or null if it has no expiration */
	private Date expirationTime;

	/** The expiration rule for this object */
	private String expirationTimeRuleId;

	/**
	 * Indicate if the requester is charged for conducting this operation from
	 * Requester Pays Buckets.
	 */
	private boolean isRequesterCharged;

	public Date getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}

	public String getExpirationTimeRuleId() {
		return expirationTimeRuleId;
	}

	public void setExpirationTimeRuleId(String expirationTimeRuleId) {
		this.expirationTimeRuleId = expirationTimeRuleId;
	}

	public boolean isRequesterCharged() {
		return isRequesterCharged;
	}

	public void setRequesterCharged(boolean isRequesterCharged) {
		this.isRequesterCharged = isRequesterCharged;
	}

}
