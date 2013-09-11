/**
 * © 2013 FlowForwarding.Org
 * All Rights Reserved.  Use is subject to license terms.
 */
package org.flowforwarding.of.protocol.ofmessages;

import org.flowforwarding.of.protocol.ofmessages.OFMessageBuilder;
import org.flowforwarding.of.protocol.ofmessages.OFMessageFlowMod.OFMessageFlowModHandler;

/**
 * @author Infoblox Inc.
 *
 */
public class OFMessageBuilder13 implements OFMessageBuilder {

   /* (non-Javadoc)
    * @see org.flowforwarding.of.controller.protocol.OFMessageBuilder#build(java.lang.String)
    */
   @Override
   public IOFMessageHandler build(String msg) {

      return null;
   }
   
   @Override
   public OFMessageFlowModHandler buildFlowMod() {
      // TODO Improvs. To make bulder a REAL builder: FlowMod and Ref should be combined from parts.
      // TODO Improvs: OFMessageRef?
      return OFMessageFlowModHandler.create();
   }

}
