let $centre := request:get-parameter("idCR","")

let $idAdresse :=
	for $recherche in collection('/db/Raweb/Bastri')/AdresseGeographique_root/AdresseGeographique/idCR[contains(.,$centre)]
	return $recherche/ancestor::AdresseGeographique/idAdresseGeographique/node()
	
let $membres :=
	for $recherchetwo in collection('/db/Raweb/Bastri')/EntiteINRIA_root/EntiteINRIA/idAdresseGeographique[contains(.,$idAdresse)]
		for $recherchetres in collection('/db/Raweb/Bastri')/Personne_root/Personne/idPersonne[contains(.,$recherchetwo/ancestor::EntiteINRIA/idPersonne/node())]
		return <personne>{$recherchetres/ancestor::Personne/nom}{$recherchetres/ancestor::Personne/prenom}{$recherchetres/ancestor::Personne/dateNaissance}</personne>
		
return <membres>{$membres}</membres>