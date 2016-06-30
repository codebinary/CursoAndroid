package com.james.codebinary.trickymarket.modelos;

import com.james.codebinary.trickymarket.R;

/**
 * Datos de prueba para las pestañas
 */
public class Products {

    private static Product[] telefonos = {
            new Product(
                    "Hisense HS-U98",
                    " 4Gb ROM, 1GB RAM, Camara 8Mpx.",
                    "$167 USD",
                    3.1f,
                    R.drawable.smartphone_hisense_hs_u98),
            new Product(
                    "DarkFull",
                    " 16Gb ROM, 2GB RAM, Camara 13Mpx.",
                    "$295 USD",
                    4.0f,
                    R.drawable.smartphone_darkfull),
            new Product(
                    "Moto G",
                    " 4Gb Rom, 1GB RAM, Camara 13Mpx.",
                    "$189.9 USD",
                    4.6f,
                    R.drawable.smartphone_motog),
            new Product(
                    "BQ Aquaris 5 HD",
                    " 16Gb ROM, 1GB RAM, Camara 8Mpx.",
                    "$199.9 USD",
                    3.0f,
                    R.drawable.smartphone_bq_aquaris_5),
            new Product(
                    "Aquaris 5.7",
                    " 16Gb ROM, 2GB RAM, Camara 13Mpx.",
                    "$259.9 USD",
                    4.6f,
                    R.drawable.smartphone_aquaris_57),

            new Product(
                    "Wiko Rainbow",
                    " 4Gb ROM, 1GB RAM, Camara 8Mpx.",
                    "$169 USD",
                    4.1f,
                    R.drawable.smartphone_wiko_rainbow),


            new Product(
                    "Hisense HS-U980",
                    " 8Gb ROM, 1GB RAM, Camara 8Mpx.",
                    "$203.9 USD",
                    2.8f,
                    R.drawable.smartphone_hisense_hs_u980)

    };

    private static Product[] tablets = {
            new Product(
                    "Apple iPad Air 2",
                    "iOS 8.1",
                    "$448 USD",
                    5.0f,
                    R.drawable.tablet_apple_ipad_air_2),
            new Product(
                    "Samsung Galaxy Tab S 8.4",
                    "Android 4.4 Kitkat",
                    "$431 USD",
                    4.0f,
                    R.drawable.tablet_samsung_galaxy_tab_s_84),
            new Product(
                    "Lenovo ThinkPad 8",
                    "Windows 8.1",
                    "$390 USD",
                    4.6f,
                    R.drawable.tablet_lenovo_thikpad_8),
            new Product(
                    "Samsung Galaxy Pro 8.4",
                    "Android",
                    "$299 USD",
                    3.0f,
                    R.drawable.tablet_galaxy_tab_pro_84),
            new Product(
                    "Amazon Kindle Fire HDX 8.9",
                    "Fire OS",
                    "$379 USD",
                    3f,
                    R.drawable.tablet_amazon_kindle_fire_hdx),

            new Product(
                    "Nvidia Shield Tablet",
                    "Android 4.4 Kitkat",
                    "$375 USD",
                    4.8f,
                    R.drawable.tablet_nvidia_shield),


            new Product(
                    "ASUS Transformer Pad Infinity TF700",
                    "Android 4.2 Jelly Bean",
                    "$509 USD",
                    4f,
                    R.drawable.tablet_asus_transformer_pad_infinity_tf700)
    };

    private static Product[] portatiles = {
            new Product(
                    "Dell Latitude 12",
                    "Model No: 7204",
                    "$6474 USD",
                    5.0f,
                    R.drawable.portatil_latitude_12_rugged),
            new Product(
                    "Alienware 17 R1 Flagship",
                    "Gaming",
                    "$3849 USD",
                    4.0f,
                    R.drawable.portatil_alienware_17_flagship),
            new Product(
                    "MSI GT80 Titan SLI",
                    "Gaming",
                    "$3299 USD",
                    4.6f,
                    R.drawable.portatil_msi_gt80_titan),
            new Product(
                    "ASUS ROG G751YJ-DH72X",
                    "Gaming",
                    "$2999 USD",
                    3.0f,
                    R.drawable.portatil_asus_rog_g751jy),
            new Product(
                    "Toshiba X70-AST3G26",
                    "All-Purpose",
                    "$2699 USD",
                    3f,
                    R.drawable.portatil_toshiba_x70_ast3g26),

            new Product(
                    "Sony VAIO Duo 13",
                    "2-in-1",
                    "$2699 USD",
                    4.8f,
                    R.drawable.portatil_sony_vaio_duo_13_svd1322bpxb),


            new Product(
                    "Gigabyte Aorus X3 Plus v3",
                    "Gaming",
                    "$2538 USD",
                    4f,
                    R.drawable.portatil_gigabyte_aorus_x3_plus_v3)
    };

    public static Product[] getTelefonos() {
        return telefonos;
    }

    public static Product[] getTablets() {
        return tablets;
    }

    public static Product[] getPortatiles() {
        return portatiles;
    }
}
