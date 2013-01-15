package org.flowforwarding.of.controller.protocol;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericEnumSymbol;
import org.apache.avro.generic.GenericData.EnumSymbol;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;

public class Protocol {
	
	private final String schemaSrc = "of_protocol_12.avpr";
	
	private Schema ofpHeaderSchema = null; 
	private Schema ofpSwitchFeaturesSchema = null;
	private Schema ofpSwitchConfigSchema = null; 
	private Schema ofpMatchSchema = null;
	private Schema ofpFlowModSchema = null;
	private Schema ofpFlowModBaseSchema = null;
	
	private Schema ofpTypeSchema = null;
	private Schema ofpConfigFlagsSchema = null;	
	private Schema ofpFlowModCommandSchema = null;
	private Schema ofpFlowModFlagsSchema = null;
	private Schema ofpMatchTypeSchema = null;
	
	org.apache.avro.Protocol protocol = null;

	public void init() {
		 
		try {
			protocol = org.apache.avro.Protocol.parse(getClass().getClassLoader().getResourceAsStream(schemaSrc));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ofpHeaderSchema =  protocol.getType("of12.ofp_header");
		ofpSwitchFeaturesSchema = protocol.getType("of12.ofp_switch_features");
		ofpSwitchConfigSchema = protocol.getType("of12.ofp_switch_config");
		ofpMatchSchema = protocol.getType("of12.ofp_match");
		ofpFlowModSchema = protocol.getType("of12.ofp_flow_mod");
		ofpFlowModBaseSchema = protocol.getType("of12.ofp_flow_mod_base");
		ofpTypeSchema = protocol.getType("of12.ofp_type");
		ofpConfigFlagsSchema = protocol.getType("of12.ofp_config_flags");
		ofpMatchTypeSchema = protocol.getType("of12.ofp_match_type");
		
		
		
	}
	
	public ByteArrayOutputStream getHello(ByteArrayOutputStream out) {
		
		GenericRecord ofpHeaderRecord = new GenericData.Record(ofpHeaderSchema);
		
		byte[] ver = {3};		
		GenericData.Fixed version = new GenericData.Fixed(ofpHeaderSchema, ver); 
		ofpHeaderRecord.put("version", version);
		
	   ofpHeaderRecord.put("type", new EnumSymbol(ofpTypeSchema, "OFPT_HELLO"));
		
	   byte[] len = {0,8};
	   GenericData.Fixed length = new GenericData.Fixed(ofpHeaderSchema, len);
		ofpHeaderRecord.put("length", length);
		
	   byte[] xd = {0,0,0,1};
	   GenericData.Fixed xid = new GenericData.Fixed(ofpHeaderSchema, xd);
	   ofpHeaderRecord.put("xid", xid);
	   
		
      DatumWriter<GenericRecord> writer = new GenericDatumWriter<GenericRecord>(ofpHeaderSchema);
	    
	   Encoder encoder = EncoderFactory.get().binaryNonEncoder(out, null);
	    
		try {
			writer.write(ofpHeaderRecord, encoder);
		    encoder.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}
	
	public ByteArrayOutputStream getSwitchFeaturesRequest(ByteArrayOutputStream out) {
		
		GenericRecord ofpHeaderRecord = new GenericData.Record(ofpHeaderSchema);
		GenericRecord ofpSwitchFeaturesRecord = new GenericData.Record(ofpSwitchFeaturesSchema);

	   byte[] ver = {3};    
	   GenericData.Fixed version = new GenericData.Fixed(ofpHeaderSchema, ver); 
	   ofpHeaderRecord.put("version", version);
	      
	   ofpHeaderRecord.put("type", new EnumSymbol(ofpTypeSchema, "OFPT_FEATURES_REQUEST"));
	      
	   byte[] len = {0,32};
	   GenericData.Fixed length = new GenericData.Fixed(ofpHeaderSchema, len);
	   ofpHeaderRecord.put("length", length);
	      
	   byte[] xd = {0,0,0,1};
	   GenericData.Fixed xid = new GenericData.Fixed(ofpHeaderSchema, xd);
	   ofpHeaderRecord.put("xid", xid);
	
		ofpSwitchFeaturesRecord.put("header",ofpHeaderRecord);
		
	   
		byte[] dpid = {0,0,0,0,0,0,0,0};
	   GenericData.Fixed datapath_id = new GenericData.Fixed(ofpSwitchFeaturesSchema, dpid);
		ofpSwitchFeaturesRecord.put("datapath_id", datapath_id);
		
	   byte[] nbuf = {0,0,0,0};
	   GenericData.Fixed n_buffers = new GenericData.Fixed(ofpSwitchFeaturesSchema, nbuf);
	   ofpSwitchFeaturesRecord.put("n_buffers", n_buffers);
		
      byte[] ntab = {0};
	   GenericData.Fixed n_tables = new GenericData.Fixed(ofpSwitchFeaturesSchema, ntab);
	   ofpSwitchFeaturesRecord.put("n_tables", n_tables);
	   
      byte[] p = {0,0,0};
      GenericData.Fixed pad = new GenericData.Fixed(ofpSwitchFeaturesSchema, p);
      ofpSwitchFeaturesRecord.put("pad", pad);

      byte[] cap = {0,0,0,0};
      GenericData.Fixed capabilities = new GenericData.Fixed(ofpSwitchFeaturesSchema, cap);
      ofpSwitchFeaturesRecord.put("capabilities", capabilities);
      
      byte[] res = {0,0,0,0};
      GenericData.Fixed reserved = new GenericData.Fixed(ofpSwitchFeaturesSchema, res);
      ofpSwitchFeaturesRecord.put("reserved", reserved);

      DatumWriter<GenericRecord> writer = new GenericDatumWriter<GenericRecord>(ofpSwitchFeaturesSchema);
	    
	   Encoder encoder = EncoderFactory.get().binaryNonEncoder(out, null);
	    
		try {
			writer.write(ofpSwitchFeaturesRecord, encoder);
		    encoder.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

	public ByteArrayOutputStream getSwitchConfigRequest(ByteArrayOutputStream out) {
		
		GenericRecord ofpHeaderRecord = new GenericData.Record(ofpHeaderSchema);
		GenericRecord ofpSwitchConfigRecord = new GenericData.Record(ofpSwitchConfigSchema);
		
		byte[] ver = {3};    
		GenericData.Fixed version = new GenericData.Fixed(ofpHeaderSchema, ver); 
	   ofpHeaderRecord.put("version", version);
	         
	   ofpHeaderRecord.put("type", new EnumSymbol(ofpTypeSchema, "OFPT_GET_CONFIG_REQUEST"));
	         
	   byte[] len = {0,12};
	   GenericData.Fixed length = new GenericData.Fixed(ofpHeaderSchema, len);
	   ofpHeaderRecord.put("length", length);
	         
	   byte[] xd = {0,0,0,1};
	   GenericData.Fixed xid = new GenericData.Fixed(ofpHeaderSchema, xd);
	   ofpHeaderRecord.put("xid", xid);
      
	   ofpSwitchConfigRecord.put("header", ofpHeaderRecord);
      
      
      ofpSwitchConfigRecord.put("flags", new EnumSymbol(ofpConfigFlagsSchema, "OFPC_FRAG_NORMAL"));

      byte[] msl = {0,0};
      GenericData.Fixed miss_send_len = new GenericData.Fixed(ofpSwitchConfigSchema, msl);
      ofpSwitchConfigRecord.put("miss_send_len", miss_send_len);
	    
      DatumWriter<GenericRecord> writer = new GenericDatumWriter<GenericRecord>(ofpSwitchConfigSchema);
	   Encoder encoder = EncoderFactory.get().binaryNonEncoder(out, null);
	    
		try {
			writer.write(ofpSwitchConfigRecord, encoder);
		    encoder.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}
	
	public ByteArrayOutputStream getFlowMod(ByteArrayOutputStream out) {
		
		GenericRecord ofpHeaderRecord = new GenericData.Record(ofpHeaderSchema);
		GenericRecord ofpFlowModRecord = new GenericData.Record(ofpFlowModSchema);
		GenericRecord ofpFlowModBaseRecord = new GenericData.Record(ofpFlowModBaseSchema);
		GenericRecord ofpMatchRecord = new GenericData.Record(ofpMatchSchema);
		
      byte[] ver = {3};    
      GenericData.Fixed version = new GenericData.Fixed(ofpHeaderSchema, ver); 
      ofpHeaderRecord.put("version", version);
            
      ofpHeaderRecord.put("type", new EnumSymbol(ofpTypeSchema, "OFPT_GET_CONFIG_REQUEST"));
            
      byte[] len = {0,12};
      GenericData.Fixed length = new GenericData.Fixed(ofpHeaderSchema, len);
      ofpHeaderRecord.put("length", length);
            
      byte[] xd = {0,0,0,1};
      GenericData.Fixed xid = new GenericData.Fixed(ofpHeaderSchema, xd);
      ofpHeaderRecord.put("xid", xid);
      
		ofpFlowModRecord.put("header", ofpHeaderRecord);
		
      byte[] ck = {0,0,0,0,0,0,0,0};
      GenericData.Fixed cookie = new GenericData.Fixed(ofpFlowModBaseSchema, ck);
      ofpFlowModBaseRecord.put("cookie", cookie);
		
      byte[] cm = {0,0,0,0,0,0,0,0};
      GenericData.Fixed cookie_mask = new GenericData.Fixed(ofpFlowModBaseSchema, cm);
      ofpFlowModRecord.put("cookie_mask", cookie_mask);
      
      byte[] tid = {0};
      GenericData.Fixed table_id = new GenericData.Fixed(ofpFlowModBaseSchema, tid);
      ofpFlowModRecord.put("table_id", table_id);
      
      ofpFlowModRecord.put("command", new EnumSymbol(ofpFlowModCommandSchema, "OFPFC_MODIFY"));
      
      byte[] itb = {0,0};
      GenericData.Fixed idle_timeout = new GenericData.Fixed(ofpFlowModBaseSchema, itb);
      ofpFlowModRecord.put("idle_timeout", idle_timeout);
      
      byte[] htb = {0,0};
      GenericData.Fixed hard_timeout = new GenericData.Fixed(ofpFlowModBaseSchema, htb);
      ofpFlowModRecord.put("hard_timeout", hard_timeout);
      
      byte[] prior = {0,0};
      GenericData.Fixed priority = new GenericData.Fixed(ofpFlowModBaseSchema, prior);
      ofpFlowModRecord.put("priority", priority);
      
      byte[] bid = {0,0,0,0};
      GenericData.Fixed buffer_id = new GenericData.Fixed(ofpFlowModBaseSchema, bid);
      ofpFlowModRecord.put("buffer_id", buffer_id);
      
      byte[] op = {0,0,0,0};
      GenericData.Fixed out_port = new GenericData.Fixed(ofpFlowModBaseSchema, op);
      ofpFlowModRecord.put("out_port", out_port);        
      
      byte[] og = {0,0,0,0};
      GenericData.Fixed out_group = new GenericData.Fixed(ofpFlowModBaseSchema, og);
      ofpFlowModRecord.put("out_group", out_group);
              
      ofpFlowModRecord.put("flags", new EnumSymbol(ofpFlowModFlagsSchema, "OFPFF_SEND_FLOW_REM"));

      byte[] p = {0,0};
      GenericData.Fixed pad = new GenericData.Fixed(ofpFlowModBaseSchema, p);
      ofpFlowModRecord.put("pad", pad);

      ofpMatchRecord.put("type", new EnumSymbol(ofpMatchTypeSchema, "OFPMT_OXM"));
        
        ByteBuffer matchLenBuffer = ByteBuffer.allocate(2);
        matchLenBuffer.put((byte)4);
        matchLenBuffer.put((byte)0);
        ofpMatchRecord.put("length", matchLenBuffer);
        
        ByteBuffer oxmBuffer = ByteBuffer.allocate(4);
        oxmBuffer.put((byte)0);
        oxmBuffer.put((byte)0);
        oxmBuffer.put((byte)0);
        oxmBuffer.put((byte)0);
        ofpMatchRecord.put("oxm_fields", oxmBuffer);
        
        ofpFlowModRecord.put("match", ofpMatchRecord);
	    
        DatumWriter<GenericRecord> writer = new GenericDatumWriter<GenericRecord>(ofpFlowModSchema);
	    Encoder encoder = EncoderFactory.get().binaryNonEncoder(out, null);
	    
		try {
			writer.write(ofpFlowModRecord, encoder);
		    encoder.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

}
