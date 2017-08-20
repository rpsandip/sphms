<%@ include file="../init.jsp" %>
<section class="content-header">
	<h1>
    	${bookingBean.campaignTitle }
  	</h1>
</section>
<section class="content-header">
	<div class="row pad-10">
		<div class="col-xs-12">
	    	<div class="box">
	       		<div class="box-body">
	       			<div class="row">
	       				<div class="form-group col-md-4">
	       						<b>Client : </b> ${bookingBean.client }
	       				</div>
	       				<fmt:formatDate pattern = "dd/MM/yyyy" 	value = "${ bookingBean.startDate}"  var="startDate"/>
	       				<div class="form-group col-md-4">
	       						<b>Start Date : </b> ${startDate }
	       				</div>
	       				<fmt:formatDate pattern = "dd/MM/yyyy" 	value = "${ bookingBean.endDate}"  var="endDate"/>
	       				<div class="form-group col-md-4">
	       						<b>End Date :</b>${endDate }
	       				</div>
	       			</div>
	       			<div class="row">
	       				<div class="form-group col-md-12">
	       					<b> <a href="${bookingBean.billURL }">DownLoad Bill </a></b>
	       				</div>
	       			</div>	
	       			<div class="row">
     					<div class="form-group col-md-12">
     						<h4><liferay-ui:message key="selected.hoardings"/> </h4>
     					</div>
     					<c:forEach items="${ bookingHordingBeanList}"  var="bookingHording">
     						<div class="form-group col-md-3">
	       					 	<b>Hoarding: </b> ${bookingHording.hordingTitle }
     						</div>
     						<div class="form-group col-md-3">
	       					 	<b>Mounting Charge: </b> Rs. ${ bookingHording.mountingCharge}/SqFt
     						</div>
     						<div class="form-group col-md-3">
	       					 	<b>Printing Charge: </b> Rs. ${ bookingHording.printingCharge}/SqFt
     						</div>
     						<div class="form-group col-md-3">
	       					 	<b>Units: </b>  ${ bookingHording.units}
     						</div>
     					</c:forEach>
     				</div>		
	       		</div>
	       	</div>
	    </div>
	</div>
</section>	       		