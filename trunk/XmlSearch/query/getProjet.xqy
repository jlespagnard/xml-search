let $annee := request:get-parameter("annee","2009")
let $anneeARechercher := concat('/db/Raweb/RA',$annee)
let $shortname := request:get-parameter("shortname","")
let $titre := request:get-parameter("titre","")
let $fullInfos := request:get-parameter("fullinfos","no")
let $theme := request:get-parameter("theme","")

let $infos :=
	for $projet in collection($anneeARechercher)/raweb/identification
	where $projet/shortname[contains(., $shortname)] and $projet/projectName[contains(.,$titre)] and ($projet/theme[contains(., $theme)] or $projet/theme-de-recherche[contains(., $theme)])
	return if(compare($fullInfos, 'yes') = 0)
	then <informations>{$projet/shortname}{$projet/projectName}{$projet/theme}{$projet/theme-de-recherche}{$projet/domaine}{$projet/ancestor::raweb/presentation}{$projet/ancestor::raweb/logiciels}{$projet/ancestor::raweb/resultat}{$projet/ancestor::raweb/contrats}</informations>
	else <informations>{$projet/shortname}{$projet/projectName}{$projet/theme}{$projet/theme-de-recherche}{$projet/presentation}</informations>
	
return <projet>{$infos}</projet>