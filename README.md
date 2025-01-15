# Ví Dụ Kiểm Thử Đăng Nhập Với Selenium

Dự án này minh họa cách sử dụng Selenium WebDriver để thực hiện các bài kiểm thử tự động cho việc đăng nhập vào một trang web. Ví dụ này bao gồm bài kiểm thử đăng nhập và xác minh đăng nhập thành công qua một phần tử chứa văn bản "Congratulations".

# Yêu Cầu

Trước khi chạy bài kiểm thử, bạn cần đảm bảo rằng hệ thống của bạn có các điều kiện sau:

- Java 22 hoặc phiên bản mới hơn
- Maven (hoặc công cụ build tương đương)
- Trình duyệt Chrome đã được cài đặt
- ChromeDriver tương thích với phiên bản Chrome của bạn

# Cài Đặt

# 1. Clone Repository

Clone repository này về máy tính của bạn:


git clone https://github.com/your-username/selenium-login-test.git
cd selenium-login-test

# 2. Cài Đặt Các Thư Viện Phụ Thuộc
Đảm bảo bạn đã có các thư viện phụ thuộc cần thiết được liệt kê trong file pom.xml. Nếu sử dụng Maven, chạy lệnh sau để tải các thư viện:

mvn clean install

# 3. Thêm ChromeDriver
Đảm bảo bạn đã tải về ChromeDriver phiên bản phù hợp với trình duyệt Chrome của bạn. Bạn có thể tải ChromeDriver tại đây: ChromeDriver tải về

Sau khi tải về, hãy đặt chromedriver.exe vào PATH của hệ thống hoặc chỉ định đường dẫn trực tiếp trong mã nguồn.

Chạy Bài Kiểm Thử
Bạn có thể chạy các bài kiểm thử bằng Maven:

mvn test

Lệnh này sẽ chạy các bài kiểm thử được định nghĩa trong file LoginTest.java, bao gồm kiểm thử đăng nhập và xác minh thông báo đăng nhập thành công.

 # Các Bước Kiểm Thử

Mở trang đăng nhập thực hành.
Nhập tên người dùng và mật khẩu vào các trường tương ứng.
Nhấn nút đăng nhập.
Chờ thông báo thành công (h1 chứa văn bản "Congratulations").
Nếu thông báo thành công xuất hiện, bài kiểm thử sẽ thành công. Nếu không, nó sẽ ném ra một ngoại lệ.
Giải Quyết Lỗi

Cảnh Báo SLF4J: Nếu bạn thấy cảnh báo liên quan đến SLF4J (Failed to load class "org.slf4j.impl.StaticLoggerBinder"), bạn có thể thêm một backend logger như Logback vào dự án bằng cách thêm phần phụ thuộc sau vào pom.xml:
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.2.10</version>
</dependency>




