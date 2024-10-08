# Design

Aplikasi POS menggunakan CLI dan menu based navigation sebagai user interface. User dapat mengakses aplikasi dari
terminal dan kemudian mengetikkan pilihan menu yang diinginkan.

## User interface

### Login
```sh
POS

Username: ___
Password: ___
```

Ditampilkan ketika aplikasi dijalankan. POS meminta user untuk memasukkan username
dan password. Apabila user dan password valid, maka user akan dibawa ke menu utama.

### Menu Utama
```sh
POS - Menu Utama

1. Managemen user
2. Managemen inventori
3. Transaksi penjualan
4. Laporan
5. Keluar

Menu: ___
```

Aplikasi POS menggunakan menu based navigation. User memilih menu yang ingin dituju
dengan mengetikkan nomor menu (1, 2, 3, dst).

### Menu Managemen User
```sh
POS - Managemen User

1. Tambah user baru
2. List user
3. Kembali ke menu utama

Menu: ___
```

#### Menu Managemen User - Tambah User Baru
```sh
POS - Management User - Tambah user baru

nama: ___
username: ___
password: ___
password (verifikasi): ___
Role (Admin/Manager/Kasir): ___

Tambah user (Y/T)? _
```

#### Menu Managemen User - List User
```sh
POS - Management User - List User
+-----+-------------------+----------+---------+
| ID. | Nama              | Username | Role    |
+-----+-------------------+----------+---------+
| 1   | admin             | admin    | Admin   |
| 2   | manager           | manager  | Manager |
| 3   | kasir             | kasir    | Kasir   |
+-----+-------------------+----------+---------+

Pilih ID user (0 untuk kembali ke menu sebelumnya): _
```

#### Menu Managemen User - User detail
```sh
POS - Managemen User - User detail

Nama: admin
Username: admin
Role: Admin

Reset password (kosongkan untuk kembali): ___
Verifikasi password: ___
```

### Menu Managemen Inventori
```sh
POS - Managemen Inventori

1. Tambah produk baru
2. List produk
3. Kembali ke menu utama

Menu: ___
```

#### Menu Managemen Inventori - Menambah produk baru
```sh
POS - Managemen Inventori - Tambah produk baru

SKU: ___
Nama Produk: ___
Harga Satuan: ___

Simpan (Y/T): _
```

#### Menu Managemen Inventori - List produk
```sh
POS - Managemen Inventori - List Produk

+-----+-------------------+----------+--------------+-------+
| ID. | Nama              | SKU      | Harga Satuan | Aktif |
+-----+-------------------+----------+--------------+-------+
| 1   | Produk 1          | SKU1     | 10000        | Y     |
| 2   | Produk 2          | SKU2     | 7000         | T     |
+-----+-------------------+----------+--------------+-------+

Pilih produk yang akan di-update (0 untuk kembali): _
```

#### Menu Managemen Inventori - Update Produk
```sh
POS - Management Inventori - Produk detail

ID: 1
Nama: Produk 1
SKU: SKU1
Harga Satuan: 10000
Aktif: Ya

Ubah informasi produk (Y/T): _

Nama Baru (enter untuk tidak ada perubahan): ___
SKU (enter untuk tidak ada perubahan): ___
Harga satuan (enter untuk tidak ada perubahan): ___
Aktif (enter untuk tidak ada perubahan) ___
```

### Menu Transaksi Penjualan
```sh
POS - Transaksi Penjualan

Tanggal: 2024-10-01
No Transaksi: <generated>
Kasir: <nama kasir>

Items:
+-----+-------------------+----------+--------------+--------+----------+
| No. | Nama              | SKU      | Harga Satuan | Banyak | Subtotal |
+-----+-------------------+----------+--------------+--------+----------+

SKU (kosongkan untuk selesai): ___
Nama barang: <tampilkan>
Harga satuan: <tampilkan>
Banyak: ___

Items:
+-----+-------------------+----------+--------------+--------+----------+
| No. | Nama              | SKU      | Harga Satuan | Banyak | Subtotal |
+-----+-------------------+----------+--------------+--------+----------+
| 1   | Produk 1          | SKU1     | 10000        | 2      | 20000    |
+-----+-------------------+----------+--------------+--------+----------+

SKU (kosongkan untuk selesai): ___

<Transaksi selesai>

+-----+-------------------+----------+--------------+--------+----------+
| No. | Nama              | SKU      | Harga Satuan | Banyak | Subtotal |
+-----+-------------------+----------+--------------+--------+----------+
| 1   | Produk 1          | SKU1     | 10000        | 2      | 20000    |
+-----+-------------------+----------+--------------+--------+----------+
|                                                Grand Total | 20000    |
+-----------------------------------------------------------------------+

Pembayaran: ___
Kembalian: <dihitung>

Faktur penjualan:

+-----------------------------+
| Tgl: 2024-10-01             |
| No: <generated>             |
| Kasir: <nama kasir>         |
| Item: 1                     |
| Banyak: 2                   |
|                             |
| Produk 1@10000 x 2 = 20000  |
|                             |
| Grand Total: 20000          |
+-----------------------------+
```

### Menu Laporan Penjualan
```sh
POS - Laporan Penjualan

Tanggal (YYYY-MM-DD/kosongkan untuk kembali ke menu sebelumnya): ___

Tanggal: 2024-10-01

Total Penjualan: <total nilai transaksi>
Banyak Transaksi: <banyak transaksi>
Jumlah Item terjual: <jumlah item terjual>

+-----------+-------------------+-----------------+
| No Faktur | Jumlah Item       | Total transaksi |
+-----------+-------------------+-----------------+
| Faktur 1  | 2 item            | 20000           |
+-----------+-------------------+-----------------+
|                 Grand Total   | 20000           |
+-------------------------------+-----------------+

Tanggal (YYYY-MM-DD/kosongkan untuk kembali ke menu sebelumnya): ___
```
