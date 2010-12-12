let $annee := request:get-parameter("annee",2006)
let $shortname := request:get-parameter("shortname","")
let $collection := concat('/db/Raweb/RA',$annee)

let $postes2007and2008 :=
	for $project in collection($collection)/raweb/identification[contains(shortname, $shortname)]
		for $postes in distinct-values($project/team/participants/person/categoryPro)
			let $count := $project/team/participants/person/categoryPro[contains(.,$postes)]
			return <repartition><categorypro>{$postes}</categorypro><nbPersonnes>{count($count)}</nbPersonnes></repartition>

let $postes2009andMore :=
	for $project2 in collection($collection)/raweb/identification[contains(shortname, $shortname)]
		for $postes in distinct-values($project2/ancestor::raweb/team/person/categoryPro)
			let $count2 := $project2/ancestor::raweb/team/person/categoryPro[contains(.,$postes)]
			return <repartition><categorypro>{$postes}</categorypro><nbPersonnes>{count($count2)}</nbPersonnes></repartition>
		
return <repartition_root>{$postes2007and2008}{$postes2009andMore}</repartition_root>