package com.don.kredivoapp.utils

import com.don.kredivoapp.data.PromoEntity
import com.don.kredivoapp.data.TopUpEntity

/**
 * Created by gideon on 13,November,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
object DataDummy {
    fun generateDummyPromo(): ArrayList<PromoEntity> {
        val promoEntities = arrayListOf<PromoEntity>()
        promoEntities.add(PromoEntity(
            "001",
            "https://ecs7.tokopedia.net/img/blog/promo/2019/02/Kredivo_Maret_Feature-Image.jpg",
            "Discount 20% at Kedai Hape Original, Mall Kota Kasablanka",
            "10 - 31 Januari 2019",
            "BIRTHDAY9",
            "<ul>\n" +
                    "<li>Promo Berlaku untuk transaksi yang dilakukan diaplikasi terbaru Bukalapak.</li>\n" +
                    "<li>Gunakan kode BIRTHDAY9 untuk dapatkan cashback sebesar 3%</li>\n" +
                    "<li>Promo hanya berlaku untuk transaksi yang menggunakan metode pengiriman J&amp;T Express dan Ninja Xpress (REG dan FAST)</li>\n" +
                    "<li>Setiap pengguna bisa menggunakan promo sebanyak 1(satu) kali per hari dan maksimal 2 (dua) kali selama periode Promo</li>\n" +
                    "<li>Promo bisa digunakan untuk belanja produk kategori apa saja yang ada di Bukalapak, kecuali kategori tiket dan voucher, produk virtual (pulsa, paket data, voucher game,listrik prabayar &amp; pascabayar, tiekt event, tiket pesawat, tiket kereta, pembayaran zakat online, pembayaran tagihan listrik, air PDAM, dan BPJS) dan produk keuangan (BukaEmas dan BukaReksa).</li>\n" +
                    "</ul>"))
        promoEntities.add(PromoEntity(
            "002",
            "https://ecs7.tokopedia.net/img/blog/promo/2019/04/Feature-Image-940x339-62.jpg",
            "Discount 20% at Kedai Hape Original, Mall Kota Kasablanka",
            "10 - 31 Januari 2019",
            "BIRTHDAY10",
            "<ul>\n" +
                    "<li>Promo Berlaku untuk transaksi yang dilakukan diaplikasi terbaru Bukalapak.</li>\n" +
                    "<li>Gunakan kode BIRTHDAY9 untuk dapatkan cashback sebesar 3%</li>\n" +
                    "<li>Promo hanya berlaku untuk transaksi yang menggunakan metode pengiriman J&amp;T Express dan Ninja Xpress (REG dan FAST)</li>\n" +
                    "<li>Setiap pengguna bisa menggunakan promo sebanyak 1(satu) kali per hari dan maksimal 2 (dua) kali selama periode Promo</li>\n" +
                    "<li>Promo bisa digunakan untuk belanja produk kategori apa saja yang ada di Bukalapak, kecuali kategori tiket dan voucher, produk virtual (pulsa, paket data, voucher game,listrik prabayar &amp; pascabayar, tiekt event, tiket pesawat, tiket kereta, pembayaran zakat online, pembayaran tagihan listrik, air PDAM, dan BPJS) dan produk keuangan (BukaEmas dan BukaReksa).</li>\n" +
                    "</ul>"))
        promoEntities.add(PromoEntity(
            "003",
            "https://ecs7.tokopedia.net/img/blog/promo/2018/11/Feature-Image_940x339-1.jpg",
            "Discount 20% at Kedai Hape Original, Mall Kota Kasablanka",
            "10 - 31 Januari 2019",
            "BIRTHDAY11",
            "<ul>\n" +
                    "<li>Promo Berlaku untuk transaksi yang dilakukan diaplikasi terbaru Bukalapak.</li>\n" +
                    "<li>Gunakan kode BIRTHDAY9 untuk dapatkan cashback sebesar 3%</li>\n" +
                    "<li>Promo hanya berlaku untuk transaksi yang menggunakan metode pengiriman J&amp;T Express dan Ninja Xpress (REG dan FAST)</li>\n" +
                    "<li>Setiap pengguna bisa menggunakan promo sebanyak 1(satu) kali per hari dan maksimal 2 (dua) kali selama periode Promo</li>\n" +
                    "<li>Promo bisa digunakan untuk belanja produk kategori apa saja yang ada di Bukalapak, kecuali kategori tiket dan voucher, produk virtual (pulsa, paket data, voucher game,listrik prabayar &amp; pascabayar, tiekt event, tiket pesawat, tiket kereta, pembayaran zakat online, pembayaran tagihan listrik, air PDAM, dan BPJS) dan produk keuangan (BukaEmas dan BukaReksa).</li>\n" +
                    "</ul>"))
        promoEntities.add(PromoEntity(
            "004",
            "https://ecs7.tokopedia.net/img/blog/promo/2019/09/OG_1200X630.jpg",
            "Discount 20% at Kedai Hape Original, Mall Kota Kasablanka",
            "10 - 31 Januari 2019",
            "BIRTHDAY12",
            "<ul>\n" +
                    "<li>Promo Berlaku untuk transaksi yang dilakukan diaplikasi terbaru Bukalapak.</li>\n" +
                    "<li>Gunakan kode BIRTHDAY9 untuk dapatkan cashback sebesar 3%</li>\n" +
                    "<li>Promo hanya berlaku untuk transaksi yang menggunakan metode pengiriman J&amp;T Express dan Ninja Xpress (REG dan FAST)</li>\n" +
                    "<li>Setiap pengguna bisa menggunakan promo sebanyak 1(satu) kali per hari dan maksimal 2 (dua) kali selama periode Promo</li>\n" +
                    "<li>Promo bisa digunakan untuk belanja produk kategori apa saja yang ada di Bukalapak, kecuali kategori tiket dan voucher, produk virtual (pulsa, paket data, voucher game,listrik prabayar &amp; pascabayar, tiekt event, tiket pesawat, tiket kereta, pembayaran zakat online, pembayaran tagihan listrik, air PDAM, dan BPJS) dan produk keuangan (BukaEmas dan BukaReksa).</li>\n" +
                    "</ul>"))
        return promoEntities
    }

    fun generateDummyPulsa(): ArrayList<TopUpEntity> {
        val topUpEntities = arrayListOf<TopUpEntity>()
        topUpEntities.add(TopUpEntity(100,25000.0,25000.0,"Pulsa"))
        topUpEntities.add(TopUpEntity(101,50000.0,50000.0,"Pulsa"))
        topUpEntities.add(TopUpEntity(102,100000.0,100000.0,"Pulsa"))
        topUpEntities.add(TopUpEntity(103,150000.0,150000.0,"Pulsa"))
        topUpEntities.add(TopUpEntity(104,195000.0,200000.0,"Pulsa"))
        return topUpEntities
    }


    fun generateDummyDataPackage(): ArrayList<TopUpEntity> {
        val topUpEntities = arrayListOf<TopUpEntity>()
        topUpEntities.add(TopUpEntity(100,25000.0,25000.0,"1 GB bonus Pulsa Rp 2000"))
        topUpEntities.add(TopUpEntity(101,50000.0,50000.0,"2 GB bonus Pulsa Rp 5000"))
        topUpEntities.add(TopUpEntity(102,100000.0,100000.0,"5GB/bulan"))
        topUpEntities.add(TopUpEntity(103,150000.0,150000.0,"10GB/bulan"))
        topUpEntities.add(TopUpEntity(104,195000.0,200000.0,"25GB/bulan"))
        return topUpEntities
    }
}