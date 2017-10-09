/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.government.approvals.approvalServices;

import java.util.Random;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/")
public class ApprovalServices {

    @GET
    @Path("/electrical-status/{applicationNumber}")
    @Produces({ "application/json" })
    public String getElectricalStatus(@PathParam("applicationNumber") String applicationNumber) {
    	if (getRandomInt() < 3) {
    		return "{\"Electrical Status\":\"" + "Denied" + "\"}";
    	}
    	else {
    		return "{\"Electrical Status\":\"" + "Approved" + "\"}";
    	}
    }

    @GET
    @Path("/structural-status/{applicationNumber}")
    @Produces({ "application/json" })
    public String getStructuralStatus(@PathParam("applicationNumber") String applicationNumber) {
    	if (getRandomInt() < 2) {
    		return "{\"Structural Status\":\"" + "Denied" + "\"}";
    	}
    	else {
    		return "{\"Structural Status\":\"" + "Approved" + "\"}";
    	}
    }
    
    @POST
    @Path("/electrical-permit-apply")
    @Produces({ "application/json" })
    public String submitElectricalApplication() {
        return "{\"Application Status\":\"" + "Recieved" + "\"}";
    }
    
    @POST
    @Path("/structural-permit-apply")
    @Produces({ "application/json" })
    public String submitStructuralApplication() {
        return "{\"Application Status\":\"" + "Recieved" + "\"}";
    }
    
    @DELETE
    @Path("/electrical-permit-cancel")
    @PathParam("/applicationNumber")
    @Produces({ "application/json" })
    public String cancelElectricalApplication() {
        return "{\"Application Status\":\"" + "Cancelled" + "\"}";
    }
    
    @DELETE
    @Path("/structural-permit-cancel")
    @PathParam("/applicationNumber")
    @Produces({ "application/json" })
    public String cancelStructuralApplication() {
        return "{\"Application Status\":\"" + "Cancelled" + "\"}";
    }
    
    private int getRandomInt() {
    	Random random = new Random();
    	return random.nextInt(10) + 1;
    }

}
