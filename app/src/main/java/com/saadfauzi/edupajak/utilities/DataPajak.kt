package com.saadfauzi.edupajak.utilities

import com.saadfauzi.edupajak.data.local.PajakEntity

object DataPajak {
    val taxes = arrayListOf(
        PajakEntity(
            id = 1,
            taxesCode = 411121,
            taxesName = "PPh Pasal 21",
            taxesIcon = "https://pajaknesia.id/wp-content/uploads/2021/04/jasa-konsultan-pajak-spt-pph-21.jpg",
            desc = "PPh 21 merupakan pajak pemotongan yang dikenakan atas penghasilan yang diterima oleh seorang Wajib Pajak Orang Pribado (WPOP) dalam negeri berupa gaji, upah, honorarium, tunjangan dan pembayaran lain dengan nama dan dalam bentuk apapun yang sehubungan dengan pekerjaan, jasa, atau kegiatan yang dilakukannya. Pembayar PPh atau subjek pajak disebut juga sebagai Wajib Pajak, dan hal yang dibayarkan pajaknya disebut sebagai Objek Pajak.\n" +
                    "PPh 21 pada umumnya berkaitan dengan pajak yang dipotong pada sistem penggajian suatu perusahaan. Namun PPh 21 sebenarnya juga digunakan untuk berbagai jenis penghasilan lainnya, contohnya:\n" +
                    "\n" +
                    "1. Penghasilan bagi Pegawai Tetap, baik berupa penghasilan yang bersifat teratur maupun tidak teratur\n" +
                    "2. Penghasilan bagi Penerima Pensiun secara teratur, dapat berupa uang pensiun atau penghasilan serupa\n" +
                    "3. Penghasilan bagi korban pemutusan hubungan kerja (PHK) atau pensiun yang diterima secara sekaligus, dapat berupa uang pesangon, tunjangan/jaminan hari tua, uang manfaat pensiun, serta pembayaran lain sejenisnya\n" +
                    "4. Penghasilan bagi Pegawai Tidak Tetap atau Tenaga Kerja Lepas, dapat berupa upah satuan, upah borongan upah harian, upah mingguan, atau upah bulanan\n" +
                    "5. Penghasilan bagi Bukan Pegawai, dapat berupa honorarium, upah, komisi dan imbahan serupa\n" +
                    "6. Imbalan kepada peserta kegiatan, dapat berupa uang saku, uang rapat, honorarium, hadiah, uang representasi, atau penghargaan sejenis dengan nama dan dalam bentuk lainnya.",
        ),
        PajakEntity(
            id = 2,
            taxesCode = 411122,
            taxesName = "PPh Pasal 22",
            taxesIcon = "https://accounting.binus.ac.id/files/2020/12/PPh22.png",
            desc = "Menurut UU Pajak Penghasilan (PPh) Nomor 36 tahun 2008, Pajak Penghasilan Pasal 22 (PPh Pasal 22) adalah bentuk pemotongan atau pemungutan pajak yang dilakukan satu pihak terhadap wajib pajak dan berkaitan dengan kegiatan perdagangan barang.\\nMengingat sangat bervariasinya obyek, pemungut, dan bahkan tarifnya, ketentuan PPh Pasal 22 relatif lebih rumit dibandingkan dengan PPh lainnya, seperti PPh 21 atau pun PPh 23.\\nPada umumnya, PPh Pasal 22 dikenakan terhadap perdagangan barang yang dianggap “menguntungkan”, sehingga baik penjual maupun pembelinya dapat menerima keuntungan dari perdagangan tersebut.\nKarena itulah, PPh Pasal 22 dapat dikenakan baik saat penjualan maupun pembelian.",
        ),
        PajakEntity(
            id = 3,
            taxesCode = 411123,
            taxesName = "PPh Pasal 22 Import",
            taxesIcon = "https://accounting.binus.ac.id/files/2020/12/PPh22.png",
            desc = "Berdasarkan UU No. 36 tahun 2008 tentang Pajak Penghasilan, PPh 22 impor merupakan bentuk pemotongan pajak oleh satu pihak terhadap Wajib Pajak yang melakukan kegiatan perdagangan barang impor. UU No. 36 tahun 2008 juga menyebutkan bahwa objek pajak yang dimaksud adalah barang-barang yang dianggap menguntungkan kedua belah pihak, baik pembeli maupun penjual barang tersebut." +
                    "Tarif PPh 22 sendiri bervariasi tergantung pemungut serta objek dan jenis transaksinya. Namun, khusus untuk tarif PPh 22 impor adalah sebagai berikut:\n" +
                    "1. Jika menggunakan Angka Pengenal Importir (API), maka tarifnya adalah 2,5% dan dikalikan dengan nilai impor.\n" +
                    "2. Jika tidak menggunakan API, maka tarifnya adalah 7,5% dan dikalikan dengan nilai impor.\n" +
                    "3. Jika termasuk impor yang tidak dikuasai, maka tarifnya adalah 7,5% dan dikalikan dengan nilai lelang.",
        ),
        PajakEntity(
            id = 4,
            taxesCode = 411124,
            taxesName = "PPh Pasal 23",
            taxesIcon = "https://flazztax.com/wp-content/uploads/2021/01/Pelajari-dengan-Baik-Segala-Ketentuan-Pajak-Penghasilan-PPh-Pasal-23.jpg",
            desc = "Pajak Penghasilan Pasal 23 (PPh Pasal 23) adalah pajak yang dikenakan pada penghasilan atas modal, penyerahan jasa, atau hadiah dan penghargaan, selain yang telah dipotong PPh Pasal 21. Umumnya penghasilan jenis ini terjadi saat adanya transaksi antara pihak yang menerima penghasilan (penjual atau pemberi jasa) dan pemberi penghasilan. Pihak pemberi penghasilan (pembeli atau penerima jasa) akan memotong dan melaporkan PPh pasal 23 tersebut kepada kantor pajak. Objek PPh Pasal 23 telah ditambahkan oleh pemerintah hingga menjadi 62 jenis jasa lainnya seperti yang tercantum dalam PMK No. 141/PMK.03/2015.",
        ),
        PajakEntity(
            id = 5,
            taxesCode = 411125,
            taxesName = "PPh Pasal 25/29 Orang Pribadi",
            taxesIcon = "https://www.sanyangtaxconsultants.com/wp-content/uploads/2019/07/Images-1055.jpg",
            desc = "Pajak Penghasilan Pasal 29 merupakan pajak kurang bayar, sedangkan PPh Pasal 25 adalah angsuran PPh terutang. PPh Pasal 25 ini digunakan sebagai pengurang PPh terutang yang hasilnya merupakan Pajak Penghasilan 29 yang harus dilunasi.\nPajak Penghasilan atau PPh Pasal 25 dan Pasal 29 cukup sulit untuk dibedakan terlebih bagi orang awam yang tidak mengetahui segala ketentuan pajak. Dimana kedua pajak penghasilan tersebut akan dikenakan atau dibebankan atas penghasilan yang diperoleh suatu badan usaha. Baik Pajak Penghasilan pasal 25 dan pasal 29 akan dibebankan atas laba yang diperoleh perusahaan dari kegiatan usaha yang dilakukannya. Dalam praktiknya, pajak penghasilan atau PPh yang dibebankan kepada wajib pajak badan bisa dicicil selama periode pajak yang berjalan. Kedua pajak tersebut memiliki tujuan untuk meringankan beban pajak wajib pajak dengan memberikan cicilan atas kredit pajak yang dimiliki.",
        ),
        PajakEntity(
            id = 6,
            taxesCode = 411126,
            taxesName = "PPh Pasal 25/29 Badan",
            taxesIcon = "https://www.sanyangtaxconsultants.com/wp-content/uploads/2019/07/Images-1055.jpg",
            desc = "PPh Pasal 25 badan adalah pajak yang dikenakan untuk wajib pajak pribadi, perusahaan atau badan hukum lainnya atas penghasilan yang didapatkan. Di mana, pajak ini dibayar secara angsuran dengan tujuan meringankan beban wajib pajak, mengingat pajak terutang harus dilunasi dalam jangka waktu satu tahun. Pembayaran ini harus dilakukan sendiri dan tidak bisa diwakilkan. Sedangkan, PPh 29 adalah PPh Kurang Bayar yang tercantum dalam SPT Tahunan PPh, yaitu sisa dari PPh  terutang dalam tahun pajak yang bersangkutan dikurangi kredit PPh (PPh Pasal 21, 22, 23, dan 24) dan PPh 25. PPh pasal 29 ini terjadi ketika pajak yang terutang untuk suatu tahun pajak ternyata lebih besar daripada kredit pajak, maka kekurangan pajak yang terutang harus dilunasi sebelum Surat Pemberitahuan Tahunan disampaikan.",
        ),
        PajakEntity(
            id = 7,
            taxesCode = 411127,
            taxesName = "PPh Pasal 26",
            taxesIcon = "https://www.ladfanidkonsultindo.com/wp-content/uploads/2021/01/PPH26-01-scaled-1-e1610372596514.jpg",
            desc = "Menurut Undang-Undang Nomor 36 Tahun 2008, PPh Pasal 26 merupakan pajak yang dikenakan atas penghasilan yang diterima atau diperoleh Wajib Pajak luar negeri dari Indonesia selain bentuk usaha tetap (BUT) yang berada di Indonesia. Kriteria seorang individu atau perusahaan yang dikategorikan sebagai Wajib Pajak luar negeri adalah\\nSeorang individu yang tidak bertempat tinggal di Indonesia, individu yang tinggal di Indonesia tidak lebih dari 183 hari dalam setahun atau 12 bulan, perusahaan yang tidak didirikan atau berada di Indonesia, yang mengoperasikan usahanya melalui BUT di Indonesia.\\nSeorang individu yang tidak bertempat tinggal di Indonesia, individu yang tinggal di Indonesia tidak lebih dari 183 hari dalam setahun atau 12 bulan, perusahaan yang tidak didirikan atau berada di Indonesia, yang dapat menerima atau memperoleh penghasilan dari Indonesia tidak melalui menjalankan usaha melalui suatu BUT di Indonesia.",
        ),
        PajakEntity(
            id = 8,
            taxesCode = 411128,
            taxesName = "PPh Final",
            taxesIcon = "https://www.ladfanidkonsultindo.com/wp-content/uploads/2020/05/lt59005c1965f1d.jpg",
            desc = "PPh final merupakan pungutan atas penghasilan yang menggunakan metode perhitungan dengan tarif khusus. Tujuannya, untuk menyederhanakan administrasi perpajakan.\\nPajak Penghasilan Final atau yang juga disebut PPh Pasal 4 ayat (2) pada dasarnya merupakan pajak yang memiliki skema tarif dan cara perhitungan yang berbeda dengan pajak penghasilan non-final.\\nPPh Final ini langsung dikenakan dengan tarif dan dasar pengenaan pajak tertentu atas berbagai jenis penghasilan yang diperoleh WP selama satu tahun berjalan.\\nTujuan pemerintah menetapkan PPh Final adalah untuk meringankan beban WP dalam menunaikan kewajiban perpajakan.\\nAda dua pertimbangan yang mendasari keputusan tersebut, yaitu:\n" +
                    "1. Penyederhanaan pengenaan pajak penghasilan atas penghasilan dari usaha\\n\n" +
                    "2. Memudahkan serta mengurangi beban administrasi bagi wajib pajak",
        ),
        PajakEntity(
            id = 9,
            taxesCode = 411211,
            taxesName = "PPN Dalam Negeri",
            taxesIcon = "https://ik.imagekit.io/tk6ir0e7mng/uploads/2022/03/1648723699471.png",
            desc = "Sedangkan pengertian Pajak Pertambahan Nilai adalah pajak yang dikenakan atas konsumsi dalam negeri oleh Wajib Pajak Orang Pribadi, Badan, dan Pemerintah. Dalam penerapannya, Badan atau Perorangan yang membayar pajak ini tidak diwajibkan untuk menyetorkan langsung ke kas negara, melainkan lewat pihak yang memotong/memungut PPN. Pajak Pertambahan Nilai bersifat objektif, tidak kumulatif, dan merupakan pajak tidak langsung. Subjek pajaknya terdiri dari Pengusaha Kena Pajak (PKP) dan non PKP.\\nBedanya, jika sebagai PKP wajib memungut, sedangkan Non PKP tidak bisa memungut Pajak Pertambahan Nilai. Tapi ketika melakukan transaksi barang/jasa kena PPN tidak bisa mengkreditkan Pajak Masukan. Jadi, PPN adalah pungutan pajak yang dibebankan atas transaksi jual-beli barang atau jasa kena pajak yang dilakukan oleh Wajib Pajak Pribadi maupun Wajib Pajak Badan yang telah dikukuhkan sebagai Pengusaha Kena Pajak (PKP).",
        ),
        PajakEntity(
            id = 10,
            taxesCode = 411212,
            taxesName = "PPN Import",
            taxesIcon = "https://ik.imagekit.io/tk6ir0e7mng/uploads/2022/03/1648723699471.png",
            desc = "PPN Impor adalah pajak pertambahan nilai (PPN) yang dibebankan untuk Barang Kena Pajak atau Jasa Kena Pajak yang diimpor dari luar negeri. Contoh Barang Kena Pajak PPN impor adalah alat, mesin, dan lain-lain.\\nPajak PPN tidak dikenakan untuk komoditas impor berikut ini:\\n1. Barang kebutuhan pokok seperti beras, gula, sayur dan lain sebagainya.\\n2. Barang hasil pertambangan dan pengeboran.\\n3. Makanan atau minuman yang disajikan di hotel atau restoran.\\n4. Uang dan emas batangan.\\n5. Jasa pelayanan medis, pelayanan keuangan, pelayanan sosial termasuk diantaranya vaksin, alat pelengkap protokol kesehatan pandemi Covid19.",
        ),
        PajakEntity(
            id = 11,
            taxesCode = 411219,
            taxesName = "PPN Lainnya",
            taxesIcon = "https://ik.imagekit.io/tk6ir0e7mng/uploads/2022/03/1648723699471.png",
            desc = "PPN atau Pajak Pertambahan Nilai dikenakan dan disetorkan oleh pengusaha atau perusahaan yang telah dikukuhkan sebagai Pengusaha Kena Pajak (PKP).\\nNamun beban PPN tersebut ditanggung oleh konsumen akhir. Sejak 1 Juli 2016, PKP se-Indonesia wajib membuat faktur pajak elektronik atau e-Faktur untuk menghindari penerbitan faktur pajak fiktif untuk pengenaan PPN kepada lawan transaksinya.\\n\\nYang dikenakan Pajak Pertambahan Nilai atau biasa disebut dengan Objek PPN adalah:\\n1. Penyerahan Barang Kena Pajak (BKP) dan Jasa Kena Pajak (JKP) di dalam Daerah Pabean yang dilakukan oleh pengusaha\\n2. Impor Barang Kena Pajak\\n3. Pemanfaatan Barang Kena Pajak tidak berwujud dari luar Daerah Pabean di dalam Daerah Pabean\\n4. Pemanfaatan Jasa Kena Pajak dari luar Daerah Pabean di dalam Daerah Pabean\\n5. Ekspor Barang Kena Pajak berwujud atau tidak berwujud dan Ekspor Jasa Kena Pajak oleh Pengusaha Kena Pajak (PKP)",
        ),
    )
}