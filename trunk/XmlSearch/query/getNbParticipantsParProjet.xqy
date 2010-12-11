let $anneeDebut := request:get-parameter("anneeDebut",2006)
let $anneeFin := request:get-parameter("anneeFin",2009)
let $shortname := request:get-parameter("shortname","")

let $infos :=
	for $anneeCourrante in ($anneeDebut to $anneeFin)
		let $collection := concat('/db/Raweb/RA',$anneeCourrante)
			for $projet in collection($collection)/raweb/identification/shortname[contains(., $shortname)]
			return if($anneeCourrante=2006 or $anneeCourrante=2007)
			then <participants><annee>{$anneeCourrante}</annee> <nbparticipants> {(count($projet/ancestor::raweb/identification/team/participants/person))}</nbparticipants></participants>
			else <participants><annee>{$anneeCourrante}</annee> <nbparticipants>{(count($projet/ancestor::raweb/team/person))}</nbparticipants></participants>

return <participants_root>{$infos}</participants_root>