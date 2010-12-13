Sur cette page il y aura un gros camembert avec tous les th&egrave;mes du monde. Quand on clique sur un th&egrave;me, il y a la m&ecirc;me carte du 
monde que dans conf&eacute;rence mais qu'avec ce th&egrave;me l&agrave;.
<br/><br/>
<table width="50%">
	<tr>
		<td width="25%">
			<input type="radio" name="rbtnThemeAnnee" value="2006" id="2006" onclick="callGetThemeParAnnee('2006');"/>
			<label for="2006">2006</label>
		</td>
		<td width="25%">
			<input type="radio" name="rbtnThemeAnnee" value="2007" id="2007" onclick="callGetThemeParAnnee('2007');"/>
			<label for="2007">2007</label>
		</td>
		<td width="25%">
			<input type="radio" name="rbtnThemeAnnee" value="2008" id="2008" onclick="callGetThemeParAnnee('2008');"/>
			<label for="2008">2008</label>
		</td>
		<td>
			<input type="radio" name="rbtnThemeAnnee" value="2009" id="2009" checked onclick="callGetThemeParAnnee('2009');"/>
			<label for="2009">2009</label>
		</td>
	</tr>
	<tr>
		<td colspan="4"><div id="theme_chart_div"></div></td>
	</tr>
</table>
