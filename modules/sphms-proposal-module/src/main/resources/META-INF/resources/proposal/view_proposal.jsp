<%@ include file="../init.jsp" %>
<section class="content-header">
	<h1>
    	${proposalBean.campaignTitle }
  	</h1>
</section>
<section class="content-header">
	<div class="row pad-10">
		<div class="col-xs-12">
	    	<div class="box">
	       		<div class="box-body">
	       			<div class="row">
	       				<div class="form-group col-md-4">
	       						<b>Client : </b> ${proposalBean.client }
	       				</div>
	       				<fmt:formatDate pattern = "dd/MM/yyyy" 	value = "${ proposalBean.startDate}"  var="startDate"/>
	       				<div class="form-group col-md-4">
	       						<b>Start Date : </b> ${startDate }
	       				</div>
	       				<fmt:formatDate pattern = "dd/MM/yyyy" 	value = "${ proposalBean.endDate}"  var="endDate"/>
	       				<div class="form-group col-md-4">
	       						<b>End Date :</b>${endDate }
	       				</div>
	       			</div>
	       			<div class="row">
	       				<div class="form-group col-md-12">
	       					<b> <a href="${proposalBean.pptFileURL }">DownLoad PPT </a></b>
	       				</div>
	       				<div class="form-group col-md-12">
	       					<b> <a href="${proposalBean.xlsxFileURL }">DownLoad Xlsx </a></b>
	       				</div>
	       			</div>	
	       			<div class="row">
     					<div class="form-group col-md-12">
     						<h4><liferay-ui:message key="selected.hoardings"/> </h4>
     					</div>
     					<c:forEach items="${ proposalHordingBeaList}"  var="proposalHording">
     						<div class="form-group col-md-12">
	     						<div class="form-group col-md-3">
		       					 	<b>Hoarding: </b> ${proposalHording.hordingTitle }
	     						</div>
	     						<div class="form-group col-md-3">
		       					 	<b>Mounting Charge: </b> Rs. ${ proposalHording.mountingCharge}/SqFt
	     						</div>
	     						<div class="form-group col-md-3">
		       					 	<b>Printing Charge: </b> Rs. ${ proposalHording.printingCharge}/SqFt
	     						</div>
	     						<div class="form-group col-md-3">
		       					 	<b>Units: </b>  ${ proposalHording.units}
	     						</div>
     						</div>
     					</c:forEach>
     				</div>		
	       		</div>
	       	</div>
	    </div>
	</div>
</section>	       		