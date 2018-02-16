package com.alacriti.shespeaks.biz.delegate;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alacriti.shespeaks.log.impl.AppLogger;
import com.alacriti.shespeaks.util.LogUtil;
import com.google.api.services.people.v1.model.ContactGroup;
import com.google.api.services.people.v1.model.Name;
import com.google.api.services.people.v1.model.Person;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class GoogleAPIFTL {
	private static final AppLogger log = LogUtil.getLogger(GoogleAPIFTL.class);
	public String contactData(ContactGroup contactGroup,List<String> persons ){
		
		//Freemarker configuration object
		Configuration cfg = new Configuration();
		StringWriter str = new StringWriter();
		try {
			//Load template from source folder
			cfg.setDirectoryForTemplateLoading(new File("/home/kirtik/Desktop/check_once/shespeaks_pro/GooglePeopleApiDemo/HRMBE/src/main/webapp/"));
			Template template = cfg.getTemplate("data.ftl");
			
			GetDetailsOfGoogleUser delegate = new GetDetailsOfGoogleUser();
			// Build the data-model
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("Count", contactGroup);			
			data.put("Details", persons);			
			template.process(data, str);		
			
			// Console output
						Writer out = new OutputStreamWriter(System.out);
						template.process(data, out);
						out.flush();
						
						log.logInfo("Ftl String is: "+str.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return str.toString();
	}
}
