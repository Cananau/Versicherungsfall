package org.camunda.versicherung;

import java.io.IOException;

import javax.mail.MessagingException;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


public class AngebotSenden implements JavaDelegate {

	
	public static void angebotzukunde(String subject, String content, String email, String wordDocPath, String docuentName) throws MessagingException, IOException {
		EmailKonfigurationen.sendMail(subject, content, email, wordDocPath, docuentName);
	}

	public void execute(DelegateExecution execution) throws Exception {
		
		  String email = (String) execution.getVariable("KundenEmail");
		  String kundeName = (String) execution.getVariable("KundenName");
		  String kundeVorname = (String) execution.getVariable("KundenVorname");
		  String subject = "Ihre Anfrage bei der Loop GmbH";
		  String content = ("\nGuten Tag liebe "+kundeVorname+" "+kundeName+ ","
				  			+"\n\nwir freuen uns Ihnen nach ausf�hrlicher Pr�fung ein Angebot unterbreiten zu k�nnen."
							+"\nDieses ist als Anhang beigef�gt. Gerne k�nnen Sie an diese Email-Adresse R�ckfragen stellen oder das Angebot best�tigen."
				  			+"\n\nLiebe Gr��e"
				  			+"\nLoop GmbH");	
		  String pdfDocPath = (String) execution.getVariable("pdfDocPath");
		  String docuentName = (String) execution.getVariable("docuentName");

		  angebotzukunde(subject, content, email, pdfDocPath, docuentName);
	}
}
