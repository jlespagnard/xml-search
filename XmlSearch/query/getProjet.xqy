let $annee := request:get-parameter("annee","2009")
let $anneeARechercher := concat('/db/Raweb/RA',$annee)
let $shortname := request:get-parameter("shortname","")
let $fullInfos := request:get-parameter("fullinfos","no")
let $theme := request:get-parameter("theme","")

let $infos :=
	for $projet in collection($anneeARechercher)/raweb/identification
	where ($projet/shortname[contains(., $shortname)] or $projet/projectName[contains(.,$shortname)])and ($projet/theme[contains(., $theme)] or $projet/theme-de-recherche[contains(., $theme)])
	return if(compare($fullInfos, 'yes') = 0)
	then <informations>{$fullInfos}{$projet/shortname}{$projet/projectName}{$projet/theme}{$projet/domaine}{$projet/ancestor::raweb/presentation}{$projet/ancestor::raweb/logiciels}{$projet/ancestor::raweb/resultat}{$projet/ancestor::raweb/contrats}</informations>
	else <informations>{$projet/shortname}{$projet/projectName}{$projet/theme}{$projet/presentation}</informations>
	
return <projet>{$infos}</projet>