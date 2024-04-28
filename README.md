<!-- Easy-FLV: Java RTSP/RTMP to FLV Converter -->
# 📺 Easy-FLV: Java RTSP/RTMP to FLV Converter

[![GitHub stars](https://img.shields.io/github/stars/javpower/easy-flv.svg)](https://github.com/javpower/easy-flv) 
[![GitHub issues](https://img.shields.io/github/issues/javpower/easy-flv.svg)](https://github.com/javpower/easy-flv/issues) 
[![Apache License 2.0](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0) 
[![Java Version](https://img.shields.io/badge/java-1.8+-orange.svg)](https://adoptopenjdk.net/) 
[![Spring Boot](https://img.shields.io/badge/spring--boot-2.7.+-blue.svg)](https://spring.io/projects/spring-boot) 

## 🌟 About Easy-FLV
Easy-FLV is a Java library that converts RTSP or RTMP video streams into FLV format for playback in web browsers. It provides an efficient, stable, and easily integrable solution for real-time video monitoring, live streaming, and video stream processing.

### Why Choose Easy-FLV?
- **Efficient Conversion**: Quickly converts video streams to FLV format with no complex configuration required.
- **Easy Integration**: Used as a Spring Boot Starter, it can be easily integrated into any Java project.
- **Modern Browser Support**: Supports all major modern browsers without the need for additional plugins.
- **Real-time Stream Processing**: Suitable for the conversion of real-time video streams, such as security monitoring and live broadcasting.

## 📄 Screenshots
Below are screenshots of Easy-FLV in action:

![img_1.png](img_1.png)
![img.png](img.png)

## 🚀 Quick Start

### Add Maven Dependency
Include the following Maven dependency in your Spring Boot project:

```xml
<dependency>
    <groupId>io.github.javpower</groupId>
    <artifactId>rtsp-converter-flv-spring-boot-starter</artifactId>
    <version>1.5.9.1</version>
</dependency>
```

### Implement Interface
Create a service class that implements the `IOpenFLVService` interface to provide the stream address:

```java
@Service
public class RtspDataService implements IOpenFLVService {

    @Override
    public String getUrl(Integer channel) {
        // Retrieve the RTSP stream address based on the channel
        return "rtsp://10.11.9.251:554/openUrl/16HV8mA";
    }
}
```

### Configure YAML
Configure Easy-FLV in your `application.yml`:

```yaml
easy:
  flv:
    host: http://localhost:8200
```

### Use Interface
To get the converted stream address and play it in a browser:

- Conversion URL: `GET http://ip:port/get/flv/hls/stream_{channel}.flv`
- Direct Browser Playback: `GET http://ip:port/flv/hls/stream_{channel}.flv`

### Direct Usage
If you prefer not to implement an interface, you can directly encode the stream address and convert it:

```java
public static void main(String[] args) throws UnsupportedEncodingException {
    String url = "rtsp://XXXXXXXX";
    String encodedUrl = java.net.URLEncoder.encode(url, "UTF-8");
    System.out.println("Encoded Stream URL: " + encodedUrl);
}
```

- Conversion URL: `GET http://ip:port/get/flv/hls/stream?url=EncodedAddress`
- Direct Browser Playback: `GET http://ip:port/flv/hls/stream?url=EncodedAddress`

## 🛠️ Contribution
Contributions of any kind are welcome, including but not limited to reporting bugs, submitting fixes, adding new features, and improving documentation.

## 📄 License
Easy-FLV is released under the [Apache License 2.0](LICENSE).

## 📧 Contact
- Email: [javpower@163.com](mailto:javpower@163.com)
- GitHub: [https://github.com/javpower/easy-flv](https://github.com/javpower/easy-flv)
- Gitee: [https://gitee.com/giteeClass/easy-flv](https://gitee.com/giteeClass/easy-flv)
