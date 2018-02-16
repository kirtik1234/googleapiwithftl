package com.alacriti.shespeaks.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import com.alacriti.shespeaks.log.impl.AppLogger;
import com.alacriti.shespeaks.util.LogUtil;



@Provider
public class HRMResponseFilter implements ContainerResponseFilter {
	private static final AppLogger log = LogUtil.getLogger(HRMResponseFilter.class);

	public void filter(ContainerRequestContext requestContext,
			ContainerResponseContext responseContext) throws IOException {
		// TODO Auto-generated method stub
		responseContext.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
		responseContext.getHeaders().putSingle("Access-Control-Allow-Credentials", "true");
		responseContext.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");
		responseContext.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
		
		}
}
//add("Access-Control-Allow-Origin", "*");