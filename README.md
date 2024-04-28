<!-- Easy-FLV: Java RTSP/RTMP to FLV Converter -->
# 📺 Easy-FLV: Java 实现的 RTSP/RTMP 到 FLV 转换器

[![GitHub stars](https://img.shields.io/github/stars/javpower/easy-flv.svg)](https://github.com/javpower/easy-flv)
[![GitHub issues](https://img.shields.io/github/issues/javpower/easy-flv.svg)](https://github.com/javpower/easy-flv/issues)
[![Apache License 2.0](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Java Version](https://img.shields.io/badge/java-1.8+-orange.svg)](https://adoptopenjdk.net/)
[![Spring Boot](https://img.shields.io/badge/spring--boot-2.7.+-blue.svg)](https://spring.io/projects/spring-boot)

## 🌟 关于 Easy-FLV
Easy-FLV 是一个用 Java 实现的库，它能够将 RTSP 或 RTMP 视频流转换为 FLV 格式，以便在浏览器中播放。它为实时视频监控、直播和视频流处理提供了一个高效、稳定且易于集成的解决方案。

### 为什么选择 Easy-FLV?
- **高效转换**：快速将视频流转换为 FLV 格式，无需复杂配置。
- **易于集成**：作为 Spring Boot Starter 使用，轻松集成到任何 Java 项目。
- **现代浏览器支持**：支持所有主流浏览器，无需额外插件。
- **实时流处理**：适用于实时视频流的转换，如安防监控和直播。

## 📄 效果图
以下是 Easy-FLV 在行动的效果图：

![img_1.png](img_1.png)
![img.png](img.png)

## 🚀 快速开始

### 添加 Maven 依赖
在你的 Spring Boot 项目中，添加以下 Maven 依赖：

```xml
<dependency>
    <groupId>io.github.javpower</groupId>
    <artifactId>rtsp-converter-flv-spring-boot-starter</artifactId>
    <version>1.5.9.1</version>
</dependency>
```

### 实现接口
创建一个服务类来实现 `IOpenFLVService` 接口，并提供流地址：

```java
@Service
public class RtspDataService implements IOpenFLVService {

    @Override
    public String getUrl(Integer channel) {
        // 根据 channel 获取 RTSP 视频流地址
        return "rtsp://10.11.9.251:554/openUrl/16HV8mA";
    }
}
```

### 配置 YAML
在 `application.yml` 中配置 Easy-FLV：

```yaml
easy:
  flv:
    host: http://localhost:8200
```

### 使用接口
通过以下接口获取转换后的流地址，并在浏览器中播放：

- 转换地址：`GET http://ip:port/get/flv/hls/stream_{channel}.flv`
- 播放地址：`GET http://ip:port/flv/hls/stream_{channel}.flv`

### 直接使用
如果不使用接口，可以直接编码流地址并转换：

```java
public static void main(String[] args) throws UnsupportedEncodingException {
    String url = "rtsp://XXXXXXXX";
    String encodedUrl = java.net.URLEncoder.encode(url, "UTF-8");
    System.out.println("Encoded Stream URL: " + encodedUrl);
}
```

- 转换地址：`GET http://ip:port/get/flv/hls/stream?url=编码后的地址`
- 播放地址：`GET http://ip:port/flv/hls/stream?url=编码后的地址`

## 🛠️ 贡献
我们欢迎任何形式的贡献，包括但不限于报告 bug、提交修复、添加新功能、改进文档等。

## 📄 许可证
Easy-FLV 根据 [Apache License 2.0](LICENSE) 发布。

## 📧 联系
- Email: [javpower@163.com](mailto:your-email@example.com)
- GitHub: [https://github.com/javpower/easy-flv](https://github.com/javpower/easy-flv)
- Gitee: [https://gitee.com/giteeClass/easy-flv](https://gitee.com/giteeClass/easy-flv)
