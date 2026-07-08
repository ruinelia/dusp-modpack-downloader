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

## Làm thế nào để mở Command Prompt hoặc Terminal ngay tại thư mục chứa `downloader.jar`?

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

Bạn nên tạo một **thư mục mới và trống**, sau đó tải toàn bộ file vào đó.

Sau khi tải xong, sao chép toàn bộ các file vào thư mục game của Minecraft.

- Với Minecraft Launcher, đây thường là thư mục `.minecraft`.
- Với các launcher khác (Prism Launcher, MultiMC, Modrinth App, ...), hãy sao chép vào thư mục của instance tương ứng.

Việc tải vào một thư mục riêng sẽ giúp dễ kiểm tra và tránh ghi đè nhầm các file khác.

---

## Khi modpack cập nhật thì phải làm gì?

Chỉ cần chạy lại `downloader.jar` và tải phiên bản mới.

Sau khi tải xong, sao chép các file mới vào `.minecraft`.

> Nếu không muốn mất các thiết lập cá nhân, hãy bỏ qua file `options.txt` khi sao chép.

---

## Vì sao phải thêm `--add-modules jdk.incubator.vector`?

Một số tính năng của modpack sử dụng SIMD để tăng hiệu năng.

Để kích hoạt, hãy thêm JVM Argument sau vào Minecraft Launcher:

```text
--add-modules jdk.incubator.vector
```

Nếu không thêm tham số này, modpack vẫn có thể hoạt động, nhưng các tối ưu hóa SIMD sẽ không được sử dụng.
