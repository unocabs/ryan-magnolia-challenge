<h2>${portfolioCode!}</h2>

<br/>

<#list funds!>
    <ul>
        <#items as fund>
            <li>${fund.name} - ${fund.isinNumber}</li>
        </#items>
    </ul>
</#list>
