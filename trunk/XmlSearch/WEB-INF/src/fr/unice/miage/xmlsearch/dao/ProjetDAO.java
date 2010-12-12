package fr.unice.miage.xmlsearch.dao;

import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fr.unice.miage.xmlsearch.critere.Critere;
import fr.unice.miage.xmlsearch.critere.ProjetCritere;
import fr.unice.miage.xmlsearch.objets.Participant;
import fr.unice.miage.xmlsearch.objets.Projet;
import fr.unice.miage.xmlsearch.utils.Constantes;
import fr.unice.miage.xmlsearch.utils.Utils;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public class ProjetDAO extends DAO {
	
	/**
	 * @param p_contexte application context
	 */
	public ProjetDAO(String p_contexte) {
		super(p_contexte);
	}
	
	/**
	 * @param p_critere	search criteria
	 * @param fullInfos	<code>true</code> if all the project information should be recovered else <code>false</code>
	 * @return	the list of projects found
	 */
	public List<Projet> rechercherProjet(Critere p_critere, boolean p_fullInfos) {
		List<Projet> projets = null;
		
		Document doc = this.executerQueryRechercheProjet(p_critere);
		if(doc != null) {
			String annee = p_critere.get(Constantes.Projet.ANNEE.getLabel())[0];
			projets = new LinkedList<Projet>();
			Projet projet;
			NodeList nodeInformations = doc.getElementsByTagName("informations");
			Element elemInformations = null, elemShortName = null, elemProjectName = null, elemTheme = null, elemPresentation = null, elemLogiciels = null, elemResultats = null, elemContrats = null;
			for(int i=0;i<nodeInformations.getLength();i++) {
				elemInformations = (Element)nodeInformations.item(i);
				elemShortName = (Element)elemInformations.getElementsByTagName(Constantes.Projet.SHORT_NAME.getLabel()).item(0);
				elemProjectName = (Element)elemInformations.getElementsByTagName(Constantes.Projet.PROJECT_NAME.getLabel()).item(0);
				if(elemInformations.getElementsByTagName(Constantes.Projet.THEME.getLabel()).getLength() == 0) {
					elemTheme = (Element)elemInformations.getElementsByTagName(Constantes.Projet.THEME_DE_RECHERCHE.getLabel()).item(0);
				}
				else {
					elemTheme = (Element)elemInformations.getElementsByTagName(Constantes.Projet.THEME.getLabel()).item(0);
				}
				if(p_fullInfos) {
					this.removeParticipantsNode(elemInformations);
					elemPresentation = (Element)elemInformations.getElementsByTagName(Constantes.Projet.PRESENTATION.getLabel()).item(0);
					elemLogiciels = (Element)elemInformations.getElementsByTagName(Constantes.Projet.LOGICIELS.getLabel()).item(0);
					elemResultats = (Element)elemInformations.getElementsByTagName(Constantes.Projet.RESULTATS.getLabel()).item(0);
					elemContrats = (Element)elemInformations.getElementsByTagName(Constantes.Projet.CONTRATS.getLabel()).item(0);
					
					projet = new Projet(this.getTextContent(elemShortName), this.getTextContent(elemProjectName), this.getTextContent(elemTheme), annee, this.getTextContent(elemPresentation), this.getTextContent(elemLogiciels), this.getTextContent(elemResultats), this.getTextContent(elemContrats));
				}
				else {
					projet = new Projet(this.getTextContent(elemShortName), this.getTextContent(elemProjectName), this.getTextContent(elemTheme), annee, null, null, null, null);
				}
				projets.add(projet);
			}
		}
		
		return projets;
	}
	
	/**
	 * remove the participant node
	 * @param p_elementNode elementnode
	 */
	private void removeParticipantsNode(Element p_elementNode) {
		for(int i=0;i<p_elementNode.getChildNodes().getLength();i++) {
			Node child = p_elementNode.getChildNodes().item(i);
			if(child.getNodeType() == Node.ELEMENT_NODE) {
				if(child.getNodeName().equalsIgnoreCase(Constantes.Projet.PARTICIPANTS.getLabel())) {
					p_elementNode.removeChild(child);
				}
				if(child.hasChildNodes()) {
					this.removeParticipantsNode((Element)child);
				}
			}
		}
	}
	
	/**
	 * @param p_elementNode elementnode
	 * @return text of the element
	 */
	private String getTextContent(Element p_elementNode) {
		String textContent = "";
		DOMSource domSource = new DOMSource(p_elementNode);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		TransformerFactory tf = TransformerFactory.newInstance();
		try {
			Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "html");
			transformer.transform(domSource, result);
			textContent = writer.toString();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
//		textContent = textContent.replace("\n", "<br />");
		textContent = textContent.replaceAll("<" + Constantes.Projet.SHORT_NAME.getLabel() + ">", "");
		textContent = textContent.replaceAll("</" + Constantes.Projet.SHORT_NAME.getLabel() + ">", "");
		textContent = textContent.replaceAll("<" + Constantes.Projet.PROJECT_NAME.getLabel() + ">", "");
		textContent = textContent.replaceAll("</" + Constantes.Projet.PROJECT_NAME.getLabel() + ">", "");
		textContent = textContent.replaceAll("<" + Constantes.Projet.THEME.getLabel() + ">", "");
		textContent = textContent.replaceAll("</" + Constantes.Projet.THEME.getLabel() + ">", "");
		textContent = textContent.replaceAll("<" + Constantes.Projet.THEME_DE_RECHERCHE.getLabel() + ">", "");
		textContent = textContent.replaceAll("</" + Constantes.Projet.THEME_DE_RECHERCHE.getLabel() + ">", "");
		textContent = textContent.replaceAll("<" + Constantes.Projet.PRESENTATION.getLabel() + ">", "");
		textContent = textContent.replaceAll("</" + Constantes.Projet.PRESENTATION.getLabel() + ">", "");
		textContent = textContent.replaceAll("<" + Constantes.Projet.LOGICIELS.getLabel() + ">", "");
		textContent = textContent.replaceAll("</" + Constantes.Projet.LOGICIELS.getLabel() + ">", "");
		textContent = textContent.replaceAll("<" + Constantes.Projet.RESULTATS.getLabel() + ">", "");
		textContent = textContent.replaceAll("</" + Constantes.Projet.RESULTATS.getLabel() + ">", "");
		textContent = textContent.replaceAll("<" + Constantes.Projet.CONTRATS.getLabel() + ">", "");
		textContent = textContent.replaceAll("</" + Constantes.Projet.CONTRATS.getLabel() + ">", "");
		
		textContent = textContent.replaceAll("<" + Constantes.Participant.FISRTNAME.getLabel() + ">", "");
		textContent = textContent.replaceAll("</" + Constantes.Participant.FISRTNAME.getLabel() + ">", "");
		textContent = textContent.replaceAll("<" + Constantes.Participant.LASTNAME.getLabel() + ">", "");
		textContent = textContent.replaceAll("</" + Constantes.Participant.LASTNAME.getLabel() + ">", "");
		textContent = textContent.replaceAll("<" + Constantes.Participant.AFFILIATION.getLabel() + ">", "");
		textContent = textContent.replaceAll("</" + Constantes.Participant.AFFILIATION.getLabel() + ">", "");
		textContent = textContent.replaceAll("<" + Constantes.Participant.CATEGORYPRO.getLabel() + ">", "");
		textContent = textContent.replaceAll("</" + Constantes.Participant.CATEGORYPRO.getLabel() + ">", "");
		textContent = textContent.replaceAll("<" + Constantes.Participant.RESEARCHCENTRE.getLabel() + ">", "");
		textContent = textContent.replaceAll("</" + Constantes.Participant.RESEARCHCENTRE.getLabel() + ">", "");
		textContent = textContent.replaceAll("<" + Constantes.Participant.MOREINFO.getLabel() + ">", "");
		textContent = textContent.replaceAll("</" + Constantes.Participant.MOREINFO.getLabel() + ">", "");
		textContent = textContent.replaceAll("<" + Constantes.Participant.HDR.getLabel() + ">", "");
		textContent = textContent.replaceAll("</" + Constantes.Participant.HDR.getLabel() + ">", "");
		
		return textContent.trim();
	}
	
	/**
	 * retrieves the document from the query search project
	 * @param p_critere criterion
	 * @return document containing the response XML
	 */
	private Document executerQueryRechercheProjet(Critere p_critere) {
		String query = this.getContexte() + "getProjet.xqy";
		
		String params = Utils.getParams(p_critere, Constantes.Projet.SHORT_NAME.getLabel(), 
				Constantes.Projet.PROJECT_NAME.getLabel(), Constantes.Projet.ANNEE.getLabel(), 
				Constantes.Projet.THEME.getLabel(), Constantes.Projet.FULL_INFOS.getLabel());
		if(!params.isEmpty()) {
			query += "?" + params;
		}
		
		return Utils.getResultatRequete(query);
		
	}
	
	/**
	 * @param p_shortName the short name of the project to recover
	 * @param p_annee year project to recover
	 * @return	project whose short name is <code>p_shortName</code>
	 */
	public Projet getProjet(String p_shortName, String p_annee) {
		ProjetCritere critere = new ProjetCritere(new String[]{p_shortName}, null, null, new String[]{p_annee}, true);
		List<Projet> projets = rechercherProjet(critere, true);
		
		return (projets == null || projets.isEmpty()) ? null : projets.get(0);
	}

	/**
	 * @param p_shortName	Project ID
	 * @param p_annee		the project year
	 * @return	the list of project participants with the identifier <code>p_shortName</code>
	 */
	public List<Participant> getParticipantsProjet(String p_shortName, String p_annee) {
		
		List<Participant> participants = null;
		
		String query = this.getContexte() + "getParticipantProjet.xqy";
		ProjetCritere critere = new ProjetCritere(new String[]{p_shortName}, null, null, new String[]{p_annee}, false);
		String params = Utils.getParams(critere, Constantes.Projet.SHORT_NAME.getLabel(), 
				Constantes.Projet.PROJECT_NAME.getLabel(), Constantes.Projet.ANNEE.getLabel(), 
				Constantes.Projet.THEME.getLabel(), Constantes.Projet.FULL_INFOS.getLabel());
		if(!params.isEmpty()) {
			query += "?" + params;
		}
		
		Document doc = Utils.getResultatRequete(query);
		if(doc != null) {
			participants = new LinkedList<Participant>();
			Participant participant;
			NodeList nodePerson = doc.getElementsByTagName("person");			
			Element elemPerson = null, elemfirstname = null, elemlastname = null, elemaffiliation = null, elemcategoryPro = null, elemresearchcentre = null, elemmoreinfo = null, elemhdr = null;
			
			for(int i=0;i<nodePerson.getLength();i++) {
				elemPerson = (Element)nodePerson.item(i);
				elemfirstname = (Element)elemPerson.getElementsByTagName(Constantes.Participant.FISRTNAME.getLabel()).item(0);
				elemlastname = (Element)elemPerson.getElementsByTagName(Constantes.Participant.LASTNAME.getLabel()).item(0);
				elemaffiliation = (Element)elemPerson.getElementsByTagName(Constantes.Participant.AFFILIATION.getLabel()).item(0);
				elemcategoryPro = (Element)elemPerson.getElementsByTagName("categoryPro").item(0);
				elemresearchcentre = (Element)elemPerson.getElementsByTagName(Constantes.Participant.RESEARCHCENTRE.getLabel()).item(0);
				elemmoreinfo = (Element)elemPerson.getElementsByTagName(Constantes.Participant.MOREINFO.getLabel()).item(0);
				elemhdr = (Element)elemPerson.getElementsByTagName(Constantes.Participant.HDR.getLabel()).item(0);
				
				String firstname = this.getTextContent(elemfirstname);
				String lastname = this.getTextContent(elemlastname);
				String affiliation = this.getTextContent(elemaffiliation);
				String categoryPro = this.getTextContent(elemcategoryPro);
				String researchCentre = this.getTextContent(elemresearchcentre);
				String moreInfo = this.getTextContent(elemmoreinfo);
				String hdr = this.getTextContent(elemhdr);	
				
				participant = new Participant(firstname, lastname, affiliation, categoryPro, researchCentre, moreInfo, hdr);
				participants.add(participant);
			}
		}
		
		return participants;
	}

	/**
	 * @param shortname the project shortname
	 * @return list for each year the number of participants
	 */
	public Map<String, String> getNbParticipantsParProjet(String shortname) {
		
		Map<String, String> retour = null;
		
		ProjetCritere critere = new ProjetCritere(new String[]{shortname}, null, null, null, false);
		
		List<Map<String, String>> results = super.getResultatsRequete("getNbParticipantsParProjet.xqy", 
				critere, Constantes.Projet.SHORT_NAME.getLabel());
		
		if(results != null && !results.isEmpty()) {
			retour = new LinkedHashMap<String, String>();
			String annee = null, nbrPart = null;
			for (Map<String, String> result : results) {
				for(String key : result.keySet()) {
					if(annee == null) {
						annee = result.get(key);
					}
					else if(nbrPart == null) {
						nbrPart = result.get(key);
					}
					if(annee != null && nbrPart != null) {
						retour.put(annee, nbrPart);
						annee = null;
						nbrPart = null;
					}
				}
			}
		}
		
		return retour;
	}
	
	/**
	 * number of people for each category for a project and one year
	 * @param p_shortName project shortname
	 * @param p_annee year
	 * @return list of number of people for each category
	 */
	public Map<String, String> getRepartitionCategories(String p_shortName, String p_annee) {
		Map<String, String> retour = null;
		
		ProjetCritere critere = new ProjetCritere(new String[]{p_shortName}, null, null, new String[]{p_annee}, false);
		List<Map<String, String>> results = super.getResultatsRequete("getRepartitionCategories.xqy", 
				critere, Constantes.Projet.SHORT_NAME.getLabel(), Constantes.Projet.ANNEE.getLabel());
		
		if(results != null && !results.isEmpty()) {
			retour = new LinkedHashMap<String, String>();
			String categorie = null, nbPersonnes = null;
			for (Map<String, String> result : results) {
				for(String key : result.keySet()) {
					if(categorie == null) {
						categorie = result.get(key);
					}
					else if(nbPersonnes == null) {
						nbPersonnes = result.get(key);
					}
					if(categorie != null && nbPersonnes != null) {
						retour.put(categorie, nbPersonnes);
						categorie = null;
						nbPersonnes = null;
					}
				}
			}
		}
		
		return retour;
	}
}