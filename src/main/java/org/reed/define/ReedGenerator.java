package org.reed.define;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import org.reed.log.ReedLogger;
import org.reed.utils.EnderUtil;
import org.reed.utils.StringUtil;
import de.codecentric.boot.admin.server.domain.values.InstanceId;
import de.codecentric.boot.admin.server.domain.values.Registration;
import de.codecentric.boot.admin.server.services.InstanceIdGenerator;

public class ReedGenerator implements InstanceIdGenerator {
    @Override
    public InstanceId generateId(Registration registration) {
        ReedLogger.debug(EnderUtil.devInfo() + " name = " + registration.getName());
        ReedLogger.debug(EnderUtil.devInfo() + " serviceUrl = " + registration.getServiceUrl());
        ReedLogger.debug(EnderUtil.devInfo() + " manageUrl = " + registration.getManagementUrl());
        ReedLogger.debug(EnderUtil.devInfo() + " healthUrl = " + registration.getHealthUrl());
        ReedLogger.debug(EnderUtil.devInfo() + " source = " + registration.getSource());
        ReedLogger.debug(EnderUtil.devInfo() + " metaData = " + registration.getMetadata());
        String key = registration.getName();
        String serviceUrl = registration.getServiceUrl();
        if (!StringUtil.isEmpty(serviceUrl)) {
            serviceUrl = serviceUrl.replace("http://", "");
            serviceUrl = serviceUrl.replace("https://", "");
            if (serviceUrl.contains("/")) {
                serviceUrl = serviceUrl.substring(0, serviceUrl.indexOf("/"));
            }
        }
        return InstanceId.of(new String(key + "@" + serviceUrl));
    }

    @SuppressWarnings("unused")
    private static String getLinuxLocalIp() throws SocketException {
        String ip = "";
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en
                    .hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                String name = intf.getName();
                if (!name.contains("docker") && !name.contains("lo")) {
                    for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr
                            .hasMoreElements();) {
                        InetAddress inetAddress = enumIpAddr.nextElement();
                        if (!inetAddress.isLoopbackAddress()) {
                            String ipaddress = inetAddress.getHostAddress().toString();
                            if (!ipaddress.contains("::") && !ipaddress.contains("0:0:")
                                    && !ipaddress.contains("fe80")) {
                                ip = ipaddress;
                            }
                        }
                    }
                }
            }
        } catch (SocketException ex) {
            ip = "127.0.0.1";
        }
        return ip;
    }

    @SuppressWarnings("unused")
    private static String getWindowsLocalIp() throws UnknownHostException {
        String ip = "";
        try {
            ip = InetAddress.getLocalHost().getHostAddress().toString();
        } catch (UnknownHostException e) {
            ip = "127.0.0.1";
        }
        return ip;
    }

    // public static void main(String[] args) {
    // String key = "REED-ADMIN";
    // String encode1 = Base64Util
    // .encode("http://11.11.54.163:20793/cnpcoa-auth-center/actuator".getBytes(StandardCharsets.UTF_8));
    // String encode2 = Base64Util
    // .encode("http://11.10.32.42:15000/cnpcoa-auth-center/actuator".getBytes(StandardCharsets.UTF_8));
    //// String encode1 = StringUtil.md5(Base64Util
    //// .encode("http://11.11.54.163:20793/cnpcoa-auth-center/actuator".getBytes(StandardCharsets.UTF_8)));
    //// String encode2 = StringUtil.md5(Base64Util
    //// .encode("http://11.10.32.42:15000/cnpcoa-auth-center/actuator".getBytes(StandardCharsets.UTF_8)));
    // System.err.println(encode1);
    // System.out.println(encode2);
    // }
}
