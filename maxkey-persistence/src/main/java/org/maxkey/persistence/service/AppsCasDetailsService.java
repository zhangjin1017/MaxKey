/*
 * Copyright [2020] [MaxKey of copyright http://www.maxkey.top]
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
 

package org.maxkey.persistence.service;

import java.util.concurrent.TimeUnit;

import org.apache.mybatis.jpa.persistence.JpaBaseService;
import org.maxkey.entity.apps.AppsCasDetails;
import org.maxkey.persistence.mapper.AppsCasDetailsMapper;
import org.springframework.stereotype.Repository;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

@Repository
public class AppsCasDetailsService  extends JpaBaseService<AppsCasDetails>{

	protected final static  Cache<String, AppsCasDetails> detailsCache =
            Caffeine.newBuilder()
                .expireAfterWrite(30, TimeUnit.MINUTES)
                .maximumSize(200000)
                .build();

	public AppsCasDetailsService() {
		super(AppsCasDetailsMapper.class);
	}

	/* (non-Javadoc)
	 * @see com.connsec.db.service.BaseService#getMapper()
	 */
	@Override
	public AppsCasDetailsMapper getMapper() {
		return (AppsCasDetailsMapper)super.getMapper();
	}

	public  AppsCasDetails  getAppDetails(String id , boolean cached) {
		AppsCasDetails details = null;
		if(cached) {
			details = detailsCache.getIfPresent(id);
			System.out.println("detailsCache1 " + details);
			if(details == null) {
				details = getMapper().getAppDetails(id);
				System.out.println("getAppDetails2 " + details);
				if(details != null) {
					detailsCache.put(id, details);
				}
			}
		}else {
			details = getMapper().getAppDetails(id);
			System.out.println("getAppDetails3 " + details);
		}
		return details;
	}
}
