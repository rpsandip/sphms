<%@ include file="../init.jsp" %>

<portlet:actionURL var="uploadPOURL" name="/upload-po">
	<portlet:param name="billingId" value="${billingId }"/>
</portlet:actionURL>

<liferay-ui:success key="po-upload-success" message="po-upload-success"/>
<liferay-ui:error key="po-upload-error" message="po-upload-error"/>


<section class="content-header">
  <h1>
  	 Upload PO
  </h1>
</section>
<div class="row">
	<div class="col-xs-12">
    	<div class="box">
       		<div class="box-body">
       			<aui:form name="uploadPOFrm" action="${uploadPOURL}" cssClass="row contact_form" method="POST" enctype="multipart/form-data">
					<div class="row">
     					<div class="form-group col-md-12">
							<aui:input type="file" name="uploadPOFile" label="Upload File"/>
						</div>
					</div>		
					<div class="row">
     					<div class="form-group col-md-12">
							<aui:button value="Upload" name="uploadPO"  cssClass="uplaodPOBtn btn btn-primary"></aui:button>
						</div>
					</div>		
       			</aui:form>
       		</div>
       	</div>
     </div>
</div>       			

<section class="content-header">
  <h1>
  	 Uploaded PO Files
  </h1>
</section>

<section class="content">
 <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
            	<table id="clients" class="display table table-bordered table-hover table-striped" cellspacing="0" width="100%">
					<thead>
			            <tr>
			                <th>PO File</th>
			            </tr>
     			   </thead>
        		   <tbody>
            	      <c:forEach items="${documentBeanList }" var="document">
            			<tr>
			                <td>  <a href="${ document.documentURL}" target="_blank">${document.fileName }</a></td>
        			    </tr>
           			</c:forEach>
           			</tbody>
				</table>
            </div>
        </div>
     </div>
  </div>
</section>       
<script type="text/javascript">
        jQuery.noConflict();
        (function($) {
            $(function() {  
            	 $('#clients').DataTable({
            		 "pageLength": 50,
            		 "order": []
            	 });
            });
        })(jQuery);
 </script>

<aui:script>
var userModuleNameSpace =  '<portlet:namespace/>';
AUI().use('aui-base','aui-form-validator', function(A) {
	var uplaodPOBtn= A.one(".uplaodPOBtn");
	uplaodPOBtn.on('click', function(e) {
		var formValidator = Liferay.Form.get('<portlet:namespace />uploadPOFrm').formValidator;
		formValidator.validate();
		if(!formValidator.hasErrors()){
			document.<portlet:namespace />uploadPOFrm.submit();
		}
	});
});
</aui:script> 	