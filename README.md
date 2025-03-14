# Refleksi Module 5

## 1. Perbedaan antara Pengujian Performa dengan JMeter dan Profiling dengan IntelliJ Profiler

### JMeter
- **Tujuan:**  
  Mensimulasikan beban pengguna eksternal dengan mengirim permintaan HTTP ke endpoint aplikasi.
- **Fokus:**  
  Mengukur performa keseluruhan aplikasi, seperti waktu respons, throughput, dan tingkat error.
- **Metodologi:**
    - Membuat test plan dengan thread group (misalnya, 10 pengguna dengan periode ramp-up 1 detik).
    - Menambahkan sampler (misalnya, untuk endpoint `/all-student`) dan listener (seperti *View Results Tree*, *Summary Report*, dll) untuk memonitor hasil pengujian.

### IntelliJ Profiler
- **Tujuan:**  
  Menganalisis performa internal aplikasi dengan menelusuri setiap metode untuk mengidentifikasi bottleneck.
- **Fokus:**  
  Menyediakan informasi rinci mengenai waktu eksekusi (baik *total time* maupun *CPU time*) pada masing-masing metode.
- **Metodologi:**
    - Menjalankan profiler pada aplikasi yang sedang berjalan (misalnya, setelah mengakses endpoint `/all-student`).
    - Menggunakan visualisasi seperti flame graph, timeline, dan daftar metode untuk menemukan bagian kode yang mengkonsumsi banyak sumber daya, seperti metode `getAllStudentWithCourses`.

---

## 2. Bagaimana Proses Profiling Membantu Mengidentifikasi dan Memahami Titik Lemah pada Aplikasi

- **Visibilitas Mendetail:**  
  Profiling memberikan data spesifik per metode, sehingga memudahkan identifikasi bagian kode yang paling membebani.
- **Alat Visualisasi:**  
  Flame graph dan timeline menampilkan waktu dan intensitas pemakaian sumber daya, membantu melihat kapan dan di mana bottleneck terjadi.
- **Data yang Dapat Ditindaklanjuti:**  
  Informasi seperti *CPU time* memungkinkan pengembang menentukan area yang harus dioptimasi untuk perbaikan performa.

---

## 3. Efektivitas IntelliJ Profiler dalam Menganalisis dan Mengidentifikasi Bottleneck

- **Wawasan Komprehensif:**  
  Menyediakan analisis mendalam hingga level metode, memudahkan identifikasi bottleneck secara spesifik.
- **Kemudahan Penggunaan:**  
  Tampilan visual (flame graph, timeline, daftar metode) mempermudah proses analisis tanpa perlu menelusuri log yang kompleks.
- **Metrik Akurat:**  
  Perbandingan antara *total time* dan *CPU time* membantu menentukan apakah bottleneck disebabkan oleh proses komputasi intensif atau operasi lain seperti I/O.

---

## 4. Tantangan Utama dalam Pengujian Performa dan Profiling serta Cara Mengatasinya

### Tantangan
- **Variabilitas Lingkungan:**
    - **Waktu Pemanasan JIT:**  
      Hasil pengukuran awal bisa lebih lambat karena JVM belum optimal.
    - **Beban Sistem:**  
      Faktor eksternal seperti keterbatasan perangkat keras dapat mempengaruhi hasil.
- **Volume Data dan Realisme:**
    - Pentingnya menghasilkan data uji yang cukup besar dan realistis (misalnya, melalui proses data seeding).
    - Konfigurasi yang tepat pada database (misalnya, PostgreSQL) dan file `application.properties`.
- **Perbedaan Hasil:**
    - Hasil pengujian end-to-end dari JMeter mungkin tidak konsisten dengan data internal dari IntelliJ Profiler.

### Cara Mengatasi
- **Pengulangan Pengujian:**  
  Lakukan beberapa kali pengujian untuk mendapatkan hasil yang konsisten.
- **Pendekatan Komplementer:**  
  Gunakan JMeter dan IntelliJ Profiler secara bersamaan untuk saling memverifikasi data.
- **Validasi Silang:**  
  Gunakan metode logging atau monitoring tambahan untuk memastikan bahwa perbaikan yang dilakukan benar-benar mempengaruhi performa.

---

## 5. Manfaat Utama Menggunakan IntelliJ Profiler

- **Rincian yang Mendalam:**  
  Memperlihatkan metode yang paling mengkonsumsi sumber daya sehingga pengembang bisa fokus pada area yang bermasalah.
- **Optimasi Terfokus:**  
  Memudahkan refactoring dengan menargetkan bagian kode yang memberikan dampak terbesar terhadap performa.
- **Perbandingan Visual:**  
  Tampilan perbandingan sebelum dan sesudah optimasi membantu memverifikasi peningkatan performa (misalnya, target minimal 20% perbaikan).
- **Integrasi dengan IDE:**  
  Proses profiling menjadi lebih efisien karena langsung terintegrasi dalam IntelliJ.

---

## 6. Menangani Ketidakkonsistenan Hasil antara Profiling dan Pengujian dengan JMeter

- **Pengukuran Berulang:**  
  Lakukan beberapa kali uji coba untuk mengatasi variabilitas hasil akibat pemanasan JIT atau beban sistem.
- **Analisis Kontekstual:**  
  Pahami bahwa JMeter mengukur waktu respons end-to-end, sedangkan IntelliJ Profiler mengukur eksekusi internal.
- **Validasi Silang:**  
  Gunakan metode monitoring atau logging tambahan untuk memastikan konsistensi hasil.
- **Pendekatan Iteratif:**  
  Setelah optimasi, ulangi kedua jenis pengujian untuk memastikan bahwa perbaikan yang dilakukan konsisten dan valid.

---

## 7. Strategi Optimasi Kode Aplikasi Berdasarkan Hasil Pengujian dan Profiling

- **Identifikasi Hotspots:**  
  Temukan metode yang mengkonsumsi sumber daya paling banyak, misalnya `getAllStudentWithCourses`.
- **Refactoring dan Optimasi:**  
  Perbaiki algoritma, optimalkan query database, dan kurangi perhitungan yang tidak perlu.  
  Gunakan commit message yang jelas, contohnya:  
  `"[Refactoring] - Optimizing method getAllStudentWithCourses"`
- **Pengujian Regresi:**  
  Lakukan unit test dan regresi test untuk memastikan perubahan tidak mengganggu fungsionalitas aplikasi.
- **Validasi Kinerja:**  
  Jalankan kembali pengujian menggunakan JMeter dan IntelliJ Profiler untuk memastikan peningkatan performa minimal 20%.
- **Dokumentasi:**  
  Catat hasil perbandingan sebelum dan sesudah optimasi di README.md sebagai referensi dan verifikasi.

---


![Screenshot 2025-03-14 203536](https://github.com/Nadekoooo/exercise-profiling/blob/main/ss1.png?raw=true)

![Screenshot 2025-03-14 205019](https://github.com/Nadekoooo/exercise-profiling/blob/main/ss2.png?raw=true)

![Screenshot 2025-03-14 205929](https://github.com/Nadekoooo/exercise-profiling/blob/main/ss3.png?raw=true)

![Screenshot 2025-03-14 205507](https://github.com/Nadekoooo/exercise-profiling/blob/main/ss4.png?raw=true)

![Screenshot 2025-03-14 210821](https://github.com/Nadekoooo/exercise-profiling/blob/main/ss5.png?raw=true)

![Screenshot 2025-03-14 211154](https://github.com/Nadekoooo/exercise-profiling/blob/main/ss6.png?raw=true)

![Screenshot 2025-03-14 211630](https://github.com/Nadekoooo/exercise-profiling/blob/main/ss7.png?raw=true)

![Screenshot 2025-03-14 211710](https://github.com/Nadekoooo/exercise-profiling/blob/main/ss8.png?raw=true)
