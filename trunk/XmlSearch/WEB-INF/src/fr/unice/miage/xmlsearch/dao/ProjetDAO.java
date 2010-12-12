package fr.unice.miage.xmlsearch.dao;

import java.util.LinkedHashMap;
import java.io.StringWriter;
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
import fr.unice.miage.xmlsearch.critere.ParticipantCritere;
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
	 * Constructeur
	 * @param p_contexte contexte
	 */
	public ProjetDAO(String p_contexte) {
		super(p_contexte);
	}
	
	/**
	 * @param p_critere	les crit&egrave;res de recherche
	 * @param fullInfos	<code>true</code> si la totalit&eacute; des informations d'un projet
	 * 					doit &ecirc;tre r&eacute;cup&eacute;e, <code>false</code> sinon
	 * @return	la liste des projets trouv&eacute;s
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
		
		return textContent.trim();
	}
	
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
	 * @param p_shortName	le short name du projet &agrave; r&eacute;cup&eacute;rer
	 * @param p_annee	l'ann&eacute;e du projet &agrave; r&eacute;cup&eacute;rer
	 * @return	le projet dont le short name correspond &agrave; <code>p_shortName</code>
	 */
	public Projet getProjet(String p_shortName, String p_annee) {
		ProjetCritere critere = new ProjetCritere(new String[]{p_shortName}, null, null, new String[]{p_annee}, true);
		List<Projet> projets = rechercherProjet(critere, true);
		
		return (projets == null || projets.isEmpty()) ? null : projets.get(0);
	}

	/**
	 * @param p_shortName	l'identifiant du projet
	 * @param p_annee		l'ann&eacute;e du projet
	 * @return	la liste des participants au projet ayant pour identifiant <code>p_shortName</code>
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
			String annee = critere.get(Constantes.Projet.ANNEE.getLabel())[0];
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
				
				int longueur = 0;
				longueur = Constantes.Participant.FISRTNAME.getLabel().length() + 2;
				String firstname = this.getTextContent(elemfirstname);
				if(firstname.length() > 0)
					firstname = firstname.substring(longueur, firstname.length()-longueur-1);
				longueur = Constantes.Participant.LASTNAME.getLabel().length() + 2;
				String lastname = this.getTextContent(elemlastname);
				if(lastname.length() > 0)
					lastname = lastname.substring(longueur, lastname.length()-longueur-1);
				longueur = Constantes.Participant.AFFILIATION.getLabel().length() + 2;
				String affiliation = this.getTextContent(elemaffiliation);
				if(affiliation.length() > 0)
					affiliation = affiliation.substring(longueur, affiliation.length()-longueur-1);
				longueur = Constantes.Participant.CATEGORYPRO.getLabel().length() + 2;
				String categoryPro = this.getTextContent(elemcategoryPro);
				if(categoryPro.length() > 0)
					categoryPro = categoryPro.substring(longueur, categoryPro.length()-longueur-1);
				longueur = Constantes.Participant.RESEARCHCENTRE.getLabel().length() + 2;
				String researchCentre = this.getTextContent(elemresearchcentre);
				if(researchCentre.length() > 0)
					researchCentre = researchCentre.substring(longueur, researchCentre.length()-longueur-1);
				longueur = Constantes.Participant.MOREINFO.getLabel().length() + 2;
				String moreInfo = this.getTextContent(elemmoreinfo);
				if(moreInfo.length() > 0)
					moreInfo = moreInfo.substring(longueur, moreInfo.length()-longueur-1);
				longueur = Constantes.Participant.HDR.getLabel().length() + 2;
				String hdr = this.getTextContent(elemhdr);	
				if(hdr.length() > 0)
					hdr = hdr.substring(longueur, hdr.length()-longueur-1);
				
				participant = new Participant(firstname, lastname, affiliation, categoryPro, researchCentre, moreInfo, hdr);
				participants.add(participant);
			}
		}
		
		return participants;
	}
}