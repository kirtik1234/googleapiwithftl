package com.alacriti.shespeaks.resteasy.resource;
import org.apache.log4j.*;
import com.alacriti.shespeaks.log.impl.AppLogger;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.alacriti.shespeaks.biz.delegate.GetDetailsOfGoogleUser;
import com.alacriti.shespeaks.model.vo.SampleVO;
@Path("/message")
public class ResourceForGOAuth {

	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.TEXT_XML)
	public Response sampleResourceGet(@PathParam("param") String msg) {

		//SampleDelegate delegate = new SampleDelegate();
		
		System.out.println("msg:::: "+msg);
		
		//String result = "<RestfulExample><H1>" + msg + "</H1></RestfulExample>";

			
		return Response.status(200).entity(msg).build();

	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response sampleResourcePost(SampleVO sampleVO) throws FileNotFoundException, IOException {
		//Logger.getLogger("sampleVO::: "+sampleVO);
		System.out.println("sampleVO::: "+sampleVO);
		
		GetDetailsOfGoogleUser delegate = new GetDetailsOfGoogleUser();
		String getdetails = delegate.getMessage(sampleVO);
		
		return Response.status(200).entity(getdetails).build();

	}
}
