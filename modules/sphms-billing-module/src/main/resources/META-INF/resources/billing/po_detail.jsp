<%@page import="com.sphms.common.service.model.LandLord"%>
<%@page import="com.sphms.common.service.service.LandLordLocalServiceUtil"%>
<%@ include file="../init.jsp" %>

<portlet:resourceURL id="/download-po" var="downLoadPOURL" />
<liferay-ui:error key="error-po-publish" message="error-po-publish"/>
<liferay-ui:success key="po-publish-success" message="po-publish-success"/>

<liferay-ui:success key="po-update-success" message="po-update-success"/>
<liferay-ui:success key="po-update-error" message="po-update-error"/>

<section class="content-header">
  <h1>
  	 Purchase Orders
  </h1>
</section>
<section class="content">
 <div class="row">
 	 <div class="col-xs-12">
     	<div class="box">
            <div class="box-body">
            	<table id="poList" class="display table table-bordered table-hover table-striped" cellspacing="0" width="100%">
					<thead>
			            <tr>
			                <th>Owner</th>
			                <th>Hoardings</th>
			                <th>PO Number</th>
			                <th>Financial Year</th>
			                <th>Download</th>
			                 <th>Status</th>
			                <th>Action</th>
			      
			            </tr>
     			   </thead>
        		   <tbody>
            	      <c:forEach items="${poBeanMap }" var="poBean">
            			<tr>
            				 <c:set var="landLordId" value="${poBean.key }"/>
            				  <c:set var="poBean" value="${poBean.value }"/>
            				<%
            					long landLordId = (Long)pageContext.getAttribute("landLordId");
            					String owner = "";
            					if(landLordId>0){
            						try{
            							LandLord landLord = LandLordLocalServiceUtil.getLandLord(landLordId);
            							owner = landLord.getFirstName()+" " + landLord.getLastName();
            						}catch(Exception e){
            							e.printStackTrace();
            						}
            					}
            				%>
            				<td><%=owner %></td>
            				<td>
            					<ul>
            						<c:forEach items="${poBean.hordingList }" var="poHordingDTO">
            							<li>
            								${poHordingDTO.hordingTitle}
            							</li>
            						</c:forEach>
            					</ul>
            				</td>
            				<td>${poBean.poNumber}</td>
            				<td>${poBean.financialYear}</td>
            				<td><a data-billing-id="${ poBean.billingId}" data-landlord-id="${poBean.landlordId }" class="po-download">DownLoad</a></td>
        			    	<td>
        			    					<c:choose>
            									<c:when test='${poBean.status eq "Generated" }'>
	            										<portlet:actionURL var="publishPOActionURL" name="/publish_PO">
															<portlet:param name="billingId" value="${ poBean.billingId}"/>
														</portlet:actionURL>
										
														<a href="${publishPOActionURL}">
		            										Publish
		            									</a>
            									</c:when>
            									<c:otherwise>
            										Sent To Client
            									</c:otherwise>
            								</c:choose>
            							
        			    	</td>
        			    	<td>
								
            						
            							<portlet:renderURL var="editPODetailURL">
       							 			<portlet:param name="mvcRenderCommandName" value="/edit_po" />
       							 			<portlet:param name="billingId" value="${ poBean.billingId}" />
										</portlet:renderURL>
            							
            								<a href="${editPODetailURL}">
            									Edit
            								</a>
            						
        			    	</td>
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
            	 $('#poList').DataTable({
            		 "order": []
            	 });
            });
            
            $(".po-download").on('click', function(){
            	window.location.href = '${downLoadPOURL}' + '&<portlet:namespace/>billingId='+$(this).data('billing-id')+'&<portlet:namespace/>landlordId='+ $(this).data('landlord-id');
            });
        })(jQuery);
    </script>     