package org.door2door.filters;

import com.google.common.net.HttpHeaders;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.util.Arrays;

@Provider
public class CorsFilter implements ContainerRequestFilter, ContainerResponseFilter {
	private static final String[] ORIGIN_WHITELIST = { "http://localhost:5000" };

	@Override
	public void filter(ContainerRequestContext reqContext) {
		// noop
	}
	@Override
	public void filter(ContainerRequestContext reqContext,
					   ContainerResponseContext resContext) {
		String origin = reqContext.getHeaderString(HttpHeaders.ORIGIN);
		if (Arrays.stream(ORIGIN_WHITELIST).anyMatch(name -> name.equals(origin))) {
			resContext.getHeaders().add("Access-Control-Allow-Origin", origin);
		} else if(origin != null) {
			//todo replace once logger added
			System.out.println("Illegal CORs request from origin [" + origin + "]");
		}
		resContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
		resContext.getHeaders().add("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, PATCH, DELETE");
		resContext.getHeaders().add("Access-Control-Max-Age", "3600");
		resContext.getHeaders().add("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, X-Requested-With, Authorization, remember-me, auth-bearer");

	}
}
