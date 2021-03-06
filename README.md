#Quick Start Guide: Warp OpenFlow controller
====================================

This OpenFlow Controller implementation is based on [Apache AVRO] (https://avro.apache.org/) library

>1. Setup a WARP_ROOT environment variable where the project is placed, e.g.:
```bash
 $ cd <warp_root_dir>
 $ export WARP_ROOT=`pwd`
```

>2. Build Avro library (One time Step - and when ever Avro library is modified):
 ```bash
 $ cd $WARP_ROOT/src/main/java/avro-trunk/lang/java/avro
 $ mvn install -DskipTests
 ```

>3. Build warp.jar and JavaDoc API:
 ```bash
 $ cd $WARP_ROOT
 $ ant
 $ ant javadoc
 ```

>4. Running the OpenFlow Switch and Warp Controller<br/>
   Warp Controller [User's Guide] (https://github.com/FlowForwarding/warp/wiki/Warp-User's-Guide)<br/>
   Warp Controller [testing against OpenFlow 1.3 LINC Switch] (https://github.com/FlowForwarding/warp/wiki/Warp-testing-against-OpenFlow-1.3-LINC-Switch)<br/>

   For Developers, interested in [using the API] (https://github.com/FlowForwarding/warp/wiki/Warp-Java-API-Cookbook)<br/>

>5. Additional Documentation (docs directory):<br/>
     (1) Using Apache Avro to implement an OpenFlow protocol library: UsingApacheAVROtoimplementOFProtocol.pdf<br/>
     (2) Details of Architecture and Implementation: Architecture_and_Implementation_Details.txt<br/>
     (3) 'ant javadoc' target builds API documentation and is placed in docs/api directory<br/>
