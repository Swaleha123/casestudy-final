package com.cts.project.config;



	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.cloud.context.config.annotation.RefreshScope;
	import org.springframework.stereotype.Component;

	@Component
	@RefreshScope
	public class ServiceConfig {

		@Value("${authUsername}")
		private String Username;
		
		@Value("${authPassword}")
		private String Password;
		

		public String getUsername() {
			return Username;
		}

		public String getPassword() {
			return Password;
		}

		
	}


