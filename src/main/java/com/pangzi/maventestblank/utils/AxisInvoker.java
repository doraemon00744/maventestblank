package com.pangzi.maventestblank.utils;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAP11Constants;
import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.springframework.stereotype.Component;

/**
 * Created by pangzi on 16/2/15.
 */
@Component
public class AxisInvoker {
    private String endPointReference;
    private String action;
    private String nameSpace;
    private String methodName;
    private String methodValueName;

    public String getEndPointReference() {
        return endPointReference;
    }

    public void setEndPointReference(String endPointReference) {
        this.endPointReference = endPointReference;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodValueName() {
        return methodValueName;
    }

    public void setMethodValueName(String methodValueName) {
        this.methodValueName = methodValueName;
    }

    public String invokeWithString(String methodValue) throws AxisFault {
        ServiceClient sender = new ServiceClient();
        Options option = new Options();
        option.setSoapVersionURI(SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI);
        option.setAction(action);
        EndpointReference epReference = new EndpointReference(
                endPointReference);
        option.setTransportInProtocol(Constants.TRANSPORT_HTTP);
        option.setTo(epReference);
        sender.setOptions(option);
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace(nameSpace, "");
        OMElement method = fac.createOMElement(methodName, omNs);
        OMElement value = fac.createOMElement(methodValueName, omNs);
//            OMElement theUserID = fac.createOMElement("theUserID ", omNs);
        value.setText(methodValue);
//            theUserID.setText("");
        method.addChild(value);
//            method.addChild(theUserID);

        OMElement result = sender.sendReceive(method);
//        System.out.println(result);
        return result.toString();
    }
}
