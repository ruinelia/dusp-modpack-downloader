## Tôi đang dùng Linux hoặc macOS, làm thế nào để chạy downloader?

1. Mở **Terminal**.
2. Di chuyển đến thư mục chứa `downloader.jar`.

Ví dụ:

```bash
cd ~/Downloads/Modpack
```

3. Chạy lệnh:

```bash
java -jar downloader.jar
```

---

## Làm thế nào để mở Terminal ngay tại thư mục chứa `downloader.jar`?

### Windows

Mở thư mục chứa `downloader.jar`, sau đó:

- Nhấp vào thanh địa chỉ của File Explorer.
- Gõ `cmd` rồi nhấn **Enter**.

Hoặc:

- Giữ **Shift** và nhấp chuột phải vào khoảng trống trong thư mục.
- Chọn **Open in Terminal** (hoặc **Open PowerShell window here** trên một số phiên bản Windows).

### Linux

Mở thư mục chứa `downloader.jar`, nhấp chuột phải vào khoảng trống và chọn **Open in Terminal**.

### macOS

Mở ứng dụng **Terminal**, sau đó nhập:

```bash
cd 
```

Lưu ý có **một dấu cách ở cuối**. Sau đó kéo thư mục chứa `downloader.jar` vào cửa sổ Terminal rồi nhấn **Enter**.

---

## Tôi cần cài Java phiên bản nào?

Downloader yêu cầu **Java 17 trở lên**.

Để kiểm tra phiên bản Java đang cài, chạy:

```bash
java -version
```

Nếu hiện phiên bản từ **17** trở lên thì bạn có thể sử dụng downloader.

---

## Chương trình báo không tìm thấy `java`

Điều này thường có nghĩa là:

- Java chưa được cài đặt.
- Hoặc Java chưa được thêm vào biến môi trường (`PATH`).

Hãy cài đặt Java 17 trở lên rồi thử lại.

---

## Tôi nên tải modpack vào đâu?

Hãy chạy downloader trong **thư mục Minecraft** mà bạn muốn cài modpack.

Ví dụ:

- Minecraft Launcher: thư mục `.minecraft`
- Prism Launcher: thư mục của instance
- MultiMC: thư mục của instance
- Modrinth App: thư mục của instance

Downloader sẽ tự tải mới hoặc cập nhật các tệp cần thiết. Những tệp được đánh dấu `once` sẽ không bị ghi đè nếu đã tồn tại.

---

## Khi modpack cập nhật thì phải làm gì?

Chỉ cần chạy lại `downloader.jar`.

Downloader sẽ tự động:
- tải các tệp còn thiếu;
- cập nhật các tệp đã thay đổi;
- giữ nguyên các tệp được đánh dấu `once`.

---

## Vì sao phải thêm `--add-modules jdk.incubator.vector`?

Một số tính năng của modpack sử dụng SIMD để tăng hiệu năng.

Để kích hoạt, hãy thêm JVM Argument sau vào Minecraft Launcher:

```text
--add-modules jdk.incubator.vector
```

Nếu không thêm tham số này, modpack vẫn có thể hoạt động, nhưng các tối ưu hóa SIMD sẽ không được sử dụng.
