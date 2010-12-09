<centres>
{
for $adresse in document("/db/Raweb/Bastri/AdresseGeographique.xml")//AdresseGeographique_root/AdresseGeographique

let $latitude := $adresse/latitude/node()
let $longitude := $adresse/longitude/node()
let $libelle:= $adresse/libelle/node()

return <centre> <idCR> {$adresse/idCR/node()} </idCR> <libelle> {$libelle} </libelle> <latitude> {$latitude} </latitude> <longitude> {$longitude}</longitude> </centre>
}
</centres>