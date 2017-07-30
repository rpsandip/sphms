<%@ include file="../init.jsp" %>

<portlet:actionURL var="addHordingURL" name="/add_hording">
</portlet:actionURL>


<section class="content-header">
  <c:choose>
	<c:when test="${ hordingBean.hordingId gt 0}">
		<h1>
    		<liferay-ui:message key="update.hording"/> 
  		</h1>
	</c:when>
	<c:otherwise>
		<h1>
    		<liferay-ui:message key="add.hording"/> 
  		</h1>
	</c:otherwise>
</c:choose>
</section>
<br/>
<div class="row pad-10">
	<div class="col-xs-12">
    	<div class="box">
       		<div class="box-body">
       			<aui:form name="addHordingFm" action="${addHordingURL}" cssClass="row contact_form" method="post" enctype="multipart/form-data">
       				<div class="row pad-15">
       					<aui:select name="landLordId" label="land.lord" cssClass="form-control">
	       					 	<aui:option value="">Select Land Lord</aui:option>
	       					 	<c:forEach items="${landLordList }" var="landLord">
	       					 		<aui:option value="${landLord.landLordId }" selected='${hordingBean.landLordId eq landLord.landLordId ? true : false }'> ${landLord.firstName } ${landLord.lastName }</aui:option>
	       					 	</c:forEach>
						</aui:select>
       				</div>
       				<div class="row">
	       				<div class="form-group col-md-12">
	       					 <aui:input name="title" label="title" cssClass="form-control" value="${hordingBean.title }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">70</aui:validator>
							 </aui:input>
						</div>
					</div>	
					<div class="row">
	       				<div class="form-group col-md-4">
	       					 <aui:input name="location" label="location" cssClass="form-control" value="${hordingBean.location }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">70</aui:validator>
							 </aui:input>
						</div>
						<div class="form-group col-md-4">
	       					 <aui:input name="city" label="city" cssClass="form-control" value="${hordingBean.city }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">70</aui:validator>
							 </aui:input>
						</div>
						<div class="form-group col-md-4">
	       					 <aui:input name="state" label="state" cssClass="form-control" value="${hordingBean.state }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">70</aui:validator>
							 </aui:input>
						</div>
					</div>
					<div class="row">
	       				<div class="form-group col-md-4">
	       					 <aui:select name="type" label="type" cssClass="form-control">
	       					 	<aui:option value="EL" selected='${hordingBean.hordingType eq "EL" ? true : false }' >EL</aui:option>
	       					 	<aui:option value="BL" selected='${hordingBean.hordingType eq "BL" ? true : false }'>BL</aui:option>
	       					 	<aui:option value="NL" selected='${hordingBean.hordingType eq "NL" ? true : false }'>NL</aui:option>
							 </aui:select>
						</div>
						<div class="form-group col-md-4">
	       					 <aui:select name="height" label="hight" cssClass="form-control">
	       					 	<aui:option value="5" selected='${hordingBean.height eq 5 ? true : false }'>5</aui:option>
	       					 	<aui:option value="10" selected='${hordingBean.height eq 10 ? true : false }'>10</aui:option>
	       					 	<aui:option value="15" selected='${hordingBean.height eq 15 ? true : false }'>15</aui:option>
	       					 	<aui:option value="20" selected='${hordingBean.height eq 20 ? true : false }'>20</aui:option>
	       					 	<aui:option value="25" selected='${hordingBean.height eq 25 ? true : false }'>25</aui:option>
	       					 	<aui:option value="30" selected='${hordingBean.height eq 30 ? true : false }'>30</aui:option>
							 </aui:select>
						</div>
						<div class="form-group col-md-4">
	       					 <aui:select name="width" label="width" cssClass="form-control">
	       					 	<aui:option value="5" selected='${hordingBean.width eq 5 ? true : false }'>5</aui:option>
	       					 	<aui:option value="10" selected='${hordingBean.width eq 10 ? true : false }'>10</aui:option>
	       					 	<aui:option value="15" selected='${hordingBean.width eq 15 ? true : false }'>15</aui:option>
	       					 	<aui:option value="20" selected='${hordingBean.width eq 20 ? true : false }'>20</aui:option>
	       					 	<aui:option value="25" selected='${hordingBean.width eq 25 ? true : false }'>25</aui:option>
	       					 	<aui:option value="30" selected='${hordingBean.width eq 30 ? true : false }'>30</aui:option>
							 </aui:select>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-4">
	       					<aui:select name="owerType" label="ownerType" cssClass="form-control">
	       					 	<aui:option value="0" selected='${hordingBean.ownerTypeInt eq 0 ? true : false }'>Own</aui:option>
	       					 	<aui:option value="1" selected='${hordingBean.ownerTypeInt eq 1 ? true : false }'>Trade</aui:option>
							 </aui:select>
						</div>
						<div class="form-group col-md-4">
	       					<aui:input name="upinNo" label="upinNo" cssClass="form-control" value="${hordingBean.upinNo }">
						     	<aui:validator name="maxLength">70</aui:validator>
							 </aui:input>
						</div>
						<div class="form-group col-md-4">
	       					<aui:input name="mncTax" label="mncTax" cssClass="form-control" value="${hordingBean.mncTax }">
						     	<aui:validator name="maxLength">70</aui:validator>
							 </aui:input>
						</div>
					</div>	
					<div class="row">
						<div class="form-group col-md-6">
	       					<aui:input name="pricePerMonth" label="pricePerMonth" cssClass="form-control" value="${hordingBean.pricePerMonth }">
						     	<aui:validator name="maxLength">10</aui:validator>
							 </aui:input>
						</div>
						<div class="form-group col-md-6">
	       					<aui:input name="otherExpYear" label="otherExpYear" cssClass="form-control" value="${hordingBean.otherExpYear }">
						     	<aui:validator name="maxLength">10</aui:validator>
							 </aui:input>
						</div>
					</div>	
					<div class="row">
						<div class="form-group col-md-12">
							<h3>Hoarding Images: </h3>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<h4>Normal Image :</h4>
							<input type="file" name="normalImage" id="normalImage"/>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<h4>Short Image :</h4>
							<input type="file" name="shortImage" id="shortImage"/>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<h4>Long Image :</h4>
							<input type="file" name="longImage" id="longImage"/>
						</div>
					</div>
					
					<c:choose>
						<c:when test="${ hordingBean.hordingId gt 0}">
							<div class="row">
       							<div class="form-group col-md-12">
									<aui:button type="button" value="Update Hoarding"  cssClass="addHordingBtn btn btn-primary"/>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="row">
       							<div class="form-group col-md-12">
									<aui:button type="button" value="Add Hoarding"  cssClass="addHordingBtn btn btn-primary"/>
								</div>
							</div>
						</c:otherwise>
					</c:choose>		
					<aui:input type="hidden" name="hordingId" value="${hordingBean.hordingId }"/>	       					
       			</aui:form>
       		</div>
        </div>
   </div>
</div>

<aui:script>
AUI().use('aui-base','aui-form-validator', function(A) {
	var addHordingBtn= A.one(".addHordingBtn");
	
	var dropDonwValidator = new A.FormValidator({
		boundingBox: document.<portlet:namespace/>addHordingFm,
		rules: {
			<portlet:namespace/>landLordId: {
				required: true
			}
		},
		fieldStrings: {
			<portlet:namespace/>landLordId: {
				required: 'Please select Land Lord'
				}
		}
	});
	
	
	
	addHordingBtn.on('click', function(e) {
		var formValidator = Liferay.Form.get('<portlet:namespace />addHordingFm').formValidator;
		formValidator.validate();
		dropDonwValidator.validate();
		if(!formValidator.hasErrors() && !dropDonwValidator.hasErrors()){
			document.<portlet:namespace />addHordingFm.submit();
		}
	});
});
</aui:script>   	
       			