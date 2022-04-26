package com.alzohar.session.traciking.config;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

public class HttpSessionConfig extends AbstractHttpSessionApplicationInitializer {

	@Bean
	public MapSessionRepository mapSessionRepository() {
		return new MapSessionRepository(new ConcurrentHashMap<>());
	}

	@Bean
	public CookieSerializer cookieSerializer() {
		DefaultCookieSerializer serializer = new DefaultCookieSerializer();
		serializer.setUseBase64Encoding(true);
		serializer.setCookieName("_sessionapp_key");
		serializer.setCookiePath("/");
		serializer.setCookieMaxAge(10 * 60); // 10 Minute
		serializer.setUseHttpOnlyCookie(true);
		serializer.setUseSecureCookie(false);
		return serializer;
	}
}