<br/>
<fieldset>
<legend>Formulaire de recherche</legend>
<table id="formrech">
	<tr>
		<td width="200px"><label for="shortname">Titre ou acronyme</label> : </td>
		<td width="200px"><input type="text" name="shortname" id="shortname" /></td>
	</tr>
	<tr>
		<td width="200px"><label for="theme">Th&egrave;me</label> : </td>
		<td width="200px"><input type="text" name="theme" id="theme" /></td>
	</tr>
	<tr>
		<td width="200px">Ann&eacute;e</td>
		<td width="200px"><select name="annee" id="annee">
			    <option value="2006">2006</option>
			    <option value="2007">2007</option>
			    <option value="2008">2008</option>
			    <option value="2009" selected="selected">2009</option>
			    <option value="2010">2010</option>
			</select>
		</td>
	</tr>
	<tr>
		<td width="200px"></td>
		<td width="200px"></td>
		<td width="200px"><input type="submit" value="Rechercher" onclick="recherche()"></td>
	</tr>
</table>
</fieldset>
<br/>
<fieldset id="result" style="display: none">
	<legend>R&eacute;sultats de la recherche</legend>
	<div id="afficheprojets"></div>
</fieldset>