<h3>Total Count of Contacts is : ${Count.memberCount}</h3>
<h4>Names of Contact</h4>
<#--<table>
	<thead>
		<th>Fisrt Name</th>
		<th>Last Name </th>
		<th>Family Name </th>
		<th>Given Name </th>
	</thead>
		<#list Details as detail>
			<tr>${detail}</tr>
		</#list>
		<tr></tr><tr></tr><tr></tr>
</table>-->
 <ol>
<#list Details as detail>
	<li>${detail}</li>
</#list>
</ol>