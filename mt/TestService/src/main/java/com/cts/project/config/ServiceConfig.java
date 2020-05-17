package com.cts.project.config;



	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.cloud.context.config.annotation.RefreshScope;
	import org.springframework.stereotype.Component;

	@Component
	@RefreshScope
	public class ServiceConfig {

		@Value("${authUsername1}")
		private String authUsername1;
		
		@Value("${authPassword1}")
		private String authPassword1;
	
		public String getUsername1() {
			return authUsername1;
		}

		public String getPassword1() {
			return authPassword1;
		}
		
		@Value("${authUsername}")
		private String authUsername;
		
		@Value("${authPassword}")
		private String authPassword;
		

		public String getAuthUsername() {
			return authUsername;
		}

		public String getAuthPassword() {
			return authPassword;
		}

		
	}


