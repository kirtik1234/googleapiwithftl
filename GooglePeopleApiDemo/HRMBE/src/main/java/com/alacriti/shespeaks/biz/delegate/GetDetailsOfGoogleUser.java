package com.alacriti.shespeaks.biz.delegate;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.alacriti.shespeaks.constants.Constants;
import com.alacriti.shespeaks.log.impl.AppLogger;
import com.alacriti.shespeaks.model.vo.SampleVO;
import com.alacriti.shespeaks.util.LogUtil;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.people.v1.PeopleService;
import com.google.api.services.people.v1.model.ContactGroup;
import com.google.api.services.people.v1.model.ListConnectionsResponse;
import com.google.api.services.people.v1.model.Name;
import com.google.api.services.people.v1.model.Person;

public class GetDetailsOfGoogleUser extends BaseDelegate {
	private static final AppLogger log = LogUtil.getLogger(GetDetailsOfGoogleUser.class);

	public String getMessage(SampleVO sampleVO) throws FileNotFoundException, IOException {
		log.debugPrintCurrentMethodName();
		log.logInfo("In delegate");
		HttpTransport httpTransport = new NetHttpTransport();
		JacksonFactory jsonFactory = new JacksonFactory();
		String clientId = Constants.CLIENT_ID;
		String clientSecret = Constants.SECRET_KEY;
		String detailsOfPerson= null;
		
		try{
			// Step 2: Exchange -->
			GoogleTokenResponse tokenResponse = new GoogleAuthorizationCodeTokenRequest(httpTransport, jsonFactory,
				clientId, clientSecret, sampleVO.getCode(), Constants.LOCALHOST).execute();
			// End of Step 2 <--

			GoogleCredential credential = new GoogleCredential.Builder().setTransport(httpTransport)
				.setJsonFactory(jsonFactory).setClientSecrets(clientId, clientSecret).build()
				.setFromTokenResponse(tokenResponse);

			PeopleService peopleService = new PeopleService.Builder(httpTransport, jsonFactory, credential).build();
		
		
		
			/*log.logInfo("<<<<<<<<<<<<<<<<<<<<<------ListContactGroupsResponse START----->>>>>>>>>>>>>>>>>>>>>>>>");
			ListContactGroupsResponse response = peopleService.contactGroups().list().execute();
			List<ContactGroup> connections = response.getContactGroups();
			for (ContactGroup person : connections) {
				log.logInfo("ContactGroup:::" + person);
			}
			log.logInfo("<<<<<<<<<<<<<<<<<<<<<------ListContactGroupsResponse END----->>>>>>>>>>>>>>>>>>>>>>>>");*/
		
		
		
			log.logInfo("<<<<<<<<<<<<<<<<<<<<<------ContactGroup All START----->>>>>>>>>>>>>>>>>>>>>>>>");
			ContactGroup contactGroup = peopleService.contactGroups().get("contactGroups/all").execute();
			log.logInfo("All contactGroups MemberCount:::: " + contactGroup.getMemberCount());
			log.logInfo("<<<<<<<<<<<<<<<<<<<<<------ContactGroup All END----->>>>>>>>>>>>>>>>>>>>>>>>");
		
		
		/*
			log.logInfo("<<<<<<<<<<<<<<<<<<<<<------ContactGroup Friends START----->>>>>>>>>>>>>>>>>>>>>>>>");
			ContactGroup contactGroup1 = peopleService.contactGroups().get("contactGroups/friends").execute();
			log.logInfo(" Friends contactGroups MemberCount:::: " + contactGroup1.getMemberCount());
			log.logInfo("<<<<<<<<<<<<<<<<<<<<<------ContactGroup Friends END----->>>>>>>>>>>>>>>>>>>>>>>>");		
		*/
		
		
			log.logInfo("<<<<<<<<<<<<<<<<<<<<<------ListConnections START----->>>>>>>>>>>>>>>>>>>>>>>>");
			ListConnectionsResponse connectionsResponse = peopleService.people().connections().list("people/me")
				.setPersonFields("names,emailAddresses").execute();
			List<Person> persons = connectionsResponse.getConnections();
			List<String> names = new ArrayList<String>();
			int i=0;
			for(Person prcns : persons){
				log.logInfo("Name:::" + prcns.getNames());
				if(prcns.getNames()!=null){
					i++;
					log.logInfo("count is: "+i);
					names.add(prcns.getNames().get(0).getDisplayName());
					names.add(prcns.getNames().get(0).getDisplayNameLastFirst());
				}
			}
//			for (Person person : persons) {
//				log.logInfo("Name:::" + person.getNames());
//			}
			log.logInfo("<<<<<<<<<<<<<<<<<<<<<------ListConnections END----->>>>>>>>>>>>>>>>>>>>>>>>");
		
			GoogleAPIFTL processftl = new GoogleAPIFTL();
			detailsOfPerson = processftl.contactData(contactGroup, names);
		}
		catch(Exception e){
			log.logInfo(e.getMessage());
		}
		return detailsOfPerson;
	}

}
