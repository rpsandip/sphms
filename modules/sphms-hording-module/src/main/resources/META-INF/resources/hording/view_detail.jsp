<%@ include file="../init.jsp" %>
<section class="content-header">
	<h1>
    	${hordingBean.title }, ${ hordingBean.city}
  	</h1>
</section>
<section class="content-header">
	<div class="row pad-10">
		<div class="col-xs-12">
	    	<div class="box">
	       		<div class="box-body">
	       			<div class="row">
	       				<div class="form-group col-md-4">
	       						<b>Location : </b> ${hordingBean.location }
	       				</div>
	       				<div class="form-group col-md-4">
	       						<b>Land Lord : </b> ${hordingBean.landLordName }
	       				</div>
	       				<div class="form-group col-md-4">
	       						<b>Price Per Month :</b> Rs. ${hordingBean.pricePerMonth }/PM
	       				</div>
	       			</div>	
	       			<div class="row">
	       				<div class="form-group col-md-4">
	       						<b>Type : </b> ${hordingBean.hordingType }
	       				</div>
	       				<div class="form-group col-md-4">
	       						<b>Size :</b> ${hordingBean.size }(Sq. Ft)
	       				</div>
	       				<div class="form-group col-md-4">
	       						<b>Owner Type : </b> ${hordingBean.ownerType }
	       				</div>
	       			</div>
	       			<div class="row">
	       				<div class="form-group col-md-4">
	       						<b>UPIN No :  </b> ${hordingBean.upinNo }
	       				</div>
	       				<div class="form-group col-md-4">
	       						<b>Municipal Tax :</b> Rs. ${hordingBean.mncTax }
	       				</div>
	       				<div class="form-group col-md-4">
	       						<b>Other Expense Per Year :</b> Rs. ${hordingBean.otherExpYear }
	       				</div>
	       			</div>
	       			<div class="row">
						<div class="form-group col-md-12">
							<h4>Hoarding Images: </h4>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group col-md-4">
							<b><liferay-ui:message key="normal.image"></liferay-ui:message></b><br/>
							<div><img src="${hordingBean.normalImageURL }" style="height:3.8cm;"></div>
						</div>
						<div class="form-group col-md-4">
							<b><liferay-ui:message key="short.image"></liferay-ui:message></b><br/>
							<div><img src="${hordingBean.shortImageURL }" style="height:3.8cm;"></div>
						</div>
						<div class="form-group col-md-4">
							<b><liferay-ui:message key="long.image"></liferay-ui:message></b><br/>
							<div><img src="${hordingBean.longImageURL }" style="height:3.8cm;"></div>
						</div>
					</div>	
	       		</div>
	       	</div>
	    </div>
	</div>       		
</section>