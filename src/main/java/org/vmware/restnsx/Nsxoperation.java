package org.vmware.restnsx;

import java.beans.Encoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

import org.springframework.util.Base64Utils;
import org.vmware.trustcert.AcceptSSL;

public class Nsxoperation {
	private HttpsURLConnection hurl = null;
	private String baseurl = "https://vsm1"; // vsm1 mapped to nsx ip
												// ex:10.108.28.167

	private String username = "admin";
	private String password = "default";
	private URL url = null;

	public Nsxoperation() throws NoSuchAlgorithmException {
		AcceptSSL s = new AcceptSSL();
		try {
			HostnameVerifier hv1 = s.acceptAllSSL();
			HttpsURLConnection.setDefaultHostnameVerifier(hv1);

		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void putSegments() throws IOException {
		String path = "/api/2.0/vdn/config/segments";
		String segpayload = "<segmentRange><id>1</id><name>seg1</name>" + "<desc>desc</desc><begin>5000</begin>"
				+ "<end>6000</end></segmentRange>";
		url = new URL(baseurl + path);
		hurl = (HttpsURLConnection) url.openConnection();
		hurl.setDoOutput(true);
		hurl.setRequestMethod("PUT");
		hurl.setRequestProperty("Accept", "application/xml");
		hurl.setRequestProperty("Content-type", "application/xml");
		hurl.setRequestProperty("Authorization", "Basic YWRtaW46ZGVmYXVsdA==");
		OutputStream os = hurl.getOutputStream();
		os.write(segpayload.getBytes());
		os.flush();
		System.out.println("status:" + hurl.getResponseCode());

		BufferedReader br = new BufferedReader(new InputStreamReader(hurl.getInputStream()));
		String b = null;
		while ((b = br.readLine()) != null) {
			System.out.println(b);
		}
		System.out.println("#### post Read over ####");

	}

	public void getSegments() throws IOException {

		/*
		 * String auth=username+":"+password; byte[] bc =
		 * Base64Utils.encode(auth.getBytes()); System.out.println(bc);
		 */
		System.out.println("#### rest control for nsx ####");
		String path = "/api/2.0/vdn/config/segments";
		url = new URL(baseurl + path);
		hurl = (HttpsURLConnection) url.openConnection();
		hurl.setDoInput(true);
		hurl.setRequestMethod("GET");
		hurl.setRequestProperty("Accept", "application/xml");
		hurl.setRequestProperty("Content-type", "application/xml");
		hurl.setRequestProperty("Authorization", "Basic YWRtaW46ZGVmYXVsdA==");
		System.out.println("status:" + hurl.getResponseCode());
		BufferedReader br = new BufferedReader(new InputStreamReader(hurl.getInputStream()));
		String b = null;
		while ((b = br.readLine()) != null) {
			System.out.println(b);
		}
		System.out.println("#### getSegments Read over ####");

	}

	public void postMulticasts() throws IOException{
		String path = "/api/2.0/vdn/config/multicasts";
		String payload = "<multicastRange><name>name</name><desc>description</desc><begin>239.1.1.1</begin><end>239.3.3.3</end></multicastRange>";
		url = new URL(baseurl + path);
		hurl = (HttpsURLConnection) url.openConnection();
		hurl.setDoOutput(true);
		hurl.setRequestMethod("POST");
		hurl.setRequestProperty("Accept", "application/xml");
		hurl.setRequestProperty("Content-type", "application/xml");
		hurl.setRequestProperty("Authorization", "Basic YWRtaW46ZGVmYXVsdA==");
		OutputStream os = hurl.getOutputStream();
		os.write(payload.getBytes());
		os.flush();
		System.out.println("status:" + hurl.getResponseCode());

		BufferedReader br = new BufferedReader(new InputStreamReader(hurl.getInputStream()));
		String b = null;
		while ((b = br.readLine()) != null) {
			System.out.println(b);
		}
		System.out.println("#### post Multicasts Read over ####");
	}

	public void getMulticasts() throws IOException{
		String path = "/api/2.0/vdn/config/multicasts";
		url = new URL(baseurl + path);
		hurl = (HttpsURLConnection) url.openConnection();
		hurl.setDoInput(true);
		hurl.setRequestMethod("GET");
		hurl.setRequestProperty("Accept", "application/xml");
		hurl.setRequestProperty("Content-type", "application/xml");
		hurl.setRequestProperty("Authorization", "Basic YWRtaW46ZGVmYXVsdA==");
		System.out.println("status:" + hurl.getResponseCode());
		BufferedReader br = new BufferedReader(new InputStreamReader(hurl.getInputStream()));
		String b = null;
		while ((b = br.readLine()) != null) {
			System.out.println(b);
		}
		System.out.println("#### getSegments Read over ####");
	}

	public void postBaseConfigure() throws IOException {
		String path = "/api/2.0/nwfabric/configure";
		String payload = "<nwFabricFeatureConfig><resourceConfig><resourceId>domain-c7</resourceId></resourceConfig></nwFabricFeatureConfig>";
		url = new URL(baseurl + path);
		hurl = (HttpsURLConnection) url.openConnection();
		hurl.setDoOutput(true);
		hurl.setRequestMethod("POST");
		hurl.setRequestProperty("Accept", "application/xml");
		hurl.setRequestProperty("Content-type", "application/xml");
		hurl.setRequestProperty("Authorization", "Basic YWRtaW46ZGVmYXVsdA==");
		OutputStream os = hurl.getOutputStream();
		os.write(payload.getBytes());
		os.flush();
		System.out.println("status:" + hurl.getResponseCode());

		BufferedReader br = new BufferedReader(new InputStreamReader(hurl.getInputStream()));
		String b = null;
		while ((b = br.readLine()) != null) {
			System.out.println(b);
		}
		System.out.println("#### postBaseConfigure Read over ####");
	}

	public void postAdvConfigure() throws IOException {
		String path = "/api/2.0/nwfabric/configure";
		String payload = "<nwFabricFeatureConfig>" + "   <featureId>com.vmware.vshield.vsm.vxlan</featureId>"
				+ "  <resourceConfig>" + "      <resourceId>domain-c7</resourceId>"
				+ "        <configSpec class='clusterMappingSpec'>"
				+ "           <switch><objectId>dvs-10</objectId></switch>" + "            <vlanId>0</vlanId>"
				+ "        <vmknicCount>1</vmknicCount>"
				+ "            <!-- ipPoolId is optional and if none is specified will assume DHCP for VTEP address assignment.-->"
				+ "            <!-- <ipPoolId></ipPoolId> -->" + "        </configSpec>" + "    </resourceConfig>"
				+ "    <resourceConfig>" + "        <resourceId>dvs-10</resourceId>"
				+ "        <configSpec class='vdsContext'>" + "            <switch><objectId>dvs-10</objectId></switch>"
				+ "            <mtu>1600</mtu>"
				+ "            <!-- teaming value can be one ofFAILOVER_ORDER|ETHER_CHANNEL|LACP_ACTIVE|LACP_PASSIVE|LOADBALANCE_LOADBASED|LOADBALANCE_SRCID|LOADBALANCE_SRCMAC|LACP_V2 -->"
				+ "            <teaming>FAILOVER_ORDER</teaming>" + "        </configSpec>" + "    </resourceConfig>"
				+ "</nwFabricFeatureConfig>";

		url = new URL(baseurl + path);
		hurl = (HttpsURLConnection) url.openConnection();
		hurl.setDoOutput(true);
		hurl.setRequestMethod("POST");
		hurl.setRequestProperty("Accept", "application/xml");
		hurl.setRequestProperty("Content-type", "application/xml");
		hurl.setRequestProperty("Authorization", "Basic YWRtaW46ZGVmYXVsdA==");
		OutputStream os = hurl.getOutputStream();
		os.write(payload.getBytes());
		os.flush();
		System.out.println("status:" + hurl.getResponseCode());

		BufferedReader br = new BufferedReader(new InputStreamReader(hurl.getInputStream()));
		String b = null;
		while ((b = br.readLine()) != null) {
			System.out.println(b);
		}
		System.out.println("#### postAdvConfigure Read over ####");
	}
}
