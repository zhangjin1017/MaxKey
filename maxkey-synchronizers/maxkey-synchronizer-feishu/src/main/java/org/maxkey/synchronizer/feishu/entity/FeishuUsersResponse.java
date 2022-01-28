/*
 * Copyright [2022] [MaxKey of copyright http://www.maxkey.top]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 

package org.maxkey.synchronizer.feishu.entity;

import org.maxkey.synchronizer.entity.ResponseData;

public class FeishuUsersResponse  extends ResponseData{

	FeishuUsersData data;

	public FeishuUsersResponse() {
		super();
	}

	public FeishuUsersData getData() {
		return data;
	}

	public void setData(FeishuUsersData data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FeishuUsersResponse [data=");
		builder.append(data);
		builder.append("]");
		return builder.toString();
	}


	
}