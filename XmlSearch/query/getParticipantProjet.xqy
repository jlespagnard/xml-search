let $annee := request:get-parameter("annee","2009")
let $anneeARechercher := concat('/db/Raweb/RA',$annee)
let $shortname := request:get-parameter("shortname","")

let $infos :=
	for $projet in collection($anneeARechercher)/raweb/identification
	where $projet/shortname[contains(., $shortname)]
	return if($annee="2006" or $annee="2007")
	then $projet/ancestor::raweb/identification/team
	else $projet/ancestor::raweb/team
		
return <participants>{$infos}</participants>
