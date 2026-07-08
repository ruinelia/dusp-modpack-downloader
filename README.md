# DuSenpai Minecraft Season 4 Modpack Downloader

[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)
![Java 17+](https://img.shields.io/badge/Java-17%2B-orange)

Công cụ tải và cập nhật modpack **DuSenpai Minecraft Season 4**.

## Yêu cầu

- Java 17 trở lên

Kiểm tra phiên bản Java:

```bash
java -version
```

## Chuẩn bị

Trước khi chạy downloader, hãy đảm bảo:

- Đã tạo hoặc chọn thư mục Minecraft (ví dụ: `.minecraft`, Prism Launcher, MultiMC hoặc Modrinth App).
- Đã cài đúng phiên bản Fabric Loader mà modpack yêu cầu.
- Đã cài phiên bản Java phù hợp với modpack.

## Tải modpack

1. Sao chép `downloader.jar` vào thư mục đã chuẩn bị.
2. Mở Terminal tại thư mục chứa `downloader.jar`.
3. Chạy lệnh:

```bash
java -jar downloader.jar
```

Chương trình sẽ lần lượt yêu cầu:

### URL manifest

Nhập URL của tệp `manifest.json`.

- Nhấn **Enter** để sử dụng [URL mặc định](https://raw.githubusercontent.com/DemoVPS69420/modpacklauncherupdater/main/manifest.json).

### Thư mục tải xuống

Nhập đường dẫn đến thư mục mà bạn muốn tải hoặc cập nhật modpack.

- Nhấn **Enter** để sử dụng thư mục hiện tại.
- Nếu thư mục đã chứa modpack, downloader sẽ tải các tệp còn thiếu hoặc đã thay đổi.
- Các tệp được đánh dấu `once` sẽ được giữ nguyên nếu chúng đã tồn tại.

Sau khi hiển thị thông tin modpack, nhập **Y** hoặc nhấn **Enter** để bắt đầu tải.

Khi hoàn tất, chỉ cần chạy Minecraft là có thể chơi được.
Vui lòng xem thêm cách kích hoạt **SIMD** bên dưới để tối ưu trò chơi.

## Kích hoạt SIMD

Để bật các tối ưu hóa SIMD, hãy thêm JVM Argument sau vào Minecraft Launcher:

```text
--add-modules jdk.incubator.vector
```

Nếu không thêm tham số này, các tối ưu hóa SIMD sẽ không khả dụng.

## Cập nhật modpack

Khi modpack có phiên bản mới, chỉ cần chạy lại `downloader.jar` để cập nhật.

Các tệp được đánh dấu `once` sẽ được giữ nguyên nếu chúng đã tồn tại.

## Cần trợ giúp?

Nếu gặp sự cố hoặc có thắc mắc, hãy xem [FAQ.md](FAQ.md).

## Miễn trừ trách nhiệm

Dự án này không trực thuộc hoặc đại diện cho ban quản lý máy chủ **DuSenpai Minecraft Season 4**. Đây là một công cụ do bên thứ ba phát triển nhằm hỗ trợ tải modpack.

## Giấy phép

Dự án được phát hành theo **MIT License**.
