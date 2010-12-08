package fr.unice.miage.xmlsearch.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import fr.unice.miage.xmlsearch.critere.Critere;

/**
 * @author Julien Lespagnard
 * @author Elodie Mazuel
 * @version 1.0
 */
public abstract class Utils {
	/**
	 * @param p_requete	la requ&ecirc;te &agrave; ex&eacute;cuter
	 * @return	le document DOM XML contenant le r&eacute; de la requ&ecirc;te <code>p_requete</code> 
	 */
	public static Document getResultatRequete(String p_requete) {
		try {
			URI uri = new URI(p_requete);
			URL url = uri.toURL();
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			return builder.parse(url.openStream());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param p_node	le node &agrave; lire
	 * @param p_infos	la liste contenant les informations lues dans le node si 
	 * 					celui-ci contient des &eacute;l&eacute;ment texte
	 */
	public static void lireXml(Node p_node, List<Map<String, String>> p_infos) {
		if(p_node.getNodeType() == Node.TEXT_NODE) {
			if(p_node.getTextContent() != null && !p_node.getTextContent().trim().isEmpty()) {
				Map<String, String> donnees;
				if(p_infos.isEmpty()) {
					donnees = new LinkedHashMap<String, String>();
					p_infos.add(donnees);
				}
				else {
					donnees = p_infos.get(p_infos.size()-1);
				}
				String nomParentNode = p_node.getParentNode().getNodeName();
				if(donnees.containsKey(nomParentNode)) {
					donnees = new LinkedHashMap<String, String>();
					p_infos.add(donnees);
				}
				donnees.put(nomParentNode.toLowerCase(), p_node.getTextContent());
			}
			
		}
		if(p_node.hasChildNodes()) {
			for(Node child = p_node.getFirstChild() ; child != null ; child = child.getNextSibling()) {
				Utils.lireXml(child, p_infos);
			}
		}
	}
	
	/**
	 * @param p_critere		les crit&egrave;res de recherches
	 * @param p_nomsParams	le nom des crit&egraveres de recherche &agrave; r&eacute;cup&eacute;rer
	 * @return	la requ&ecirc;te param&eacute;tr&eacute;e
	 */
	public static String getParams(Critere p_critere, String... p_nomsParams) {
		StringBuilder params = new StringBuilder();
		
		if(p_critere != null) {
			String[] valeurs;
			for (String nomParam : p_nomsParams) {
				valeurs = p_critere.get(nomParam);
				
				if(valeurs != null && valeurs.length > 0) {
					for (String valeur : valeurs) {
						params.append("&" + nomParam + "=" + valeur);
					}
				}
			}
			
			if(params.length() > 0) {
				params = params.delete(0, 1);
			}
		}
		
		return params.toString();
	}
}
