package com.alacriti.shespeaks.resteasy.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.alacriti.shespeaks.biz.delegate.UserDelegate;
import com.alacriti.shespeaks.log.impl.AppLogger;
import com.alacriti.shespeaks.model.vo.UserRoleVO;
import com.alacriti.shespeaks.util.LogUtil;


@Path("/user")
public class UserResource {
	private static final AppLogger log = LogUtil.getLogger(UserResource.class);
	@POST
	@Path("/addUserRole")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUserRole(UserRoleVO userRoleVO) {
		log.logDebug("userRoleVO.RoleName********"+userRoleVO.getRoleName());
		UserDelegate userDelegate= new UserDelegate();
		userDelegate.createUserRole(userRoleVO);
		return Response.status(200).entity(userRoleVO).build();

	}
	
	
	@GET
	@Path("/getUserRole/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUserRole(@PathParam("param") int RoleId) {
		UserRoleVO userVO= new UserRoleVO();
		userVO.setRoleTypeId(RoleId);
		log.logDebug("Roleid***********"+userVO.getRoleTypeId());
		UserDelegate userDelegate= new UserDelegate();
		userDelegate.getUserRole(userVO);
		
		return Response.status(200).entity(userVO).build();

	}
}