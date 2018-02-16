package com.alacriti.shespeaks.resteasy.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.alacriti.shespeaks.resteasy.resource.ResourceForGOAuth;
import com.alacriti.shespeaks.resteasy.resource.UserResource;

public class ShespeaksApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> classes = new HashSet<Class<?>>();

	public ShespeaksApplication() {
		singletons.add(new ResourceForGOAuth());
		singletons.add(new UserResource());
		
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
