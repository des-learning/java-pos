# Java POS (Point of Sale) System

## Overview
Aplikasi POS (Point of Sale) dikembangkan menggunakan Java.
Fitur aplikasi:
1. Managemen user
2. Managemen inventori
3. Transaksi penjualan
4. Laporan

Aplikasi ini menggunakan tampilan CLI (command line interface)
dengan navigasi menggunakan menu.

## Fitur

### 1. **Managemen User**
- **Buat user baru**: menambahkan user dengan role (`admin`, `manager`, `kasir`).
- **Reset password user**
- **Autentikasi user**: autentikasi user menggunakan username dan password.
- **Roles**: mengelola permission user berdasarkan role (`admin`, `manager`, `kasir`).

### 2. **Management Inventori**
- **Menambah produk baru**: Menambahkan produk ke invetori dengan detail nama produk, SKU, dan harga.
- **Update informasi produk**: Mengupdate informasi produk (harga).
- **Menampilkan inventori**: list dan detail inventori produk.
- **Menghapus/mengnon-aktifkan produk**: menghapus atau meng-nonaktifkan produk yang sudah tidak dijual

### 3. **Transaksi Penjualan**
- **Transaksi baru**: memulai transaksi penjualan baru
- **Menambahkan item barang ke transaksi**
- **Menampilkan isi transaksi**
- **Membayar transaksi**
- **Mencetak faktur penjualan**

### 4. **Laporan**
- **Laporan penjualan**: laporan penjualan berdasarkan periode tertentu

## Menggunakan repository ini

1. Clone repository ini

```sh
git clone https://github.com/des-learning/java-pos.git
```

2. Check branch repository ini untuk melihat progress

```sh
git branch
```

3. Checkout branch untuk melihat perubahan pada branch tersebut

```sh
git checkout <branch>
```

Direkomendasikan untuk menggunakan IDE untuk membuka project ini.

## Menjalankan aplikasi

Ke directory `src/main/java` buka `POSApp` dan click tombol run.

## Isi branch

* `00-DESIGN`

  dokumen design UI

* `01-main-loop`

  inisialisasi user management untuk menampung daftar user.
  POS memiliki user default sebagai berikut:
  - admin/admin - sebagai admin
  - manager/manager - sebagai manager
  - kasir/kasir - sebagai kasir

  user sudah bisa login dan menampilkan menu utama

* `02-extract-user-management` 

   extract fungsi yang berhubungan dengan user ke class terpisah.
   code ini merupakan implementasi dari abstraksi, setelah fungsi
   user di extract ke class terpisah program utama sekarang mendelegasi
   fungsi authenticate user ke user management

*  `03-extract-menu-navigation`

    extract fungsi menu navigation ke class tersendiri, karena
    menu navigation akan digunakan pada beberapa screen yang berbeda
    dengan meng-extract menu navigation kita dapat menggunakan class
    yang sama untuk fungsi navigasi di screen-screen tersebut (code
    reuse).
