# DuSenpai Minecraft Season 4 Modpack Downloader

Công cụ tải và cập nhật modpack **DuSenpai Minecraft Season 4**.

## Yêu cầu

- Java 17 trở lên

Kiểm tra phiên bản Java:

```bash
java -version
```

## Hướng dẫn sử dụng

1. Tạo một **thư mục trống** ở vị trí mà Java có quyền ghi dữ liệu.
2. Sao chép `downloader.jar` vào thư mục đó.
3. Mở Terminal tại thư mục chứa `downloader.jar`.
4. Chạy lệnh:

```bash
java -jar downloader.jar
```

Chương trình sẽ lần lượt yêu cầu:

### URL manifest

Nhập đường dẫn đến file `manifest.json`.

- Nhấn **Enter** để sử dụng [đường dẫn mặc định](https://raw.githubusercontent.com/DemoVPS69420/modpacklauncherupdater/main/manifest.json).

### Thư mục tải xuống

Nhập đường dẫn đến thư mục muốn tải modpack vào.

- Nhấn **Enter** để sử dụng thư mục hiện tại.

Sau khi hiển thị thông tin modpack, nhập **Y** hoặc nhấn **Enter** để bắt đầu tải.

Khi hoàn tất, chỉ cần sao chép toàn bộ các file đã tải vào thư mục Minecraft là có thể sử dụng.

## Cập nhật modpack

Khi modpack có phiên bản mới, chỉ cần chạy lại `downloader.jar` và tải lại.

Sau khi tải xong, sao chép các file mới vào Minecraft để cập nhật.

> **Lưu ý:** Nếu không muốn các thiết lập cá nhân bị ghi đè, hãy bỏ qua file `options.txt` (nếu có) khi sao chép.

## Kích hoạt SIMD

Để sử dụng các tối ưu hóa SIMD, hãy thêm JVM Argument sau vào Minecraft Launcher trước khi khởi chạy game:

```text
--add-modules jdk.incubator.vector
```

Nếu không thêm tham số này, các tối ưu hóa SIMD sẽ không được kích hoạt.

## Cần trợ giúp?

Nếu gặp sự cố hoặc có thắc mắc, hãy xem [FAQ.md](FAQ.md).

## Miễn trừ trách nhiệm

Dự án này không trực thuộc hoặc đại diện cho ban quản lý máy chủ **DuSenpai Minecraft Season 4**. Đây là một công cụ do bên thứ ba phát triển nhằm hỗ trợ tải modpack.

## Giấy phép

Dự án được phát hành theo **MIT License**.
